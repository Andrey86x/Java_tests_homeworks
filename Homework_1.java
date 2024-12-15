import java.util.*;

public class Homework_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try
        {
            while (homeWorkNumber(sc));
        }
        catch (java.lang.Exception e) {
            System.err.print(e);
        }
        finally {
            sc.close();
        }
    }
    static boolean homeWorkNumber(Scanner sc) {
        try {
            int num = (int) getNumber("ДЗ №1. Выберите номер задания от 1 до 5: (0 для выхода)", sc);
            switch (num) {
                case 0: return false;
                case 1:
                    number1(sc);
                    break;
                case 2:
                    number2(sc);
                    break;
                case 3:
                    number3(sc);
                    break;
                case 4:
                    number4(sc);
                    break;
                case 5:
                    number5(sc);
                    break;
                default: return true;
            }
        }
        catch (java.util.InputMismatchException e) {
            System.err.print(e);
            System.out.println();
            return true;
        }
        return true;
    }

    static void number1(Scanner sc){
        double d1 = getNumber("Введите первое число", sc);
        double d2 = getNumber("Введите второе число", sc);
        if (d1 == d2) {
            System.out.println("Числа равны, повторить ввод? (y)");
            if (sc.next().equals("y")) {
                number1(sc);
                return;
            }
        }
        System.out.println("Число " + (d1 > d2 ? d2 : d1) + " наименьшее");
    }

    static void number2(Scanner sc){
        double d1 = getNumber("Введите описываемое число", sc);
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

    static void number3(Scanner sc){
        for (int i=1; i < 11; i++){
            for(int j=1; j < 11; j++){
                System.out.printf("%2d x%2d =%2d ",i,j,i*j);
            }
            System.out.println();
        }
    }

    static void number4(Scanner sc){
        System.out.println("Введите вид прогрессии (a - арифметическая/ g - геометрическая)");
        String s = sc.next();
        if (!(s.equals("a")) && !(s.equals("g"))) {
            System.out.println("Ошибка ввода");
            return;
        }
        double step = getNumber("Введите шаг прогрессии", sc);
        int num = (int)getNumber("Введите количество чисел", sc);
        double firstNum = getNumber("Введите первый элемент прогрессии", sc);

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

    static void number5(Scanner sc){
        int year = (int)getNumber("Введите год", sc);
        if ((year % 150 == 0) || (year % 4 == 0)) {
            System.out.println("Год високосный");
        }
        else {
            System.out.println("Год не вискососный");
        }
    }

    static double getNumber(String s, Scanner sc) {
        System.out.println(s);
        if (sc.hasNextDouble()) return sc.nextDouble();
        else {
            sc.next();
            throw new java.util.InputMismatchException();
        }
    }
}