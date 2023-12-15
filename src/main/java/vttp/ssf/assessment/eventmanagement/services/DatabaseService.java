package vttp.ssf.assessment.eventmanagement.services;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import jakarta.json.Json;
import jakarta.json.JsonArray;
import jakarta.json.JsonObject;
import jakarta.json.JsonReader;
import vttp.ssf.assessment.eventmanagement.models.Event;

@Service
public class DatabaseService {

    public List<Event> readFile(String fileName) throws IOException {
        List<Event> eventList = new LinkedList<>();
        ClassPathResource resource = new ClassPathResource(fileName);
        try (InputStream is = resource.getInputStream()) {
            JsonReader jsonReader = Json.createReader(is);
            JsonArray jsonArray = jsonReader.readArray();
            for (JsonObject jsonObject : jsonArray.getValuesAs(JsonObject.class)) {
                Integer eventId = jsonObject.getInt("eventId");
                String eventName = jsonObject.getString("eventName");
                Integer eventSize = jsonObject.getInt("eventSize");
                Long eventDate = jsonObject.getJsonNumber("eventDate").longValue();
                Integer participants = jsonObject.getInt("participants");
                eventList.add(new Event(eventId, eventName, eventSize, eventDate, participants));
            }

            return eventList;
        }         
    }
}
