package homeWork1;

 import java.util.Scanner;

 public class Main {
     public static void main(String[] args) {
         //System.out.println(factorial(4));
         //outputOfPrimeNumber();
         //System.out.println(calculator());
     }

     /**
      * Вычислить n-ое треугольного число(сумма чисел от 1 до n), n! (произведение чисел от 1 до n/
      */
     public static int factorial(int n) {
         int result = 1;
         for (int i = 1; i <= n; i++) {
             result = result * i;
         }
         return result;
     }

     /**
      * Вывести все простые числа от 1 до 1000
      */
     public static void outputOfPrimeNumber() {
         int number = 1000;
         for (int i = 2; i < number; i++) {
             if(i == 2 || i == 3){
                 System.out.print(i + " ");
             }
             if(primeNumber(i) == true) {
                 System.out.print(i + " ");
             }
         }


     }
     public static boolean primeNumber(int n) {
         int j = 0;
         boolean result = false;
         for (int i = 2; i*i <= n && j != 1; i++) {
             if(n % i == 0) {
                 j = 1;
             }
             if(j == 1){
                 result = false;
             } else {
                 result = true;
             }
         }
         return result;
     }

     /**
      * Реализовать простой калькулятор
      */
     public static int calculator() {
         System.out.println("Введите число а: ");
         Scanner enterNumber = new Scanner(System.in);
         int a = enterNumber.nextInt();
         System.out.println("Введите число b: ");
         int b = enterNumber.nextInt();
         System.out.println("Введите действие (+,-,*,/): ");
         char c = enterNumber.next().charAt(0);
         if(c == '+') {
             return sum(a, b);
         } else if (c == '-') {
             return difference(a, b);
         } else if (c == '*') {
             return multiplication(a, b);
         } else if (c == '/') {
             return division(a, b);
         } else {
             System.out.println("Введены неверные знгачения");
             return 0;
         }
     }
     public static int sum(int a, int b) {
         return a+b;
     }
     public static int difference(int a, int b) {
         return a-b;
     }
     public static int multiplication(int a, int b) {
         return a*b;
     }
     public static int division(int a, int b) {
         return a/b;
     }

 }