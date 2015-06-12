package com.hines.yahtzee;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class ScoreKeeperTestOnes {
    ScoreKeeper scoreKeeper;
    Die dieOne;
    Die dieTwo;
    Die dieThree;
    Die dieFour;
    Die dieFive;

    @Test    
    public void calculateScorePairsCategoryOne() {
        // Act
        when(dieOne.roll()).thenReturn(3);
        when(dieTwo.roll()).thenReturn(3);
        when(dieThree.roll()).thenReturn(3);
        when(dieFour.roll()).thenReturn(4);
        when(dieFive.roll()).thenReturn(4);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.PAIR);

        //Assert
        assertThat(score, equalTo(8));        
    }
}