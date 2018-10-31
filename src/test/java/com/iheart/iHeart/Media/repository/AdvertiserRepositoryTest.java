package com.iheart.iHeart.Media.repository;

import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.iheart.iHeart.Media.Service.AdvertiserService;
import com.iheart.iHeart.Media.model.Advertiser;



import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdvertiserRepositoryTest {
	
	

	@InjectMocks
	AdvertiserService service;
	
    @Mock
    AdvertiserRepository repository;
    
	
    
    private static final long ID = 1;
    @Test
    public void findByIdTest() {
    	service.getById(ID);
    	verify(repository).getById(ID);
    }
    
    
    @Test
    public void getAllTest() {
    	service.getAll();
    	verify(repository).getAll();
    }
    
      
    @Test
    public void saveAdvertiserTest() {
    	Advertiser advertiser = mock(Advertiser.class);
    	service.create(advertiser);
    	verify(repository).insert(advertiser);
    }
    
    @Test
    public void updateAdvertiserTest() {
    	Advertiser advertiser = mock(Advertiser.class);
    	service.update(advertiser);
    	verify(repository).update(advertiser);
    }
    
    
    @Test
    public void getByNameTest() {
    	service.getByName("TEST");
    	verify(repository).getByName("TEST");
    }
    
    @Test
    public void deleteAdvertiserTest() {
    	service.delete(ID);
    	verify(repository).delete(ID);
    }   
    
    @Test
    public void updateAdvertiserCreditLimitTest() {
    	Advertiser advertiser = mock(Advertiser.class);
    	service.updateCreditLimit(advertiser);
    	verify(repository).updateCreditLimit(advertiser);
    }        
}
