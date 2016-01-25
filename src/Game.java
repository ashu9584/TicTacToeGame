import java.util.Random;
import java.util.Scanner;

/*
 * Created by ashutoshchaubey on 25/01/16.
 */
public class Game {
    public static void main(String[] a){
        System.out.println(" Welcome to the TICTACTOE game !!! ");
        TicTacToe t = new TicTacToe();
        Scanner sc = new Scanner(System.in);
        char c;
        System.out.println(" Enter the Alphabet for the user ");
        c = sc.next().charAt(0);
        t.setUserId(c);
        System.out.println(" Enter the Alphabet for the computer  ");
        c = sc.next().charAt(0);
        t.setComputerId(c);
        Random rand = new Random();
        if(Math.abs(rand.nextInt())%2==0)
            t.current=t.user;
        else
            t.current=t.computer;

        System.out.println(t.current+" will start the game ");
        while((!t.isThereAWinner()) && (!t.isBoardFilled())) {
            if(t.current==t.user) {
                System.out.print("\n Enter the position you want to play ! ");
                int pos = sc.nextInt();
                t.playTurn(pos);
            }
            else{
                t.playTurn(0);
            }
            t.printboard();
        }
        if(t.winner!='-')
            System.out.println(t.winner+" is the winner ");
        else
            System.out.println(" Tied ! ");
    }

}
