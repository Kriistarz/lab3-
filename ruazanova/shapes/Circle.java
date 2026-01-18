package ru.ruazanova.shapes;

import ru.ruazanova.core.Point;

public class Circle extends Shape {
    private Point center;
    private double radius;

    public Circle(Point center, double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Радиус не может быть отрицательным или нулевым");
        }
        this.center = center;
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String toString() {
        return String.format("Круг с центром %s и радиусом %.2f", center, radius);
    }
}
