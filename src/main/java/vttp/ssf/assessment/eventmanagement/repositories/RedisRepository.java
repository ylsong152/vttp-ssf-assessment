package vttp.ssf.assessment.eventmanagement.repositories;

import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository{

	@Autowired
	private RedisTemplate<String, Object> redisTemplate;

	// TODO: Task 2
	public void saveRecord(Event event) throws JsonProcessingException {

		ObjectMapper objectMapper = new ObjectMapper();
		Event e = new Event(event.getEventId(), event.getEventName(), event.getEventSize(), event.getEventDate(), event.getParticipants());
		String eventAsString = objectMapper.writeValueAsString(e);

		if (redisTemplate.opsForList().range("events", 0, -1).contains(eventAsString)) {
			return;
		}
		redisTemplate.opsForList().rightPush("events", eventAsString);
	}

	// TODO: Task 3
	public Integer getNumberOfEvents() {
		return redisTemplate.opsForList().range("events", 0, -1).size();
	}

	// TODO: Task 4
	// Check again ltr
	public Event getEvent(Integer index) throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		String json = redisTemplate.opsForList().index("events", index).toString();
		Event e = objectMapper.readValue(json, Event.class);
		return e;
	}

	public List<Event> getEventList() throws JsonMappingException, JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
		List<Event> e = new LinkedList<>();
		for (int i =0; i < getNumberOfEvents(); i++) {
			String json = redisTemplate.opsForList().index("events", i).toString();
			Event event = objectMapper.readValue(json, Event.class);
			e.add(event);
		}
		return e;
	}
}
