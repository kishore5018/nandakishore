package com.java;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class EmpdaoImpl implements Empdao{

	private DataSource dataSource;
	
	
	
	
	
	public DataSource getDataSource() {
		return dataSource;
	}

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void insert(Employee employee) {
		try{
		Connection conn=dataSource.getConnection();
		PreparedStatement pstmt=conn.prepareStatement("insert into spwdata (id,username,password) values(?,?,?)");
		pstmt.setInt(1, employee.getId());
		pstmt.setString(2, employee.getUsername());
		pstmt.setString(3, employee.getPassword());
		int i=pstmt.executeUpdate();
		if(i==1){
			System.out.println("Insert Success");
		}else{
			System.out.println("Insert Not Success");
		}
		
		}catch(Exception e){
			System.out.println(e);
		}
	}

	@Override
	public List<Employee> fetch() {
		List<Employee> ll=new ArrayList<>();
		try{
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement("select * from spwdata");
			ResultSet rs=pstmt.executeQuery();
			
			while(rs.next()){
				Employee e=new Employee();
				e.setId(rs.getInt("id"));
				e.setUsername(rs.getString("username"));
				e.setPassword(rs.getString("password"));
			ll.add(e);
			}
			
			System.out.println(ll);
		
		}catch(Exception e){
			System.out.println(e);
		}
		
		return ll;
	}

	@Override
	public void update(Employee employee) {
		try{
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement("update spwdata set username=?,password=? where id=?");
			pstmt.setString(1, employee.getUsername());
			pstmt.setString(2, employee.getPassword());
			pstmt.setInt(3, employee.getId());
			int i=pstmt.executeUpdate();
			if(i==1){
				System.out.println("Update Success");
			}else{
				System.out.println("Update Not Success");
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
		
		
	}

	@Override
	public void delete(Employee employee) {
		try{
			Connection conn=dataSource.getConnection();
			PreparedStatement pstmt=conn.prepareStatement("delete from spwdata where id=?");
			pstmt.setInt(1, employee.getId());
			int i=pstmt.executeUpdate();
			if(i==1){
				System.out.println("Delete Success");
			}else{
				System.out.println("Delete Not Success");
			}
			
			
		}catch(Exception e){
			System.out.println(e);
		}
		
	}

}
