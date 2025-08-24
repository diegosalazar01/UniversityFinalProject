public abstract class Teacher extends Person {

    protected double baseSalary;

    public Teacher(){}
    public Teacher(String name,double baseSalary){
        super(name);
        this.baseSalary = baseSalary;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public abstract double calculateSalary();
}


