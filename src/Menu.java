import java.util.*;

public class Menu {

    List<Student> students = new ArrayList<>();
    List<Teacher> teachers = new ArrayList<>();
    List<Classes> classes = new ArrayList<>();
    Scanner sc = new Scanner(System.in);

    public void initializeData(){
        Teacher teacher1 = new FullTimeTeacher("Alice", 1000, 5);
        Teacher teacher2 = new FullTimeTeacher("Bob", 1200, 3);
        Teacher teacher3 = new PartTimeTeacher("Charlie", 50, 20);
        Teacher teacher4 = new PartTimeTeacher("Diana", 40, 25);

        teachers.addAll(Arrays.asList(teacher1, teacher2, teacher3, teacher4));

        Student student1 = new Student("John", 1, 20);
        Student student2 = new Student("Emma", 2, 21);
        Student student3 = new Student("Liam", 3, 22);
        Student student4 = new Student("Olivia", 4, 19);
        Student student5 = new Student("Noah", 5, 23);
        Student student6 = new Student("Sophia", 6, 20);

        students.addAll(Arrays.asList(student1, student2, student3, student4, student5, student6));


        Classes class1 = new Classes("Math", 101, teacher1);
        class1.addStudent(student1); class1.addStudent(student2);

        Classes class2 = new Classes("Physics", 102, teacher2);
        class2.addStudent(student3); class2.addStudent(student4);

        Classes class3 = new Classes("Chemistry", 103, teacher3);
        class3.addStudent(student5);

        Classes class4 = new Classes("Biology", 104, teacher4);
        class4.addStudent(student6);

        classes.addAll(Arrays.asList(class1, class2, class3, class4));
    }

    //First case
    public void listAllProfessors()
    {
        System.out.println("Professors Information: ");
        for (int i = 0; i < teachers.size() ; i++){
            System.out.println("\nNombre: " + teachers.get(i).getName());
            System.out.println("Salario base: " + teachers.get(i).getBaseSalary());
            System.out.println("Salario final: " + teachers.get(i).calculateSalary());
        }
    }

    //Second case
    public void printClasses(){
        System.out.println("Classes: ");
        for (int i = 0; i < classes.size() ; i++){
            System.out.println(i+1 + ". " + classes.get(i).getName());
        }
        System.out.println("Select the number of the class to display its data: ");
        int choice = sc.nextInt();

        System.out.println("Class information: ");
        System.out.println("Name: " + classes.get(choice-1).getName());
        System.out.println("Classroom Number: " + classes.get(choice-1).getClassroom());
        System.out.println("Students: ");
        for (int j = 0; j < classes.get(choice-1).getStudents().size(); j++){
                System.out.println(classes.get(choice-1).getStudents().get(j).getName());
        }

        System.out.println("Teacher name: " + classes.get(choice-1).getTeacher().getName());
    }

    //Third case
    public void addStudentToClass(){
        System.out.println("\nAdding student to a class: ");
        System.out.println("Enter the student name: ");
        String name = sc.next();
        System.out.println("\nEnter the student id: ");
        int id = sc.nextInt();
        System.out.println("\nEnter the student age: ");
        int age = sc.nextInt();

        Student student = new Student(name, id, age);
        students.add(student);

        System.out.println("Which class you would like to add the student to: ");
        for (int i = 0; i < classes.size() ; i++){
            System.out.println(i+1 + ". " + classes.get(i).getName());
        }
        int choice = sc.nextInt();
        classes.get(choice-1).addStudent(student);

        for (int i = 0; i < classes.size() ; i++){
            System.out.println("\nName : " + classes.get(i).getName());
            for (int j = 0; j < classes.get(i).getStudents().size(); j++){
                System.out.println(classes.get(i).getStudents().get(j).getName());
            }
        }
        System.out.println("Student added successfully!");
    }

    //Fifth case
    public void findClassesByStudent(){
        System.out.println("\nFinding student by student id: ");
        System.out.println("Enter the student id: ");
        int id = sc.nextInt();

        System.out.println("Classes: ");
        for(int j = 0; j < classes.size(); j++){
           for (int i = 0; i < classes.get(j).getStudents().size(); i++){
                if (classes.get(j).getStudents().get(i).getId() == id) {
                    System.out.println("Student found in class: " + classes.get(j).getName());
                }
            }
        }
    }

    public void menu() {
        int choice;
        boolean validInput = false;
        do {
            System.out.println("\n--- University System Menu ---");
            System.out.println("1. Print all professors");
            System.out.println("2. Print all classes");
            System.out.println("3. Add new student to class");
            System.out.println("4. Create new class");
            System.out.println("5. Find classes by student ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            choice = sc.nextInt();


            while (!validInput) {
                try {
                    choice = sc.nextInt();
                    if (choice >= 1 && choice <= 6) {
                        validInput = true;
                    } else {
                        System.out.println("Invalid option. Please enter a number between 1 and 6.");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input. Please enter an integer number.");
                    sc.nextLine();
                }
            }

            switch (choice) {
                case 1 : listAllProfessors(); break;
                case 2 : printClasses(); break;
                case 3 : addStudentToClass();  break;
                //case 4 : createNewClass();  break;
                case 5 : findClassesByStudent();  break;
                case 6 : System.out.println("Thank you for using Globant University..."); sc.close() ;break;
                default : System.out.println("Invalid option."); break;
            }
        } while (choice != 6);
    }

}
