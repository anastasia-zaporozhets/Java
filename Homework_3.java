package homeWork3;

import java.util.*;

public class Main {
    public static void main(String[] args) {
//        int[] array = new int[10];
//        Random random = new Random();
//        for (int i = 0; i < array.length; i++) {
//            array[i] = random.nextInt(10);
//        }
//        System.out.println(Arrays.toString(array));
//        System.out.println(Arrays.toString(mergesort(array)));

//        delEvenNum();
        searchInArray();
    }

    /**
     * Реализовать алгоритм сортировки слиянием
     */
    public static int[] mergesort(int[] array1) {
        int[] buffer1 = Arrays.copyOf(array1, array1.length);
        int[] buffer2 = new int[array1.length];
        int[] result = mergesortInner(buffer1, buffer2, 0, array1.length);
        return result;
    }

    /**
     *
     * @param buffer1 Массив для сортировки.
     * @param buffer2 Буфер. Размер должен быть равен размеру buffer1.
     * @param startIndex Начальный индекс в buffer1 для сортировки.
     * @param endIndex Конечный индекс в buffer1 для сортировки.
     * @return
     */
    public static int[] mergesortInner(int[] buffer1, int[] buffer2, int startIndex, int endIndex) {
        if (startIndex >= endIndex - 1) {
            return buffer1;
        }

        // уже отсортирован.
        int middle = startIndex + (endIndex - startIndex) / 2;
        int[] sorted1 = mergesortInner(buffer1, buffer2, startIndex, middle);
        int[] sorted2 = mergesortInner(buffer1, buffer2, middle, endIndex);

        // Слияние
        int index1 = startIndex;
        int index2 = middle;
        int destIndex = startIndex;
        int[] result = sorted1 == buffer1 ? buffer2 : buffer1;
        while (index1 < middle && index2 < endIndex) {
            result[destIndex++] = sorted1[index1] < sorted2[index2]
                    ? sorted1[index1++] : sorted2[index2++];
        }
        while (index1 < middle) {
            result[destIndex++] = sorted1[index1++];
        }
        while (index2 < endIndex) {
            result[destIndex++] = sorted2[index2++];
        }
        return result;
    }

    /**
     * Пусть дан произвольный список целых чисел, удалить из него четные числа
     */
    public static void delEvenNum() {
        List<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(100);
            array.add(val);
        }
        System.out.println(Arrays.asList(array));
        for (int i = 0; i < array.size(); ) {
            if(array.get(i) % 2 == 0) {
                array.remove(i);
            } else {
                i++;
            }
        }
        System.out.println(Arrays.asList(array));
    }

    /**
     * Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.
     */
    public static void searchInArray() {
        List<Integer> array = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int val = random.nextInt(100);
            array.add(val);
        }
        System.out.println(Arrays.asList(array));
        int max = array.get(0);
        int min = array.get(0);
        int mean = 0;
        for (int i = 0; i < array.size(); i++) {
            if(array.get(i) > max) {
                max = array.get(i);
            }
            if(array.get(i) < min) {
                min = array.get(i);
            }
            mean = mean + array.get(i);
        }
        mean = mean / array.size();
        System.out.println("Максимальное число: " + max);
        System.out.println("Минимальное число: " + min);
        System.out.println("Среднее: " + mean);
    }
}