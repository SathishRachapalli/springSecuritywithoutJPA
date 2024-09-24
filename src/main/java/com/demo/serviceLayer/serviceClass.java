package com.demo.serviceLayer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.TransactionalDemo.dto.employee;
import com.demo.TransactionalDemo.repository.empRepo;

@Service
public class serviceClass {
	
	@Autowired
	private empRepo repo;
	
	
	@Transactional
	public void saveEmployeeInfo()
	{
		
		for(int i=1;i<=10;i++)
		{
			employee emp=new employee();
			emp.setEmpId(i);
			emp.setEmpName("testEmployee"+i);
			repo.saveEmployee(emp);
			
			if(i==7)
			{
				throw new RuntimeException("some error occured, and needs to rollback the transaction!!!");
			}
		}
		
		//repo.saveEmployee(null);   // in-order to save the employee record, we need to create employee object
	}

}
