package PT2019.PT2019.Assignment5;

public class MonitoredData {
	private String startTime;
	private String endTime;
	private String activity;
	
	public MonitoredData() {
		this.startTime = "";
		this.endTime = "";
		this.activity = "";
	}
	
	public MonitoredData(String startTime, String endTime, String activity) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.activity = activity;
	}
	
	@Override
	public String toString() {
		return this.startTime + " " + this.endTime + " " + this.activity + "\n";
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

	public String getActivity() {
		return activity;
	}

	public void setActivity(String activity) {
		this.activity = activity;
	}
}
