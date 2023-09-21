
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

public class Leave_Management_System {

    static Scanner scan = new Scanner(System.in);

    static class EmployeesOrder implements Comparable<EmployeesOrder> {

        String Name, Gender, Type;

        int Id, serial_no;

        public EmployeesOrder(String Name, int Id, String Gender, String Type, int serial_no) {
            this.Name = Name;
            this.Id = Id;
            this.Gender = Gender;
            this.Type = Type;
            this.serial_no = serial_no;
        }

        public EmployeesOrder() {

        }

        public String getName() {
            return Name;
        }

        public void setName(String Name) {
            this.Name = Name;
        }

        public int getId() {
            return Id;
        }

        public void setId(int Id) {
            this.Id = Id;
        }

        public String getGender() {
            return Gender;
        }

        public void setGender(String Gender) {
            this.Gender = Gender;
        }

        public String getType() {
            return Type;
        }

        public void setType(String Type) {
            this.Type = Type;
        }

        public int getSerial() {
            return serial_no;
        }

        public void setSerial(int serial_no) {
            this.serial_no = serial_no;
        }

        @Override
        public String toString() {
            return "Name=" + Name + "\n"
                    + "Id= " + Id + "\n"
                    + " Gender = " + Gender + "\n"
                    + " Type= " + Type + "\n"
                    + " serial_no= " + serial_no + "\n";
        }

        @Override
        public int compareTo(EmployeesOrder t) {

            if (this.getSerial() > t.getSerial()) {

                return 1;

            } else if (this.getSerial() < t.getSerial()) {

                return -1;

            }

            return 0;

        }

    }

    static Leave_Details ld = new Leave_Details();

    static Leaved_Employees l = new Leaved_Employees();

    static EmployeesOrder eo = new EmployeesOrder();

    static List<Leave_Details> list = new ArrayList<>();

    static PriorityQueue<EmployeesOrder> pq = new PriorityQueue<>();

    static Stack<Leaved_Employees> stack = new Stack<>();

    static String Name, Gender, Type;
    static int Id, serial_no = 0;

    static int Menu() {

        int choice;

        System.out.println("1: Add The request of the Employees");
        System.out.println("2: See The request of the Employees");
        System.out.println("3: Apply for leave");
        System.out.println("4: See already leaved Employees");
        System.out.println("5: See Total appliers for Leave");
        System.out.println("6: Exit");

        choice = scan.nextInt();

        if (choice != 1 && choice != 2 && choice != 3 && choice != 4 && choice != 5 && choice != 6) {

            try {

                throw new Exception("Enter between 1-6 ! Try Again!!");

            } catch (Exception e) {

                System.out.println(e);

                Menu();

            }

        }

        return choice;

    }

    public static void main(String[] args) {

        while (true) {

            int choice = Menu();

            switch (choice) {

                case 1:

                    serial_no++;

                    System.out.println("Enter the name of the employee: ");
                    Name = scan.next();

                    System.out.println("Enter the Id of the employee: ");
                    int Id = scan.nextInt();

                    System.out.println("Enter the gender: ");
                    Gender = scan.next();

                    System.out.println("Enter the leave type: ");
                    Type = scan.next();

                    try {

                        if (Type.equalsIgnoreCase("maternity") && Gender.equalsIgnoreCase("Male")) {

                            throw new Exception("Matenary is only applicable for female");

                        } else {

                            list.add(new Leave_Details(Name, Id, Gender, Type));

                            pq.add(new EmployeesOrder(Name, Id, Gender, Type, serial_no));

                        }

                    } catch (Exception e) {

                        serial_no--;

                        System.out.println(e);

                        Menu();

                    }

                    break;

                case 2:

                    pq.forEach((i) -> {
                        System.out.println(i.toString() + "\n");
                    });

                    break;

                case 3:

                    try {

                        eo = pq.poll();

                        if (eo.getName() == null) {

                            throw new Exception("No Entry Yet!!");

                        }

                        l = new Leaved_Employees(eo.getName(), eo.getId(), eo.getGender(), eo.getType());

                        stack.push(l);

                        serial_no--;

                    } catch (Exception e) {

                        System.out.println("No Entry Yet!!");

                    }

                    break;

                case 4:

                    try {

                        stack.forEach((i) -> {
                            System.out.println(i.toString() + "\n");
                        });

                    } catch (Exception e) {
                        System.out.println("Invalid Occurs!");
                    }

                    break;

                case 5:

                    try {

                        list.forEach((i) -> {
                            System.out.println(i.toString() + "\n");
                        });

                    } catch (Exception e) {

                        System.out.println("No entry yet!!");

                    }

                    break;

                case 6:

                    System.exit(0);

                    break;

            }

        }

    }
}
