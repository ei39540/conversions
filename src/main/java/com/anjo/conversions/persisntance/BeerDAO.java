package com.anjo.conversions.persisntance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class BeerDAO {
	
	Connection conn = null;

	public BeerDAO()
	{
		try {
			Class.forName("org.sqlite.JDBC");
			conn = connect();
		}
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	private Connection connect() {
		Connection tmpConn = null;
		try {
			// db parameters
			String url = "jdbc:sqlite:Beers.db";
			//String url = "jdbc:sqlite:c:/Dev/Beers.db";
			// create a connection to the database
			tmpConn=  DriverManager.getConnection(url);
			System.out.println("Connection to SQLite has been established.");
			//createDB();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return tmpConn;
	}
	
	public void disConnect()
	{
		try{
			if (conn != null){
				conn.close();
			}
		}catch (SQLException ex) {
			System.out.println("In disConnect(): "+ex.getMessage());
		}
	}
	
	public void createDB()
	{
		String sql="CREATE TABLE IF NOT EXISTS beers(name VARCHAR(100))";
		try{
			Statement stmt = conn.createStatement(); 
			stmt.executeQuery(sql);
		}
		 catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public ArrayList<String> getBeers()
	{
		ArrayList<String> arrList=new ArrayList<String>();
		String sql = "SELECT * FROM beers";
		//List<Beer> beers = jdbcTemplate.query("SELECT * FROM beers",
		//		(resultSet, rowNum) -> new Beer(resultSet.getString("name")));
		try (Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(sql)) {
			
			while(rs.next()) 
			{
				//System.out.println(rs.getString(1));
				arrList.add(rs.getString(1));
			}
			
		}
		 catch (SQLException e) {
			System.out.println(e.getMessage());
		}
		return arrList;
	}
	public void addBeer(String beer)
	{
		String sql = "INSERT INTO beers VALUES ('"+beer+"')";
		//List<Beer> beers = jdbcTemplate.query("SELECT * FROM beers",
		//		(resultSet, rowNum) -> new Beer(resultSet.getString("name")));
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
		
			
			
			
		}
		 catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	public void deleteBeer(String beer)
	{
		String sql = "DELETE FROM beers WHERE name='"+beer+"'";
		//List<Beer> beers = jdbcTemplate.query("SELECT * FROM beers",
		//		(resultSet, rowNum) -> new Beer(resultSet.getString("name")));
		try {
			Statement stmt = conn.createStatement(); 
			ResultSet rs = stmt.executeQuery(sql);
		
			
			
			
		}
		 catch (SQLException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
