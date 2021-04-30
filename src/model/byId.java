package model;

import java.util.Comparator;

public class byId implements Sort{

	public byId(PeopleListL pl) {
		sortFile(pl);
		System.out.println("Sort by Id done");

	}

	public void sortFile(PeopleListL pl){
		pl.get_peopleList().sort(Comparator.comparing(People::get_id));
	}
}
