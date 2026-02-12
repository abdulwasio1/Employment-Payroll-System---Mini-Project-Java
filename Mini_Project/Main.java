package Codes.Mini_Project;

import java.util.Scanner;

import static Codes.Mini_Project.menu.printMenu;

public class Main {
    public static void main(String[] args)  {
        Scanner input = new Scanner(System.in);
        Control c1 = new Control();
        while (true){
            printMenu();
            System.out.print("Enter Choice : ");
            int ch = input.nextInt();
            if (ch==1){
                System.out.println("1. Part Time");
                System.out.println("2. Full Time");
                System.out.print("Enter type : ");
                int type = input.nextInt();
                if (type==1){
                    String jobType = "Part Time";
                    Employee p_emp;
                    System.out.println("Enter details for Part Time Employee");
                    System.out.print("Enter Name : ");
                    input.nextLine();
                    String name = input.nextLine();
                    String id;
                    while (true){
                        System.out.print("Enter Emp ID : ");
                        id = input.nextLine();
                        if (c1.exits(id)){
                            System.out.println("This Id exits already, Enter different ID");
                        }else {
                            break;
                        }
                    }
                    System.out.print("Enter Working hours : ");
                    int hours = input.nextInt();
                    System.out.print("Enter per hour rate : ");
                    double hourRate = input.nextDouble();
                    p_emp = new part_time(name , id , jobType, hours, hourRate);
                    c1.addEmp(p_emp);

                } else if (type==2) {
                    String jobType = "Full Time";
                    Employee f_emp;
                    System.out.println("Enter details for Full Time Employee");
                    System.out.print("Enter Name : ");
                    input.nextLine();
                    String name = input.nextLine();
                    String id;
                    while (true){
                        System.out.print("Enter Emp ID : ");
                        id = input.nextLine();
                        if (c1.exits(id)){
                            System.out.println("This Id exits already, Enter different ID");
                        }else {
                            break;
                        }
                    }
                    System.out.print("Enter Monthly Salary : ");
                    double salary = input.nextDouble();
                    f_emp = new full_time(name , id ,jobType, salary);
                    c1.addEmp(f_emp);

                }else {
                    System.out.println("Invalid Choice");
                }

            }else if (ch==2){
                System.out.print("Enter the Emp ID to remove : ");
                String id = input.next();
                c1.removeEmp(id);
            } else if (ch==5) {
                c1.displayAll();
            }else if (ch==6) {
                System.out.println("Thanks for using....");
                break;
            }else if (ch==3){
                System.out.print("Enter Id to search : ");
                input.nextLine();
                String id = input.nextLine();
                c1.check(id);
            }else if (ch==4){
                System.out.print("Enter Emp ID  : ");
                String id = input.next();
                if (c1.exits(id)){
                    System.out.println("What you want to update");
                    System.out.println("1. ID");
                    System.out.println("2. Name");
                    System.out.println("3. Salary");
                    System.out.print("Enter Choice : ");
                    int up = input.nextInt();
                    if (up==1){
                        System.out.print("Enter New ID : ");
                        String newID = input.next();
                        c1.updateId(id,newID);
                    }else if (up==2){
                        System.out.print("Enter New Name : ");
                        String newName = input.next();
                        c1.updateName(id , newName);
                    }  else if (up == 3) { //GPT
                          // Consume newline

                        // Call the updateSalarySimple method with scanner
                        c1.updateSalarySimple(id);

                    } else {
                        System.out.println("Invalid choice for update!");
                    }
                } else {
                    System.out.println("Employee ID not found!");
                }

            } else System.out.println("Invalid Choice, Try Again");

        }
    }

}



