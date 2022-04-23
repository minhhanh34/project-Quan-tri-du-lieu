package Management;

public class AveragePercentState implements State {

	StudentManagement manager;
	
	public AveragePercentState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\n\tTrung bình theo phần trăm\n");
	}
	
	@Override
	public void performAction() {
		showAveragePercent();
		handing();
	}
	
	
	private void showAveragePercent() {
		// hiển thị điểm theo phần trăm
		
	}

	private void handing() {
		navigate(manager.getHomeState());
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
