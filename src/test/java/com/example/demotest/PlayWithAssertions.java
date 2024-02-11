package com.example.demotest;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.withinPercentage;

public class PlayWithAssertions {

    @Test
    void testAssertTrue() {
        //add assertion for true
        assertThat(BigDecimal.valueOf(123.1235)).isCloseTo(BigDecimal.valueOf(123.134), withinPercentage(0.01));
    }
}
