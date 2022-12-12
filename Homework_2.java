package homeWork2;

 import org.json.JSONArray;
 import org.json.JSONObject;
 import java.io.IOException;
 import java.util.Arrays;
 import java.util.logging.FileHandler;
 import java.util.logging.Logger;
 import java.util.logging.SimpleFormatter;

 public class Main
 {
     public static void main(String[] args)
     {
         //filterString();
         //bubbleSort();
         derivationOfGrades();
     }

     /**
      * Дана строка sql-запроса "select * from students where ".
      * Сформируйте часть WHERE этого запроса, используя StringBuilder.
      * Данные для фильтрации приведены ниже в виде json строки
      */
     public static void filterString()
     {
         JSONObject student = new JSONObject("{\"name\":\"Ivanov\", \"country\":\"Russia\", \"city\":\"Moscow\", \"age\":\"null\"}");
         String name = (String) student.get("name");
         String country = (String) student.get("country");
         String city = (String) student.get("city");
         System.out.println("select * from students where name = " + name + " and country = " + country + "and city = " + city);
     }

     /**
      * Реализуйте алгоритм сортировки пузырьком числового массива, результат после каждой итерации запишите в лог-файл
      */
     public static String bubbleSort()
     {
         Logger logger = Logger.getLogger(Main.class.getName());
         FileHandler fh = null;
         try {
             fh = new FileHandler("log.txt");
         } catch (IOException e) {
             throw new RuntimeException(e);
         }
         logger.addHandler(fh);
         SimpleFormatter sFormat = new SimpleFormatter();
         fh.setFormatter(sFormat);
         int[] array = new int[12];
         for (int i = 0; i < array.length; i++)
         {
             array[i] = ((int)(Math.random() * 10));
         }
         boolean isSorted = false;
         int value;
         while(!isSorted)
         {
             isSorted = true;
             for (int i = 0; i < array.length-1; i++)
             {
                 if(array[i] > array[i+1])
                 {
                     isSorted = false;
                     value = array[i];
                     array[i] = array[i+1];
                     array[i+1] = value;
                 }
                 logger.info(Arrays.toString(array));
             }
         }
         return Arrays.toString(array);
     }

     /**
      * Дана json строка (можно сохранить в файл и читать из файла)
      * Написать метод(ы), который распарсит json и, используя StringBuilder,
      * создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет]
      */
     public static void derivationOfGrades()
     {
         JSONArray students = new JSONArray("[" +
                 "{\"фамилия\":\"Иванов\",\"оценка\":\"5\",\"предмет\":\"Математика\"}," +
                 "{\"фамилия\":\"Петрова\",\"оценка\":\"4\",\"предмет\":\"Информатика\"}," +
                 "{\"фамилия\":\"Краснов\",\"оценка\":\"5\",\"предмет\":\"Физика\"}]");
         for (int i = 0; i < students.length(); i++)
         {
             StringBuilder lastName = new StringBuilder((String) students.getJSONObject(i).get("фамилия"));
             StringBuilder grade = new StringBuilder((String) students.getJSONObject(i).get("оценка"));
             StringBuilder subject = new StringBuilder((String) students.getJSONObject(i).get("предмет"));
             System.out.println("Студент(ка) " + lastName + " получил(а) " + grade + " по предмету " + subject);
         }
     }
 }