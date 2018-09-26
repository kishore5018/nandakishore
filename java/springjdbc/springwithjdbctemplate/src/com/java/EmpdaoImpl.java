package com.java;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.JdbcTemplate;

public class EmpdaoImpl implements Empdao {
	
	
	private JdbcTemplate jdbcTemplate;
	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void insert(Employee employee) {
	  String query="insert into spwdata (id,username,password) values(?,?,?)";
	  Object[] args=new Object[]{employee.getId(),employee.getUsername(),employee.getPassword()};
		int i=jdbcTemplate.update(query, args);
		if(i==1){
			System.out.println("Insert Success");
		}else{
			System.out.println("Insert Not Sucess");
		}
	}

	@Override
	public List<Employee> fetch() {

		String query="select * from spwdata";
		List<Employee> ll=new ArrayList<>();
		
		List<Map<String, Object>> l=jdbcTemplate.queryForList(query);
		for(Map<String,Object> m:l){
			Employee e=new Employee();
			e.setId(Integer.parseInt(String.valueOf(m.get("id"))));
			e.setUsername(String.valueOf(m.get("username")));
			e.setPassword(String.valueOf(m.get("password")));
			ll.add(e);
		}
		
		System.out.println(ll);
		return ll;
	}

	@Override
	public void update(Employee employee) {
		 String query="update spwdata set username=?,password=? where id=?";
		  Object[] args=new Object[]{employee.getUsername(),employee.getPassword(),employee.getId()};
			int i=jdbcTemplate.update(query, args);
			if(i==1){
				System.out.println("Update Success");
			}else{
				System.out.println("Update Not Sucess");
			}	
	}

	@Override
	public void delete(Employee employee) {
		String query="delete from spwdata where id=?";
		  Object[] args=new Object[]{employee.getId()};
			int i=jdbcTemplate.update(query, args);
			if(i==1){
				System.out.println("Delete Success");
			}else{
				System.out.println("Delete Not Sucess");
			}	
		
	}

}
