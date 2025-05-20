package com.abrito.dsList2025.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.abrito.dsList2025.dto.GameListDTO;
import com.abrito.dsList2025.entities.GameList;
import com.abrito.dsList2025.repositories.GameListRepository;

@Service
public class GameListService {
	
	@Autowired
	private GameListRepository gameListRepository;
	
	@Transactional(readOnly =  true)
	public List<GameListDTO> findAll(){
		List<GameList>  result = gameListRepository.findAll();
		return result.stream().map(x -> new GameListDTO(x)).toList();		
	}

}
