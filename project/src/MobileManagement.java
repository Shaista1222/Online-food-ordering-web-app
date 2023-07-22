import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.BufferedReader;
import javax.swing.*;

public class MobileManagement {
	MobileDetails head;
	File f = new File("Mobile.txt");

	public void insert(int id, String title, int price, int qty) {
		EmployeeManagement mg = new EmployeeManagement();
		addMobiles(id, title, price, qty);
		try {
			FileWriter fw = new FileWriter(f, true);
			fw.write(id + "\t" + title + "\t" + price + "\t" + qty + "\n");

			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addMobiles(int id, String title, int price, int qty) {
		MobileDetails n1 = new MobileDetails();
		n1.mobileId = id;
		n1.mobTitle = title;
		n1.mobPrice = price;
		n1.mobQty = qty;
		if (head == null) {
			head = n1;
		} else {
			MobileDetails last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = n1;
		}
		n1.next = null;
	}

	public void saveToNode() {
		try {
			FileReader fr = new FileReader(f);
			BufferedReader br = new BufferedReader(fr); // read line by line
			String r1 = br.readLine();
			while (r1 != null) {
				String array[] = r1.split("\t");
				int id = Integer.parseInt(array[0]);
				int price = Integer.parseInt(array[2]);
				int qty = Integer.parseInt(array[3]);
				addMobiles(id, array[1], price, qty);
				r1 = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void lowStock(int id, int qty) {
		MobileDetails n1 = search(id);
		while (n1 != null) {
			if (n1.mobQty < qty) {
				System.out.println(n1.mobileId + "\t" + n1.mobTitle + "\t" + n1.mobQty);
			}
			n1 = n1.next;
		}
	}

	public MobileDetails search(int id) {
		MobileDetails n1 = head;
		while (n1.mobileId != id) {
			n1 = n1.next;
			if (n1 == null) {
				return null;
			}
		}
		return n1;
	}

	
	
	public void displayMobiles() {
		MobileDetails n1 = head;
		while (n1 != null) {
			System.out.println(n1.mobileId + "\t" + n1.mobTitle + "\t" + n1.mobPrice + "\t" + n1.mobQty);
			n1 = n1.next;
		}
	}
	public void updateMobileQTY(int id, int oldQty) {
	MobileDetails n1= search(id);
	if(n1 != null) {		
		n1.mobQty=oldQty;
	}else {
	      System.out.println("ID not found");
	}
	}
}
