package com.demo.TransactionalDemo.dto;


public class employee {
	
	private int empId;
	private String empName;
	
	public employee() {
		super();
	}
	public employee(int empId, String empName) {
		super();
		this.empId = empId;
		this.empName = empName;
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
	@Override
	public String toString() {
		return "employee [empId=" + empId + ", empName=" + empName + "]";
	}
	
	
	
	

}
