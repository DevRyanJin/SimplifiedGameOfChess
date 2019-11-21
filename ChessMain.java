//-----------------------------------------
// NAME		: Sijin Lee
// STUDENT NUMBER	: 7822352
// COURSE		: COMP 2150
// INSTRUCTOR	: Heather Matheson
// ASSIGNMENT	: assignment 3
// QUESTION	: question 1
//
// REMARKS: Implement a simplified version of the game of Chess (Opponents are  Human player or Computer)
//
//
//-----------------------------------------

import java.util.Scanner;

public class ChessMain
{
    public static String getName(Scanner sc)
    {
        System.out.println("Enter Name: ");
        String name = sc.next();

        return name;
    }

    public static int getMode(Scanner sc)
    {
        System.out.println("Enter Mode to Play (1: With Human, 2: With Computer)");
        int mode = sc.nextInt();

        while(mode < 1 || mode > 2)
        {
            System.out.println("Invalid Mode. Enter again(1-2): ");
            mode = sc.nextInt();
        }

        return mode;
    }

    public static ChessController makeController(Scanner sc)
    {
        ChessController controller = null;

        String player1 = getName(sc);

        int mode = getMode(sc);

        if(mode == 1)
        {
            System.out.println("Enter player-2 details");
            String player2 = getName(sc);
            controller = new ChessController(sc,player1,player2);
        }
        else
        {
            controller = new ChessController(sc,player1,null);
            controller.promptForOpponentDifficulty(1);
        }

        return controller;
    }

    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to Chess!"+"\nEnter your details");

        ChessController controller = makeController(sc);

        while(!controller.isGameOver())
        {
            controller.movePiece();
        }
    }
}
