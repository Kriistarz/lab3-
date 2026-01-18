package ru.ruazanova.main;

import ru.ruazanova.core.Point;
import ru.ruazanova.lines.ClosedPolyline;
import ru.ruazanova.lines.HasLength;
import ru.ruazanova.lines.Line;
import ru.ruazanova.lines.Polyline;
import ru.ruazanova.shapes.*;
import ru.ruazanova.structures.Node;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nВыберите задание для запуска:");
            System.out.println("1 — Задание 1.3.1");
            System.out.println("2 — Задание 1.3.2");
            System.out.println("3 — Задание 1.3.3");
            System.out.println("4 — Задание 2.4");
            System.out.println("5 — Задание 3.2");
            System.out.println("6 — Задание 4.4");
            System.out.println("7 — Задание 5.5");
            System.out.println("8 — Задание 5.7");
            System.out.println("9 — Задание 6.4");
            System.out.println("10 — Задание 7.3");
            System.out.println("11 — Задание 8.4");
            System.out.println("0 — Выход");
            System.out.print("Введите номер: ");

            int choice = scanner.nextInt();
            System.out.println();

            if (choice == 0) {
                System.out.println("Выход из программы...");
                break;
            }

            switch (choice) {
                case 1:
                    System.out.println("Задание 1.3.1");
                    testSquare();
                    break;
                case 2:
                    System.out.println("Задание 1.3.2");
                    testCreateSquareWithNegativeSideLength();
                    break;
                case 3:
                    System.out.println("Задание 1.3.3");
                    testChangeSquareSideLengthToNegative();
                    break;
                case 4:
                    System.out.println("Задание 2.4");
                    testNode();
                    break;
                case 5:
                    System.out.println("Задание 3.2");
                    testClosedPolyline();
                    break;
                case 6:
                    System.out.println("Задание 4.4");
                    testFigures();
                    break;
                case 7:
                    System.out.println("Задание 5.5");
                    testGetLength();
                    break;
                case 8:
                    System.out.println("Задание 5.7");
                    testPolylinesUtils();
                    break;
                case 9:
                    System.out.println("Задание 6.4");
                    testEquals();
                    break;
                case 10:
                    System.out.println("Задание 7.3");
                    testPowerCalculator();
                    break;
                case 11:
                    System.out.println("Задание 8.4");
                    testPointClone();
                    break;
                default:
                    System.out.println("Неверный выбор! Попробуйте снова.");
            }

            System.out.println("\n------------------------------------------");
        }

        scanner.close();
    }

    public static void testPointClone() {
        Point p1 = new Point(5, 10);
        Point p2 = p1.clone();

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);

        System.out.println("p1 == p2? " + (p1 == p2));
        System.out.println("p1.equals(p2)? " + p1.equals(p2));

        p2.shift(3, -2);

        System.out.println("После изменения p2:");
        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
    }

    public static void testPowerCalculator() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите X: ");
        String xStr = scanner.nextLine();

        System.out.print("Введите Y: ");
        String yStr = scanner.nextLine();

        double result = PowerCalculator.powFromStrings(xStr, yStr);

        System.out.println("Результат: " + result);
    }

    public static void testEquals() {
        Polyline a = new Polyline(List.of(new Point(1, 1), new Point(2, 2)));
        Polyline b = new Polyline(List.of(new Point(1, 1), new Point(2, 2)));
        Polyline c = new Polyline(List.of(new Point(2, 2), new Point(1, 1)));

        System.out.println(a.equals(b));
        System.out.println(a.equals(c));
    }

    public static void testPolylinesUtils() {
        Line line = new Line(new Point(0, 0), new Point(3, 4));
        Square square = new Square(new Point(5, 5), 2);
        Triangle triangle = new Triangle(
                new Point(10, 10),
                new Point(12, 10),
                new Point(11, 12)
        );

        Polyline merged = PolylineUtils.merge(List.of(line, square, triangle));
        System.out.println(merged);
    }

    public static void testGetLength() {
        Polyline polyline = new Polyline(
            List.of(new Point(1, 1), new Point(9, 16), new Point(8, 3))
        );

        ClosedPolyline closedPolyline = new ClosedPolyline(
            List.of(new Point(8, 1), new Point(9, 12), new Point(10, 6))
        );

        Line line = new Line(
            new Point(0, 0), new Point(10, 10)
        );

        List<HasLength> lines = List.of(polyline, closedPolyline, line);

        LengthsSum lengthsSum = new LengthsSum(lines);
        System.out.print("Сумма длин до добавления еще одного объекта с длиной: ");
        System.out.println(lengthsSum.getSum());

        lengthsSum.addLength(new Line(new Point(13, 9), new Point(7, 1)));
        System.out.print("Сумма длин после добавления еще одного объекта с длиной: ");
        System.out.println(lengthsSum.getSum());
    }


    public static void testFigures() {
        Circle circle = new Circle(new Point(5, 6), 14);
        Square square = new Square(new Point(7, 1), 11);
        Rectangle rectangle = new Rectangle(new Point(3, 9), 7, 10);
        Triangle triangle = new Triangle(new Point(0, 4), new Point(8, 11), new Point(5, 10));

        List<Shape> figures = List.of(circle, square, rectangle, triangle);

        for (Shape shape : figures) {
            System.out.println(shape.getArea());
        }
    }

    public static void testClosedPolyline() {
        Point p1 = new Point(1, 5);
        Point p2 = new Point(2, 8);
        Point p3 = new Point(5, 3);

        ClosedPolyline cpl = new ClosedPolyline(List.of(p1, p2, p3));
        Polyline pl = new Polyline(List.of(p1, p2, p3));

        System.out.print("Длина замкнутой линии: ");
        System.out.println(cpl.getLength());

        System.out.print("Длина обычной линии: ");
        System.out.println(pl.getLength());
    }

    public static void testNode() {
        Node root = new Node();
        int[] numbers = {3, 5, 4, 7, 1, 2};

        for (int num : numbers) {
            root.addValue(num);
        }

        System.out.println(root);
    }


    public static void testChangeSquareSideLengthToNegative() {
        System.out.println("Пробуем изменить сторону квадрата на отрицательное значение");
        Square s = new Square(new Point(5, 3), 20);
        System.out.println(s);
        s.setSideLength(-10);
    }

    public static void testCreateSquareWithNegativeSideLength() {
        System.out.println("Создаем квадрат с отрицательной стороной");
        Square s = new Square(new Point(5, 3), -20);
        System.out.println(s);
    }

    public static void testSquare() {
        Square s = new Square(new Point(5, 3), 23);
        Polyline pl = s.getPolyline();

        System.out.print("Длина до сдвига точки: ");
        System.out.println(pl.getLength());

        pl.shiftPointByIndexTo(3, new Point(15, 25));

        System.out.print("Длина после сдвига точки: ");
        System.out.println(pl.getLength());
    }
}