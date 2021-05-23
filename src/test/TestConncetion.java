package test;

import connection.OracleConnection;
import domain.StockException;

public class TestConncetion
{
	

	public static void main(String[] args) {
		try {
			OracleConnection oracleConnection = new OracleConnection();
			oracleConnection.open();
			
			oracleConnection.close();
		} catch (StockException e) {
			System.err.println(e.getMessage());
		}
	}

}
