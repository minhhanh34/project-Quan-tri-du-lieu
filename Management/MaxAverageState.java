package Management;

public class MaxAverageState implements State {

	StudentManagement manager;
	
	public MaxAverageState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\tĐiểm trung bình cao nhất\n");
	}
	
	@Override
	public void performAction() {
		maxAverageStudent();
		handing();
	}
	
	private void handing() {
		navigate(manager.getHomeState());
	}

	private void maxAverageStudent() {
		// Tìm sinh viên có điểm trung bình cao nhất trong csdl
		
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
