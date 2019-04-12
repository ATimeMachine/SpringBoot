package com.example.springboot.properties;

import com.example.springboot.properties.Thread.CallJasper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = PropertiesApplication.class)
public class PropertiesApplicationTests {

	@Test
	public void contextLoads() {
		CallJasper callJasper = new CallJasper();
		List<Thread> threads = callJasper.creadThread();
		callJasper.startThread(threads);
	}

}
