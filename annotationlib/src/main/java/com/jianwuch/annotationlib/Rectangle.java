package com.jianwuch.annotationlib;

/**
 * @author jove.chen
 * @date 2019/6/11
 */
@Shape(type = Rectangle.class, id = "Rectangle")
public class Rectangle implements ShapeInterface {
    @Override
    public void draw() {
        System.out.println("Draw a Rectangle");
    }
}
