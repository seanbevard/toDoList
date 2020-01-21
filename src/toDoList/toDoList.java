package toDoList;

import java.util.ArrayList;
import java.util.Scanner;

public class toDoList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//int to store menu choice
		int menuOption = -1;		
		
		//array to store items
		ArrayList<toDoItem> toDoList = new ArrayList();
		
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
					if (toDoList.size() == 0) {
						System.out.println("ToDo List is Empty!");
					} else {
						for(int i = 0; i < toDoList.size(); i++) {
							int itemNumber = i+1;
							System.out.println(itemNumber + ": " + toDoList.get(i).text);
						}
					}
					break;
				case 2:
					//Add ToDo Item
					System.out.println("Enter your todo Item: ");
					Scanner scan2 = new Scanner(System.in);
					String input = scan2.nextLine();
					toDoItem nextItem = new toDoItem();
					nextItem.text = input;
					toDoList.add(nextItem);
					System.out.println("Item added!");
					break;
				case 3:
					//remove item
					System.out.println("Enter the ToDo Item Number You Want to Remove:");
					Scanner scan3 = new Scanner(System.in);
					int deleteItem = scan3.nextInt();
					toDoList.remove(deleteItem-1);
					System.out.println("Item Removed from list!");
					break;
				case 4:
					//clear items
					toDoList.removeAll(toDoList);
					System.out.println("ToDo List Cleared!");
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
