package ru.ruazanova.shapes;

import ru.ruazanova.core.Point;
import ru.ruazanova.lines.HasPolyline;
import ru.ruazanova.lines.Polyline;

import java.util.List;

public class Triangle extends Shape implements HasPolyline {
    private Point point1, point2, point3;

    public Triangle(Point point1, Point point2, Point point3) {
        this.point1 = point1;
        this.point2 = point2;
        this.point3 = point3;
    }

    @Override
    public double getArea() {
        double a = point1.distanceTo(point2);
        double b = point2.distanceTo(point3);
        double c = point3.distanceTo(point1);
        double s = (a + b + c) / 2;
        return Math.sqrt(s * (s - a) * (s - b) * (s - c));
    }

    @Override
    public String toString() {
        return String.format("Треугольник с точками %s, %s, %s", point1, point2, point3);
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(List.of(point1, point2, point3, point1));
    }
}
