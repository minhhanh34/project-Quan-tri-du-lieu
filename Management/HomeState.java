package Management;

import java.util.Scanner;

public class HomeState implements State { 
	
	private StudentManagement manager;
	
	public HomeState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\n___Quản lý sinh viên___\n");
		System.out.println("\tTrang chủ\n");
		System.out.println(" 1. Danh sách sinh viên.");
		System.out.println(" 2. Thêm sinh viên.");
		System.out.println(" 3. Xóa sinh viên.");
		System.out.println(" 4. Tìm kiếm sinh viên.");
		System.out.println(" 5. Những sinh viên có điểm trung bình cao nhất.");
		//System.out.println(" 6. Điểm trung bình của sinh viên theo %.");
		System.out.println(" 6. Sửa Thông tin sinh viên.");
		System.out.println(" 7. Danh sách sinh viên theo phân loại.");
		System.out.println(" 8. Danh sách các môn học.");
		System.out.println(" 9. Thoát.");
	}
	
	@Override
	public void performAction() {
		handling();
	}

	private void handling() {
		switch(Respone.getRespone(1, 9)) {
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
//			case 6:
//				navigate(manager.getAveragePercentState());
//				break;
			case 6:
				navigate(manager.getEditionState());
				break;
			case 7:
				navigate(manager.getCategoryState());
				break;
			case 8:
				navigate(manager.getSubjectState());
				break;
			case 9:
				System.err.println("Chương trình kết thúc! ");
				System.exit(0);
		}
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
	
}
