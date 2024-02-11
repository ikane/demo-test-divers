package com.example.demotest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;

import static java.lang.String.format;

public class MemoryTesting {

	static final Logger LOGGER = LoggerFactory.getLogger(MemoryTesting.class);

	public static void main(String[] args) {
		int mb = 1024 * 1024;
		MemoryMXBean memoryBean = ManagementFactory.getMemoryMXBean();
		long xmx = memoryBean.getHeapMemoryUsage().getMax() / mb;
		long xms = memoryBean.getHeapMemoryUsage().getInit() / mb;
		LOGGER.info(format("Initial Memory (xms) : %s mb", xms));
		LOGGER.info(format("Max Memory (xmx) : %s mb", xmx));
	}
}
