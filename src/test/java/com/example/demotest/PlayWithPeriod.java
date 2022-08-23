package com.example.demotest;

import org.junit.jupiter.api.Test;

import java.time.Period;

public class PlayWithPeriod {
	@Test
	public void test() {
		Period p3D = Period.parse("P3D");
		Period p4 = Period.parse("P4D");

		System.out.println(p3D.getDays());
		System.out.println(p4.getDays());

	}
}
