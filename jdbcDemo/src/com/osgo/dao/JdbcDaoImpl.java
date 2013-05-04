package com.osgo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.osgo.model.Circle;

// this class is responsible for talking to the database and getting the data
public class JdbcDaoImpl
{
	public Circle getCircle(int circleId)
	{
		// 1st thing needed is a connection object
		Connection conn = null;
		
		try
		{
		// initialise the client driver
		String driver = "org.apache.derby.jdbc.ClientDriver";
		// create a new instance
		Class.forName(driver).newInstance();
			
		// create a connection
		conn = DriverManager.getConnection("jdbc:derby://localhost:1527/db");
			
		// create a prepared statement, then set id value
		// pass SQL query in PreparedStatement
		PreparedStatement ps = conn.prepareStatement("SELECT * FROM circle where id = ?");
		// set the id
		ps.setInt(1, circleId);
			
		// initialise a circle object to assign the result to the circle object
		Circle circle = null;
		ResultSet rs = ps.executeQuery();
			
		// if there is a record then assign that to a new circle
		if (rs.next())
		{
			circle = new Circle(circleId, rs.getString("name"));
		} // end if
			
		// close the RecordSet
		rs.close();
			
		// close the PreparedStatement
		ps.close();
			
		return circle;
		} // end try
		
		catch (Exception exception)
		{
			throw new RuntimeException(exception);
		} // end catch
		
		finally
		{
			try
			{
				// close the connection
				conn.close();
			}
			catch (SQLException exception)
			{
			} // end catch
		} //  end finally block
					
	} // end method getCircle

} // end Class jdbcDaoImpl
