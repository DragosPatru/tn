package com.tuneride.server.service;

import java.util.List;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;

import com.tuneride.server.domain.TuningEvent;

public interface TuningEventService {
	
	public TuningEvent save(TuningEvent tuningEvent) throws EntityExistsException;

	public TuningEvent update(TuningEvent tuningEvent) throws EntityNotFoundException;
	
	public Iterable<TuningEvent> findAll();
	
	public List<TuningEvent> findByNameContaining(String name);
	
	public TuningEvent findOne(Long id);
	
	public void delete(Long id) throws EntityNotFoundException;
	
	//public void findByLocationWithinRadius(Location location, double radius);
}
