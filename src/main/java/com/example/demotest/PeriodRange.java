package com.example.demotest;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.Value;

import java.time.LocalDate;
import java.time.Period;

import static lombok.AccessLevel.PRIVATE;


@Value
@AllArgsConstructor(access = PRIVATE)
public class PeriodRange {

    Period min;
    Period max;

    public static PeriodRange of(final @NonNull Period min, final @NonNull Period max) {
        if (isAValidPeriodRange(min, max)) {
            return new PeriodRange(min, max);
        }
        throw new IllegalArgumentException("min period should be shorter than max period");
    }

    private static boolean isAValidPeriodRange(final Period min, final Period max) {
        final var aRandom30DaysMonthReferenceDate = LocalDate.of(1970, 4, 1);
        return !(aRandom30DaysMonthReferenceDate.plus(min).isAfter(aRandom30DaysMonthReferenceDate.plus(max)));
    }
}
