package com.demo.TransactionalDemo.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.demo.TransactionalDemo.dto.employee;

@Repository
public class empRepo {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void saveEmployee(employee empObj)
	{
		String sql="INSERT INTO employee VALUES (?,?);";
	Object[] args=	{empObj.getEmpId(),empObj.getEmpName()};
		
		jdbcTemplate.update(sql,args);
		System.out.println("record inserted!!!");
	}

}
