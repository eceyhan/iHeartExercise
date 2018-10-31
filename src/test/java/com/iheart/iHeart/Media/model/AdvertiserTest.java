package com.iheart.iHeart.Media.model;

import static org.mockito.Mockito.verify;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.iheart.iHeart.Media.model.Advertiser;
import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
public class AdvertiserTest {

//	@Mock
//	Advertiser advertiser;
    private static final long ID = 1;

    @Test
    public void contactNameTest() {
    	Advertiser advertiser = new Advertiser();
    	advertiser.setContactName("TEST");        
        assertTrue(advertiser.getContactName() == "TEST");
    	
    }
    
    @Test
    public void nameTest() {
    	Advertiser advertiser = new Advertiser();
    	advertiser.setName("TEST");        
        assertTrue(advertiser.getName() == "TEST");    	
    }
    
    @Test
    public void creditLimitTest() {
    	Advertiser advertiser = new Advertiser();
    	advertiser.setCreditLimit(100.00);        
        assertTrue(advertiser.getCreditLimit() == 100.00);    	
    }
    
    @Test
    public void IDTest() {
    	Advertiser advertiser = new Advertiser();
    	advertiser.setId(ID);        
        assertTrue(advertiser.getId() == ID);    	
    }

    
}
