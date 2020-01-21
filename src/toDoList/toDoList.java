package toDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class toDoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int menuOption = -1;		
		
		ArrayList<toDoItem> toDoList = new ArrayList();
		
		toDoItem newItem = new toDoItem();
		newItem.text = "First Item";
		toDoList.add(newItem);

		toDoItem newItem2 = new toDoItem();
		newItem2.text = "second Item";
		toDoList.add(newItem2);
		
		System.out.println("Welcome To Your To-Do List!\n"
				+ "Please Select An Option:\n"
				+ "1) View To-Do Items\n"
				+ "2) Add To-Do Item\n"
				+ "3) Remove To-Do Item\n"
				+ "4) Clear All Items\n"
				+ "5) Exit Program");
		
		Scanner scan = new Scanner(System.in);
		menuOption = scan.nextInt();
		
		while (menuOption != 5) {
			switch (menuOption) {
				case 1:
					//view list
					System.out.println(toDoList.size());
					for(int i = 0; i < toDoList.size(); i++) {
						int itemNumber = i+1;
						System.out.println(itemNumber + ": " + toDoList.get(i).text);
					}
					break;
				case 2:
					//add item
					break;
				case 3:
					//remove item
					break;
				case 4:
					//clear items
					break;
			}
			System.out.println("Enter Another Menu Choice:");
			menuOption = scan.nextInt();
			
		}
		System.out.println("Goodbye!");
		
		
//		
//		Scanner scan = new Scanner(System.in);
//		System.out.println("Please enter a To-Do Item:");
//		String todoItem = scan.nextLine();
//		toDoList.add(todoItem);

	}
}
