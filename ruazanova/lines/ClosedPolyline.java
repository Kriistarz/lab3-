package ru.ruazanova.lines;

import ru.ruazanova.core.Point;

import java.util.List;

public class ClosedPolyline extends Polyline implements HasLength {

    public ClosedPolyline(List<Point> points) {
        super(points);
    }

    public ClosedPolyline() {
        super();
    }

    @Override
    public double getLength() {
        double length = super.getLength();

        if (super.getPoints().size() > 1) {
            Point first = super.getPoints().getFirst();
            Point last = super.getPoints().getLast();

            double dx = last.getX() - first.getX();
            double dy = last.getY() - first.getY();

            length += Math.sqrt(dx * dx + dy * dy);
        }

        return length;
    }
}
