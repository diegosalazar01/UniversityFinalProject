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
        class1.addStudent(student1);
        class1.addStudent(student2);

        Classes class2 = new Classes("Physics", 102, teacher2);
        class2.addStudent(student3);
        class2.addStudent(student4);

        Classes class3 = new Classes("Chemistry", 103, teacher3);
        class3.addStudent(student5);
        class3.addStudent(student6);

        Classes class4 = new Classes("Biology", 104, teacher4);
        class4.addStudent(student6);
        class4.addStudent(student1);

        classes.addAll(Arrays.asList(class1, class2, class3, class4));
    }

    //First case here we go
    public void listAllProfessors()
    {
        if (teachers.isEmpty()){
            System.out.println("There are no teachers to display.");
        }
        else {
            System.out.println("Professors Information: ");
            for (int i = 0; i < teachers.size(); i++) {
                System.out.println("\nNombre: " + teachers.get(i).getName());
                System.out.printf("Salario base: %.1f%n", teachers.get(i).getBaseSalary());
                System.out.printf("Salario final: %.1f%n", teachers.get(i).calculateSalary());
            }
        }
    }

    //Second case here we go
    public void printClasses(){
        System.out.println("Classes: ");
        for (int i = 0; i < classes.size() ; i++){
            System.out.println(i+1 + ". " + classes.get(i).getName());
        }
        System.out.println("Select the number of the class to display its data: ");
        int choice = sc.nextInt();

        if (choice-1 < classes.size() && choice > 0){
            System.out.println("\nClass information: ");
            System.out.println("Name: " + classes.get(choice-1).getName());
            System.out.println("Classroom Number: " + classes.get(choice-1).getClassroom());
            System.out.println("Students: ");
            for (int j = 0; j < classes.get(choice-1).getStudents().size(); j++){
                System.out.println(classes.get(choice-1).getStudents().get(j).getName());
            }

            System.out.println("Teacher name: " + classes.get(choice-1).getTeacher().getName());
        } else {
            System.out.println("Please select a number of the list. \n");
            printClasses();
        }

    }

    //Third case here we go
    public void addStudentToClass(){
        System.out.println("\nAdding student to a class: ");

        String name;
        while (true) {
            System.out.println("Enter the student name: ");
            name = sc.nextLine();
            if (!name.trim().isEmpty()){
                break;
            } else {
                System.out.println("Please enter the student name.");
            }
        }

        int id;
        while (true) {
            System.out.println("\nEnter the student id: ");
            id = sc.nextInt();

            boolean idExists = false;

            for (int j = 0; j < classes.size(); j++) {
                for (int k = 0; k < classes.get(j).getStudents().size(); k++) {
                    if (classes.get(j).getStudents().get(k).getId() == id) {
                        idExists = true;
                        break;
                    }
                }
                if (idExists) {
                    break;
                }
            }
            if (idExists) {
                System.out.println("Student with id "+ id +" already exists.\n");
            } else {
                break;
            }
        }
        int age;
        while (true) {
            System.out.println("\nEnter the student age: ");
            age = sc.nextInt();
            if (age < 0 || age > 120) {
                System.out.println("Please enter a number between 0 and 120.\n");
            } else {
                break;
            }
        }

        Student student = new Student(name, id, age);
        students.add(student);

        int choice;

        while (true){
            System.out.println("Which class you would like to add the student to: ");
            for (int i = 0; i < classes.size() ; i++){
                System.out.println(i+1 + ". " + classes.get(i).getName());
            }
            choice = sc.nextInt();
            if (choice-1 < classes.size() && choice > 0){
                classes.get(choice-1).addStudent(student);
                System.out.println("Student added successfully!");

                System.out.println("\nClass name: " + classes.get(choice-1).getName());
                System.out.println("Students: ");
                for (int j = 0; j < classes.get(choice-1).getStudents().size(); j++) {
                    System.out.println(classes.get(choice-1).getStudents().get(j).getName());
                }
                break;
            } else {
                System.out.println("Please select a number of the list. \n");
            }
        }
    }

    //Fourth class here we go
    //If you choose option 4 and it doesn't work the first time, please try again.
    public void createNewClass(){
        sc.nextLine();

        Classes class5 = new Classes();
        System.out.println("\nCreating a new class: ");

        while (true) {
            System.out.println("Enter the name of the class: ");
            String name = sc.nextLine();
            if (!name.trim().isEmpty()){
                class5.setName(name);
                break;
            } else {
                System.out.println("Please enter a valid name for the class.");
            }
        }


        while (true) {
            System.out.println("Enter the classroom number, an integer number between 100 and 200: ");
            if (sc.hasNextInt()) {
                int classroom = sc.nextInt();
                sc.nextLine();
                if (classroom >= 100 && classroom <= 200){
                    class5.setClassroom(classroom);
                    break;
                } else {
                    System.out.println("Please enter a number between 100 and 200.");
                }
            } else {
                System.out.println("Invalid input. Please enter a valid number.");
                sc.nextLine();
            }
        }


        while (true) {
            System.out.println("Choose the teacher you would like to add to: ");
            for (int i = 0; i < teachers.size() ; i++){
                System.out.println(i+1 + ". " + teachers.get(i).getName());
            }
            if (sc.hasNextInt()) {
                int choice2 = sc.nextInt();
                sc.nextLine();
                if (choice2-1 < teachers.size() && choice2 > 0){
                    class5.setTeacher(teachers.get(choice2-1));
                    break;
                } else {
                    System.out.println("Please select a valid teacher from the list.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
            }
        }

        int choiceDoWhile;
        do {
            System.out.println("Add existing students to the class");
            System.out.println("1. Add students to the class: ");
            System.out.println("2. Not add more students to the class: ");

            if (sc.hasNextInt()) {
                choiceDoWhile = sc.nextInt();
                sc.nextLine();

                if (choiceDoWhile == 1) {
                    System.out.println("Choose which students you would like to add to the class: ");
                    for (int i = 0; i < students.size(); i++) {
                        System.out.println(i + 1 + ". " + students.get(i).getName());
                    }
                    if (sc.hasNextInt()) {
                        int choice = sc.nextInt();
                        sc.nextLine();
                        if (choice >= 1 && choice <= students.size()) {
                            class5.addStudent(students.get(choice - 1));
                            System.out.println("Student added successfully.");
                        } else {
                            System.out.println("Please enter a valid student number.");
                        }
                    } else {
                        System.out.println("Invalid input. Please enter a number.");
                        sc.nextLine();
                    }
                } else if (choiceDoWhile != 2) {
                    System.out.println("Please enter a number between 1 and 2.");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                sc.nextLine();
                choiceDoWhile = 0;
            }
        } while (choiceDoWhile != 2);


        classes.add(class5);
        System.out.println("Class created successfully!");

        System.out.println("\nClass name: " + class5.getName());
        System.out.println("Classroom number: " + class5.getClassroom());
        System.out.println("Teacher name: " + class5.getTeacher().getName());
        System.out.println("Students: ");
        for (Student student : class5.getStudents()){
            System.out.println(student.getName());
        }
    }

    //Fifth case here we go
    public void findClassesByStudent(){
        System.out.println("\nFinding student by student id: ");
        System.out.println("Enter the student id: ");
        int id = sc.nextInt();

        if (id > 0 && id < students.size()+1){
            System.out.println("Classes: ");
            for(int j = 0; j < classes.size(); j++){
                for (int i = 0; i < classes.get(j).getStudents().size(); i++){
                    if (classes.get(j).getStudents().get(i).getId() == id) {
                        System.out.println("Student " + classes.get(j).getStudents().get(i).getName() +" was found in the class: " + classes.get(j).getName());
                    }
                }
            }
        } else {
            System.out.println("Student with id " + id + " not exists.");
            findClassesByStudent();
        }
    }

    public void menu() {
        int choice;

        do {
            System.out.println("\n--- Globant University System Menu ---");
            System.out.println("1. Print all professors");
            System.out.println("2. Print all classes");
            System.out.println("3. Add new student to class");
            System.out.println("4. Create new class");
            System.out.println("5. Find classes by student ID");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            while (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                System.out.print("Choose an option: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1: listAllProfessors(); break;
                case 2: printClasses(); break;
                case 3: addStudentToClass(); break;
                case 4: createNewClass(); break;
                case 5: findClassesByStudent();  break;
                case 6:
                    System.out.println("Thank you for using Globant University...");
                    sc.close();
                    break;
                default:
                    System.out.println("Invalid option. Please enter a number between 1 and 6.");
                    break;
            }
        } while (choice != 6);
    }
}
