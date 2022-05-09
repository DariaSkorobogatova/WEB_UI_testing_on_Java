package Homework_4;

public class Triangle {
    public Triangle() {
    }

    public static double triangleArea (int a, int b, int c) throws MyException {
        if (a < 0 || b < 0 || c < 0) throw new MyException("Сторона треугольника не может быть отрицательной длины");
        if (a == 0 || b == 0 || c == 0) throw new MyException("Сторона треугольника не может быть нулевой длины");
        if (a + b < c || b + c < a || a + c < b) throw new MyException("Указанные значения не могут сформировать треугольник");
        // Расчет площади треугольника по формуле Герона
        double p = (a + b + c) / 2.0; // полупериметр треугольника
        double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
        return s;
    }
}
