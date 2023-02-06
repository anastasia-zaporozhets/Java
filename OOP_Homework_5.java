package homeWork5;

import homeWork5.Service.Servise;
import homeWork5.View.ConsoleView;

import java.util.InputMismatchException;

public class MathController {
    private final Servise service = new Servise();
    private final ConsoleView consoleView = new ConsoleView();
    public void execute() throws InputMismatchException {
        while (true) {
            try {
                switch (consoleView.showMenu()) {
                    case 1 -> consoleView.showMathResult(service.sum(consoleView.enteringNumbers(), consoleView.enteringNumbers()));
                    case 2 -> consoleView.showMathResult(service.difference(consoleView.enteringNumbers(), consoleView.enteringNumbers()));
                    case 3 -> consoleView.showMathResult(service.multiplication(consoleView.enteringNumbers(), consoleView.enteringNumbers()));
                    case 4 -> consoleView.showMathResult(service.division(consoleView.enteringNumbers(), consoleView.enteringNumbers()));
                    case 5 -> System.exit(0);
                    default -> {
                        System.out.println("Вы ввели число не из диапозона от 1 до 4");
                        continue;
                    }
                }
                break;
            } catch (InputMismatchException ex) {
                System.out.println("Ошибка ввода данных. Введите число от 1 до 4");
            }
        }
    }
}

package homeWork5;

import homeWork5.Controller.MathController;

public class Main {
    public static void main(String[] args) {
        MathController mathController = new MathController();
        mathController.execute();
    }
}

package homeWork5;

public class MathResult {
    private final int result;
    public MathResult(int result) {
        this.result = result;
    }
    public int getResult() {
        return result;
    }
}

package homeWork5;

import homeWork5.Model.MathResult;
import homeWork5.Service.impls.MathOperations;

public class Servise implements MathOperations {
    public MathResult sum(int a, int b) {
        return new MathResult(a + b);
    }
    @Override
    public MathResult difference(int a, int b) {
        return new MathResult(a - b);
    }
    @Override
    public MathResult multiplication(int a, int b) {
        return new MathResult(a * b);
    }
    @Override
    public MathResult division(int a, int b) {
        return new MathResult(a / b);
    }
}

package homeWork5;
import homeWork5.Model.MathResult;

public interface MathOperations {
    MathResult sum(int a, int b);
    MathResult difference(int a, int b);
    MathResult multiplication(int a, int b);
    MathResult division(int a, int b);
}

package homeWork5;

import homeWork5.Model.MathResult;

public interface View {
    void showMathResult(MathResult result);
    Integer enteringNumbers();
    int showMenu();
}

package homeWork5;

import homeWork5.Model.MathResult;
import org.jetbrains.annotations.NotNull;

import java.util.Scanner;

public class ConsoleView {
    public Integer enteringNumbers() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите число: ");
        return scanner.nextInt();
    }
    public void showMathResult(@NotNull MathResult result) {
        System.out.printf("Результат: %s", result.getResult());
    }
    public int showMenu() {
        Scanner in = new Scanner(System.in);
        System.out.println("Какую операцию вы хотите: " + "\n");
        System.out.println("1.Сложение ");
        System.out.println("2.Вычитание ");
        System.out.println("3.Умножение ");
        System.out.println("4.Деление ");
        System.out.println("5.Выход ");
        return in.nextInt();
    }
}