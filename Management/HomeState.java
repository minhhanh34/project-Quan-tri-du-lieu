package Management;

import java.util.Scanner;

public class HomeState implements State { 
	
	private StudentManagement manager;
//	private int respone = 0;
	
	public HomeState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("___Quản lý sinh viên___\n");
		System.out.println("\tTrang chủ\n");
		System.out.println(" 1. Danh sách sinh vien.");
		System.out.println(" 2. Thêm sinh viên.");
		System.out.println(" 3. Xóa sinh viên.");
		System.out.println(" 4. Tìm kiếm sinh viên.");
		System.out.println(" 5. Những sinh viên có điểm trung bình cao nhất.");
		System.out.println(" 6. Điểm trung bình của sinh viên theo %.");
		System.out.println(" 7. Sửa Thông tin sinh viên.");
		System.out.println(" 8. Danh sách sinh viên theo phân loại.");
	}
	
	@Override
	public void performAction() {
//		getRespone();
		handling();
	}
	
//	private void getRespone() {
//		Scanner sc = new Scanner(System.in);
//		do {
//			System.out.println("\nLựa chọn: ");
//			respone = sc.nextInt();
//			if(respone <= 0 || respone > 8)
//				System.out.println("Lựa chọn không hợp lệ! Chọn lại.");
//		} while (respone <= 0 || respone > 8);
//		//sc.close();
//	}

	private void handling() {
		switch(Respone.getRespone(1, 8)) {
			case 1:
				navigate(manager.getStudentListState());
				break;
			case 2:
				navigate(manager.getAdditionState());
				break;
			case 3:
				navigate(manager.getRemovementState());
				break;
			case 4:
				navigate(manager.getSearchState());
				break;
			case 5:
				navigate(manager.getMaxAverageState());
				break;
			case 6:
				navigate(manager.getAveragePercentState());
				break;
			case 7:
				navigate(manager.getEditionState());
				break;
			case 8:
				navigate(manager.getCategoryState());
				break;
		}
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
	
}
