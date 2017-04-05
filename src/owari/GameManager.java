/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package owari;

import owari.Exceptions.QuitGameException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Board;
import owari.Exceptions.IllegalMoveException;

/**
 *
 * @author Yerlan
 */
public class GameManager {

    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        gameManager.mainMenu();
    }

    public void mainMenu() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("        Main menu!");
        System.out.println("        Please select one option and enter the number");
        System.out.println("1. New Game Human vs Human");
        System.out.println("2. New Game Human vs Computer");
        System.out.println("3. Load Game");
        try {
            int input = scanner.nextInt();
            switch (input) {
                case 1:
                    newGameHvH();
                    break;
                case 2:
                    newGameHvC();
                    break;
                case 3:
                    loadGame();
                    break;
                //default: System.out.println("please enter one of the options!"); mainMenu();
            }
        } catch (Exception e) {
            System.out.println("please enter one of the options!" + e);
            mainMenu();
        }
    }

    public static void newGameHvH() throws QuitGameException {
        Board board = new Board();
        board.toString();
        while (board.getResult() == 0) {
            Board bclone = board.clone();
            HumanPlayer player1 = new HumanPlayer();
            HumanPlayer player2 = new HumanPlayer();
            try {
                board.makeMove(0, player1.getMove(board, 0));
            } catch (IllegalMoveException ex) {
                Logger.getLogger(GameManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        //player1.getMove(board, 1);
        //checkGameState(board);
        System.out.println("HvH");
    }

    public static void newGameHvC() throws QuitGameException {
        Board board = new Board();
        HumanPlayer humanPlayer = new HumanPlayer();
        ComputerPlayer computerPlayer = new ComputerPlayer();
        humanPlayer.getMove(board, 1);
        System.out.println("HvC");
    }

    public static void loadGame() {
        System.out.println("Load");
    }

    private static void checkGameState(Board board) {

    }
}
