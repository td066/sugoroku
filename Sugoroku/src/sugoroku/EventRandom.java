package sugoroku;

public class EventRandom {
	private int eventId;
	private int eventType;
	private String eventTitle;
	private String eventInfo;
	private String eventResult;
	public EventRandom(int eventType, String eventTitle, String eventInfo, String eventResult) {
		this.eventId = 0; //TODO id管理
		this.eventType = eventType;
		this.eventTitle = eventTitle;
		this.eventInfo = eventInfo;
		this.eventResult = eventResult;
	}
	public int getEventType() {
		return this.eventType;
	}
	public String getEventTitle() {
		return this.eventTitle;
	}
	public String getEventInfo() {
		return this.eventInfo;
	}
	public String getEventResult() {
		return this.eventResult;
	}
}
