package model;

import java.util.HashMap;
import java.util.Iterator;

public class PeopleHashmap implements Iterable<People>{
	
	private HashMap<String,People> _peopleList;

	
	
	
	public PeopleHashmap(HashMap<String, People> _peopleList) {
		super();
		this._peopleList = _peopleList;
	}


	public HashMap<String, People> getPeopleList() {
		return _peopleList;
	}


	public void setPeopleList(HashMap<String, People> _peopleList) {
		this._peopleList = _peopleList;
	}


	@Override
	public Iterator<People> iterator() {
		return new PeopleHashmapIterator(this);
	}
	
	
	

}
