package model;

import java.util.HashMap;
import java.util.Iterator;

public class PeopleListH implements Iterable<People>{
	
	private HashMap<String,People> _peopleList;

	
	
	
	public PeopleListH(HashMap<String, People> _peopleList) {
		super();
		this._peopleList = _peopleList;
	}


	public HashMap<String, People> get_peopleList() {
		return _peopleList;
	}


	public void set_peopleList(HashMap<String, People> _peopleList) {
		this._peopleList = _peopleList;
	}


	@Override
	public Iterator<People> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
