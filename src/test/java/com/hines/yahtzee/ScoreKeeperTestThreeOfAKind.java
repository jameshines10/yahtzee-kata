package com.hines.yahtzee;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;

public class ScoreKeeperTestThreeOfAKind {
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
    public void calculateScoreThreeOfKindCategory1() {
        // Act
        when(dieOne.roll()).thenReturn(3);
        when(dieTwo.roll()).thenReturn(3);
        when(dieThree.roll()).thenReturn(3);
        when(dieFour.roll()).thenReturn(4);
        when(dieFive.roll()).thenReturn(5);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.THREE_OF_KIND);

        //Assert
        assertThat(score, equalTo(9));        
    }

    @Test    
    public void calculateScoreThreeOfKindCategory2() {
        // Act
        when(dieOne.roll()).thenReturn(6);
        when(dieTwo.roll()).thenReturn(3);
        when(dieThree.roll()).thenReturn(6);
        when(dieFour.roll()).thenReturn(4);
        when(dieFive.roll()).thenReturn(6);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.THREE_OF_KIND);

        //Assert
        assertThat(score, equalTo(18));        
    }

    @Test    
    public void calculateScoreThreeOfKindCategory3() {
        // Act
        when(dieOne.roll()).thenReturn(6);
        when(dieTwo.roll()).thenReturn(3);
        when(dieThree.roll()).thenReturn(6);
        when(dieFour.roll()).thenReturn(4);
        when(dieFive.roll()).thenReturn(3);        

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};
        
        int score = scoreKeeper.calculateScore(pipCounts, Category.THREE_OF_KIND);

        //Assert
        assertThat(score, equalTo(0));        
    }

    @Test
    public void calculateScoreThreeOfKindCategory4() {
        // Act
        when(dieOne.roll()).thenReturn(3);
        when(dieTwo.roll()).thenReturn(6);
        when(dieThree.roll()).thenReturn(6);
        when(dieFour.roll()).thenReturn(6);
        when(dieFive.roll()).thenReturn(3);

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};

        int score = scoreKeeper.calculateScore(pipCounts, Category.THREE_OF_KIND);

        //Assert
        assertThat(score, equalTo(18));
    }

    @Test
    public void calculateScoreThreeOfKindCategory5() {
        // Act
        when(dieOne.roll()).thenReturn(3);
        when(dieTwo.roll()).thenReturn(3);
        when(dieThree.roll()).thenReturn(6);
        when(dieFour.roll()).thenReturn(6);
        when(dieFive.roll()).thenReturn(6);

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};

        int score = scoreKeeper.calculateScore(pipCounts, Category.THREE_OF_KIND);

        //Assert
        assertThat(score, equalTo(18));
    }

    @Test
    public void calculateScoreThreeOfKindCategory6() {
        // Act
        when(dieOne.roll()).thenReturn(6);
        when(dieTwo.roll()).thenReturn(3);
        when(dieThree.roll()).thenReturn(6);
        when(dieFour.roll()).thenReturn(6);
        when(dieFive.roll()).thenReturn(6);

        int[] pipCounts = {dieOne.roll(), dieTwo.roll(), dieThree.roll(), dieFour.roll(), dieFive.roll()};

        int score = scoreKeeper.calculateScore(pipCounts, Category.THREE_OF_KIND);

        //Assert
        assertThat(score, equalTo(18));
    }
}