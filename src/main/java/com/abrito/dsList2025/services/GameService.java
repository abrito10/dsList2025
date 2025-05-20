package com.abrito.dsList2025.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito.dsList2025.dto.GameDTO;
import com.abrito.dsList2025.dto.GameMinDTO;
import com.abrito.dsList2025.entities.Game;
import com.abrito.dsList2025.repositories.GameRepository;

@Service
public class GameService {
	
	@Autowired
	private GameRepository gameRepository;
	
	@Transactional(readOnly =  true)
	public List<GameMinDTO> findAll(){
		List<Game>  result = gameRepository.findAll();
		return result.stream().map(x -> new GameMinDTO(x)).toList();		
	}

	@Transactional(readOnly =  true)	
	public GameDTO findById(Long id) {
		Game result = gameRepository.findById(id).get();
		GameDTO dto = new GameDTO(result);
		return dto;
	}
}
