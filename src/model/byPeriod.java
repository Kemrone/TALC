package model;

import java.util.Comparator;

public class byPeriod implements Sort {

	public byPeriod(PeopleListL pl) {
		sortFile(pl);
	}

	@Override
	public void sortFile(PeopleListL pl){
		pl.get_peopleList().sort(Comparator.comparing(People::getTotalAttendanceDuration));
	}

}
