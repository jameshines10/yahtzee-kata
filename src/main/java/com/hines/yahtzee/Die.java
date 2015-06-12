package com.hines.yahtzee;

import java.util.Random;

class Die {
    private int pipCount;

    public int roll() {
        Random randomGenerator = new Random();

        int pips = randomGenerator.nextInt(5) + 1;

        this.pipCount = pips;

        return pips; 
    }

    public int getPipCount() {
        return this.pipCount;
    }
}