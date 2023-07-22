import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import javax.swing.*;

public class EmployeeManagement {

	EmployeesDetails head;
	int countEmployees;
	File file= new File("Employee.txt");
	public void insert(int id, String name, int age, float salary) {
		addEmployees(id, name, age, salary);
		try {
			FileWriter fw= new FileWriter(file, true);
			fw.write(id+"\t"+name+"\t"+age+"\t"+salary+"\n");
			fw.close();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void addEmployees(int id, String name, int age, float salary) {
		
		EmployeesDetails n1= new EmployeesDetails();
		n1.empId=id;
		n1.empName=name;
		n1.empAge=age;
		n1.empSalary=salary;
		if(head==null) {
			head=n1;
			countEmployees++;
		}else {
			EmployeesDetails last= head;
			while(last.next != null) {
				last=last.next;
			}
			last.next=n1;
		}
		n1.next=null;
		countEmployees++;
}
	public EmployeesDetails search(int id) {
		EmployeesDetails n1= head;
		while(n1.empId!= id){
			n1=n1.next;
		}
		return n1;
	}
	public void updateSalary(int id, float newSalary) {
		EmployeesDetails n1= search(id);
		n1.empSalary=newSalary;
	}
	public void updateAge(int id, int age ) {
		EmployeesDetails n1= search(id);
		n1.empAge=age;
	}
	public void deleteEmployeeData(int id) {
		EmployeesDetails n1= searchPre(id);
		if(n1 != null) {
		n1.next=n1.next.next;
		}
	}
	public EmployeesDetails searchPre(int id) {
		EmployeesDetails n1= head;
		EmployeesDetails p= head;
		while(n1.empId!= id){
			p=n1;
			n1=n1.next;
		} 
		return p;
	}
	public void saveToNode() {
		try {
		FileReader fr= new FileReader(file);
		BufferedReader br= new BufferedReader(fr); // read line by line
		String rl= br.readLine();
		while(rl != null) {
		String array[]=rl.split("\t");
		int id= Integer.parseInt(array[0]);
		int age=Integer.parseInt(array[2]);
		float salary=Float.parseFloat(array[3]);
		addEmployees(id, array[1], age, salary);
		rl=br.readLine();
		}
		br.close();
	}catch(IOException e){
		e.printStackTrace();
	}
}
	public void displayEmployee() {
		
		EmployeesDetails n1= head;
		while(n1 != null) {
			System.out.println(n1.empId+"\t"+n1.empName+"\t"+n1.empAge+"\t"+n1.empSalary);
			n1=n1.next;
		}
	}
	public int getCountEmployees() {
		return countEmployees;
	}
	
}