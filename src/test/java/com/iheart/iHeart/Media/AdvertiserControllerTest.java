package com.iheart.iHeart.Media;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpStatus;
import com.iheart.iHeart.Media.Service.AdvertiserService;
import com.iheart.iHeart.Media.model.Advertiser;

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
	Advertiser advertiser;
	
	
	private static final long ID = 1;
	
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
	public void advertiserHasCredit() {
		when(advertiserService.getById(ID)).thenReturn(advertiser);
		when(advertiserService.hasEnoughCredit(ID)).thenReturn(true);						
		assertEquals(controller.advertiserHasCredit(ID), true);
	}
	
	@Test
	public void createAdvertiserTestWhenNameDoesNotExist() {
		when(advertiserService.doesAdvertiserExist(advertiser)).thenReturn(false);
		assertEquals(controller.createAdvertiser(advertiser).getStatusCode(), HttpStatus.CREATED);
	}
	

	@Test
	public void createAdvertiserTestWhenNameDoesExist() {
		when(advertiserService.doesAdvertiserExist(advertiser)).thenReturn(true);
		assertEquals(controller.createAdvertiser(advertiser).getStatusCode(), HttpStatus.CONFLICT);
	}

	
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
