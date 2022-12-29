package homework6;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class main {

    public static void main(String[] args) {
        Set<Laptop> laptops = new HashSet<>();

        laptops.add(new Laptop("Xiaomi RedmiBook 15 JYU4525RU", 256, "Windows 11 Домашняя"));

        laptops.add(new Laptop("ASUS VivoBook 14 F415EA-UB34", 128, "Windows 10 Домашняя S-режим"));

        laptops.add(new Laptop("HP 15-dy2067ms 4W2K2UA", 256, "Windows 11 Домашняя S-режим"));

        laptops.add(new Laptop("HUAWEI MateBook D 15 BoM-WFQ9 5500U/16+512 Mystic Silver", 512, "Windows 11 Домашняя"));

        laptops.add(new Laptop("Thunderobot 911 Air D (JT0098E06RU)", 256, "не установлена"));

        System.out.println("===== Первый фильтр =====");
        Map<Object, Set<Laptop>> filteredLaptops = Laptop.filterByProperty(laptops);
        print(filteredLaptops);

        System.out.println("===== Второй фильтр =====");
        Map<Object, Set<Laptop>> filteredLaptops2 = Laptop.filterByMinValue(laptops);
        print(filteredLaptops2);
    }

    private static void print(Map<Object, Set<Laptop>> map) {
        for (Map.Entry<Object, Set<Laptop>> entry : map.entrySet()) {
            System.out.println(entry);
            System.out.println();
        }
    }
}



package homework6;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Laptop {

    private String name;
    private int hardDrive;
    private String operatingSystem;

    public Laptop(String name,int hardDrive, String operatingSystem) {
        this.name = name;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
    }
    public String getName() {
        return this.name;
    }
    public int getHardDrive() {
        return this.hardDrive;
    }
    public String getOperatingSystem() {
        return this.operatingSystem;
    }

    @Override
    public String toString() {
        return "LAPTOP [NAME=" + this.name + ", HARDDRIVE=" + this.hardDrive + ", OS=" + this.operatingSystem;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((this.name == null) ? 0 : name.hashCode());
        result = prime * result + this.hardDrive;
        result = prime * result + ((this.operatingSystem == null) ? 0 : this.operatingSystem.hashCode());
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Laptop other = (Laptop) obj;
        if (this.name == null) {
            if (other.name != null)
                return false;
        } else if (!this.name.equals(other.name))
            return false;
        if (this.hardDrive != other.hardDrive)
            return false;
        if (this.operatingSystem == null) {
            if (other.operatingSystem != null)
                return false;
        } else if (!this.operatingSystem.equals(other.operatingSystem))
            return false;
        return true;
    }

    public static Map<Object, Set<Laptop>> filterByProperty(Set<Laptop> laptops) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - объём жёсткого диска,");
        System.out.println("2 - операционная система,");

        String code = sc.nextLine();
        System.out.println();

        Map<Object, Set<Laptop>> result = new TreeMap<>();

        if (code.equals("1")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.hardDrive)) {
                    result.get(laptop.hardDrive).add(laptop);
                } else {
                    Object key = (Object) laptop.hardDrive;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.hardDrive).add(laptop);
                }
            }
        } else if (code.equals("2")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.operatingSystem)) {
                    result.get(laptop.operatingSystem).add(laptop);
                } else {
                    Object key = (Object) laptop.operatingSystem;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.operatingSystem).add(laptop);
                }
            }
        } else {
            System.out.println("Ошибка ввода!");
        }

        return result;
    }

    public static Map<Object, Set<Laptop>> filterByMinValue(Set<Laptop> laptops) {
        System.out.println("Введите цифру, соответствующую необходимому критерию:");
        System.out.println("1 - объём жёсткого диска,");

        String code = sc.nextLine();
        System.out.println();

        Map<Object, Set<Laptop>> result = new TreeMap<>();

        if (code.equals("1")) {
            for (Laptop laptop : laptops) {
                if (result.containsKey(laptop.hardDrive)) {
                    result.get(laptop.hardDrive).add(laptop);
                } else {
                    Object key = (Object) laptop.hardDrive;
                    result.put(key, new HashSet<Laptop>());
                    result.get(laptop.hardDrive).add(laptop);
                }
            }
        } else {
            System.out.println("Ошибка ввода!");
            return result;
        }
        return result;
    }

    private static Map<Object, Set<Laptop>> getMinValueFloat(Map<Object, Set<Laptop>> result) {
        System.out.println("Введите минимальное значение (дробная часть при наличии должна быть отделена запятой):");

        final Float minValue;
        try {
            minValue = sc.nextFloat();
            System.out.println();
        } catch (InputMismatchException ime) {
            System.out.println();
            System.out.println("Ошибка ввода!");
            return result;
        }

        result = result.entrySet().stream()
                .filter(map -> (Float) map.getKey() >= minValue)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return result;
    }

    private static Map<Object, Set<Laptop>> getMinValueInteger(Map<Object, Set<Laptop>> result) {
        System.out.println("Введите минимальное значение (целое число):");

        final Integer minValue;
        try {
            minValue = sc.nextInt();
            System.out.println();
        } catch (InputMismatchException ime) {
            System.out.println();
            System.out.println("Ошибка ввода!");
            return result;
        }

        result = result.entrySet().stream()
                .filter(map -> (Integer) map.getKey() >= minValue)
                .collect(Collectors.toMap(map -> map.getKey(), map -> map.getValue()));

        return result;
    }



    private static Scanner sc = new Scanner(System.in);
}