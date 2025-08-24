public class FullTimeTeacher extends Teacher {

    private int experienceYears;

    public FullTimeTeacher(){}
    public FullTimeTeacher(String name, double baseSalary,int experienceYears){
        super(name,baseSalary);
        this.experienceYears = experienceYears;
    }

    public int getExperienceYears() {
        return experienceYears;
    }

    public void setExperienceYears(int experienceYears) {
        this.experienceYears = experienceYears;
    }

    public double calculateSalary() {
        return baseSalary * (experienceYears * 1.1f);
    }
}
