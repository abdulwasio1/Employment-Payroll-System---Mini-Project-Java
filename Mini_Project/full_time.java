package Codes.Mini_Project;

public class full_time extends Employee{
    private double monthlySalary;

    public full_time(String name, String id, String type, double monthlySalary) {
        super(name, id, type);
        this.monthlySalary = monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }



    @Override
    double calSalary(){
        return monthlySalary;
    }
}
