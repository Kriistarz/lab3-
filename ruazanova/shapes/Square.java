package ru.ruazanova.shapes;

import ru.ruazanova.core.Point;
import ru.ruazanova.lines.HasPolyline;
import ru.ruazanova.lines.Polyline;

import java.util.List;

public class Square extends Shape implements HasPolyline {
    private Point topLeftPoint;
    private int sideLength;

    public Square(Point point, int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны не может быть отрицательной");
        }

        this.topLeftPoint = point;
        this.sideLength = sideLength;
    }

    public Square(int x, int y, int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны не может быть отрицательной");
        }

        this.topLeftPoint = new Point(x, y);
        this.sideLength = sideLength;
    }

    public int getSideLength() {
        return sideLength;
    }

    public void setSideLength(int sideLength) {
        if (sideLength <= 0) {
            throw new IllegalArgumentException("Длина стороны не может быть отрицательной");
        }
        this.sideLength = sideLength;
    }

    @Override
    public Polyline getPolyline() {
        int x = topLeftPoint.getX();
        int y = topLeftPoint.getY();

        Point p1 = topLeftPoint;
        Point p2 = new Point(x + sideLength, y);
        Point p3 = new Point(x + sideLength, y + sideLength);
        Point p4 = new Point(x, y + sideLength);
        Point p5 = p1;

        return new Polyline(List.of(p1, p2, p3, p4, p5));
    }

    @Override
    public String toString() {
        return String.format("Квадрат в точке %s со стороной %d", topLeftPoint.toString(), sideLength);
    }

    @Override
    public double getArea() {
        return sideLength * sideLength;
    }
}
