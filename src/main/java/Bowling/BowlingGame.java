package Bowling;

public class BowlingGame {

    private int score = 0;
    private int[] scores = new int[21];

    public BowlingGame(){
    }

    public int getScore(int turn){
        int score = 0;
        int round = 0;
        for(int i = 0; i < turn; i++){
            if(isTurnAStrike(round)){
                score += 10 + this.scores[round+1] + this.scores[round+2];
                round++;
            }else if(isTurnASpare(round)){
                score += 10 + this.scores[round+2];
                round += 2;
            }else {
                score += this.scores[round] + this.scores[round+1];
                round += 2;
            }
        }
        return score;
    }

    public void setScore(Integer pins){
        this.scores[this.score++] += pins;
    }

    public boolean isTurnASpare(int pos){
        return this.scores[pos] + this.scores[pos+1] == 10;
    }

    public boolean isTurnAStrike(int pos){
        return this.scores[pos] == 10;
    }

}
