package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;

@Controller
@RequestMapping("/events")
public class EventController {

	@Autowired
	private RedisRepository redisRepo;

	//TODO: Task 5
	@GetMapping("/listing")
	public ModelAndView displayEvents() throws JsonMappingException, JsonProcessingException {
		List<Event> eventList = redisRepo.getEventList();
		ModelAndView mav = new ModelAndView("event-listing");
		mav.addObject("events", eventList);
		return mav;
	}
}
