package Management;

import java.sql.Connection;
import java.sql.DriverManager;

public final class DatabaseConnection {
	private static Connection instance;
	
	private DatabaseConnection() {
		
	}
	
	public static Connection getInstance() {
		if(instance == null) {
			try {
				instance = DriverManager.getConnection("jdbc:mysql://localhost/qlsv?user=root");
			} catch (Exception e) {
				System.out.println("\n ERROR! - " + e.getMessage());
			}
		}
		return instance;
	}
}
