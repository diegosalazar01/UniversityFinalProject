import java.util.ArrayList;
import java.util.List;

public class Classes {

    private String name;
    private int classroom;
    private List<Student> students;
    private Teacher teacher;

    public Classes() {this.students = new ArrayList<>();}
    public Classes(String name, int classroom,Teacher teacher) {
        this.name = name;
        this.classroom = classroom;
        this.teacher = teacher;
        this.students = new ArrayList<>();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public String getName() {
        return name;
    }

    public int getClassroom() {
        return classroom;
    }

    public List<Student> getStudents() {
        return students;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassroom(int classroom) {
        this.classroom = classroom;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }
}
