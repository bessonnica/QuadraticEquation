package util;

/**
 * Класс предназначен для решения квадратного уравнения
 */
import java.util.Scanner;

import static java.lang.Math.abs;
import static java.lang.Math.pow;
import static java.lang.Math.sqrt;

public class Main {
    private static double EPS = 1.0E-8D;

    public Main() {
    }

    private static void solve(double a, double b, double c) {
        String aLotOfSolutions = "Уранение имеет бесконечное множество решений";
        String noSolution = "Уравнение не имеет решения";
        String linearEquation = "Линейное уравнение имеет одно решение: ";
        String twoEqualsRoots = "Уранение имеет два кратных корня: ";
        String twoRoots = "Уравнение имеет два разных корня: ";
        if(abs(a) < EPS) {
            if(abs(b) < EPS) {
                if(abs(c) < EPS) { // a = 0, b = 0, c = 0 -> x - любое
                    System.out.println(aLotOfSolutions);
                } else { // a = 0, b = 0, c != 0 -> уравнение не имеет решений
                    System.out.println(noSolution);
                }
            } else { // a = 0, b != 0, c != 0 -> линейное уравнение, один корень
                System.out.println(linearEquation + "x = " + -c / b);
            }
        } else if(abs(b) < EPS && abs(c) > EPS) { // a != 0, b = 0, c != 0 -> неполное квадратное уравнение
            if(-c / a > EPS) { // извлечение корня возможно, только если подкоренное выражение больше ноля
                double[] D1 = new double[]{sqrt(abs(c / a)), -sqrt(abs(c / a))};
                System.out.println(twoRoots + "x1 = " + D1[0] + ", x2 = " + D1[1]);
            } else {
                System.out.println(noSolution);
            }
        } else { // a != 0, b != 0, c != 0 - квадратное уравнение, находим дискриминант и корни
            double D = pow(b, 2.0D) - 4.0D * a * c;
            double[] x;
            if(abs(D) < EPS) {
                x = new double[]{-b / (2.0D * a)};
                System.out.println(twoEqualsRoots + "x1 = x2 = " + x[0]);
            } else if(abs(D) > EPS) {
                x = new double[]{(-b + sqrt(D)) / (2.0D * a), (-b - sqrt(D)) / (2.0D * a)};
                System.out.println(twoRoots + "x1 = " + x[0] + ", x2 = " + x[1]);
            } else {
                System.out.println(noSolution);
            }
        }

    }

    public static void main(String[] args) {
        System.out.println("Введите параметры уравнения a b c:");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) {
            solve(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        }

    }
}
