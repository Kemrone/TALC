package model;

import java.util.HashMap;
import java.util.Iterator;

public class PeopleHashmapIterator implements Iterator<People> {

	
	/*
	//******************************************\\
	//*********** A implementer *****************\\
	\\******************************************\\
	\\*****************************************\\
	*/
	
	
	private PeopleHashmap _peopleList;
    private int _currentPos;
     
     public PeopleHashmapIterator(PeopleHashmap peopleList) {
         this._peopleList = peopleList;
         _currentPos = 0;
     }

     
     public boolean hasNext() {
    	 int size = _peopleList.getPeopleList().size();
         return (_currentPos+1 < size);
     }

	@Override
	public People next() {
		HashMap<String, People> hashmap = _peopleList.getPeopleList();
   	 	String[] keys = (String[]) hashmap.keySet().toArray();
        return hashmap.get(keys[_currentPos++]);
	}



	
}
