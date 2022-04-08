package Management;

public class AdditionState implements State {

	private StudentManagement manager;
	
	public AdditionState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\tThêm sinh viên\n");
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
		System.out.println("\t1. Tiếp tục thêm.");
		System.out.println("\t2. Trang chủ.");
	}

	private void addStudent() {
		// Thêm sinh viên vào csdl
		
		
		handing();
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
