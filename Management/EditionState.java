package Management;

public class EditionState implements State {
	
	StudentManagement manager;
	
	public EditionState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\tSửa thông tin\n");
	}
	
	@Override
	public void performAction() {
		editStudentInfo();
		handing();
	}
	
	
	private void handing() {
		showListChoose();
		if(Respone.getRespone(1, 2) == 1) {
			editStudentInfo();
		} else {
			navigate(manager.getHomeState());
		}
	}

	private void showListChoose() {
		System.out.println("\t1. Tiếp tục Sửa.");
		System.out.println("\t2. Trang chủ.");
	}

	private void editStudentInfo() {
		// sửa thông tin sinh viên trong csdl
		
		
		handing();
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
