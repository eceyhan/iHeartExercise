package com.iheart.iHeart.Media;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.experimental.categories.Category;

@RunWith(SpringRunner.class)
@SpringBootTest
@Category(IntegrationTest.class)
public class IHeartMediaApplicationTests {

	@Test
	public void contextLoads() {
        System.out.println("This test method should be run");
	}

}
