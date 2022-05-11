package Management;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.util.Scanner;

public class AdditionState implements State {

	private StudentManagement manager;
	
	public AdditionState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\n\tThêm sinh viên\n");
	}
	
	@Override
	public void performAction() {
		addStudent();
		handing();
	}
	
	
	private void handing() {
		showListChoose();
		if(Respone.getRespone(1, 2) == 1) {
			addStudent();
		} else {
			navigate(manager.getHomeState());
		}
	}

	private void showListChoose() {
		System.out.println("\n\t1. Tiếp tục thêm.");
		System.out.println("\t2. Trang chủ.");
	}

	private void addStudent() {
		Connection connection = DatabaseConnection.getInstance();
		Scanner sc = new Scanner(System.in);
		System.out.print("MSSV: ");
		String mssv = sc.nextLine();
		System.out.print("Họ tên: ");
		String name = sc.nextLine();
		System.out.print("Địa chỉ: ");
		String address = sc.nextLine();
		System.out.print("Lớp: ");
		String grade = sc.nextLine();
		System.out.print("SĐT: ");
		String phone = sc.nextLine();
		System.out.print("Giới tính: ");
		String gender = sc.nextLine();
		
		System.out.print("Điểm Quản trị hệ thống: ");
		double qtht = sc.nextDouble();
		System.out.print("Điểm Phân tích thiết kế hệ thống: ");
		double pttkht = sc.nextDouble();
		System.out.print("Điểm Quản trị dữ liệu: ");
		double qtdl = sc.nextDouble();
		
		try {
			PreparedStatement prepareStatementSinhVien = connection.prepareStatement("INSERT INTO sinhvien values (?, ?, ?, ?, ?, ?)");
			PreparedStatement prepareStatementDiem = connection.prepareStatement("INSERT INTO diem values (?, ?, ?, ?)");
			
			prepareStatementSinhVien.setString(1, mssv);
			prepareStatementSinhVien.setString(2, name);
			prepareStatementSinhVien.setString(3, address);
			prepareStatementSinhVien.setString(4, grade);
			prepareStatementSinhVien.setString(5, phone);
			prepareStatementSinhVien.setString(6, gender);
			prepareStatementSinhVien.executeUpdate();
			
			prepareStatementDiem.setString(1, mssv);
			prepareStatementDiem.setDouble(2, qtht);
			prepareStatementDiem.setDouble(3, pttkht);
			prepareStatementDiem.setDouble(4, qtdl);
			int row = 0;
			row = prepareStatementDiem.executeUpdate();
			
			if(row != 0)
				System.out.println("\n Thêm thành công!");
			else 
				System.out.println("\n Thêm thất bại!");
		} catch (Exception e) {
			System.out.println("\n ERROR! - " + e.getMessage());
		}
		
		handing();
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
