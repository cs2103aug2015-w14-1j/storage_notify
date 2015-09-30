package cs.notify.storage;

import java.io.Serializable;
import java.util.*;

public class Task implements Serializable{
	private String taskName;
	private int id;
	private String fromDate;
	private String toDate;
	private String fromTime;
	private String toTime;
	private String date;
	private String time;
	
	private static final long serialVersionUID = 1L;
	
	public Task(String taskName) {
		this.taskName = taskName;
	}
	private boolean deleted;
	
	public String getTaskName() {
		return taskName;
	}
	
	public String getFromDate() {
		return fromDate;
	}
	
	public String getToDate() {
		return toDate;
	}
	
	public String getFromTime() {
		return fromTime;
	}
	
	public String getToTime() {
		return toTime;
	}
	
	public String getDate() {
		return date;
	}
	
	public String getTime() {
		return time;
	}
	
	public int getTaskId() {
		return id;
	}
	
	public boolean isDeleted() {
		return deleted;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public String toString() {
		return taskName;
	}
}
