
package Scrabble;

public class Player {
    private String name;
    private int score;
    private boolean played;

    public Player() {
        score = 0;
        played = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isPlayed() {
        return played;
    }

    public void setPlayed(boolean played) {
        this.played = played;
    }
    
    public void updateScore (int score) {
        this.score = this.score + score;
    }
}