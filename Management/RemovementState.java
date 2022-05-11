package Management;

import java.sql.Connection;
import java.sql.Statement;
import java.util.Scanner;


public class RemovementState implements State {
	
	StudentManagement manager;
	
	public RemovementState(StudentManagement manager) {
		this.manager = manager;
	}	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("\n\tXóa sinh viên\n");
	}
	
	@Override
	public void performAction() {
		removeStudent();
		handing();
	}
	
	private void handing() {
		showListChoose();
		if(Respone.getRespone(1, 2) == 1) {
			removeStudent();
		} else {
			navigate(manager.getHomeState());
		}
	}

	private void showListChoose() {
		System.out.println("\n\t1. Tiếp tục xóa.");
		System.out.println("\t2. Trang chủ.");
	}

	private void removeStudent() {
		Scanner sc = new Scanner(System.in);
		System.out.print("MSSV: ");
		String mssv = sc.nextLine();
		try {
			Connection connection = DatabaseConnection.getInstance();
			Statement statement = connection.createStatement();
			int row1 = 0, row2 = 0;
			row1 = statement.executeUpdate("DELETE FROM sinhvien WHERE MSSV = \"" + mssv + "\"");
			row2 = statement.executeUpdate("DELETE FROM diem WHERE MSSV = \"" + mssv + "\"");
			if(row1 != 0 && row2 != 0)
				System.out.println("\n Xóa thành công!");
			else
				System.out.println("\n Xóa thất bại!");
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
