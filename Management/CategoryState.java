package Management;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import Management.MaxAverageState.Average;

public class CategoryState implements State {

	private StudentManagement manager;
	
	public CategoryState(StudentManagement manager) {
		this.manager = manager;
	}
	
	@Override
	public void display() {
		System.out.println("\n\tDanh sách phân loại\n");
	}
	
	@Override
	public void performAction() {
		categoryStudent();
		handing();
	}
	
	
	private void handing() {
		showListChoose();
		if(Respone.getRespone(1, 1) == 1)
			navigate(manager.getHomeState());
	}

	private void showListChoose() {
		System.out.println("\n1. Trang Chủ.");
	}

	private void categoryStudent() {
		MaxAverageState.getAverageListFromDatabase();
		Collections.sort(MaxAverageState.averages, new Comparator<MaxAverageState.Average>() {

			@Override
			public int compare(Average o1, Average o2) {
				return o1.avg < o2.avg ? 1 : -1;
			}
			
		});
		System.out.println("Loại Giỏi (>= 8.0) :\n");
		for(MaxAverageState.Average each : MaxAverageState.averages) {
			if(each.avg >= 8.0)
				System.out.println("  " + each.mssv + " - " + each.avg);
		}
		
		System.out.println("\nLoại Khá (6.5 - 7.9): \n");
		for(MaxAverageState.Average each : MaxAverageState.averages) {
			if(each.avg >= 6.5 && each.avg < 8.0)
				System.out.println("  " + each.mssv + " - " + each.avg);
		}
		
		System.out.println("\nTrung Bình (< 6.5): \n");
		for(MaxAverageState.Average each : MaxAverageState.averages) {
			if(each.avg < 6.5)
				System.out.println("  " + each.mssv + " - " + each.avg);
		}
	}

	public void navigate(State state) {
		manager.setState(state);
		manager.run();
	}
	
}
