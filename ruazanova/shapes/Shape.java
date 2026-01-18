package ru.ruazanova.shapes;

public abstract class Shape {
    public abstract double getArea();

    @Override
    public String toString() {
        return getClass().getSimpleName();
    }
}
