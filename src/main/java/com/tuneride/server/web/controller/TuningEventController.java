package com.tuneride.server.web.controller;

import javax.inject.Inject;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tuneride.server.domain.TuningEvent;
import com.tuneride.server.service.TuningEventService;

@RestController
@RequestMapping("/springjwt")
public class TuningEventController {
	
	@Inject
	private TuningEventService tuningEventService;
	
	@PreAuthorize("hasAuthority('ADMIN_USER') or hasAuthority('STANDARD_USER')")
	@RequestMapping(value = "/events", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Iterable<TuningEvent>> getEvents(@RequestParam(value="name", defaultValue="") String name) {
		Iterable<TuningEvent> events = null;
		if (name.isEmpty()) {
			events = tuningEventService.findAll();
		} else {
			events = tuningEventService.findByNameContaining(name);
		}
		return new ResponseEntity<Iterable<TuningEvent>>(events, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/event", method = RequestMethod.POST,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TuningEvent> createEvent(@RequestBody TuningEvent event) {
		TuningEvent tuningEvent = null;
		try {
			tuningEvent = tuningEventService.save(event);
		} catch (EntityExistsException e) {
			return new ResponseEntity<TuningEvent>(HttpStatus.CONFLICT);
		}
		return new ResponseEntity<TuningEvent>(tuningEvent, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/event/{id}", method = RequestMethod.GET,  produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TuningEvent> getById(@PathVariable Long id) {
		TuningEvent tuningEvent = null;
		try {
			tuningEvent = tuningEventService.findOne(id);
			
		} catch (EntityExistsException e) {
			return new ResponseEntity<TuningEvent>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TuningEvent>(tuningEvent, HttpStatus.OK);
	}

	@RequestMapping(value = "/event", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TuningEvent> updateEvent(@RequestBody TuningEvent event) {
		// call service update
		TuningEvent tuningEvent = null;
		try {
			tuningEvent = tuningEventService.update(event);
		} catch (EntityNotFoundException e) {
			return new ResponseEntity<TuningEvent>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TuningEvent>(tuningEvent, HttpStatus.CREATED);	
	}
	
	@RequestMapping(value = "/event/{id}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Void> deleteEvent(@PathVariable Long id) {
		// call service delete
		tuningEventService.delete(id);
		return ResponseEntity.ok().build();
	
	}
	
}
