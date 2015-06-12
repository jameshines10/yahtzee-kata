package com.hines.yahtzee;

import java.util.*;

class ScoreKeeper {
    private int score;

    private int getOnesScore(int[] pipCounts) {
        int onesScore = 0;

        for (int pip : pipCounts) {
            if(pip == 1){
                onesScore += 1;
            }
        }

        return onesScore;
    }

    private int getPairScore(int[] pipCounts) {
        int pairNum = 0;
        int maxPairNum = 0;

        for(int i = 0; i < pipCounts.length; i++){
            for (int j = 0; j < pipCounts.length; j++) {
                if(i != j){
                    if(pipCounts[j] == pipCounts[i] && pipCounts[j] != pairNum) {
                        pairNum = pipCounts[j];

                        if(pairNum > maxPairNum){
                            maxPairNum = pairNum;
                        }
                    }
                }
            }
        }

        return maxPairNum * 2;
    }

    private int getThreeOfKindScore(int[] pipCounts) {
        int tripletNum = 0;
        boolean gotTriplets = false;

        List<Integer> triplets = new ArrayList<Integer>();

        outerloop:
        for(int i = 0; i < pipCounts.length; i++){
            for (int j = 0; j < pipCounts.length; j++) {
                if(i != j && pipCounts[j] == pipCounts[i]) {
                    tripletNum = pipCounts[j];

                    triplets.add(pipCounts[j]);

                    if(triplets.size() == 3){
                        gotTriplets = true;
                        break outerloop;
                    }
                }
            }
        }

        if(gotTriplets){
            tripletNum *= 3;
        }else{
            tripletNum = 0;
        }

        return tripletNum;
    }

    public int calculateScore(int[] pipCounts, Category category) {
        int score = 0;

        switch(category){
            case ONES: 
                this.score = getOnesScore(pipCounts);                   
                break;
            case PAIR:
                this.score = getPairScore(pipCounts);
                break;
            case THREE_OF_KIND:
                this.score = getThreeOfKindScore(pipCounts);
                break;      
        }

        return this.score;
    }
}