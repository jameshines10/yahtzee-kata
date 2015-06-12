package com.hines.yahtzee;

import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.Matchers.*;

public class DieTest {
    @Test
    public void pipCountAlwaysLessThanSix() {
        // Arrange
        Die die = new Die();        

        // Act
        die.roll();

        //Assert
        assertThat(die.getPipCount(), lessThan(6));
    }

    @Test
    public void pipCountAlwaysGreaterThanZero() {
        // Arrange
        Die die = new Die();        

        // Act
        die.roll();

        //Assert
        assertThat(die.getPipCount(), greaterThan(0));
    }
}