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

	@Test
	void spring_cron_expression_daily() {
		var expression = CronExpression.parse("@daily");
		var result = expression.next(LocalDateTime.now());
		System.out.println(result);
	}

	@Test
	void spring_cron_expression_daily2() {
		var expression = CronExpression.parse("0 0 0 * * *");
		var result = expression.next(LocalDateTime.now());
		System.out.println(result);
	}

	@Test
	void spring_cron_expression_test2() {
		var expression = CronExpression.parse("0 * * * * *");
		var result = expression.next(LocalDateTime.now());
		System.out.println(result);
	}
	@Test
	void spring_cron_expression_every_5s() {
		var expression = CronExpression.parse("* 0/5 * * * *");
		var result = expression.next(LocalDateTime.now());
		System.out.println(result);
	}

	@Test
	void spring_cron_expression_reboot() {
		var expression = CronExpression.parse("@daily");
		var result = expression.next(LocalDateTime.now());
		System.out.println(result);
	}
}
