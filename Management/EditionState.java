package Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

import com.mysql.cj.protocol.Resultset;

public class EditionState implements State {
	
	StudentManagement manager;
	
	public EditionState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\n\tSửa thông tin\n");
	}
	
	@Override
	public void performAction() {
		editStudentInfo();
		//handing();
	}
	
	
	
	private void handing(String mssv) {
		Scanner sc = new Scanner(System.in);
		switch(Respone.getRespone(1, 7)) {
		
			case 1:
				String newMSSV = getNew("MSSV");
				updateToDatabase("mssv", mssv, newMSSV);
				break;
			case 2:
				String newName = getNew("Họ tên");
				updateToDatabase("Ten", mssv, newName);
				break;
			case 3:
				String newAddress = getNew("Địa chỉ");
				updateToDatabase("DiaChi", mssv, newAddress);
				break;
			case 4:
				String newClass = getNew("Lớp");
				updateToDatabase("Lop", mssv, newClass);
				break;
			case 5:
				String newPhoneNumber = getNew("Số điện thoại");
				updateToDatabase("soDienThoai", mssv, newPhoneNumber);
				break;
			case 6:
				String newGender = getNew("Giới tính");
				updateToDatabase("GioiTinh", mssv, newGender);
				break;
			case 7:
				break;
		}
		
		showListChoose();
		if(Respone.getRespone(1, 2) == 1) {
			editStudentInfo();
		} else {
			navigate(manager.getHomeState());
		}
	}
	
	

	private void updateToDatabase(String field, String mssv, String newValue) {
		Connection connection = DatabaseConnection.getInstance();
		try {
			Statement statement = connection.createStatement();
			statement.executeUpdate("UPDATE sinhvien SET " + field + " = \"" + newValue + "\" WHERE mssv = \"" + mssv + "\"");
			if(field == "mssv") {
				statement.executeUpdate("UPDATE diem SET " + field + " = \"" + newValue + "\" WHERE mssv = \"" + mssv + "\"");
			}
			System.out.println("\n Sửa thành công!");
		} catch (Exception e) {
			System.out.println("\n Thất bại!");
		}
	}

	private String getNew(String field) {
		Scanner sc = new Scanner(System.in);
		System.out.print(field + " mới: ");
		String value = sc.nextLine();
		return value;
	}

	private void showListChoose() {
		System.out.println();
		System.out.println("\t1. Tiếp tục Sửa.");
		System.out.println("\t2. Trang chủ.");
	}

	private void editStudentInfo() {
		System.out.print("MSSV của sinh viên cần sửa: ");
		Scanner sc = new Scanner(System.in);
		String mssv = sc.nextLine();
		showOption();
		handing(mssv);
	}
	
	private void showOption() {
		System.out.println();
		System.out.println("Mục cần sửa: ");
		System.out.println("1. MSSV.");
		System.out.println("2. Họ tên.");
		System.out.println("3. Địa chỉ.");
		System.out.println("4. Lớp.");
		System.out.println("5. Số điện thoại.");
		System.out.println("6. Giới tính.");
		System.out.println("7. Trở về.");
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
