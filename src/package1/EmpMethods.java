package package1;

import java.sql.*;
import java.util.Scanner;

public class EmpMethods {
	
	static Scanner sc=new Scanner(System.in);
	
	public static void addEmployee() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect=DriverManager.getConnection("jdbc:mysql://localhost:3306/task7","root","ram7");
		
		System.out.println("Enter your Id:");
		int id=Integer.parseInt(sc.nextLine());
		System.out.println("Enter your Name:");
		String name=sc.nextLine();
		System.out.println("Enter your Salary:");
		int salary=Integer.parseInt(sc.nextLine());
		System.out.println("Enter your Location:");
		String Location=sc.nextLine();
		
		EmpVari obj=new EmpVari(id,name,salary,Location);
		
		String query="INSERT INTO employee(id,name,salary,location) VALUES(?,?,?,?)";
		
		PreparedStatement pst=connect.prepareStatement(query);
		pst.setInt(1, obj.getId());
		pst.setString(2, obj.getName());
		pst.setInt(3, obj.getSalary());
		pst.setString(4, obj.getLocation());
		
		pst.executeUpdate();
		System.out.println("Employee added Successfully...");
		
	}
	
	public static void viewEmployee() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect1=DriverManager.getConnection("jdbc:mysql://localhost:3306/task7","root","ram7");
		Statement state=connect1.createStatement();
		String query1="SELECT * From employee";
		ResultSet rs=state.executeQuery(query1);
		
		System.out.println("ID | Name | Salary | Location");
		while(rs.next()) {
			System.out.println(rs.getInt("id")+"|"+rs.getString("name")+"|"+rs.getInt("salary")+"|"+rs.getString("location"));
			
		}
	}
	
	public static void updateEmployee() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect2=DriverManager.getConnection("jdbc:mysql://localhost:3306/task7","root","ram7");
		
		System.out.println("Enter Id to Update:");
		int id=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter New Name :");
		String name=sc.nextLine();
		
		System.out.println("Enter New Salary:");
		int salary=Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter New Location :");
		String location=sc.nextLine();
		
		String query2="UPDATE employee SET name=?,salary=?,location=? WHERE id=?";
		PreparedStatement pst=connect2.prepareStatement(query2);
		pst.setString(1, name);
		pst.setInt(2, salary);
		pst.setString(3, location);
		pst.setInt(4, id);
		
		int result = pst.executeUpdate();
		if(result>0) {
			System.out.println("Employee Updated Successfully..");
		}
		else {
			System.out.println("Employee Not Found..");
		}

	}
	
	public static void deleteEmployee() throws SQLException, ClassNotFoundException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connect3=DriverManager.getConnection("jdbc:mysql://localhost:3306/task7","root","ram7");
		
		System.out.println("Enter Id to Delete:");
		int id=Integer.parseInt(sc.nextLine());
		
		String query3="DELETE FROM employee WHERE id=?";
		PreparedStatement pst=connect3.prepareStatement(query3);
		pst.setInt(1, id);
		
		int ans=pst.executeUpdate();
		if(ans>0) {
			System.out.println("Employee Deleted Successfully..");
		}
		else {
			System.out.println("Employee Not Found..!");
		}	
	}
}
