package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	
	Scanner scan = new Scanner (System.in);
	Random rand = new Random();
	
	
	ArrayList <Employee> employeeList = new ArrayList<>();
	
	
	public Main() {
		
		int action;
		
		do {
			
			printingMenu();
			
			System.out.print(">> ");
			action = scan.nextInt();
			scan.nextLine();
			
			if (action == 1) addAssistant();
			else if (action == 2) viewEmployee();
			else if (action == 3) resignEmployee();
			else if (action == 4) {
				System.out.println("\nThank you for using NAR Program :)\n");
				break;
			}
			
		}
		
		while (true);
		
	}
	
	public void addAssistant() {
		
		String employeeName, employeeRole, employeeType;
		int employeeAge, employeeWorkhour, employeeSalary;
		
		System.out.println("Add New Assistant");
		System.out.println("======================\n");
		
		do {
			
			System.out.print("Input Employee's Name [>= 2 Words]: ");
			employeeName = scan.nextLine();
			
			String[] words = employeeName.trim().split("\\s+");
			if (words.length >= 2) {
				break;
			}
			
		}
		
		while (true);
		
		do {
			
			System.out.print("Input Employee's Age [>= 17]: ");
			employeeAge = scan.nextInt();
			
			if (employeeAge >= 17) break;
			
		}
		
		while (true);
		
		do {
			
			System.out.print("Input Employee's Role ['Assistant' | 'Subject Coordinator' | 'Network Administrator']: ");
			employeeRole = scan.nextLine();
			
			if (employeeRole.equalsIgnoreCase("Assistant") || employeeRole.equalsIgnoreCase("Subject Coordinator") ||
					employeeRole.equalsIgnoreCase("Network Administrator")) break;
			
		}
		
		while (true);
		
		do {
			
			System.out.print("Input Employee's Type ['Parttime' | 'Fulltime' | 'Lifetime']: ");
			employeeType = scan.nextLine();
			
			if (employeeType.equalsIgnoreCase("Parttime") || employeeType.equalsIgnoreCase("Fulltime") ||
					employeeType.equalsIgnoreCase("Lifetime")) break;
			
		}
		
		while (true);
		
		if (employeeType.equalsIgnoreCase("Parttime")){
			
			do {
				
				System.out.print("Input Employee's Pay Hour [>= 10000]: ");
				employeeSalary = scan.nextInt();
				
				if (employeeSalary >= 10000) break;
				
			}
			
			while (true);
			
			do {
				
				System.out.print("Input Employee's Hour per Week [> 0]: ");
				employeeWorkhour = scan.nextInt();
				
				if (employeeWorkhour >= 1) break;
				
			}
			
			while (true);
			
			employeeList.add(new Parttime(employeeName, employeeRole, employeeType, "Active", employeeAge, employeeSalary, 10));
			
		}
		
		else if (employeeType.equalsIgnoreCase("Fulltime")){
			
			do {
				
				System.out.print("Input Employee's Base Salary [>= 100000]: ");
				employeeSalary = scan.nextInt();
				
				if (employeeSalary >= 100000) break;
				
			}
			
			while (true);
			
			employeeList.add(new Fulltime(employeeName, employeeRole, employeeType, "Active", employeeAge, employeeSalary, 46));
			
		}
		
		else {
			
			employeeList.add(new Lifetime(employeeName, employeeRole, employeeType, "Active", employeeAge, 10000000, 36));
			
		}
		
		System.out.println("\nAdd Employee Succeed\n");
		
		entering();
		
	}
	
	public boolean viewEmployee() {
		
		if (employeeList.size() == 0) {
			System.out.println("There is no Employee at LCAS");
			entering();
			return false;
		}
		
		else {
			int index = 1;
			
			for (Employee employee : employeeList) {
				
				System.out.printf("\nEmployee %d\n", index++);
				System.out.printf("%s Employee\n", employee.getEmployeeType());
				System.out.println("========================");
				System.out.printf("Status: %s\n", employee.getStatus());
				System.out.printf("Name: %s\n", employee.getEmployeeName());
				System.out.printf("Age: %d\n", employee.getAge());
				System.out.printf("Role: %s\n", employee.getEmployeeRole());
				
				if (employee instanceof Fulltime && employee instanceof Lifetime) {
					System.out.printf("Base Salary per Month %d\n", employee.getSalary());
				}
				
				else {
					System.out.printf("Working Hour per Week: %d\n", employee.getTime());
					System.out.printf("Salary per Hour: %d\n", employee.getSalary());
				}
				
				System.out.println();
				
			}
		}
		
		entering();
		return true;
		
	}

	public void resignEmployee() {
		
		int resignEmployee;
		
		if (employeeList.size() == 0) return;
		
		viewEmployee();
		
		do {
			
			System.out.printf("Input employee number that want to resign [%d..%d]: ", 1, employeeList.size());
			resignEmployee = scan.nextInt();
			scan.nextLine();
			
			if (resignEmployee >= 1 && resignEmployee <= employeeList.size()) break;
			
		}
		
		while (true);
		
		Employee resignedEmployee = employeeList.get(resignEmployee-1);
		
		if (resignedEmployee.getStatus().equals("Active")) {
			System.out.printf("%s is resigning... say goodbye :(\n", resignedEmployee.getEmployeeName());
			resignedEmployee.setStatus("Not Active");
		}
		
		else if (resignedEmployee.getStatus().equals("Not Active")) {
			System.out.printf("%s is already resigned\n", resignedEmployee.getEmployeeName());
		}
		
		else if (resignedEmployee.getEmployeeRole().equals("Lifetime")) {
			System.out.println("Don't go anywhere master!");
		}
		
		entering();
		return;
		
	}
	
	
	public void entering() {
		System.out.println("Press enter to continue");
		scan.nextLine();
	}
	
	
	public void printingMenu() {
		
		System.out.println("NAR Menu");
		System.out.println("====================");
		System.out.println("1. Add Assistant");
		System.out.println("2. View Employee");
		System.out.println("3. Resign?");
		System.out.println("4. Exit");
		
	}
	
	public static void main(String[] args) {
		new Main();
	}

}
