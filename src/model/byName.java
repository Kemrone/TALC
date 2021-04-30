package model;

import java.util.Comparator;

public class byName {

	public byName(PeopleListL pl) {
		sortFile(pl);
		System.out.println("Sort by Name done");

	}

	public void sortFile(PeopleListL pl){
		pl.get_peopleList().sort(Comparator.comparing(People::getName));
	}

}
