package test;

import java.sql.Connection;
import java.sql.SQLException;

import connection.OracleConnection;
import domain.StockException;

public class TestConncetion
{
	

	public static void main(String[] args) {
		try {
			OracleConnection oracleConnection = new OracleConnection();
			oracleConnection.open();
			Connection con = oracleConnection.getConnection();
			System.out.println(con.getMetaData().getDatabaseMajorVersion());
			oracleConnection.close();
		} catch (StockException | SQLException e) {
			System.err.println(e.getMessage());
		}
	}

}
