package com.hines.yahtzee;

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
        int timesInArray = 1;

        outerloop:
        for(int i = 0; i < pipCounts.length; i++){
            for (int j = 0; j < pipCounts.length; j++) {
                if(i != j && (pipCounts[j] == pipCounts[i])) {
                    timesInArray++;
                    tripletNum = pipCounts[j];

                    if(timesInArray == 3){
                        gotTriplets = true;
                        break outerloop;
                    }
                }
            }

            timesInArray = 1;
        }

        if(gotTriplets){
            tripletNum *= 3;
        }else{
            tripletNum = 0;
        }

        return tripletNum;
    }

    private int getFourOfKindScore(int[] pipCounts) {
        int quadNum = 0;
        boolean gotQuads = false;
        int timesInArray = 1;

        outerloop:
        for(int i = 0; i < pipCounts.length; i++){
            for (int j = 0; j < pipCounts.length; j++) {
                if(i != j && (pipCounts[j] == pipCounts[i])) {
                    timesInArray++;
                    quadNum = pipCounts[j];

                    if(timesInArray == 4){
                        gotQuads = true;
                        break outerloop;
                    }
                }
            }

            timesInArray = 1;
        }

        if(gotQuads){
            quadNum *= 4;
        }else{
            quadNum = 0;
        }

        return quadNum;
    }

    public int calculateScore(int[] pipCounts, Category category) {
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
            case FOUR_OF_KIND:
                this.score = getFourOfKindScore(pipCounts);
                break;
        }

        return this.score;
    }
}