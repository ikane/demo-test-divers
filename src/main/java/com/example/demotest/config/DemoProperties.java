package com.example.demotest.config;

import com.example.demotest.PeriodRange;
import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Getter
@ConfigurationProperties(prefix = "demo")
public class DemoProperties {
	private final PeriodRange periodRange;

	public DemoProperties(PeriodRange periodRange) {
		this.periodRange = periodRange;
	}
}
