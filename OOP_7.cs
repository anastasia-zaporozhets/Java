using static EmployeePayTypeEnum;
public class SalesPersonal: Employee
    {
        public int SalesNumber { get; set; }
        public SalesPersonal() { }
        public SalesPersonal(string fullName, int age, int empId, float currPay, string ssn, int numbOfOpts) :
            base (fullName,age, empId,currPay,ssn, EmployeePayTypeEnumm.Salaried)
        { 
            SalesNumber = numbOfOpts;
        }
        public override void GiveBonus(float amount)
        {
            int salesBonus = 0;
            if(SalesNumber > 0 && SalesNumber <=100)
                salesBonus = 10;
            else
            {
                if (SalesNumber > 101 && SalesNumber <= 200)
                    salesBonus = 15;
                else
                    salesBonus = 20;
            }
           base.GiveBonus(amount * salesBonus);
        }
        public override void DisplayStats()
        {
            base.DisplayStats();
            Console.WriteLine("SalesNumbers: {0}", SalesNumber);
        }
    }

Manager manager =new Manager("Kolya",50,92,100000,"12-12-12",37);
manager.GiveBonus(300);
Console.WriteLine("Manager");
manager.DisplayStats();
Console.WriteLine("**********************");
SalesPersonal sales = new SalesPersonal("Ivan",23,35,80000,"12-13-12",31);
sales.GiveBonus(100);
Console.WriteLine("SalesPersonal");
sales.DisplayStats();

using static EmployeePayTypeEnum;
public class Manager:Employee
    {
        public int StockOptions { get; set; }
        public Manager() { }
        public Manager(string fullName, int age, int empId, float currPay, string ssn, int numbOfOpts):
            base(fullName,age, empId,currPay,ssn, EmployeePayTypeEnumm.Salaried)
        {
            StockOptions = numbOfOpts;
        }

        public override void GiveBonus(float amount)
        {
            base.GiveBonus(amount);
            Random r = new Random();
            StockOptions+=r.Next(500);
        }
        public override void DisplayStats()
        {
            base.DisplayStats();
            Console.WriteLine("StockOptions: {0}", StockOptions);
        }
    }

    public class EmployeePayTypeEnum{

          public enum EmployeePayTypeEnumm
        {
            Hourly,
            Salaried,
            Commission
        }

    }

    using static EmployeePayTypeEnum;
    public class Employee{
        private string _empName;
        private int _empId;
        private float _currPay;
        private int _age;
        private string _empSSN;
        private EmployeePayTypeEnumm _payType;

        public string SocialSecurityNumber
        {
           get { return _empSSN; }
           private set { _empSSN = value; }
        }
        public EmployeePayTypeEnumm PayType
        {
            get { return _payType; }
            set { _payType = value; }   
        }

        public Employee() { }
       
        public Employee(string name, int id, float pay,string empSsn)
            :this (name,id,0, pay, empSsn, EmployeePayTypeEnumm.Salaried) { }
        public Employee(string name, int id, int age, float pay,string snn,EmployeePayTypeEnumm payTypeEnum )
        {
            Pay=pay;
            Name=name;
            Id=id;
            Age=age;
            SocialSecurityNumber=snn;
            PayType = payTypeEnum;

        }
        // свойства! полей
        public string Name
        {
            get { return _empName; }
            set
            {
                if (value.Length > 15)
                {
                    Console.WriteLine("Error");
                }
                else
                {
                    _empName = value;
                }
            }
        }

        public int Id
        {
            get { return _empId; }
            set { _empId = value; }
        }
        public int Age
        {
            get { return _age; }
            set { _age = value; }
        }
        public float Pay { get { return _currPay; } set { _currPay = value; } }
        public virtual void GiveBonus(float amount)
        {
            switch (PayType)
            {
                case EmployeePayTypeEnumm.Commission:
                    Pay += .10f * amount;
                    break;
                case EmployeePayTypeEnumm.Hourly:
                    Pay += 40f * amount / 2080F;
                    break;
                case EmployeePayTypeEnumm.Salaried:
                    Pay += amount;
                    break;
                default:
                    Pay += 0;
                    break;
            }
        }
        public virtual void DisplayStats()
        {
            Console.WriteLine("Name: {0}", Name);
            Console.WriteLine("Id: {0}", Id);
            Console.WriteLine("Pay: {0}", Pay);
            Console.WriteLine("Age: {0}", Age);
            Console.WriteLine("SSN: {0}", SocialSecurityNumber);
           
        }

    }


