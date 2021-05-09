package model;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class TEAMSProcessor {

    private Collection<People> _allpeople = null;
    private String _fileName;
    private String _startTime;
    private String _endTime;

    public TEAMSProcessor(File _file, String _start, String _stop) {
        /*
         csv file to read
         start time of the course
         end time of the source
        */
        this._startTime = _start;
        this._endTime = _stop;

        // load CSV file
        this._fileName = _file.getName();
        var teamsFile = new TEAMSAttendanceList(_file);

        // filter to extract data for each people
        var lines = teamsFile.get_attlist();
        if (lines != null) {
            // convert lines in data structure with people & periods
            var filter = new TEAMSAttendanceListAnalyzer(lines);
            // cut periods before start time and after end time
            filter.setStartAndStop(_start, _stop);
            // sort
            List<People> peopleByDuration = new ArrayList<>(filter.get_peopleList().values());
            Collections.sort(peopleByDuration);
            // init the people collection
            this._allpeople = peopleByDuration;//filter.get_peopleList().values();
        }
    }

  	  public Collection<People> get_allpeople() {
       		 return _allpeople;
  	}

   	 public void set_allpeople(Collection<People> _allpeople) {
		this._allpeople = _allpeople;
	}
    
   

	public String get_fileName() {
		return _fileName;
	}

	public void set_fileName(String _fileName) {
		this._fileName = _fileName;
	}

	public String get_startTime() {
		return _startTime;
	}

	public void set_startTime(String _startTime) {
		this._startTime = _startTime;
	}

	public String get_endTime() {
		return _endTime;
	}

	public void set_endTime(String _endTime) {
		this._endTime = _endTime;
	}

	
    
    
    
}
