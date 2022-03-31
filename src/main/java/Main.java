import Bowling.BowlingGame;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        BowlingGame game = new BowlingGame();
        Scanner sc= new Scanner(System.in);
        System.out.println("Welcome to Bowling game");
        for(int i = 1; i <= 9; i++){
            System.out.print("turn "+ i + " How many pins did you get down for the first trial ? ");
            int pins1= sc.nextInt();
            game.setScore(pins1);
            if(pins1 < 10){
                System.out.print("turn "+ i + " How many pins did you get down for the second trial ? ");
                int pins2= sc.nextInt();
                game.setScore(pins2);
            }
            System.out.println("turn "+ i + ", Score = " + game.getScore(i));
        }
        System.out.print("turn 10, How many pins did you get down for the first trial ? ");
        int pins1= sc.nextInt();
        game.setScore(pins1);
        System.out.print("turn 10, How many pins did you get down for the second trial ? ");
        int pins2= sc.nextInt();
        game.setScore(pins2);
        if(pins1 == 10 || pins1 + pins2 == 10){
            System.out.print("turn 10, How many pins did you get down for the third trial ? ");
            int pins3= sc.nextInt();
            game.setScore(pins3);
        }
        System.out.println("Score = " + game.getScore(10));
    }
}
