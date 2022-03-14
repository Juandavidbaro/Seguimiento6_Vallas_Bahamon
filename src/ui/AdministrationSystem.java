package ui;

import java.io.IOException;
import java.util.Scanner;
import model.*; 

public class AdministrationSystem {
	
	private Scanner sca; 
	private BillboardList bList; 
	
	public AdministrationSystem() throws ClassNotFoundException, IOException {
		sca = new Scanner(System.in);
		bList = new BillboardList(); 
		bList.deserializar();
		
	}
	
	public static void main(String[] args) throws IOException, ClassNotFoundException{
		
		AdministrationSystem adS = new AdministrationSystem(); 
		
		System.out.println("***************************************"); 
		System.out.println("               Welcome               \n");
		System.out.println("***************************************"); 
		
		int option = -1; 
		do {
			option = adS.menuOption(); 
			adS.menu(option);
		}while(option!=0);
		
		
	} 
	
	public int menuOption() {
		int option = 0; 
		
		System.out.println("Enter the option that do you want\n");
		System.out.println("Menu option\n"+
						"(1) Data import\n"+
						"(2) Add billboard\n"+
						"(3) Show billboardList\n"+
						"(4) Export hazard report\n"+
						"(0) Close program\n");
		
		try {
			option = sca.nextInt(); 
		}catch(Exception e) {
			e.printStackTrace();
			option = -1;
		}
		sca.nextLine(); 
		return option; 
	}
	
	@SuppressWarnings("unused")
	public void menu(int optionUser) throws IOException, ClassNotFoundException {
		
		switch(optionUser){
		case 0: 
			System.out.println("*** The program has been closed ***");
			bList.serializar();
			break; 
		case 1: 
			String fileImport = dataImport();
			bList.loadBillboards(fileImport); 
			System.out.println("*** Data import with successfully ***\n");
			break; 
		case 2:
			String data =dataBillboard();
			Billboard obj =bList.creatBillboard(data);
			bList.addBillboard(obj);
			System.out.println("*** Billboard add with successfully ***\n");
			break; 
		case 3: 
			System.out.println(bList.listBillboards());
			
			break; 
		case 4: 
			String report = bList.reportBillboard();
			System.out.println(report);
			bList.writeReport(report);
			System.out.println("\n\n*** Report saved with successfully ***\n");
			
			break; 
		default: 
			System.out.println("*** Incorrect option ***");
			break; 
		}
	}

	public String dataImport() {
		String  url = ""; 
 
		System.out.println("Please, enter the url of the file to import");
		
		System.out.println("Enter this path: .\\\\files\\\\Datos1.csv or another url\n");
		
		url = sca.nextLine(); 		
		
		return url;
	}

	public String dataBillboard() {
		String out = "";
		
		System.out.println("Enter the following data with sepatation ++ betwwen them\n"+
		"for example: heigt++width++inUse++brand");
		
		out = sca.nextLine(); 
		return out; 
	}
	
	
}
