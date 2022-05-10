package Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Locale;

public class SubjectState implements State{
	
	private StudentManagement manager;
	
	public SubjectState(StudentManagement manager) {
		this.manager = manager;
	}

	@Override
	public void display() {
		System.out.println("\n\tThông tin môn học\n");
	}

	@Override
	public void performAction() {
		showDetailSubject();
		handling();
	}

	private void showDetailSubject() {
		Connection connection = DatabaseConnection.getInstance();
		
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM giangvien");
			
            System.out.printf(" %-30s%-15s%-20s%n%n", "Môn học", "Mã GV", "Tên GV");
			while(result.next()) {
				String id = result.getString("maGV").strip();
				String name = result.getString("tenGV").strip();
				String subject = result.getString("tenMonHoc").strip();
				
                System.out.printf(" %-34s%-15s%-20s%n", subject, id, name);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void handling() {
		showListChoose();
		Respone.getRespone(1, 1);
		navigate(manager.getHomeState());
	}

	private void showListChoose() {
		System.out.println("\n 1. Trang chủ.");
	}

	private void navigate(State homeState) {
		manager.setState(homeState);
		manager.run();
	}
	
	

}
