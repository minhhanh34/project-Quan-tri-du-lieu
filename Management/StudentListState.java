package Management;

public class StudentListState implements State {
	
	private StudentManagement manager;
	
	public StudentListState(StudentManagement manager) {
		this.manager = manager;
	}	
	
	@Override
	public void display() {
		System.out.println("\tDanh sách sinh viên\n");
	}
	
	@Override
	public void performAction() {
		showStudentList();
		navigate(manager.getHomeState());
	}
	
	public void showStudentList() {
		// kết nối mysql ở đây và hiển thị ra danh sách sinh viên
	}
	
	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
