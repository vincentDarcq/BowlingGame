package Bowling;

import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.CoreMatchers.*;

public class BowlingGameTest{

    private BowlingGame game;

    @Before
    public void setGame(){
        game = new BowlingGame();
    }

    @Test
    public void getAllNull(){
        for(int i = 0; i < 21; i++){
            game.setScore(0);
        }
        assertThat(game.getScore(10), is(0));
    }

    @Test
    public void getAllSpares(){
        for(int i = 0; i < 21; i++){
            game.setScore(5);
        }
        assertThat(game.getScore(10), is(150));
    }

    @Test
    public void getPerfectScore(){
        for(int i = 0; i < 12; i++){
            game.setScore(10);
        }
        assertThat(game.getScore(10), is(300));
    }
}
