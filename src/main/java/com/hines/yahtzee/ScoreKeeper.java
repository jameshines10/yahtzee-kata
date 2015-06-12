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

    public int calculateScore(int[] pipCounts, Category category) {
        int score = 0;

        switch(category){
            case ONES: 
                this.score = getOnesScore(pipCounts);                   
                break;
            case PAIR:
                this.score = getPairScore(pipCounts);
                break;       
        }

        return this.score;
    }
}