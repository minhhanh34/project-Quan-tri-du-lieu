package Management;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class MaxAverageState implements State {

	private StudentManagement manager;
	public static List<Average> averages = new ArrayList<Average>();
	private static List<Average> maxAverages = new ArrayList<Average>();
	
	public static class Average {
		public String mssv;
		public String name;
		public double avg;
		
		public Average(String mssv, String name, double avg) {
			this.mssv = mssv;
			this.name = name;
			this.avg  = avg;
		}
	}
	
	public MaxAverageState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\n\tĐiểm trung bình cao nhất\n");
	}
	
	@Override
	public void performAction() {
		getAverageListFromDatabase();
		findMaxAverage();
		getMaxAverageStudent();
		handling();
	}
	
	public void getMaxAverageStudent() {
		Connection connection = DatabaseConnection.getInstance();
		
		try {
			Statement statement = connection.createStatement();
			for(Average each : maxAverages) {
				ResultSet result = statement.executeQuery("SELECT * FROM sinhvien WHERE mssv = \"" + each.mssv + "\"");
				while(result.next()) {
					String mssv = result.getString("MSSV");
					String ten = result.getString("Ten");
					String lop = result.getString("Lop");
					
					System.out.println();
					System.out.println("MSSV           : " + mssv);
					System.out.println("Họ tên         : " + ten);
					System.out.println("Lớp            : " + lop);
					System.out.println("Điểm trung bình: " + each.avg);
				}
			}
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	private void findMaxAverage() {
		Average max = Collections.max(averages, new Comparator<Average>() {

			@Override
			public int compare(Average o1, Average o2) {
				// TODO Auto-generated method stub
				return o1.avg > o2.avg ? 1 : (o1.avg < o2.avg ? -1 : 0);
			}
		});
		
		maxAverages.clear();
		for(Average each : averages) {
			if(each.avg == max.avg) {
				maxAverages.add(each);
			}
		}
	}

	private void handling() {
		showListChoose();
		Respone.getRespone(1, 1);
		navigate(manager.getHomeState());
	}

	private void showListChoose() {
		System.out.println("\n1. Về trang chủ.");
	}

	public static void getAverageListFromDatabase() {
		Connection connection = DatabaseConnection.getInstance();
		try {
			Statement statement = connection.createStatement();
			ResultSet result = statement.executeQuery("SELECT *, Ten FROM diem a, sinhvien b Where a.mssv = b.mssv");
			averages.clear();
			while(result.next()) {
				double quanTriHeThong = result.getDouble("QuanTriHeThong");
				double phanTichThietKeHeThong = result.getDouble("PhanTichThietKeHeThong");
				double quanTriDuLieu = result.getDouble("QuanTriDuLieu");
				double avg = (quanTriHeThong + phanTichThietKeHeThong + quanTriDuLieu) / 3;
				avg = (double) Math.round(avg*100) / 100;
				
				String mssv = result.getString("MSSV");
				String name = result.getString("Ten");
				averages.add(new Average(mssv, name, avg));
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
