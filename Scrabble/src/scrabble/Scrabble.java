/*

 */
package Scrabble;

import java.util.List;
import java.util.Scanner;

public class Scrabble {

    static int Flag, Start, player = 1;
    static boolean end = false;
    static Scanner sc = new Scanner(System.in);
    static Alphabet AlphabetList = new Alphabet();
    static String Word, YN, NewGame;
    static Player playerOne = new Player(), playerTwo = new Player(), playerNow = playerOne, winner;

    public static void main(String[] args) {

        while (!end) {
            startup();
            if (Start == 1) {
                players();

                Flag = 0;
                while (Flag == 0) {
                    print(AlphabetList.getAlphabetList());

                    System.out.print(playerNow.getName() + ", please enter your word: ");
                    Word = sc.next().toLowerCase();

                    if (Word.equals("???")) {
                        score();
                        NewGame();
                    } else {
                        CheckWord();
                    }
                    if (player == 1) {
                        playerOne = playerNow;
                        if (playerOne.isPlayed()) {
                            playerTwo.setPlayed(false);
                            playerNow = playerTwo;
                            player = 1;
                        }
                    } else {
                        playerTwo = playerNow;
                        if (playerTwo.isPlayed()) {
                            playerOne.setPlayed(false);
                            playerNow = playerOne;
                            player = 1;
                        }
                    }
                }
            } else {
                end = false;
                System.out.println("You exited the game!!!");
                System.exit(0);
            }
        }
    }

    public static void startup() {
        System.out.println("Welcome to the WORD WARS game.\n");
        System.out.println("Press (1) To start the game.\n");
        System.out.print("Press any other key to exit the game\nEnter your selection: ");
        Start = sc.nextInt();
    }

    public static void players() {
        System.out.println("********************************");
        System.out.print("Enter player 1 name: ");
        playerOne.setName(sc.next());
        System.out.print("Enter player 2 name: ");
        playerTwo.setName(sc.next());
        System.out.println("\nLET'S PLAY WORD WARS!!!");
    }

    public static void CheckWord() {
        if (AlphabetList.checkWord(Word)) {
            System.out.println("Enter (y) yes if both players agree on the word: ");
            YN = sc.next();
            if (YN.equals("y")) {
                if (AlphabetList.RemoveAlphabet(Word)) {
                    playerNow.updateScore(Word.length());
                    Flag = 0;
                    playerNow.setPlayed(true);
                }
            } else {
                playerNow.setPlayed(false);
                System.out.println("");
                System.out.println("Both players have to agree, please enter your word again!");
            }
        } else {
            playerNow.setPlayed(false);
            System.out.println("YOU ENTERED A WORD THAT CONTAINS A LETTER THAT IS USED OR NOT VALID. PLEASE ENTER ANOTHER WORD!");
        }
    }

    public static void print(List< Character> alphabetList) {
        System.out.print("Alphabet letters left: ");
        for (int i = 0; i < alphabetList.size(); i++) {
            System.out.print(alphabetList.get(i) + " ");
        }
        System.out.println();
    }

    private static void score() {
        if (playerOne.getScore() > playerTwo.getScore()) {
            winner = playerOne;
        } else if (playerOne.getScore() < playerTwo.getScore()) {
            winner = playerTwo;
        } else {
            System.out.println("Same SCORE!!!");
            return;
        }
        System.out.println("WINNER OF THE GAME IS: " + winner.getName() + " with a score of: " + winner.getScore());
        System.out.println("YOUR NAME HAS BEEN SAVED TO THE HALL OF FAME!!!");
        System.out.println("THE GAME IS NOW OVER. THANK YOU FOR PLAYING WORD WARS!!!\n");
    }

    public static void NewGame() {
        System.out.println("Would like to play another game? (y / n)");
        NewGame = sc.next();
        if (!NewGame.equals("y")) {
            end = true;
            System.out.println("You exited the game!!!");
            System.exit(0);
        } else {
            Flag = 1;
            end = false;
        }
    }
}