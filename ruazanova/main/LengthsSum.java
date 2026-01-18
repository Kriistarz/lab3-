package ru.ruazanova.main;

import ru.ruazanova.lines.HasLength;

import java.util.List;

public class LengthsSum {
    private double sum = 0.0;

    public LengthsSum() {  }

    public LengthsSum(List<HasLength> lines) {
        this.sum = getSum(lines);
    }

    public double getSum() {
        return sum;
    }

    public double getSum(List<HasLength> lines) {
        clearSum();
        for (HasLength line : lines) {
            sum += line.getLength();
        }
        return sum;
    }

    public void addLength(List<HasLength> lines) {
        for (HasLength line : lines) {
            sum += line.getLength();
        }
    }

    public void addLength(HasLength line) {
        sum += line.getLength();
    }

    public void clearSum() {
        sum = 0.0;
    }
}
