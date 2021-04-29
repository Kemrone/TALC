package model;

import model.*;
import view.*;





public abstract class Fichier {
	
	

	protected TEAMSProcessor t;
	protected String content;
	

	private Sort strategyS;
	
	public Fichier(TEAMSProcessor t) {
		this.t = t;
	}
	
	
	public void setStrateyS(Sort s){
		
	}

	public String getFile(){
		return null;
	
	}
	
	public void sorted(){
		
	}
	
	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}
	
}
