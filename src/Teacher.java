public abstract class Teacher {

    protected String name;
    protected double baseSalary;

    public Teacher(){}
    public Teacher(String name,double baseSalary){
        this.name=name;
        this.baseSalary = baseSalary;
    }

    public String getName() {
        return name;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
}


