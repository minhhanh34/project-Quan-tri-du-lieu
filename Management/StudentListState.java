package Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class StudentListState implements State {
	
	private StudentManagement manager;
	
	public StudentListState(StudentManagement manager) {
		this.manager = manager;
	}	
	
	@Override
	public void display() {
		System.out.println("\n\tDanh sách sinh viên\n");
	}
	
	@Override
	public void performAction() {
		showStudentList();
		handling();
	}
	
	private void handling() {
		showListChoose();
		Respone.getRespone(1, 1);
		navigate(manager.getHomeState());
	}

	private void showListChoose() {
		System.out.println("\n1. Về trang chủ.");
	}

	public void showStudentList() {
		Connection connection = DatabaseConnection.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM sinhvien");
			System.out.printf("   %-7s|    %-11s|  %-6s|   %-7s\n", "MSSV", "Họ tên", "Lớp", "Giới tính");
			while(result.next()) {
				String mssv = result.getString("MSSV");
				String ten = result.getString("Ten");
				String diaChi = result.getString("DiaChi");
				String lop = result.getString("Lop");
				String gioiTinh = result.getString("GioiTinh");
				System.out.printf("%-10s|%-15s|%-8s|     %-5s\n", mssv, ten, lop, gioiTinh);
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}
	
	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
