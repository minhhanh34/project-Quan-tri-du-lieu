package Management;

public class SearchState implements State {

	StudentManagement manager;
	
	public SearchState(StudentManagement manager) {
		this.manager = manager;
	}	
	
	@Override
	public void display() {
		System.out.println("\tTìm kiếm sinh viên\n");
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
		System.out.println("\t1. Tiếp tục tìm.");
		System.out.println("\t2. Trang chủ.");
	}

	private void searchStudent() {
		// Tìm sinh viên trong csdl
		
		
		handing();
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
