import javax.swing.*;

public class Main {

	public static void main(String[] args) {
		EmployeeManagement obj = new EmployeeManagement();
		MobileManagement n1 = new MobileManagement();
		SaleManagement n2 = new SaleManagement();
		obj.saveToNode();
		n1.saveToNode();
		// obj.insert(05, "abrish", 5, 2320);
		// obj.insert(02, "shumaila", 5, 26220);
		// obj.insert(03, "shees", 5, 28220);
		// obj.deleteEmployeeData(02);
		// obj.deleteEmployeeData(03);
		//
		// obj.displayEmployee();

		// n1.insert(01, "Samsung J3", 20000, 20);
		// n1.insert(07, "Samsung j5", 30000, 30);
		// n1.lowStock(01, 30);
        n1.updateMobileQTY(01, 25);
        n1.displayMobiles();
//
//		// sales management
//		
//		n2.addSales(07, 02 , 04, 30000, "12/6/2022");
//		n2.displaySale();
//		n2.saveToNode();
//		n2.insertSalingData(10, 01, 05, 20000, "22/6/2022");
//		n2.insertSalingData(10, 01, 06, 20000, "23/6/2022");
//		n2.insertSalingData(10, 01, 07, 20000, "24/6/2022");
//		n2.insertSalingData(10, 01, 3, 20000, "25/6/2022");
		
		//n2.displaySale();
	}
}
