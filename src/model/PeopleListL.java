package model;


import java.util.Iterator;
import java.util.LinkedList;

public class PeopleListL implements Iterable<People> {
	
private LinkedList<People> _peopleList;

	
	
	
	public PeopleListL(LinkedList<People> _peopleList) {
		super();
		this._peopleList = _peopleList;
	}


	public LinkedList<People> get_peopleList() {
		return _peopleList;
	}


	public void set_peopleList(LinkedList<People> _peopleList) {
		this._peopleList = _peopleList;
	}


	@Override
	public Iterator<People> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
