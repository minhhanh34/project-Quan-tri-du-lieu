package Management;

public class CategoryState implements State {

	StudentManagement manager;
	
	public CategoryState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\tDanh sách phân loại\n");
	}
	
	@Override
	public void performAction() {
		categoryStudent();
		handing();
	}
	
	
	private void handing() {
		navigate(manager.getHomeState());
	}

	private void categoryStudent() {
		// Danh sách sinh viên theo phân loại
		
		
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
	
}
