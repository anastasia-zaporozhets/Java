package homeWork4
import java.util.Scanner;


import Worker.*;
public class Presenter{

    public void addPersonaToDepartment(Persona persona, Group group){
        boolean check = persona.checkAddGroup(group);
        if (check) {
            group.addPeople(persona);
        } else {
            System.out.println("Олень отказался!");
        }
    }

    public String UpdateDepint()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("В какой отдел желаете перейти?");
        System.out.println("IT\nLogistics\nFinance");
        String answer1 = in.next();
        return answer1;
        }

        public void AddPersona(){ 
            Scanner in = new Scanner(System.in);
            System.out.println("-".repeat(25));
            System.out.println("Сортировка по параметру:");
            System.out.println("ФИО работника: ");
            String FIO = in.nextLine();
            System.out.println("ПОЛ работника: ");
            String Sex = in.nextLine();
            System.out.println("Возраст работника: ");
            int Age = in.nextInt();  
        Persona p = new Persona(FIO, Sex, Age);
        Group depAcc1 = new Group("Accounting");
        addPersonaToDepartment(p, depAcc1);
        depView(depAcc1);
        }

        public void UppdateDep(){
            System.out.println("Введите ваши данные");
            Scanner in = new Scanner(System.in);
            System.out.println("ФИО работника: ");
            String FIO = in.nextLine();
            System.out.println("ПОЛ работника: ");
            String Sex = in.nextLine();
            System.out.println("Возраст работника: ");
            int Age = in.nextInt();  
            Persona p = new Persona(FIO, Sex, Age);
            Group depAcc1 = new Group(UpdateDepint());
            addPersonaToDepartment(p, depAcc1);
            depView(depAcc1);
        
        }

        public  void depView(Group root){
            System.out.println("Название отдела" +" "+ root.deptName);
            for (var a: root.GetDep()) {
                System.out.println(a.getpFIO()+ " " + a.getpSex()+ " " + a.getpAge());
            }
        }

    }

    public class Main {
        public static void main(String[] args) {
            new App().start();
        }
    }

    public class App {
        public void start()  {
            StringBuilder sb = new StringBuilder()
                    .append("\n ==== \n")
                    .append("1- добавить работника\n")
                    .append("2 - поменять отдел\n")
                    .append("3 - показать отдел\n")
                    .append("0 - выход\n");           
    ConsoleView ui=new ConsoleView();
    Presenter p =new Presenter();
            while (true) {
                ui.set(sb.toString());
                switch (ui.get()) {
                    case "1":
                        p.AddPersona();
                        break;
                    case "2":
                        p.UppdateDep();
                        break;          
                    case "0":
                        break;
                }
            }
        }
    
        
        
    }

    import java.util.Scanner;

    public class ConsoleView {
        Scanner in = new Scanner(System.in);
    
        public String get() {
            return in.next();
        };
    
        public void set(String value) {
            System.out.println(value);
    
        }
    }



    import java.util.Scanner;


public class Persona {
    String pFIO;
    String pSex;
    int pAge;

    public Persona(String p_FIO, String p_Sex, int p_Age){
        this.pFIO = p_FIO;
        this.pSex = p_Sex;
        this.pAge = p_Age;
    }

    public String getpFIO() {
        return pFIO;
    }
    public String getpSex() {
        return pSex;
    }
    public int getpAge() {
        return pAge;
    }

    public boolean checkAddGroup(Group group){
        System.out.println("Добавить в группу " + group.deptName + "?");
        Scanner in = new Scanner(System.in);
        System.out.println("0 - НЕТ\n1 - ДА");
        int choice = in.nextInt();
        return choice != 0;
    }

    public void Display(){
        System.out.println("ФИО:"+ getpFIO() +" "+ "Пол:"+ getpSex()+" "+ "Возраст:"+ getpAge());
    }

}



public class Group extends Department {
    
    public Group(String GropName){
        setDeptName(GropName);
    }

    public void addPeople(Persona persona){
        personaInDept.add(persona);
    }
  

}


import java.util.ArrayList;


public class Department {
    public String deptName;
    ArrayList<Persona> personaInDept = new ArrayList<>();
    
    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public ArrayList<Persona>  GetDep(){
        return personaInDept;
    }

}