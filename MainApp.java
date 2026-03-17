import java.util.List;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        StudentDAO dao = new StudentDAO();

        int choice;

        do {
            System.out.println("\n==== Student Management System ====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter Name: ");
                    String name = sc.next();
                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    System.out.print("Enter Course: ");
                    String course = sc.next();

                    Student s = new Student(name, age, course);
                    dao.insertStudent(s);
                    break;

                case 2:
                    List<Student> students = dao.getAllStudents();
                    System.out.println("\nID\tName\tAge\tCourse");
                    for (Student st : students) {
                        System.out.println(
                                st.getId() + "\t" +
                                st.getName() + "\t" +
                                st.getAge() + "\t" +
                                st.getCourse()
                        );
                    }
                    break;

                case 3:
                    System.out.print("Enter ID to update: ");
                    int uid = sc.nextInt();
                    System.out.print("Enter new Name: ");
                    String newName = sc.next();

                    dao.updateStudent(uid, newName);
                    break;

                case 4:
                    System.out.print("Enter ID to delete: ");
                    int did = sc.nextInt();

                    dao.deleteStudent(did);
                    break;

                case 5:
                    System.out.println("Thank you!");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);
    }
}