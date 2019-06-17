package com.jianwuch.annotationlib;

import com.google.auto.service.AutoService;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.processing.AbstractProcessor;
import javax.annotation.processing.Filer;
import javax.annotation.processing.Messager;
import javax.annotation.processing.ProcessingEnvironment;
import javax.annotation.processing.Processor;
import javax.annotation.processing.RoundEnvironment;
import javax.lang.model.SourceVersion;
import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import javax.lang.model.element.TypeElement;
import javax.lang.model.util.Elements;
import javax.lang.model.util.Types;

/**
 * @author jove.chen
 * @date 2019/6/11
 */
@AutoService(Processor.class)
public class ShapeFactoryProcessor extends AbstractProcessor {
    /**
     * // Get type utils.
     */
    private Types mTypeUtils;
    private Messager mMessager;

    /**
     * File util, write class file into disk
     */
    private Filer mFiler;

    /**
     * Get class meta.
     */
    private Elements mElementUtils;
    //private Map<String, FactoryGroupedClasses> factoryClasses = new LinkedHashMap<>();
    /**
     * Contain field need autowired and his super class.
     */
    private Map<TypeElement, List<Element>> parentAndChild = new HashMap<>();

    /**
     * 设置支持的Java soucre版本,
     * 可以使用“@SupportedSourceVersion(SourceVersion.RELEASE_7)”进行替换
     * @return 当前使用的java版本号
     */
    @Override
    public SourceVersion getSupportedSourceVersion() {
        return super.getSupportedSourceVersion();
    }

    /**
     * 设置指定支持的注解类型,
     * 可以使用“@SupportedAnnotationTypes({com.jianwuch.annotationlib.Shape})”对类进行注释替换这种方式
     * @return 需要处理的指定注释类型集合
     */
    @Override
    public Set<String> getSupportedAnnotationTypes() {
        Set<String> annotataions = new LinkedHashSet<String>();
        annotataions.add(Shape.class.getCanonicalName());
        return annotataions;
    }

    @Override
    public synchronized void init(ProcessingEnvironment processingEnvironment) {
        super.init(processingEnvironment);
        mTypeUtils = processingEnvironment.getTypeUtils();
        mMessager = processingEnvironment.getMessager();
        mFiler = processingEnvironment.getFiler();
        mElementUtils = processingEnvironment.getElementUtils();
    }

    @Override
    public boolean process(Set<? extends TypeElement> set, RoundEnvironment roundEnvironment) {
        for (Element annotatedElement : roundEnvironment.getRootElements()) {
            if (annotatedElement.getKind() == ElementKind.CLASS) {
                System.out.println("---->cjw"+annotatedElement.getSimpleName());
            }
        }
        return true;
    }
}
