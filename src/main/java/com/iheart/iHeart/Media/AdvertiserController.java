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
import com.iheart.iHeart.Media.exception.AdvertiserNotFoundException;
import com.iheart.iHeart.Media.model.Advertiser;
import com.iheart.iHeart.Media.repository.AdvertiserRepository;
import com.iheart.iHeart.Media.util.CustomErrorType;

import io.swagger.models.Model;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

 // https://github.com/vojtechruz/rest-docs-starter/blob/master/src/main/java/com/vojtechruzicka/springfoxexample/controllers/PersonController.java

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
	public boolean advertiserHasCredit(@PathVariable("id") long id) {
		return advertiserService.hasEnoughCredit(id);
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
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Advertiser not found"),
                    HttpStatus.NOT_FOUND);
    		
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
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Advertiser not found"),
                    HttpStatus.NOT_FOUND);
    		
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
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Advertiser not found"),
                    HttpStatus.NOT_FOUND);
        }
        else {
        	advertiserService.delete(id);        
        	return new ResponseEntity<String>("Advertiser deleted successfullly", HttpStatus.OK);
        }
    }
    
    @RequestMapping(value = "/advertiser/", method = RequestMethod.POST)
    public ResponseEntity<?> createAdvertiser(@RequestBody Advertiser advertiser) {       
        if (advertiserService.doesAdvertiserExist(advertiser)) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to create. An advertiser with name " + 
            advertiser.getName() + " already exist."), HttpStatus.CONFLICT);
        }        
        advertiserService.create(advertiser); 
        return new ResponseEntity<Advertiser>(advertiser, HttpStatus.CREATED);
    }
}
