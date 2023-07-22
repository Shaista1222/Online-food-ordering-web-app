import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.*;
import java.io.IOException;

public class SaleManagement {

	SaleDetails head;
	File file = new File("Saling.txt");

	public void insertSalingData(int saleId, int mobId, int CustomerId, float purchasePrice, String saleOfDate) {
		EmployeeManagement em = new EmployeeManagement();
		addSaling(saleId, mobId, CustomerId, purchasePrice, saleOfDate);
		try {
			FileWriter fw = new FileWriter(file, true);
			fw.write(saleId + "\t" + mobId + "\t" + CustomerId + "\t" + purchasePrice + "\t" + saleOfDate);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addSaling(int saleId, int mobId, int CustomerId, float purchasePrice, String saleOfDate) {
		SaleDetails n1 = new SaleDetails();
		n1.saleId = saleId;
		n1.mobId = mobId;
		n1.CustomerId = CustomerId;
		n1.purchasePrice = purchasePrice;
		n1.saleOfDate = saleOfDate;
		if (head == null) {
			head = n1;
		} else {
			SaleDetails last = head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = n1;
		}
		n1.next = null;
	}

	public void saveToNode() {
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr); // read line by line
			String r1 = br.readLine();
			while (r1 != null) {
				String array[] = r1.split("\t");
				int saleId = Integer.parseInt(array[0]);
				int mobId = Integer.parseInt(array[1]);
				int customerId = Integer.parseInt(array[2]);

				int purchasePrice = Integer.parseInt(array[2]);

				addSaling(saleId, mobId, customerId, purchasePrice, array[4]);
				r1 = br.readLine();
			}
			br.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public SaleDetails search(int id) {
		SaleDetails n1 = head;
		while (n1.saleId != id) {
			n1 = n1.next;
			if (n1 == null) {
				return null;
			}
		}
		return n1;
	}

	public void displaySale() {
		SaleDetails n1 = head;
		while (n1 != null) {
			System.out.println(n1.saleId + "\t" + n1.mobId + "\t" + n1.CustomerId + "\t" + n1.purchasePrice + "\t"
					+ n1.saleOfDate);
			n1 = n1.next;
		}
	}
}