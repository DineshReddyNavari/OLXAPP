package com.zensar.stockapplication.customactuator;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;
@Component
public class TotalUsersInfoContributor implements InfoContributor{

	@Override
	public void contribute(Builder builder) {
		Map<String,Integer> UserDetails =new HashMap<String, Integer>();
		UserDetails.put("active", 100);
		UserDetails.put("inactive", 10);
		builder.withDetail("users", UserDetails);
		
	}

}
