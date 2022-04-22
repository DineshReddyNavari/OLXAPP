package com.zensar.olxadvertise.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertise.entity.Advertise;

@RestController
public class MyControllerAdvertise {
	static List<Advertise> advertiselist = new ArrayList<Advertise>();

	@PostMapping("/advertise")
	public ResponseEntity<Advertise> createAdvertise(@RequestBody Advertise advertise){
	advertiselist.add(advertise);
	return new ResponseEntity<Advertise>(advertise, HttpStatus.CREATED);
	}

	@GetMapping("/advertise/{id}")
	public Advertise getAdvertise(@PathVariable int id) {
		Optional<Advertise> advertise1 = advertiselist.stream().filter(Advertise->Advertise.getCategoryId()==id).findAny();
		
		if(advertise1.isPresent()) {
			return advertise1.get();
		}else {
			return advertise1.orElseGet(()->{return new Advertise();});
		}
}
}
