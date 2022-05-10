package Management;

public class StudentManagement {
	State homeState;
	State studentListState;
	State additionState;
	State editionState;
	State removementState;
	State searchState;
	State averagePercentState;
	State categoryState;
	State maxAverageState;
	State subjectState;
	
	State currentState;
	
	public StudentManagement() {
		homeState = new HomeState(this);
		studentListState = new StudentListState(this);
		additionState = new AdditionState(this);
		editionState = new EditionState(this);
		removementState = new RemovementState(this);
		searchState = new SearchState(this);
		averagePercentState = new AveragePercentState(this);
		categoryState = new CategoryState(this);
		maxAverageState = new MaxAverageState(this);
		subjectState = new SubjectState(this);
		currentState = homeState;
	}
	
	public void setState(State state) {
		this.currentState = state;
	}

	public State getHomeState() {
		return homeState;
	}

	public State getStudentListState() {
		return studentListState;
	}

	public State getAdditionState() {
		return additionState;
	}

	public State getEditionState() {
		return editionState;
	}

	public State getRemovementState() {
		return removementState;
	}

	public State getSearchState() {
		return searchState;
	}

	public State getAveragePercentState() {
		return averagePercentState;
	}

	public State getCategoryState() {
		return categoryState;
	}

	public State getMaxAverageState() {
		return maxAverageState;
	}
	
	public State getSubjectState() {
		return subjectState;
	}

	public State getCurrentState() {
		return currentState;
	}
	
	public void run() {
		currentState.display();
		currentState.performAction();
	}
}
