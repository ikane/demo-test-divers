package com.example.demotest;

import java.util.Date;

public class PlayWithCopilot {

    private int calculateDaysBetweenDates(Date date1, Date date2) {
        return (int) ((date2.getTime() - date1.getTime()) / (1000 * 60 * 60 * 24));
    }

       public static void main(String[] args) {
            System.out.println("Hello, world!");
        }



}
