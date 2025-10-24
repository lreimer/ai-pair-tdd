package org.example;

public class BowlingGame {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    public int score() {
        int score = 0;
        int rollIndex = 0;
        for (int frame = 0; frame < 10; frame++) {
            if (isStrike(rollIndex)) {
                score += strikeScore(rollIndex);
                rollIndex += 1;
            } else if (isSpare(rollIndex)) {
                score += spareScore(rollIndex);
                rollIndex += 2;
            } else {
                score += normalScore(rollIndex);
                rollIndex += 2;
            }
        }
        return score;
    }

    private boolean isStrike(int rollIndex) {
        return rolls[rollIndex] == 10;
    }

    private boolean isSpare(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1] == 10;
    }

    private int strikeScore(int rollIndex) {
        return 10 + rolls[rollIndex + 1] + rolls[rollIndex + 2];
    }

    private int spareScore(int rollIndex) {
        return 10 + rolls[rollIndex + 2];
    }

    private int normalScore(int rollIndex) {
        return rolls[rollIndex] + rolls[rollIndex + 1];
    }
}
