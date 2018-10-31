package com.iheart.iHeart.Media;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IHeartMediaApplicationTests {

	@Test
	public void contextLoads() {
        System.out.println("This test method should be run");
        IHeartMediaApplication.main(new String[] {"arg1", "arg2", "arg3"});

	}

}
