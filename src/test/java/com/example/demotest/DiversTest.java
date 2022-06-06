package com.example.demotest;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

class DiversTest {

    @Test
    public void givenTwoDatesInJava8_whenDifferentiating_thenWeGetSix() {
        LocalDate now = LocalDate.now();
        LocalDate sixDaysBehind = now.minusDays(6);
        LocalDate sixtyDaysAfter = now.plusDays(45);

        long sixty = ChronoUnit.DAYS.between(now, now.plusDays(60));

        Period period = Period.between(now, sixDaysBehind);
        int diff = period.getDays();

        int diff2 = Period.between(now, sixtyDaysAfter).getDays();

        assertThat(diff).isEqualTo(-6);
        //assertThat(diff2).isEqualTo(60);
        assertThat(sixty).isEqualTo(60);
    }

    @Test
    public void testAsync1() {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        String sentence = Stream.of(future1, future2, future3)
                               .map(CompletableFuture::join)
                               .collect(Collectors.joining(" "));

        assertThat(sentence).isEqualToIgnoringCase("Hello Beautiful World");
    }

    @Test
    public void testAsync2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> "Hello");
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> "Beautiful");
        CompletableFuture<String> future3 = CompletableFuture.supplyAsync(() -> "World");

        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2, future3);

        combinedFuture.get();


        assertThat(future1).isDone();
        assertThat(future2).isDone();
        assertThat(future3).isDone();
    }

    @Test
    public void testAsyncException() throws ExecutionException, InterruptedException {
        String name = null;
        CompletableFuture<String> completableFuture
                =  CompletableFuture.supplyAsync(() -> {
            if (name == null) {
                throw new RuntimeException("Computation error!");
            }
            return "Hello, " + name;
        }).handle((s, t) -> s != null ? s : "Hello, Stranger!");
        //completableFuture.handle((s, t) -> s != null ? s : "Hello, Stranger!");

        //String s = completableFuture.get();
        //assertEquals("Hello, Stranger!", s);

        System.out.println(2 >> 1);

        assertEquals("Hello, Stranger!", completableFuture.get());
    }

}