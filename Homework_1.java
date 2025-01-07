import java.util.*;
import java.lang.Exception;

public class Homework_1 {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        try
        {
            while (homeWorkNumber());
        }
        catch (Exception e) {
            System.err.print(e);
        }
        finally {
            sc.close();
        }
    }
    static boolean homeWorkNumber() {
        try {
            int num = (int) getNumber("ДЗ №1. Выберите номер задания от 1 до 5: (0 для выхода)");
            switch (num) {
                case 0: return false;
                case 1:
                    number1();
                    break;
                case 2:
                    number2();
                    break;
                case 3:
                    number3();
                    break;
                case 4:
                    number4();
                    break;
                case 5:
                    number5();
                    break;
                default: return true;
            }
        }
        catch (InputMismatchException e) {
            System.err.print(e);
            System.out.println();
            return true;
        }
        return true;
    }

    static void number1(){
        double d1 = getNumber("Введите первое число");
        double d2 = getNumber("Введите второе число");
        if (d1 == d2) {
            System.out.println("Числа равны, повторить ввод? (y)");
            if (sc.next().equals("y")) {
                number1();
                return;
            }
        }
        System.out.println("Число " + (d1 > d2 ? d2 : d1) + " наименьшее");
    }

    static void number2(){
        double d1 = getNumber("Введите описываемое число");
        String s;
        if (d1 == 0) {
            s = " нулевое";
        }
        else{
            s = d1 > 0 ? " положительное" : " отрицательное";
        }
        s += d1 % 2 == 0 ? ", четное" : ", не четное";
        System.out.println("Число " + d1 + s);
    }

    static void number3(){
        for (int i=1; i < 11; i++){
            for(int j=1; j < 11; j++){
                System.out.printf("%2d x%2d =%2d ",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void number4(){
        System.out.println("Введите вид прогрессии (a - арифметическая/ g - геометрическая)");
        String s = sc.next();
        if (!s.equals("a") && !s.equals("g")) {
            System.out.println("Ошибка ввода");
            return;
        }
        double step = getNumber("Введите шаг прогрессии");
        int num = (int)getNumber("Введите количество чисел");
        double firstNum = getNumber("Введите первый элемент прогрессии");

        double summ = firstNum;
        double summprogr = firstNum;
        for (int i = 0; i < num - 1; i++) {
            System.out.println(summ);
            summ = s.equals("a") ? summ+step : summ*step;
            summprogr += summ;
        }
        System.out.println(summ);
        System.out.println("Сумма прогрессии: " + summprogr);
    }

    static void number5(){
        int year = (int)getNumber("Введите год");
        if ((year % 150 == 0) || (year % 4 == 0)) {
            System.out.println("Год високосный");
        }
        else {
            System.out.println("Год не вискососный");
        }
    }

    static double getNumber(String s) {
        System.out.println(s);
        if (sc.hasNextDouble()) {
            return sc.nextDouble();}
        else {
            sc.next();
            throw new InputMismatchException();
        }
    }
}