package com.example.demotest;

import com.example.demotest.config.DemoProperties;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class DemoController {

	private final DemoProperties demoProperties;


	@GetMapping
	public String home() {
		return "Hello - Period is " +  demoProperties.getPeriodRange().toString();
	}
}
