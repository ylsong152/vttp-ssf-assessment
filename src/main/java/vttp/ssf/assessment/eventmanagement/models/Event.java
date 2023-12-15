package vttp.ssf.assessment.eventmanagement.models;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Event {
    private Integer eventId;
    private String eventName;
    // Max size for event
    private Integer eventSize;
    // Date in milliseconds
    private Long eventDate;
    private Integer participants;
    
    public Event() {
    }

    public Event(Integer eventId, String eventName, Integer eventSize, Long eventDate, Integer participants) {
        this.eventId = eventId;
        this.eventName = eventName;
        this.eventSize = eventSize;
        this.eventDate = eventDate;
        this.participants = participants;
    }

    
    public String getFormattedDate(Long eventDate) throws ParseException {
        DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        long milliSeconds= eventDate;
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }

    public Integer getEventId() {
        return eventId;
    }
    public void setEventId(Integer eventId) {
        this.eventId = eventId;
    }
    public String getEventName() {
        return eventName;
    }
    public void setEventName(String eventName) {
        this.eventName = eventName;
    }
    public Integer getEventSize() {
        return eventSize;
    }
    public void setEventSize(Integer eventSize) {
        this.eventSize = eventSize;
    }
    public Long getEventDate() {
        return eventDate;
    }
    public void setEventDate(Long eventDate) {
        this.eventDate = eventDate;
    }
    public Integer getParticipants() {
        return participants;
    }
    public void setParticipants(Integer participants) {
        this.participants = participants;
    }

    
}
