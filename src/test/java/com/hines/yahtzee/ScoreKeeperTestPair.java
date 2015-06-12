package com.hines.yahtzee;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class ScoreKeeperTestPair {
    ScoreKeeper scoreKeeper;
    Die dieOne;
    Die dieTwo;
    Die dieThree;
    Die dieFour;
    Die dieFive;

    @Before
    public void before() {
        // Arrange
        scoreKeeper = new ScoreKeeper();

        dieOne = Mockito.mock(Die.class);       
        dieTwo = Mockito.mock(Die.class);       
        dieThree = Mockito.mock(Die.class);       
        dieFour = Mockito.mock(Die.class);       
        dieFive = Mockito.mock(Die.class);
    }

    @Test    
    public void calculateScorePairCategory1() {
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

    @Test    
    public void calculateScorePairCategory2() {
        // Act
        when(dieOne.roll()).thenReturn(1);
        when(dieTwo.roll()).thenReturn(2);
        when(dieThree.roll()).thenReturn(3);
        when(dieFour.roll()).thenReturn(6);
        when(dieFive.roll()).thenReturn(4);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.PAIR);

        //Assert
        assertThat(score, equalTo(0));        
    }

    @Test    
    public void calculateScorePairCategory3() {
        // Act
        when(dieOne.roll()).thenReturn(2);
        when(dieTwo.roll()).thenReturn(2);
        when(dieThree.roll()).thenReturn(2);
        when(dieFour.roll()).thenReturn(6);
        when(dieFive.roll()).thenReturn(2);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.PAIR);

        //Assert
        assertThat(score, equalTo(4));        
    }

    @Test    
    public void calculateScorePairCategory4() {
        // Act
        when(dieOne.roll()).thenReturn(6);
        when(dieTwo.roll()).thenReturn(2);
        when(dieThree.roll()).thenReturn(6);
        when(dieFour.roll()).thenReturn(6);
        when(dieFive.roll()).thenReturn(5);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.PAIR);

        //Assert
        assertThat(score, equalTo(12));        
    }
}