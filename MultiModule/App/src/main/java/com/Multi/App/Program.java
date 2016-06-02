package com.Multi.App;


import com.Multi.Service.*;
import com.Multi.Model.*;
import java.util.*;

import java.net.URL;
public class Program{
	public static void main(String [] args)throws Exception{
		//Scanner input = new Scanner(System.in);
		ArrayList<Map<String, String>> tables = new ArrayList<Map<String, String>>();
		String path = new ProcessList().getPathFile();
		//ew Program().g();
		
		//System.out.println("awdas");
		System.out.println("Printing the contents of the file:");
		FullList lists = new FullList(tables, path);
		
		
		tables = lists.getArrayTable();
		//ProcessList.printResults(tables);
		
		boolean choosing = true;
		while(choosing){
			//ProcessList ProcessList = new ProcessList();
			try{
				System.out.println("Output Results:");
				ProcessList.printResults(tables);
				
				Scanner input = new Scanner(System.in);
				System.out.println("Choose Number:");
				System.out.println("1. Add\n2. Edit\n3. Ascending Sort\n4. Descending Sort\n5. Print\n6. Reload\n7. Save\n8. Exit");

				int inputNumber = input.nextInt();
				switch(inputNumber){
					case 1:
						ProcessList.chooseAdd(tables);
						break;
					case 2:
						ProcessList.chooseEdit(tables);
						break;
					case 3:
						ProcessList.chooseAscendingSort(tables);
						break;
					case 4:
						ProcessList.chooseDescendingSort(tables);
						break;
					case 5:
						ProcessList.printResults(tables);
						break;
					case 6:
						new FullList(tables, path);
						break;
					case 7:
						ProcessList.saveToFile(tables, path);
						new FullList(tables, path);
						break;
					case 8:
						choosing = false;
						break;
					default:
						System.out.println("Out of choices!");
						break;
				}
				tables = lists.getArrayTable();
			}
			catch(Exception err){
				System.out.println("Error: "+err.getMessage());
			}
		}
		System.out.println("\nProgram will exit\n");
	}
}
