package com.iheart.iHeart.Media;

import java.net.URI;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.iheart.iHeart.Media.Service.AdvertiserService;
import com.iheart.iHeart.Media.model.Advertiser;

import io.swagger.models.Model;
import java.util.Optional;
import org.springframework.http.ResponseEntity;


@RestController
//@RequestMapping("/api")
public class AdvertiserController {
	 
	 
	@Autowired
	AdvertiserService advertiserService;
	
	@RequestMapping(value = "/getAllAdvertiser",  method= RequestMethod.GET)
	public List<Advertiser> getAdvertisers() {
		return advertiserService.getAll();
	}
	
	@RequestMapping(value = "/advertiser/hasCredit/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> advertiserHasCredit(@PathVariable("id") long id) {
		Advertiser advertiser = advertiserService.getById(id);
		if(advertiser == null) {
			return new ResponseEntity<String>("Advertiser not found",HttpStatus.NOT_FOUND);
		}
		else if(advertiser.getCreditLimit() == 0) {
			return new ResponseEntity<String>("Advertiser does not have enough credit.",HttpStatus.OK);
		}
		else {
			return new ResponseEntity<String>("Advertiser has enough credit.",HttpStatus.OK);
		}		
	}
	
	@RequestMapping(value = "/advertiser/{id}", method = RequestMethod.GET)
	public Advertiser getAdvertiserById(@PathVariable("id") long id) {
		Advertiser advertiser = advertiserService.getById(id);		
		return advertiser;
	}
	
    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAdvertiser(@RequestBody Advertiser advertiser, @PathVariable long id) {
    	Advertiser currentAdvertiser =  advertiserService.getById(id);	
    	if(currentAdvertiser == null) {
            return new ResponseEntity<String>("Advertiser not found",HttpStatus.NOT_FOUND);
    		
    	}
    	else {    		
	        currentAdvertiser.setName(advertiser.getName());
	        currentAdvertiser.setContactName(advertiser.getContactName());
	        currentAdvertiser.setCreditLimit(advertiser.getCreditLimit());
	        advertiserService.updateCreditLimit(currentAdvertiser);
	        return new ResponseEntity<String>("Advertiser updated successfullly", HttpStatus.OK);						 
    		
    	}   
	}
    
    @RequestMapping(value = "/advertiserCreditLimit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAdvertiserCreditLimit(@RequestBody double creditLimit, @PathVariable long id) {
    	Advertiser currentAdvertiser =  advertiserService.getById(id);	
    	if(currentAdvertiser == null) {
            return new ResponseEntity<String>("Advertiser not found",HttpStatus.NOT_FOUND);
    		
    	}
    	else {
	        currentAdvertiser.setCreditLimit(currentAdvertiser.getCreditLimit()-creditLimit);	 
	        advertiserService.updateCreditLimit(currentAdvertiser);
	        return new ResponseEntity<String>("Credit Limit updated successfullly", HttpStatus.OK);						 
    		
    	}    	
	}
    

    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteAdvertiser(@PathVariable("id") long id) {
        if (advertiserService.getById(id) == null) {
            return new ResponseEntity<String>("Advertiser not found", HttpStatus.NOT_FOUND);
        }
        else {
        	advertiserService.delete(id);        
        	return new ResponseEntity<String>("Advertiser deleted successfullly", HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/advertiser/", method = RequestMethod.POST)
    public ResponseEntity<?> createAdvertiser(@RequestBody Advertiser advertiser) {    	
    	if(advertiserService.getByName(advertiser.getName()) == null) {
            advertiserService.create(advertiser); 
            return new ResponseEntity<Advertiser>(advertiser, HttpStatus.CREATED);    		
    	}
    	else {
    		return new ResponseEntity<String>("Advertiser already exists", HttpStatus.CONFLICT);    		

    	}
    }
}
