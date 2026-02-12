package Codes.Mini_Project;

public abstract class Employee {
    private String name;
    private String id;
    private String type;

    public Employee(String name, String id, String type) {
        this.name = name;
        this.id = id;
        this.type = type;
    }

    public Employee() {

    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }
    public String getType(){
        return type;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    abstract double calSalary();



    @Override
    public String toString() {
        return "╔══════════════════════════════════════╗\n" +
                "║         EMPLOYEE INFORMATION         ║\n" +
                "╠══════════════════════════════════════╣\n" +
                "║ Name   : " + String.format("%-28s", name) + "║\n" +
                "║ ID     : " + String.format("%-28s", id) + "║\n" +
                "║ Type   : " + String.format("%-28s", type) + "║\n" +
                "║ Salary : $" + String.format("%-27.2f", calSalary()) + "║\n" +
                "╚══════════════════════════════════════╝";
    }


}
