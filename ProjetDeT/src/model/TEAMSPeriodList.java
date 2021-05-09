package model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;

public class TEAMSPeriodList implements Iterable<TEAMSPeriod> {

	
	private LinkedList<TEAMSPeriod> _periodList;
	
	
	
	public TEAMSPeriodList() {
		super();
		this._periodList = new LinkedList<>();;
	}

	@Override
	public Iterator<TEAMSPeriod> iterator() {
		
		return new PeriodIterator(this);
	}

	
	 public void addPeriod(String action, String instant, People p) {

	        if ( action.charAt(0) == 'R' ) {
	            TEAMSPeriod period = new TEAMSPeriod(instant);
	            this._periodList.add(period);
	        } else
	            if ( action.charAt(0) == 'A' ) {
	                this._periodList.getLast().stopAt(instant);
	            } else {
	                System.out.println(p.get_name() + " --> erreur : action inconnue ["+action+"] ");
	            }
	    }
	

	public LinkedList<TEAMSPeriod> get_periodList() {
		return _periodList;
	}

	public void set_periodList(LinkedList<TEAMSPeriod> _periodList) {
		this._periodList = _periodList;
	}

	public TEAMSPeriod getFirst() {
	
		return this._periodList.getFirst();
	}

	public TEAMSPeriod getLast() {
		
		return this._periodList.getLast();
	}

	public boolean isEmpty() {

		if(this._periodList.isEmpty()) {
		return true;
		} else {
			return false;
		}
	}

	public int size() {
		
		return this._periodList.size();
	}

	public void removeLast() {
		
		this._periodList.removeLast();
		
	}
	 
	 
}
