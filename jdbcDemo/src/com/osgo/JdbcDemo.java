package com.osgo;

import com.osgo.dao.JdbcDaoImpl;
import com.osgo.model.Circle;

public class JdbcDemo
{
	public static void main(String[] args)
	{
		// initialise a DAO
		// call a method of the DAO which will fetch the data
		Circle circle = new JdbcDaoImpl().getCircle(1);
		System.out.println(circle.getName());

	} // end method main

} // end Class jdbcDemo
