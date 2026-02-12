package Codes.Mini_Project;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.LocalTime;


public class Control {
    private static final double tax = 0.1;
    private static final double insurance = 0.05;
    ArrayList<Employee> Emp_List ;

    public Control() {
        this.Emp_List = new ArrayList<>();
    }
    void addEmp(Employee emp){
        if (emp!=null){
            Emp_List.add(emp);
            System.out.println("Employee Added Successfully\n");
        }else System.out.println("Failed to Add, Try again.");
    }
    void removeEmp(String id){
        Employee toRemove = null;
        for (Employee emp : Emp_List){
            if (emp.getId().equals(id)){
                toRemove = emp;
                break;
            }
        }
        if (toRemove!=null){
            System.out.println("=== Employee Details ===");
            System.out.println("Employee Name : " + toRemove.getName());
            System.out.println("Employee Id : " + toRemove.getId());
            Emp_List.remove(toRemove);
            System.out.println("Employee " + id + " is successfully removed from Employee List");
        }else System.out.println("Failed to removed Employee");
    }
    void displayAll(){
        if (Emp_List.isEmpty()){
            System.out.println("No records to show.!");
            return;
        }

        for (Employee emp : Emp_List){
            System.out.println(emp.toString());
        }
    }
    boolean check(String id){
        for (Employee emp : Emp_List){
            if(emp.getId().equals(id)){
                System.out.println("ID found, Here is details of Employee");
                System.out.println(emp.toString());
                return true;
            }
        }
        System.out.println("ID doesn't found");
        return false;
    }
    boolean exits(String id){
        for (Employee emp :  Emp_List){
            if (emp.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }
    void updateId(String  oldId , String newID){
        for (Employee emp : Emp_List){
            if (emp.getId().equals(oldId)){
                emp.setId(newID);
                System.out.println("Employee Id is updated to " + newID);
               return;
            }
        }
    }
    void updateName(String id , String newName ){
        for (Employee emp : Emp_List){
            if (emp.getId().equals(id)){
                emp.setName(newName);
                System.out.println("Employee Name is updated to " + newName);
                return;
            }
        }

    }

    public Employee returnObj(String id){
        for (Employee emp : Emp_List){
            if (emp.getId().equals(id)){
                return emp;
            }
        }
        return null;
    }
    // Add this method to your Control class (anywhere after other methods)
    void updateSalarySimple(String id) {
        Employee employee = returnObj(id);
        Scanner input = new Scanner(System.in);
        if (employee == null) {
            System.out.println("❌ Employee not found!");
            return;
        }

        if (employee instanceof full_time) {
            System.out.print("Enter New Salary : ");
            double newSal = input.nextDouble();
            input.nextLine();
            full_time ft = (full_time) employee;
            ft.setMonthlySalary(newSal);
            System.out.println("✅ Full-Time salary updated!");
            System.out.printf("   New monthly salary: $%.2f\n", ft.calSalary());

        } else if (employee instanceof part_time) {
            part_time pt = (part_time) employee;

            // Ask for new hours and hour rate
            System.out.println("\n─── Update Part-Time Employee ───");
            System.out.println("   Current details:");
            System.out.printf("   Hours: %d, Hourly Rate: $%.2f\n", pt.getHours(), pt.getHourRate());
            System.out.printf("   Current Monthly Salary: $%.2f\n", pt.calSalary());

            System.out.print("\nEnter new working hours: ");
            int newHours = input.nextInt();

            System.out.print("Enter new hourly rate: ");
            double newRate = input.nextDouble();
            input.nextLine(); // Consume newline

            // Validate inputs
            if (newHours > 0 && newRate > 0) {
                pt.setHours(newHours);
                pt.setHourRate(newRate);

                double calculatedSalary = pt.calSalary();
                System.out.println("\n✅ Part-Time salary updated!");
                System.out.printf("   New Hours: %d\n", newHours);
                System.out.printf("   New Hourly Rate: $%.2f\n", newRate);
                System.out.printf("   Calculated Monthly Salary: $%.2f\n", calculatedSalary);

                // Check if calculated salary matches the requested newSal

            } else {
                System.out.println("❌ Hours and rate must be positive!");
            }
        }
    }
    void generateSlip(String Id){
        if (check(Id)){
            Employee temp = returnObj(Id);
            slipgenerator(Id , temp);
        }else {
            System.out.print("Try Again");
        }
    }
    void slipgenerator(String id, Employee temp){
        LocalTime time = LocalTime.now();

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("HH:mm:ss");

        String formatted = time.format(formatter);
        LocalDate date = LocalDate.now();
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("               SALARY SLIP - MONTHLY");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("\nEmployee Name   : " + temp.getName());
        System.out.println("Employee Id     : " + temp.getId());
        System.out.println("Employee Type   : " + temp.getType());
        System.out.println("Status          : " + "Active");
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("                  EARNING DETAILS");
        System.out.println("══════════════════════════════════════════════════\n");
        System.out.print("Monthly Salary  :               $");
        System.out.printf("%.2f" , temp.calSalary());
        System.out.println();
        System.out.println("--------------------------------------------------");
        System.out.print("GROSS PAY       :               $");
        System.out.printf("%.2f" , temp.calSalary());
        System.out.println("\n══════════════════════════════════════════════════");
        System.out.println("                  DEDUCTIONS");
        System.out.println("══════════════════════════════════════════════════");
        System.out.println();
        double tax =  temp.calSalary()*Control.tax;
        double ins = temp.calSalary()*Control.insurance;
        double netSlaray =  temp.calSalary()-tax-ins;
        System.out.print("Tax(10%)        :               $");
        System.out.printf("%.2f" , tax);
        System.out.println();
        System.out.print("Insurance(10%)  :               $");
        System.out.printf("%.2f" , ins);
        System.out.println("\n--------------------------------------------------");
        System.out.print("TOTAl DEDUCTION :               $" );
        System.out.printf("%.2f" , (tax + ins));
        System.out.println();
        System.out.println("══════════════════════════════════════════════════");
        System.out.println("                  NET PAY");
        System.out.println("══════════════════════════════════════════════════\n");
        System.out.print("NET SALARY      :               $");
        System.out.printf("%.2f" , netSlaray);
        System.out.println();
        System.out.println("══════════════════════════════════════════════════");
        System.out.println();
        System.out.println("Generated On    : " + date + " " + formatted);
        System.out.println("Status          : " + "PAID");
        System.out.println("══════════════════════════════════════════════════");


    }
}
