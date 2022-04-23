package Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchState implements State {

	StudentManagement manager;
	
	public SearchState(StudentManagement manager) {
		this.manager = manager;
	}	
	
	@Override
	public void display() {
		System.out.println("\n\tTìm kiếm sinh viên\n");
	}
	
	@Override
	public void performAction() {
		searchStudent();
		handing();
	}
	
	
	private void handing() {
		showListChoose();
		if(Respone.getRespone(1, 2) == 1) {
			searchStudent();
		} else {
			navigate(manager.getHomeState());
		}
	}

	private void showListChoose() {
		System.out.println("\n\t1. Tiếp tục tìm.");
		System.out.println("\t2. Trang chủ.");
	}

	public void searchStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("MSSV: ");
		String mssv = sc.nextLine();
		Connection connection = DatabaseConnection.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT * FROM sinhvien WHERE MSSV = \"" + mssv + "\"");
			if(result.next()) {
				System.out.println();
				System.out.println("MSSV     : " + result.getString("MSSV"));
				System.out.println("Họ tên   : " + result.getString("Ten"));
				System.out.println("Lớp      : " + result.getString("Lop"));
				System.out.println("Địa chỉ  : " + result.getString("DiaChi"));
				System.out.println("SDT      : " + result.getString("soDienThoai"));
				System.out.println("Giới tính: " + result.getString("gioiTinh"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		handing();
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
