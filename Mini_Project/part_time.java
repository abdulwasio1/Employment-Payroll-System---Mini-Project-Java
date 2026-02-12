package Codes.Mini_Project;

public class part_time extends Employee {
    private int hours;
    private double hourRate;

    public part_time() {
        super();
    }

    public part_time(String name, String id, String type, int hours, double hourRate) {
        super(name, id, type);
        this.hours = hours;
        this.hourRate = hourRate;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public void setHourRate(double hourRate) {
        this.hourRate = hourRate;
    }

    public int getHours() {
        return hours;
    }

    public double getHourRate() {
        return hourRate;
    }

    @Override
    double calSalary(){
        return (hourRate*hours);
    }
}
