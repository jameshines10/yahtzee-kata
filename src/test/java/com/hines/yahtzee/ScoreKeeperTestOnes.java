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
    public void calculateScoreOnesCategory1() {                       
        // Act
        when(dieOne.roll()).thenReturn(3);
        when(dieTwo.roll()).thenReturn(1);
        when(dieThree.roll()).thenReturn(1);
        when(dieFour.roll()).thenReturn(1);
        when(dieFive.roll()).thenReturn(6);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.ONES);

        //Assert
        assertThat(score, equalTo(3));        
    }

    @Test    
    public void calculateScoreOnesCategory2() {
        // Act
        when(dieOne.roll()).thenReturn(3);
        when(dieTwo.roll()).thenReturn(1);
        when(dieThree.roll()).thenReturn(5);
        when(dieFour.roll()).thenReturn(2);
        when(dieFive.roll()).thenReturn(6);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.ONES);

        //Assert
        assertThat(score, equalTo(1));        
    }

    @Test    
    public void calculateScoreOnesCategory3() {
        // Act
        when(dieOne.roll()).thenReturn(3);
        when(dieTwo.roll()).thenReturn(1);
        when(dieThree.roll()).thenReturn(1);
        when(dieFour.roll()).thenReturn(1);
        when(dieFive.roll()).thenReturn(1);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.ONES);

        //Assert
        assertThat(score, equalTo(4));        
    }
}