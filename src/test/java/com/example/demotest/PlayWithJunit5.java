package com.example.demotest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PlayWithJunit5 {

    @Test
    void testOne() {
        System.out.println("PlayWithJunit5 - Test One");
    }

    @DisplayName("Custom Display Name Test")
    @Test
    void testWithCustomDisplayName() {
        System.out.println("PlayWithJunit5 - Custom Display Name Test");
    }


    @DisplayName("Inner Class Related Tests")
    @Nested
    class InnerTestClass {

        @Test
        void testTwo() {
            System.out.println("InnerTestClass - Test Two");
        }

        @Nested
        class InnermostTestClass {

            @Test
            void testThree() {
                System.out.println("InnermostTestClass - Test Three");
            }
        }
    }
}

