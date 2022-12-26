/**
 * Телефонный справочник
 */

package homeWork5;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private static HashMap<String, ArrayList<String>> phoneNumbers = new HashMap<>();

    public void add (String name, String number) {
        if(phoneNumbers.containsKey(name)) {
            phoneNumbers.get(name).add(number);
        } else {
            ArrayList<String> values = new ArrayList<>();
            values.add(number);
            phoneNumbers.put(name,values);
        }
    }

    public ArrayList<String> find(String name) {
        if(phoneNumbers.containsKey(name)) {
            return phoneNumbers.get(name);
        }
        return new ArrayList<String>();
    }
}

/**
 * Список сотрудников
 */

package homeWork5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class ListOfEmplooyes {
    private static HashMap<String, ArrayList<String>> people = new HashMap<>();

    public void add (String firstName, String lastName) {
        if(people.containsKey(firstName)) {
            people.get(firstName).add(lastName);
        } else {
            ArrayList<String> values = new ArrayList<>();
            values.add(lastName);
            people.put(firstName,values);
        }
    }
    public static void getListOfEmplooyes() {
        String[] arrayNames = new String[people.size()];
        people.keySet().toArray(arrayNames);
        int[] arraySizeNames = new int[people.size()];
        for (int i = 0; i < arrayNames.length; i++) {
            int sizeName = people.get(arrayNames[i]).size();
            arraySizeNames[i] = sizeName;
        }
        boolean isSorted = false;
        int valueNumber;
        String valueName;
        while(!isSorted) {
            isSorted = true;
            for (int i = 0; i < arraySizeNames.length-1; i++) {
                if(arraySizeNames[i] < arraySizeNames[i+1]){
                    isSorted = false;

                    valueNumber = arraySizeNames[i];
                    arraySizeNames[i] = arraySizeNames[i+1];
                    arraySizeNames[i+1] = valueNumber;
                    valueName = arrayNames[i];
                    arrayNames[i] = arrayNames[i+1];
                    arrayNames[i+1] = valueName;
                }
            }
        }
        for (int i = 0; i < arrayNames.length; i++) {
            System.out.println("Имя " + arrayNames[i] + " повторяется " + arraySizeNames[i] + " раз(а)");
            for (int j = 0; j < arraySizeNames[i]; j++) {
                System.out.print(arrayNames[i]+ " ");
                String[] arrayLastName = new String[arraySizeNames[i]];
                people.get(arrayNames[i]).toArray(arrayLastName);
                System.out.println(arrayLastName[j]);
            }
        }
    }

}

/**
 * Пирамидальная сортировка
 */

package homeWork5;

public class HeapSort {
    public void sort(int arr[]) {
        int n = arr.length;
        // Построение кучи (перегруппируем массив)
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);
        // Один за другим извлекаем элементы из кучи
        for (int i=n-1; i>=0; i--) {
            // Перемещаем текущий корень в конец
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            // Вызываем процедуру heapify на уменьшенной куче
            heapify(arr, i, 0);
        }
    }

// Процедура для преобразования в двоичную кучу поддерева с корневым узлом i, что является
// индексом в arr[]. n - размер кучи
    void heapify(int arr[], int n, int i) {
        int largest = i; // Инициализируем наибольший элемент как корень
        int l = 2*i + 1; // левый = 2*i + 1
        int r = 2*i + 2; // правый = 2*i + 2
        // Если левый дочерний элемент больше корня
        if (l < n && arr[l] > arr[largest])
            largest = l;
        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (r < n && arr[r] > arr[largest])
            largest = r;
        // Если самый большой элемент не корень
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;
            // Рекурсивно преобразуем в двоичную кучу затронутое поддерево
            heapify(arr, n, largest);
        }
    }

    /* Вспомогательная функция для вывода на экран массива размера n */
    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i=0; i<n; ++i)
            System.out.print(arr[i]+" ");
        System.out.println();
    }
}




package homeWork5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import static homeWork5.ChessBoard.createBoard;
import static homeWork5.HeapSort.printArray;
import static homeWork5.ListOfEmplooyes.getListOfEmplooyes;

public class Main {
    public static void main(String[] args) {
//        personPhoneNumber();
//        emplooyes();
//        getHeapSort();
    }

    /**
     * 1. Реализуйте структуру телефонной книги с помощью HashMap, учитывая,
     * что 1 человек может иметь несколько телефонов.
     */
    public static void personPhoneNumber() {
        PhoneBook people = new PhoneBook();
        people.add("Соловьев Сергей", "89502321456");
        people.add("Козлова Анна", "89826234561");
        people.add("Козлова Анна", "89825234432");
        people.add("Сергеев Леонид", "89045654321");
        people.add("Васильев Петя", "89765345678");

        System.out.println(people.find("Козлова Анна"));
    }

    /**
     * Пусть дан список сотрудников:
     * Написать программу, которая найдет и выведет повторяющиеся имена
     * с количеством повторений. Отсортировать по убыванию популярности.
     */
    private static void emplooyes() {
        ListOfEmplooyes people = new ListOfEmplooyes();
        people.add("Иван", "Иванов");
        people.add("Светлана", "Петрова");
        people.add("Кристина", "Белова");
        people.add("Анна", "Мусина");
        people.add("Анна", "Крутова");
        people.add("Иван", "Юрин");
        people.add("Петр", "Лыков");
        people.add("Павел", "Чернов");
        people.add("Петр", "Чернышов");
        people.add("Мария", "Федорова");
        people.add("Марина", "Светлова");
        people.add("Мария", "Савина");
        people.add("Мария", "Рыкова");
        people.add("Марина", "Лугова");
        people.add("Анна", "Владимирова");
        people.add("Иван", "Мечников");
        people.add("Петр", "Петин");
        people.add("Иван", "Ежов");

        getListOfEmplooyes();
    }

    /**
     * Реализовать алгоритм пирамидальной сортировки (HeapSort)
     */
    public static void getHeapSort() {
        int arr[] = {13, 565, 565, 45, 58, 12, 869, 356, 56};
        HeapSort ob = new HeapSort();
        ob.sort(arr);
        System.out.println("Sorted array is");
        printArray(arr);
    }
}

/**
 * Шахматная доска
 */

package homeWork5;

import java.util.Random;

public class ChessBoard {
    public static void main(String[] args) {
        createBoard();
    }

    public static void createBoard() {
        String[][] array = new String[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                array[i][j] = " 0 ";
            }
        }
        Random rand = new Random();
        for (int i = 0; i < 8;) {
            int line = rand.nextInt(8);
            int column = rand.nextInt(8);
            int counter = 0;
            for (int j = 0; j < 8 && counter == 0; j++) {
                if (array[line][j].equals(" 1 ")) {
                    counter = 1;
                }
                if (array[j][column].equals(" 1 ")) {
                    counter = 1;
                }
            }
            if (counter == 0) {
                array[line][column] = " 1 ";
                i++;
            }
        }
        showArrayForChessBoard(array);
    }

    public static void showArrayForChessBoard(String[][] array){
        for (int i = 0; i < 8; i++) {
            System.out.println();
            for (int j = 0; j < 8; j++) {
                System.out.print(array[i][j]);
            }
        }
    }
}