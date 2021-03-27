package com.shankar.first.DAO;

import org.springframework.data.repository.CrudRepository;

import com.shankar.first.model.Alien;

public interface AlienRepo extends CrudRepository<Alien, Integer>{

}
