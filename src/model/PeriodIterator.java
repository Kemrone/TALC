package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.NoSuchElementException;

public class PeriodIterator implements Iterator<TEAMSPeriod> {

	
	 
	private TEAMSPeriodList _periodList;
	private int _currentPos;
	 
	 
	 
	public PeriodIterator(TEAMSPeriodList _periodList) {
		super();
		this._periodList = _periodList;
		this._currentPos = 0;
	}
	

	@Override
	public boolean hasNext() {
		 int size = _periodList.get_periodList().size();
         return (_currentPos < size);
	}

	@Override
	public TEAMSPeriod next() {
		LinkedList<TEAMSPeriod> list = _periodList.get_periodList();
		 if (list == null) {
			 throw new NoSuchElementException();
			 
		 } else if (this._currentPos ==0) {
			 return list.get(_currentPos++);
			 
		 } else if (this._currentPos >list.size()) {
			 throw new NoSuchElementException();
		 }
		 
		 return list.get(_currentPos++);
	}
	

}
