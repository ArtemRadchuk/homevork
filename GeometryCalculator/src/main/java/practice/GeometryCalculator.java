package practice;

import java.awt.image.VolatileImage;

public class GeometryCalculator {

    // если значение radius меньше 0, метод должен вернуть -1
    public static double getCircleSquare(double radius) {
        if (radius >= 0) {
            double S = Math.PI * Math.pow(radius, 2);
            return S;
        } else {
            return -1.0;
        }
    }


    // если значение radius меньше 0, метод должен вернуть -1
    public static double getSphereVolume(double radius) {
        if (radius >= 0) {
            double V = 4 * (Math.PI * Math.pow(radius, 3)) / 3;
            return V;
        } else if (radius <= 0) {
            return -1;
        }
        return 0.0;
    }

    public static boolean isTrianglePossible(double a, double b, double c) {
        if (a > b && a > c && (b + c) > a) {
            return true;
        } else if (c > a && c > b && (a + b) > c) {
            return true;
        } else if (b > a && b > c && (a + c) > b) {
            return true;
        } else {
            return false;
        }
    }

    // перед расчетом площади рекомендуется проверить возможен ли такой треугольник
    // методом isTrianglePossible, если невозможен вернуть -1.0
    public static double getTriangleSquare(double a, double b, double c) {
        if (isTrianglePossible(a,b,c)) {
            double p = (a + b + c) / 2;
            double S = Math.sqrt(p * (p - a) * (p - b) * (p - c));
            return S;
        } else {
            return -1.0;
        }
    }
}
