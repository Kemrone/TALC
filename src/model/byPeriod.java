package model;

import java.util.Comparator;

public class byPeriod {

	public byPeriod(PeopleListL pl) {
		sortFile(pl);
		System.out.println("Sort by Period done");
	}

	public void sortFile(PeopleListL pl){
		pl.get_peopleList().sort(Comparator.comparing(People::getTotalAttendanceDuration));
	}

}
