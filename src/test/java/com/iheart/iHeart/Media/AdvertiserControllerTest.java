package com.iheart.iHeart.Media;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import com.iheart.iHeart.Media.Service.AdvertiserService;
import com.iheart.iHeart.Media.model.Advertiser;
import com.iheart.iHeart.Media.repository.AdvertiserRepository;

import org.junit.*;
import org.mockito.*;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)

public class AdvertiserControllerTest {

	@InjectMocks
	AdvertiserController controller;
	
	@Mock
	AdvertiserService advertiserService;
	
	@Mock
	AdvertiserRepository repository;
	
	@Mock
	Advertiser advertiser;
	
	
	private static final long ID = 1;
	private static final double creditLimit = 10;

	@Test
	public void getAdvertiserByIdTest() {
		when(advertiserService.getById(ID)).thenReturn(advertiser);				
		assertEquals(controller.getAdvertiserById(ID), advertiser);
	}
	
	@Test
	public void getAdvertisersTest() {
		List<Advertiser> advertisers = new ArrayList<Advertiser>();
		advertisers.add(advertiser);
		
		when(advertiserService.getAll()).thenReturn(advertisers);				
		assertEquals(controller.getAdvertisers().size(), advertisers.size());
	}
	
	
	@Test
	public void advertiserHasCreditWhenAdvertiserIsPresent() {
		when(advertiserService.getById(ID)).thenReturn(advertiser);
		when(advertiser.getCreditLimit()).thenReturn(creditLimit);
		assertEquals(controller.advertiserHasCredit(ID).getStatusCode(), HttpStatus.OK);
	} 
	
	static double test = 0;
	@Test
	public void advertiserHasCreditWhenAdvertiserIsPresent2() {
		when(advertiserService.getById(ID)).thenReturn(advertiser);
		when(advertiser.getCreditLimit()).thenReturn(test);
		assertEquals(controller.advertiserHasCredit(ID).getStatusCode(), HttpStatus.OK);
	} 

	@Test
	public void advertiserHasCreditWhenAdvertiserIsNotPresent() {
		when(advertiserService.getById(ID)).thenReturn(null);
		assertEquals(controller.advertiserHasCredit(ID).getStatusCode(), HttpStatus.NOT_FOUND);
	} 


 
	
	
 
	

//	@Test
//	public void createAdvertiserTestWhenNameDoesExist() {		
//		when(repository.getByName("TEST")).thenReturn(advertiser);		
//		assertEquals(controller.createAdvertiser(advertiser).getStatusCode(), HttpStatus.CONFLICT);
//	}

	
	@Test
	public void updateAccountTestWhenAdvertiserIsNotPresent() {
		when(advertiserService.getById(ID)).thenReturn(null);
		assertEquals(controller.updateAdvertiser(advertiser, ID).getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void updateAccountTestWhenAdvertiserIsPresent() {
		when(advertiserService.getById(ID)).thenReturn(advertiser);
		assertEquals(controller.updateAdvertiser(advertiser, ID).getStatusCode(), HttpStatus.OK);
	}
	
	
	@Test
	public void deleteAccountTestWhenAdvertiserIsNotPresent() {
		when(advertiserService.getById(ID)).thenReturn(null);
		assertEquals(controller.deleteAdvertiser(ID).getStatusCode(), HttpStatus.NOT_FOUND);
	}
	
	@Test
	public void deleteAccountTestWhenAdvertiserIsPresent() {
		when(advertiserService.getById(ID)).thenReturn(advertiser);
		assertEquals(controller.deleteAdvertiser(ID).getStatusCode(), HttpStatus.OK);
	}
	
	@Test
	public void createAdvertiserTestWhenNameDoesNotExist() {
		when(advertiser.getName()).thenReturn("TEST");
		when(advertiserService.getByName(advertiser.getName())).thenReturn(null);		
		assertEquals(controller.createAdvertiser(advertiser).getStatusCode(), HttpStatus.CREATED);
	}
	
	@Test
	public void createAdvertiserTestWhenNameDoesExist() {
		when(advertiser.getName()).thenReturn("TEST");
		when(advertiserService.getByName(advertiser.getName())).thenReturn(advertiser);		
		assertEquals(controller.createAdvertiser(advertiser).getStatusCode(), HttpStatus.CONFLICT);
	}
	
	
	@Test
	public void updateAdvertiserCreditLimitWhenAdvertiserIsNotPresent() {
		when(advertiserService.getById(ID)).thenReturn(null);
		assertEquals(controller.updateAdvertiserCreditLimit(10.00, ID).getStatusCode(), HttpStatus.NOT_FOUND);
	}

	@Test
	public void updateAdvertiserCreditLimitWhenAdvertiserIsPresent() {
		when(advertiserService.getById(ID)).thenReturn(advertiser);
		assertEquals(controller.updateAdvertiserCreditLimit(10.00, ID).getStatusCode(), HttpStatus.OK);
	}
	
}
