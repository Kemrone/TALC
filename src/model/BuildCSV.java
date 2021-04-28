package model;

import java.util.Collection;

public class BuildCSV implements Build {

	private String fileName;
	private String startTime;
	private String endTime;
	private Collection <String> allPeople;
	
	
	
	public BuildCSV() {
		
	}
	
	public BuildCSV(String fileName, String startTime, String endTime, Collection<String> allPeople) {
		super();
		this.fileName = fileName;
		this.startTime = startTime;
		this.endTime = endTime;
		this.allPeople = allPeople;
	}
	
	
	
	
	/*
	//******************************************\\
	//*********** A implementer *****************\\
	\\******************************************\\
	\\*****************************************\\
	*/
	
	public void build(TEAMSProcessor t) {
		
	}
	
	
	/*
	//******************************************\\
	//*********** A implementer *****************\\
	\\******************************************\\
	\\*****************************************\\
	*/
	public void buildFile() {
		
	}
	/*
	//******************************************\\
	//*********** A implementer *****************\\
	\\******************************************\\
	\\*****************************************\\
	*/
	public String getCode(People p) {
		
		return "";
	}
	
	public void get_allPeople() {
		
	}
	
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public Collection<String> getAllPeople() {
		return allPeople;
	}
	public void setAllPeople(Collection<String> allPeople) {
		this.allPeople = allPeople;
	}
	
}

	

