package com.mandava.springboot.springbootrest.demo;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Field;


@Service
public class PlayerService {
	
	@Autowired
	PlayerRepository repo;

	//Get all players
	public List<Player> getAllPlayers() {
		return repo.findAll();
	}
	
	//Get player by ID
	public Player getPlayerById(int id) {
		Optional<Player> tempPlayer = repo.findById(id);
		if (tempPlayer.isEmpty()) {
			throw new PlayerNotFoundException("Player with id [" + id + "] not found");
		}
		return tempPlayer.get();
	}
	
	//Add a player
	public Player addPlayer(Player p) {
		return repo.save(p);
	}
	
	//Update a player
	public Player updatePlayer(int id, Player p) {
		Optional<Player> tempPlayer = repo.findById(id);
		if (tempPlayer.isEmpty()) {
			throw new PlayerNotFoundException("Player with id [" + id + "] not found");
		}
		p.setId(id);
		return repo.save(p);
	}
	
	//Partial update
	public Player patchPlayer(int id, Map<String, Object> partial) {
		Optional<Player> temp = repo.findById(id);
		
		if (temp.isPresent()) {
			partial.forEach((key, value) -> {
				System.out.println("Key: " + key + ", Value: " + value);
				Field f = ReflectionUtils.findField(Player.class, key);
				ReflectionUtils.makeAccessible(f);
				ReflectionUtils.setField(f, temp.get(), value);
			});
		}
		else {
			throw new PlayerNotFoundException("Player with id [" + id + "] not found");
		}
		
		return repo.save(temp.get());
	}
	
	// Update a single field
	@Transactional
	public void updateTitles(int id, int titles) {
		Optional<Player> temp = repo.findById(id);
		if (temp.isEmpty()) {
			throw new PlayerNotFoundException("Player with id [" + id + "] not found");
		}
		repo.updateTitles(id, titles);
	}
	
	//delete a player
	public void deletePlayer(int id) {
		Optional<Player> temp = repo.findById(id);
		
		if (temp.isEmpty()) {
			throw new PlayerNotFoundException("Player with id [" + id + "] not found");
		}
		
		repo.delete(temp.get());
	}
}
