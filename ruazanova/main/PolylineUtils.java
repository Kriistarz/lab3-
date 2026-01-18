package ru.ruazanova.main;

import ru.ruazanova.core.Point;
import ru.ruazanova.lines.HasPolyline;
import ru.ruazanova.lines.Polyline;

import java.util.ArrayList;
import java.util.List;

public class PolylineUtils {
    public static Polyline merge(List<HasPolyline> objects) {
        List<Point> mergedPoints = new ArrayList<>();

        for (HasPolyline obj : objects) {
            mergedPoints.addAll(obj.getPolyline().getPoints());
        }

        return new Polyline(mergedPoints);
    }
}
