package com.iheart.iHeart.Media.repository;

import static org.mockito.Mockito.*;

import org.junit.*;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.iheart.iHeart.Media.UnitTest;
import com.iheart.iHeart.Media.Service.AdvertiserService;
import com.iheart.iHeart.Media.model.Advertiser;

import io.swagger.models.HttpMethod;

import java.util.List;

import static org.junit.Assert.*;

//@SpringBootTest
//@RunWith(SpringRunner.class)
@RunWith(SpringJUnit4ClassRunner.class)
//@Category(UnitTest.class)
public class AdvertiserRepositoryTest {
	
	

	@InjectMocks
	AdvertiserService service;
	
    @Mock
    AdvertiserRepository repository;
    
	
 // http://www.springboottutorial.com/integration-testing-for-spring-boot-rest-services
	//TestRestTemplate restTemplate = new TestRestTemplate();

	//HttpHeaders headers = new HttpHeaders();
	
    
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
    	verify(repository).update(advertiser);
    }
    
    
    @Test
    public void deleteAdvertiserTest() {
    	service.getById(ID);
    	verify(repository).deleteById(ID);
    }
    
//    @Test
//    public void testAllAdvertisers() throws Exception {
//        List<Advertiser> books = (List<Advertiser>) repository.findAll2();
//        assertFalse(books.isEmpty());
//        assertEquals(2, books.size());
//    }
    
//    @Test
//	public void testRetrieveAdvertiserById() {
//
//		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
//
//		ResponseEntity<String> response = RestTemplate.exchange(
//				createURLWithPort("/students/Student1/courses/Course1"),
//				HttpMethod.GET, entity, String.class);
//
//		String expected = "{id:Course1,name:Spring,description:10 Steps}";
//
//		JSONAssert.assertEquals(expected, response.getBody(), false);
//	}
    
//    private String createURLWithPort(String uri) {
//		return "http://localhost:8080" + uri;
//	}
    
}
