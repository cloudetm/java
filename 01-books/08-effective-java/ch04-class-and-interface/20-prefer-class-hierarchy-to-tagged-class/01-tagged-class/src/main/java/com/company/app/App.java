package com.company.app;

// Tagged class - vastly inferior to a class hierarchy!
// Compare it with class hierarchy example to see the difference
class Figure{
    enum Shape{RECTANGLE, CIRCLE};
    // Tag field - the shape of this figure
    final Shape shape;
    // These fields are used only if shape is RECTANGLE
    double length;
    double width;
    // This field is used only if shape is CIRCLE
    double radius;
    // Constructor for circle
    Figure(double radius) {
        this.shape = Shape.CIRCLE;
        this.radius = radius;
    }
    // Constructor for rectangle
    Figure(double length, double width){
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }
    double area(){
        switch (shape){
            case RECTANGLE:
                return length * width;
            case CIRCLE:
                return Math.PI * (radius * radius);
            default:
                throw new AssertionError();
        }
    }
}
public class App
{
    public static void main( String[] args )
    {
        Figure figure = new Figure(8);
        System.out.println(figure.area());
    }
}
/*
output:
201.06192982974676
 */
