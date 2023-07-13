package com.arjun.practice;

public class Employee {
	
	private int empId;
	private String empName;
	private int empDept;
	private String status = "active";
	private int salary;
	
	
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empDept=" + empDept + ", status=" + status
				+ ", salary=" + salary + "]";
	}

	
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public int getEmpDept() {
		return empDept;
	}
	public void setEmpDept(int empDept) {
		this.empDept = empDept;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public int getSalary() {
		return salary;
	}
	public void setSalary(int salary) {
		this.salary = salary;
	}
	
	public Employee(int empId, String empName, int empDept, String status, int salary) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.empDept = empDept;
		this.status = status;
		this.salary = salary;
	}
	

}
