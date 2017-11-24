package com.tuneride.server.service.impl;

import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tuneride.server.domain.TuningEvent;
import com.tuneride.server.repository.EventRepository;
import com.tuneride.server.service.TuningEventService;

@Service
public class TuningEventServiceImpl implements TuningEventService {
	
	@Autowired
	private EventRepository eventRepository;

	@Override
	public TuningEvent save(TuningEvent tuningEvent) throws EntityExistsException {
		if (tuningEvent.getId() != null && eventRepository.exists(tuningEvent.getId())) {
			throw new EntityExistsException("There is already existing entity with such ID in the database.");
		}
		
		TuningEvent event = eventRepository.save(tuningEvent);
		return event;
	}

	@Override
	public TuningEvent update(TuningEvent tuningEvent) throws EntityNotFoundException {
		if (tuningEvent.getId() == null || !eventRepository.exists(tuningEvent.getId())) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}
		
		eventRepository.save(tuningEvent);
		return null;
	}
		
	@Override
	public Iterable<TuningEvent> findAll() {
		return eventRepository.findAll();
	}

	@Override
	public List<TuningEvent> findByNameContaining(String name) {
		return eventRepository.findByNameContainingIgnoreCase(name);
	}

	@Override
	public TuningEvent findOne(Long id) {
		return eventRepository.findOne(id);
	}

	@Override
	public void delete(Long id) throws EntityNotFoundException {
		if (!eventRepository.exists(id)) {
			throw new EntityNotFoundException("There is no entity with such ID in the database.");
		}
		eventRepository.delete(id);
	}
	
	
}
