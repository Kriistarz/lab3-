package ru.ruazanova.shapes;

import ru.ruazanova.core.Point;

public class Rectangle extends Shape {
    private Point topLeft;
    private double width;
    private double height;

    public Rectangle(Point topLeft, double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Стороны прямоугольника должны быть положительными");
        }
        this.topLeft = topLeft;
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public String toString() {
        return String.format("Прямоугольник с верхним левым углом %s, шириной %.2f и высотой %.2f", topLeft, width, height);
    }
}
