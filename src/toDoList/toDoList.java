package toDoList;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import toDoListEntity.ListItem;

public class toDoList {

	public static void main(String[] args) {
		//Create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(ListItem.class)
								.buildSessionFactory();
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
					//new code
					try {
						Session session = factory.getCurrentSession();
						session.beginTransaction();
						List<ListItem> allItems = session.createQuery("from listitems").list();
						for (ListItem tempItem : allItems) {
							System.out.println(tempItem);
						}
						session.getTransaction().commit();
						session.close();
//						if (allItems.size() == 0) {
//							System.out.println("ToDo List is Empty!");
//						} else {
//							for(int i = 0; i < allItems.size(); i++) {
//								int itemNumber = i+1;
//								System.out.println(itemNumber + ": " + allItems.get(i).getText());							
//							}
//						}
					}
					catch(Exception exc) {
						 
					} finally {
						factory.close();
					}

					//new code
					break;
				case 2:
					//Add ToDo Item	
					try {
						System.out.println("Enter your todo Item: ");
						Scanner scan2 = new Scanner(System.in);
						String input = scan2.nextLine();
						ListItem item = new ListItem(input);
						
						//start session
						Session session = factory.getCurrentSession();
						session.beginTransaction();
						session.save(item);
						session.getTransaction().commit();
						System.out.println("Item added!");
						session.close();
						break;
						
						
					}
					catch(Exception exc) {
						factory.close();
					}
					
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
		factory.close();

	}
}
