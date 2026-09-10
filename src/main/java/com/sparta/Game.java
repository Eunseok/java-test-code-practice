package com.sparta;

public class Game {

    private final String name;
    private int score;

    public Game(String name) {
        this.name = name;
        this.score = 0;
    }

    public void addScore(int score) {
        if (score < 0) {
            throw new IllegalArgumentException("점수는 음수일 수 없습니다.");
        }

        this.score += score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
