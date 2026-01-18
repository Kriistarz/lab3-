package ru.ruazanova.lines;

import ru.ruazanova.core.Point;

import java.util.ArrayList;
import java.util.List;

public class Polyline implements HasLength, HasPolyline {
    private ArrayList<Point> points = new ArrayList<>();

    public Polyline(List<Point> points) {
        this.points = new ArrayList<>(points);
    }

    public Polyline() {
        this.points = new ArrayList<>();
    }

    public ArrayList<Point> getPoints() {
        return points;
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void shiftPointByIndexTo(int index, Point point) {
        points.get(index).shiftTo(point);
    }

    public void shiftPointByIndexTo(int index, int x, int y) {
        points.get(index).shiftTo(new Point(x, y));
    }

    public double getLength() {
        double length = 0.0;

        for (int i = 1; i < points.size(); i++) {
            Point point1 = points.get(i - 1);
            Point point2 = points.get(i);

            double dx = point2.getX() - point1.getX();
            double dy = point2.getY() - point1.getY();

            length += Math.sqrt(dx * dx + dy * dy);
        }

        return length;
    }


    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("Линия [");

        for (int i = 0; i < points.size(); i++) {
            result.append(points.get(i).toString());
            if (i < points.size() - 1) {
                result.append(", ");
            }
        }

        result.append("]");
        return result.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null || !(obj instanceof Polyline)) {
            return false;
        }

        Polyline other = (Polyline) obj;

        return this.points.equals(other.points);
    }

    @Override
    public Polyline getPolyline() {
        return this;
    }
}
