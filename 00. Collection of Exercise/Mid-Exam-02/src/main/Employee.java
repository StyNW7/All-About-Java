package main;

public class Employee {
	
	private String employeeName;
	private String employeeRole;
	private String employeeType;
	private String status;
	private int age, salary, time;

	public Employee(String employeeName, String employeeRole, String employeeType, String status, int age, int salary,
			int time) {
		super();
		this.employeeName = employeeName;
		this.employeeRole = employeeRole;
		this.employeeType = employeeType;
		this.status = status;
		this.age = age;
		this.salary = salary;
		this.time = time;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getEmployeeRole() {
		return employeeRole;
	}

	public void setEmployeeRole(String employeeRole) {
		this.employeeRole = employeeRole;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getTime() {
		return time;
	}

	public void setTime(int time) {
		this.time = time;
	}

}
