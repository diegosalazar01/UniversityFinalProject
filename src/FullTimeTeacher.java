public class FullTimeTeacher extends Teacher {

    private int experienceYears;

    public FullTimeTeacher(){}
    public FullTimeTeacher(String name, double baseSalary,int experienceYears){
        super(name,baseSalary);
        this.experienceYears = experienceYears;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * (experienceYears * 1.1f);
    }
}
