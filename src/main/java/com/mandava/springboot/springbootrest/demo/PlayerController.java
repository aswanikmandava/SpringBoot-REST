package com.mandava.springboot.springbootrest.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class PlayerController {
	@Autowired
	PlayerService service;
	
	@GetMapping("/welcome")
	public String index() {
		return "Welcome to Tennis Player API"; 
	}

	@GetMapping("/players")
	public List<Player> allPlayers() {
		return service.getAllPlayers();
	}
	
	@GetMapping("/players/{id}")
	public Player getPlayer(@PathVariable int id) {
		return service.getPlayerById(id);
	}
	
	@PostMapping("/players")
	public Player addPlayer(@RequestBody Player p) {
		p.setId(0);
		return service.addPlayer(p);
	}
	
	@PutMapping("/players/{id}")
	public Player updatePlayer(@PathVariable int id, @RequestBody Player p) {
		return service.updatePlayer(id, p);
	}
	
	@PatchMapping("/players/{id}")
	public Player patchPlayer(@PathVariable int id, @RequestBody Map<String, Object> p) {
		return service.patchPlayer(id, p);
	}
	
	@PatchMapping("/players/{id}/titles")
	public void updateTitles(@PathVariable int id, @RequestBody int titles) {
		service.updateTitles(id, titles);
	}
	
	@DeleteMapping("/players/{id}")
	public void deletePlayer(@PathVariable int id) {
		service.deletePlayer(id);
	}
}
