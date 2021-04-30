package model;

import java.util.Iterator;

public class PeopleListIterator implements Iterator<People> {

	
	/*
	//******************************************\\
	//*********** A implementer *****************\\
	\\******************************************\\
	\\*****************************************\\
	*/
	
	
	private Iterable _peopleList;
    private int _currentPos;
     
     public PeopleListIterator(Iterable peopleList) {
             this._peopleList = peopleList;
             _currentPos = 0;
     }

     public Integer getNext() {
             return null;
     }
     
     public boolean hasNext() {
             return false;
     }

	@Override
	public People next() {
		// TODO Auto-generated method stub
		return null;
	}

	
}
