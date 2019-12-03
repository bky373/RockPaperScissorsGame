package com.example.rockpaperscissorsgame;

import java.util.Random;

public class JavaBasic {
    public static void main(String[] args) {
        double randomDouble = Math.random();
        System.out.println("randomDouble = " + randomDouble);
        int randomInt = (int) (randomDouble * 3) + 1;
        System.out.println("randomInt = " + randomInt);
        System.out.println("getRandom = " + ((int) (Math.random()*3) + 1));

        int randomClass = new Random().nextInt(3) + 1;
        System.out.println("randomClass = " + randomClass);
    }
}
