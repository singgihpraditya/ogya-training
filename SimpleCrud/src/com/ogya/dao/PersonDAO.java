package com.ogya.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.ogya.entity.Person;
import com.ogya.util.ConnectionManager;

import oracle.jdbc.OracleTypes;

public class PersonDAO {
	public void addPerson(Person person){
		System.out.println("Add person : "+person.toString());
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			String sqlQuery = "insert into person"
					+ "(id, first_name, last_name, address, position) "
					+ "values(?,?,?,?,?)";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, person.getId());
			preparedStatement.setString(2, person.getFirstName());
			preparedStatement.setString(3, person.getLastName());
			preparedStatement.setString(4, person.getAddress());
			preparedStatement.setString(5, person.getPosition());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			
			System.out.println("Insert success");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	public void updatePerson(Person person){
		System.out.println("Update person : "+person.toString());
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			String sqlQuery = "update person "
					+ "set first_name=?, "
					+ "last_name=?, "
					+ "address=?, "
					+ "position=? "
					+ "where id=? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			
			preparedStatement.setString(1, person.getFirstName());
			preparedStatement.setString(2, person.getLastName());
			preparedStatement.setString(3, person.getAddress());
			preparedStatement.setString(4, person.getPosition());
			preparedStatement.setString(5, person.getId());
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			
			System.out.println("Update success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deletePerson(String id){
		System.out.println("Delete person with id : "+id);
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			String sqlQuery = "delete from person where id=? ";
			
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, id);
			preparedStatement.executeUpdate();
			
			preparedStatement.close();
			connection.close();
			
			System.out.println("Delete success");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public List<Person> getAll(){
		System.out.println("Get all person");
		List<Person> personList = new ArrayList<Person>();
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			String sqlQuery = "select id, first_name, last_name, position, address from person";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			ResultSet resultSet = preparedStatement.executeQuery();
			while(resultSet.next()){
				String id = resultSet.getString("id");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String position = resultSet.getString("position");
				String address = resultSet.getString("address");
				
				Person person = new Person();
				person.setId(id);
				person.setAddress(address);
				person.setFirstName(firstName);
				person.setLastName(lastName);
				person.setPosition(position);
				personList.add(person);
			}

			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return personList;
	}
	
	public Person getById(String id){
		System.out.println("Get person by id");
		Person person = new Person();
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			String sqlQuery = "select * from person where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(sqlQuery);
			preparedStatement.setString(1, id);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()){
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String position = resultSet.getString("position");
				String address = resultSet.getString("address");
	
				person.setId(id);
				person.setAddress(address);
				person.setFirstName(firstName);
				person.setLastName(lastName);
				person.setPosition(position);
			}

			preparedStatement.close();
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return person;
	}
	
	public Person getByIDStoreProcedure(String id){
		Person person = new Person();
		ConnectionManager connectionManager = new ConnectionManager();
		try {
			Connection connection = connectionManager.getConnection();
			String sqlQuery = "{call GET_PERSON_BY_ID(?,?)}";
			CallableStatement callableStatement = connection.prepareCall(sqlQuery);
			callableStatement.setString(1, id);
			callableStatement.registerOutParameter(2, OracleTypes.CURSOR);
			callableStatement.executeQuery();
			
			ResultSet resultSet = (ResultSet) callableStatement.getObject(2);
			
			if(resultSet.next()){
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				String position = resultSet.getString("position");
				String address = resultSet.getString("address");
	
				person.setId(id);
				person.setAddress(address);
				person.setFirstName(firstName);
				person.setLastName(lastName);
				person.setPosition(position);
			}

			callableStatement.close();
			connection.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return person;
	}
}











