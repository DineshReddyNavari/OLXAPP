package com.zensar.olxadvertise.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.zensar.olxadvertise.entity.Advertise;

public class OlxAdvertiseServiceImpl implements OlxAdvertiseService{
	static List<Advertise> advertiselist= new ArrayList<Advertise>();
	static {
		advertiselist.add(new Advertise("laptopsale", 50000, "intel core 3 Sony Vaio", 1, "anand", 22/4/2022, "OPEN"));
	}

	@Override
	public List<Advertise> getAllAdvertises() {
		// TODO Auto-generated method stub
		return advertiselist;
	}

	@Override
	public Advertise createStock(Advertise advertise, String token) {
		if(token.equals(token)) {
			advertiselist.add(advertise);
		}
		return null;
	}

	@Override
	public Advertise getAdvertise(long id) {
		// TODO Auto-generated method stub
	for(Advertise advertise :advertiselist) {
		if(advertise.getCategoryId()==id) {
			return advertise;
		}
	}
	return null;
	}

	@Override
	public Advertise updateStock(int id, Advertise advertise) {
		// TODO Auto-generated method stub
		Advertise availableadvertise = getAdvertise(id);
		availableadvertise.setCategoryId(advertise.getCategoryId());
		availableadvertise.setTitle(advertise.getTitle());
		availableadvertise.setDescription(advertise.getDescription());
		availableadvertise.setCreateddate(advertise.getCreateddate());
		availableadvertise.setPrice(advertise.getPrice());
		availableadvertise.setUsername(advertise.getUsername());
		availableadvertise.setStatus(advertise.getStatus());
		return null;
	}

	@Override
	public List<Advertise> getAllAdvertise(String token) {
		if(token.equals("anand123")) {
		// TODO Auto-generated method stub
		return advertiselist;
	}
		else {
			return null;
		}
	}

	@Override
	public Advertise getAdvertise(int postId, String token) {
		if(token.equals("anand123")) {
			for(Advertise advertise:advertiselist) {
				if(advertise.getCategoryId()==postId) {
					return advertise;
				}
			}
		}
		return null;
	}

	@Override
	public boolean deleteAdvertise(int postId1, String token) {
		if(token.equals("anand123")) {
			for(Advertise advertise: advertiselist) {
				if(advertise.getCategoryId()==postId1) {
					advertiselist.remove(advertise);
					return true;
				}
			}
		}
		return false;
	}

	@Override
	public Advertise filterBasedAdvertise() {
		String filterText = "open";
		Optional<Advertise> list = advertiselist.stream().filter(criteria -> criteria.toString().toLowerCase().contains(filterText)).findAny();
		if(list.isPresent())
		{
			return list.get();
		}
		else
		{
			return null;
		}
		}
	

	@Override
	public Advertise searchAdvertise() {
		String searchText = "closed";
		Optional<Advertise> findAny = advertiselist.stream().filter(criteria -> criteria.toString().toLowerCase().contains(searchText)).findAny();
		if(findAny.isPresent())
		{
			return findAny.get();
		}
		else
		{
		return null;
		}
	}

	@Override
	public List<Advertise> getAllAdvertises(int postId2, String token) {
		if(token.equals("anand123")) {
			for(Advertise advertise:advertiselist) {
				if(advertise.getCategoryId()==postId2) {
					return advertiselist;
				}
			}
		}
		return null;
	}
	

}
