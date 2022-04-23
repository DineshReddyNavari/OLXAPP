package com.zensar.olxadvertise.service;

import java.util.List;

import com.zensar.olxadvertise.entity.Advertise;

public interface OlxAdvertiseService {
	public List<Advertise> getAllAdvertises();
	public Advertise createStock(Advertise advertise,String token);
	public Advertise getAdvertise(long id);
	public Advertise updateStock(int id,Advertise advertise);
	public List<Advertise> getAllAdvertise(String token);
	public Advertise getAdvertise(int postId,String token);
	public boolean deleteAdvertise(int postId1,String token);
	public Advertise filterBasedAdvertise();
	public Advertise searchAdvertise();
	public List<Advertise> getAllAdvertises(int postId2,String token);

}
