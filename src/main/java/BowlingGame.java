import java.util.HashMap;

public class BowlingGame {

    int score = 0;

    HashMap<Integer, String> resultByTurn;

    HashMap<Integer, Integer> pintsHitFirst;

    boolean thirdLastBall = false;

    public BowlingGame(){ }

    public void putScore(Integer turn, Integer trial, Integer pins){
        if(trial == 1){
            if(turn == 1){
                if(pins == 10){
                    this.score = 10;
                    this.resultByTurn.put(turn, "strike");
                }else {
                    this.score = pins;
                }
            }else if(turn == 10){
                if(pins == 10){
                    this.score += 10;
                    this.resultByTurn.put(turn, "strike");
                    this.thirdLastBall = true;
                }else {
                    this.score += pins;
                }
            } else {
                if(pins == 10){
                    this.score += 10;
                    this.resultByTurn.put(turn, "strike");
                    if(isTurnASpare(turn-1) || isTurnAStrike(turn-1)){
                        this.score += 10;
                    }
                }else {
                    this.score += pins;
                }
            }
            this.pintsHitFirst.put(turn, pins);
        }
        if(trial == 2){
            if(turn == 10){
                if(isTurnAStrike(turn)){
                    if(pins == 10){
                        this.score += 10;
                    }else {
                        this.score += pins;
                        this.pintsHitFirst.put(turn, pins);
                    }
                }else {
                    if(pins + this.pintsHitFirst.get(10) == 10){
                        this.score += pins;
                        this.thirdLastBall = true;
                    }else {
                        this.score += pins;
                    }
                }
                if(!this.thirdLastBall){
                    System.out.println("Game over, score =" + this.score);
                }
            }else {
                if (pins + this.pintsHitFirst.get(turn) == 10) {
                    this.score += pins;
                    this.resultByTurn.put(turn, "spare");
                } else {
                    this.score += pins;
                }
                if (isTurnAStrike(turn - 1)) {
                    this.score += pins + this.pintsHitFirst.get(turn);
                }
                if (isTurnASpare(turn - 1)) {
                    this.score += this.pintsHitFirst.get(turn);
                }
            }
        }
        if(trial == 3){
            if(!this.thirdLastBall){
                System.out.println("Nice try but your game is already over with the score of " + this.score);
            }else{
                this.score += pins;
                System.out.println("Game over, score =" + this.score);
            }
        }
    }

    public boolean isTurnASpare(Integer turn){
        return this.resultByTurn.get(turn).equals("spare");
    }

    public boolean isTurnAStrike(Integer turn){
        return this.resultByTurn.get(turn).equals("strike");
    }

}
