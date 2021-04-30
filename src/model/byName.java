package model;

import java.util.Comparator;

public class byName implements Sort{

	public byName(PeopleListL pl) {
		sortFile(pl);
	}
@Override
public void sortFile(PeopleListL pl){
		pl.get_peopleList().sort(Comparator.comparing(People::getName));
	}

}
