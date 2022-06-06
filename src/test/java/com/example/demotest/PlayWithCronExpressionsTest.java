package com.example.demotest;

import org.junit.jupiter.api.Test;
import org.springframework.scheduling.support.CronExpression;

import java.time.LocalDateTime;

public class PlayWithCronExpressionsTest {

	@Test
	void spring_cron_expression_test() {
		var expression = CronExpression.parse("*/30 * * * * *");
		var result = expression.next(LocalDateTime.now());
		System.out.println(result);
	}
}
