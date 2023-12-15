package vttp.ssf.assessment.eventmanagement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{

	@Autowired
	private DatabaseService databaseService;

	@Autowired
	private RedisRepository redisRepo;

	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}
	
	// TODO: Task 1
	@Override
	public void run(String... args) throws Exception {
		List<Event> eventList = databaseService.readFile("static/events.json");
		for (Event e : eventList) {
			System.out.println(">>>>>>>>>>>>>>>>>>>" + e.getEventId());
			System.out.println(">>>>>>>>>>>>>>>>>>>" + e.getEventName());
			System.out.println(">>>>>>>>>>>>>>>>>>>" + e.getEventSize());
			System.out.println(">>>>>>>>>>>>>>>>>>>" + e.getEventDate());
			System.out.println(">>>>>>>>>>>>>>>>>>>" + e.getParticipants());
			redisRepo.saveRecord(e);
		}
		Integer size = redisRepo.getNumberOfEvents();
		System.out.println("<<<<<<<<<<< " + size);

		for (int i = 0; i < size; i++) {
			System.out.println(redisRepo.getEvent(i).getEventName());
		}
	}
}
