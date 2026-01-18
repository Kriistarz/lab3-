package ru.ruazanova.lines;

import ru.ruazanova.core.Point;

import java.util.List;

public class Line implements HasLength, HasPolyline {
    private Point start;
    private Point end;

    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Line(int x1, int y1, int x2, int y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    public double getLength() {
        int dx = end.getX() - start.getX();
        int dy = end.getY() - start.getY();
        return Math.sqrt(dx * dx + dy * dy);
    }

    @Override
    public String toString() {
        return String.format("Линия от %s, до %s", start, end);
    }

    @Override
    public Polyline getPolyline() {
        return new Polyline(List.of(start, end));
    }
}
