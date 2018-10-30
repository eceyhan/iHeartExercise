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
import com.iheart.iHeart.Media.model.Student;
import com.iheart.iHeart.Media.repository.AdvertiserRepository;
import com.iheart.iHeart.Media.util.CustomErrorType;

import io.swagger.models.Model;
import java.util.Optional;
import org.springframework.http.ResponseEntity;

 // https://github.com/vojtechruz/rest-docs-starter/blob/master/src/main/java/com/vojtechruzicka/springfoxexample/controllers/PersonController.java

@RestController
//@RequestMapping("/api")
public class AdvertiserController {
	 
	
//    private AdvertiserService apiRequestService;
	@Autowired
	AdvertiserService advertiserService;
	
	@RequestMapping(value = "/getAllAdvertiser",  method= RequestMethod.GET)
	public List<Advertiser> getAdvertisers() {
		try {
			return advertiserService.getAll();
		}
		catch (Exception e) {
			return null;
		}
	}
	
	@RequestMapping(value = "/advertiser/hasCredit/{id}", method = RequestMethod.GET)
	public boolean advertiserHasCredit(@PathVariable("id") long id) {
		return advertiserService.hasEnoughCredit(id);
	}
	
	@RequestMapping(value = "/advertiser/{id}", method = RequestMethod.GET)
	public Advertiser getAdvertiserById(@PathVariable("id") long id) {
		Advertiser advertiser = advertiserService.getById(id);
		
		return advertiser;
//	        if (advertiser == null) {
//	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("User with id " + id 
//	                    + " not found"), HttpStatus.NOT_FOUND);
//	        }
//	        return new ResponseEntity<Advertiser>(advertiser, HttpStatus.OK);
		
//		try {
//			Optional<Advertiser> advertiser = repository.findById(id);
//
//			if (!advertiser.isPresent())
//				throw new AdvertiserNotFoundException("id-" + id);
//
//			return advertiser.get();			
//		}
//		catch (Exception e) {
//			return null;
//		}
	}
	
    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateStudent(@RequestBody Advertiser advertiser, @PathVariable long id) {
		try {
			Advertiser currentAdvertiser =  advertiserService.getById(id);
					
	        if (currentAdvertiser == null) {
	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }
	        currentAdvertiser.setName(advertiser.getName());
	        currentAdvertiser.setContactName(advertiser.getContactName());
	        currentAdvertiser.setCreditLimit(advertiser.getCreditLimit());
	 
	        advertiserService.update(currentAdvertiser);
	        return new ResponseEntity<Advertiser>(currentAdvertiser, HttpStatus.OK);						 
		}
		catch (Exception e) {
			return null;
		}
	}
    
    @RequestMapping(value = "/advertiserCreditLimit/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> updateAdvertiser(@RequestBody double creditLimit, @PathVariable long id) {
		try {
			Advertiser currentAdvertiser =  advertiserService.getById(id);					
	        if (currentAdvertiser == null) {
	            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to upate. User with id " + id + " not found."),
	                    HttpStatus.NOT_FOUND);
	        }	        	        	        
	        currentAdvertiser.setCreditLimit(currentAdvertiser.getCreditLimit()-creditLimit);	 
	        advertiserService.updateCreditLimit(currentAdvertiser);
	        return new ResponseEntity<Advertiser>(currentAdvertiser, HttpStatus.OK);						 
		}
		catch (Exception e) {
			return null;
		}
	}
    

    @RequestMapping(value = "/advertiser/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteUser(@PathVariable("id") long id) {
    	Advertiser advertiser = advertiserService.getById(id);
        if (advertiser == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to delete. User with id " + id + " not found."),
                    HttpStatus.NOT_FOUND);
        }
        advertiserService.delete(id);
        return new ResponseEntity<Advertiser>(HttpStatus.NO_CONTENT);
    }
    
    @RequestMapping(value = "/advertiser/", method = RequestMethod.POST)
    public ResponseEntity<?> createAdvertiser(@RequestBody Advertiser advertiser, UriComponentsBuilder ucBuilder) {       
        if (advertiserService.doesAdvertiserExist(advertiser)) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Unable to create. An advertiser with name " + 
            advertiser.getName() + " already exist."),HttpStatus.CONFLICT);
        }        
        advertiserService.create(advertiser); 
        return new ResponseEntity<Advertiser>(advertiser, HttpStatus.CREATED);
    }
    
    //HttpHeaders headers = new HttpHeaders();
    //headers.setLocation(ucBuilder.path("/api/user/{id}").buildAndExpand(user.getId()).toUri());

}
