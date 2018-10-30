package com.iheart.iHeart.Media.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iheart.iHeart.Media.model.Advertiser;

import com.iheart.iHeart.Media.repository.AdvertiserRepository;

@Service
public class AdvertiserService {

	@Autowired
	AdvertiserRepository repository;
	
	
	public List<Advertiser> getAll() {
		return repository.getAll();
	}
	
	public Advertiser getById(Long id) {
		return repository.getById(id);
	}
	
	public void create(Advertiser advertiser) {
		repository.insert(advertiser);
	}
	
	public void update(Advertiser advertiser) {
		Advertiser currentAdvertiser =  repository.getById(advertiser.getId());
		
		repository.update(advertiser);
	}
	
	public void delete(Long id) {
		repository.deleteById(id);
	}
	
	public boolean doesAdvertiserExist(Advertiser advertiser) {
		return false;
	}
	
	public void updateCreditLimit(Advertiser advertiser) {
		repository.updateCreditLimit(advertiser);
	} 
	
	public boolean hasEnoughCredit(Long id) {
		Advertiser advertiser = this.getById(id);
		if(advertiser == null) {
			return false;
		}
		return advertiser.getCreditLimit() > 0;		
	}
	
}
