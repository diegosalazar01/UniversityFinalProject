public class PartTimeTeacher extends Teacher{

    private int hoursActivePerWeek;

    public PartTimeTeacher(){}
    public PartTimeTeacher(String name, double baseSalary,int hoursActivePerWeek){
        super(name,baseSalary);
        this.hoursActivePerWeek = hoursActivePerWeek;
    }

    public double calculateSalary() {
        return baseSalary * hoursActivePerWeek;
    }
}
