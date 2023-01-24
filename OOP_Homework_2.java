package homeWork2;
import java.util.HashMap;
import java.util.Map;
public class Main {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        map.put("Хороший ключ", "Переменная");

        // Инициализация нашего "иммутабельного" класса
        AlmostMutableClass almostMutable = new AlmostMutableClass("Это неизменяемый", map);
        MutableClass mutableClass = new MutableClass("Это изменяемый класс", map);

        // Мы не можем изменять состояние объекта через добавление элементов в полученную map
        System.out.println("Результат в неизменяемом классе после того, как мы получим map");
        almostMutable.getFieldMap().put("Плохой ключ", "Другое значение");
        almostMutable.getFieldMap().keySet().forEach(e -> System.out.println(e));

        System.out.println("Результат в изменяемом классе после того, как мы получим map");
        mutableClass.getFieldMap().put("Плохой ключ", "Другое значение");
        mutableClass.getFieldMap().keySet().forEach(e -> System.out.println(e));

        System.out.println("");
        System.out.println("Результат после изменения исходного map в неизменяемом классе");
        map.put("Иной ключ", "Иное значение");
        almostMutable.getFieldMap().keySet().forEach(e -> System.out.println(e));
        System.out.println("Результат после изменения исходного map в изменяемом классе");
        mutableClass.getFieldMap().keySet().forEach(e -> System.out.println(e));
    }
}