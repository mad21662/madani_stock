package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import domain.StockException;

public class OracleConnection
{
	private Connection con;
	
	public OracleConnection() throws StockException {
		try {
			Class.forName("oracle.jdbc.OracleDriver");
		} catch (ClassNotFoundException e) {
			throw new StockException("Couldn't find database driver!");
		}
	}
	
	public void open() throws StockException {
		try {
			con = DriverManager.getConnection("jdbc:oracle:thin:localhost:1521", "DEMO" , "oracle");
		} catch (SQLException e) {
			throw new StockException("Couldn't open database Connection!");
		}
	}
	
	public void close() throws StockException {
		try {
			con.close();
		} catch (SQLException e) {
			throw new StockException("Couldn't open database Connection!");
		}
	}
	
	public Connection getConnection() {
		return con;
	}
	
}
