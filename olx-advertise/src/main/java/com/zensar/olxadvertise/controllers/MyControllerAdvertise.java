package com.zensar.olxadvertise.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.zensar.olxadvertise.entity.Advertise;
import com.zensar.olxadvertise.service.OlxAdvertiseService;

@RestController
public class MyControllerAdvertise {
	@Autowired(required = false)
	public OlxAdvertiseService advertiseservice;

	@GetMapping(value = "/advertise", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public List<Advertise> getAllAdvertises() {
		return advertiseservice.getAllAdvertises();
	}

	@PostMapping(value = "/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Advertise createStock(@RequestBody Advertise advertise, @RequestHeader("anand") String token) {

		return advertiseservice.createStock(advertise, token);

	}

	@GetMapping(value = "/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public Advertise getAdvertise(@PathVariable long advertiseId) {
		return advertiseservice.getAdvertise(advertiseId);
	}

	@PutMapping(value = "/advertise/{advertiseId}", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public Advertise updateStock(@PathVariable int advertiseId, @RequestBody Advertise advertise) {
		return advertiseservice.updateStock(advertiseId, advertise);
	}

	@GetMapping(value = "/user/advertise", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public List<Advertise> getAllAdvertisesByUser(@RequestHeader("anand") String token) {
		return advertiseservice.getAllAdvertises();
	}
	@GetMapping(value="/user/advertise/{postId}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Advertise getSpecificAdvertise(@PathVariable int postId,@RequestHeader("anand")String token)
	{
		return advertiseservice.getAdvertise(postId, token);
	}
	@DeleteMapping("/user/advertise/{postId}")
	public boolean deleteSpecificAdvertise(@PathVariable int postId,@RequestHeader("anand") String token)
	{
		return advertiseservice.deleteAdvertise(postId, token);
	}
	@GetMapping(value="/advertise/search/filtercriteria",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Advertise filterBasedSearchAdvertise()
	{
		return advertiseservice.filterBasedAdvertise();
	}
	@GetMapping(value="/advertise/search",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
	public Advertise searchAdvertise()
	{
		return advertiseservice.searchAdvertise();
	}
	@GetMapping("/advertise/{postId2}")
	public List<Advertise> getAllAdvertises(@PathVariable int postId2,@RequestHeader ("anand")String token)
	{
		return advertiseservice.getAllAdvertises();
	}
}
