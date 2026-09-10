package com.sparta;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GameTest {

    @Test
    void 게임을_생성한다() {
        // Given
        String name = "newGame";

        // When
        Game game = new Game(name);

        // Then
        assertEquals(name, game.getName());
    }

    @Test
    void 점수를_추가한다() {
        // Given
        Game game = new Game("newGame");

        // When
        game.addScore(100);

        // Then
        assertEquals(100, game.getScore());
    }

    @Test
    void 음수_점수를_추가하면_예외가_발생한다() {
        // Given
        Game game = new Game("newGame");

        // When & Then
        assertThrows(
                IllegalArgumentException.class,
                () -> game.addScore(-10)
        );
    }


    @Test
    void 음수_점수는_추가되지_않는다() {
        // Given
        Game game = new Game("newGame");
        game.addScore(100);

        // When
        assertThrows(
                IllegalArgumentException.class,
                () -> game.addScore(-10)
        );

        // Then
        assertEquals(100, game.getScore());
    }
}