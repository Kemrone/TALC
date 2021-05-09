package model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;
import java.util.Locale;

public class People implements Comparable<People> {

    private final String _name;
    private final String _id;
    private String _start;
    private String _stop;
    private TEAMSPeriodList _periodList;
  
   

    public People(String _name) {
        this._name = _name;
        this._id = StudentIDServer.getId(this._name);
        this._periodList = new TEAMSPeriodList();
    }

    
    
    public String get_id() {
        return _id;
    }

    
    
    
 
    public void forceEndTimeAt(String instant) {
        this._stop = instant;
        // delete all periods started after ending time
        var localPeriodEndingTime = TEAMSDateTimeConverter.StringToLocalDateTime(this._stop);
        boolean STOP = false;
        while (!STOP) {
            if (this._periodList.size()>0 && this._periodList.getLast().get_start().isAfter(localPeriodEndingTime))
                this._periodList.removeLast();
            else
                STOP = true;
        }

        // no ending time, so fix it
        if (this._periodList.size()>0 && this._periodList.getLast().get_end()==null)
            this._periodList.getLast().stopAt(this._stop);
        else
        // ending after the official end of the course, so limit it
        if (this._periodList.size()>0 && this._periodList.getLast().get_end().isAfter(localPeriodEndingTime))
            this._periodList.getLast().stopAt(this._stop);
    }

    
    
    
    
    
    public void forceStartTimeAt(String instant) {
        this._start = instant;
        // delete all periods ended before starting time
        var periods = this._periodList.iterator();
        boolean STOP = false;
        var localPeriodStartingTime = TEAMSDateTimeConverter.StringToLocalDateTime(this._start);
        while ( periods.hasNext() && !STOP) {
            var period = periods.next();
            if (period.get_end().isBefore(localPeriodStartingTime))
                periods.remove();
            else
                STOP = true;
        }
        // adjust starting time of period if before official course starting time
        if (!this._periodList.isEmpty() && this._periodList.getFirst().get_start().isBefore(localPeriodStartingTime))
            this._periodList.getFirst().startAt(this._start);

    }

    
    
    
    
    public long getTotalAttendanceDuration() {
        double totalDuration = 0;
        for (TEAMSPeriod period : this._periodList) {
            totalDuration += period.getDurationInMinutes();
        }
        return Math.round(totalDuration);
    }

    
    
    
    public boolean isClosed() {
        return this._periodList.getLast().isEnded();
    }

    
    
    
    public String getName() {
        return this._name;
    }


    @Override
    public String toString() {
        return "People{" +
                "_name='" + _name + '\'' +
                ", _id='" + _id + '\'' +
                ", _periodList=" + _periodList +
                ", _start='" + _start + '\'' +
                ", _stop='" + _stop + '\'' +
                '}';
    }
 
    
    public String getDate() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd MMMM yyyy");
        return ( this._periodList.getFirst().get_start().format(formatter.withLocale(Locale.FRANCE)) );
    }

    
    
    @Override
    public int compareTo(People o) {
        return (int)(this.getTotalAttendanceDuration()-o.getTotalAttendanceDuration());
    }

    
    
    public boolean isOutOfPeriod() {
        return this._periodList.isEmpty();
    }



	public String get_start() {
		return _start;
	}



	public void set_start(String _start) {
		this._start = _start;
	}



	public String get_stop() {
		return _stop;
	}



	public void set_stop(String _stop) {
		this._stop = _stop;
	}



	public String get_name() {
		return _name;
	}



	public TEAMSPeriodList get_periodList() {
		
		return this._periodList;
	}
    
    

}
