package util;

/**
 * ����� ������������ ��� ������� ����������� ���������
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
        String aLotOfSolutions = "�������� ����� ����������� ��������� �������";
        String noSolution = "��������� �� ����� �������";
        String linearEquation = "�������� ��������� ����� ���� �������: ";
        String twoEqualsRoots = "�������� ����� ��� ������� �����: ";
        String twoRoots = "��������� ����� ��� ������ �����: ";
        if(abs(a) < EPS) {
            if(abs(b) < EPS) {
                if(abs(c) < EPS) { // a = 0, b = 0, c = 0 -> x - �����
                    System.out.println(aLotOfSolutions);
                } else { // a = 0, b = 0, c != 0 -> ��������� �� ����� �������
                    System.out.println(noSolution);
                }
            } else { // a = 0, b != 0, c != 0 -> �������� ���������, ���� ������
                System.out.println(linearEquation + "x = " + -c / b);
            }
        } else if(abs(b) < EPS && abs(c) > EPS) { // a != 0, b = 0, c != 0 -> �������� ���������� ���������
            if(-c / a > EPS) { // ���������� ����� ��������, ������ ���� ����������� ��������� ������ ����
                double[] D1 = new double[]{sqrt(abs(c / a)), -sqrt(abs(c / a))};
                System.out.println(twoRoots + "x1 = " + D1[0] + ", x2 = " + D1[1]);
            } else {
                System.out.println(noSolution);
            }
        } else { // a != 0, b != 0, c != 0 - ���������� ���������, ������� ������������ � �����
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
        System.out.println("������� ��������� ��������� a b c:");
        Scanner scanner = new Scanner(System.in);
        if(scanner.hasNext()) {
            solve(Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()), Double.parseDouble(scanner.next()));
        }

    }
}
