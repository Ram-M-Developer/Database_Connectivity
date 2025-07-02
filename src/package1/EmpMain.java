package package1;

import java.util.Scanner;

public class EmpMain {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		while(true) {
			System.out.println("-----Employee Management Menu----");
			System.out.println("1.Add Employee");
			System.out.println("2.View Employee");
			System.out.println("3.Update Employee");
			System.out.println("4.Delete Employee");
			System.out.println("5.Exit");
			System.out.println("Enter Your Choice:");
			
			int choice=Integer.parseInt(sc.nextLine());
			
			try {
				switch(choice) {
				case 1:
					EmpMethods.addEmployee();
					break;
				case 2:
					EmpMethods.viewEmployee();
					break;
				case 3:
					EmpMethods.updateEmployee();
					break;
				case 4:
					EmpMethods.deleteEmployee();
					break;
				case 5:
					System.out.println("Exiting..");
					System.exit(0);
				default:
					System.out.println("Invalid Choice!!");
				}
			}
			catch(Exception e) {
				System.out.println("Error :"+e.getMessage());
			}
		}

	}
}
