package com.tuneride.server.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.tuneride.server.domain.*;

// manage TuningEvents entities with an ID type of Long
// CrudRepository comes with default methods like:
// count(), delete(id), deleteAll(), exists(ID id), findOne(ID id), save(S entity)

//  When the context is created, Spring Data JPA will scan and discover this 
// repository definition, then will automatically generate a concrete proxy that
// implements this interface
public interface EventRepository extends CrudRepository<TuningEvent, Long>{
	
	List<TuningEvent> findByNameContainingIgnoreCase(String name);
	
	List<TuningEvent> findByCityContainingIgnoreCase(String cityName);
	
	List<TuningEvent> findByCountryIgnoreCase(String country);
	
	List<TuningEvent> findByCityAndCountryIgnoreCase(String city, String country);
}
