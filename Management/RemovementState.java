package Management;

import java.util.Scanner;

public class RemovementState implements State {
	
	StudentManagement manager;
	
	public RemovementState(StudentManagement manager) {
		this.manager = manager;
	}	
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("\tXóa sinh viên\n");
	}
	
	@Override
	public void performAction() {
		removeStudent();
		handing();
	}
	
	private void handing() {
		showListChoose();
		if(Respone.getRespone(1, 2) == 1) {
			removeStudent();
		} else {
			navigate(manager.getHomeState());
		}
	}

	private void showListChoose() {
		System.out.println("\t1. Tiếp tục xóa.");
		System.out.println("\t2. Trang chủ.");
	}

	private void removeStudent() {
		// Xóa sinh viên trong csdl
		
		handing();
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
}
