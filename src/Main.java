import java.util.*;

public class Main {
    public static void main(String[] args) {
        String answ;
        System.out.println("-----------------------------");
        System.out.println("TIC TAC TOE");
        System.out.println("-----------------------------");
        System.out.println();
        System.out.println("player 1: 'X'");
        System.out.println("player 2: 'O'");
        System.out.println("*to insert 'X' or 'O': enter row and column*\n");

        // scanner class
        Scanner scanner = new Scanner(System.in);
        do{
            // 2d array to represent the board
            char[][] board = {
                    {'_', '_', '_'},
                    {'_', '_', '_'},
                    {'_', '_', '_'}
            };

            // player
            char player = 'X';
            int p = 1;

            // scanner input
            boolean check = false;
            int count = 0;
            boolean taken = false;
            while (!check) {
                boolean success = false;
                if (count == 9) {
                    System.out.println("it's a tie!");
                    break;
                }
                while (!success) {
                    try {
                        System.out.println("player " + p + ": enter your move (row and column):");
                        int rows = scanner.nextInt();
                        int columns = scanner.nextInt();
                        if ((board[rows - 1][columns - 1] != 'X') && (board[rows - 1][columns - 1] != 'O')) {
                            board[rows - 1][columns - 1] = player;
                            count++;
                            success = true;
                        } else {
                            System.out.println("\nposition row: " + rows + ", column: " + columns + " already taken!\n");
                        }

                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("\nenter valid row and column!\n");
                    } catch (InputMismatchException e) {
                        System.out.println("\nenter valid row and column!\n");
                        scanner.reset();
                        scanner.next();
                    }

                }
                updateGameBoard(board);
                player = changePlayer(player);
                if (p == 1) {
                    p = 2;
                } else {
                    p = 1;
                }

                // player 1 (X) win conditions
                if (XCheckRows0(board) || XCheckRows1(board) || XCheckRows2(board)) {
                    System.out.println("PLAYER 1 WON!");
                    check = true;
                }
                if (XCheckColumns0(board) || XCheckColumns1(board) || XCheckColumns2(board)) {
                    System.out.println("PLAYER 1 WON!");
                    check = true;
                }
                if (XCheckDiagLR(board) || XCheckDiagRL(board)) {
                    System.out.println("PLAYER 1 WON!");
                    check = true;
                }

                // player 2 (O) win conditions
                if (OCheckRows0(board) || OCheckRows1(board) || OCheckRows2(board)) {
                    System.out.println("PLAYER 2 WON!");
                    check = true;
                }
                if (OCheckColumns0(board) || OCheckColumns1(board) || OCheckColumns2(board)) {
                    System.out.println("PLAYER 2 WON!");
                    check = true;
                }
                if (OCheckDiagLR(board) || OCheckDiagRL(board)) {
                    System.out.println("PLAYER 2 WON!");
                    check = true;
                }
            }
            System.out.println("do you want to play again? (Y/N):");
            answ = scanner.next();
            System.out.println();

        } while (answ.equals("Y") || answ.equals("y"));
            System.out.println("thanks for playing ;)");
            scanner.close();
    }
    static void updateGameBoard(char[][] board){
        for (int z = 0; z < 52; z++) {
            System.out.println();
        }
        for (int i = 0; i < board.length; i++) {
            System.out.println("-------------");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print('|');
                System.out.print(' ');
                System.out.print(board[i][j]);
                System.out.print(' ');
                if(j == board.length-1){
                    System.out.print('|');
                }
            }
            System.out.println();
        }
        System.out.println("-------------\n");
    }
    static char changePlayer(char player){
        if (player == 'X') {
            player = 'O';

        }
        else {
            player = 'X';

        }
        return player;
    }

    // player 1 (X) wind conditions
    static boolean XCheckRows0(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && i == 0) check++;
            }
        }
        return check == 3;
    }
    static boolean XCheckRows1(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && i == 1) check++;
            }
        }
        return check == 3;
    }
    static boolean XCheckRows2(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && i == 2) check++;
            }
        }
        return check == 3;
    }
    static boolean XCheckColumns0(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && j == 0) check++;
            }
        }
        return check == 3;
    }
    static boolean XCheckColumns1(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && j == 1) check++;
            }
        }
        return check == 3;
    }
    static boolean XCheckColumns2(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && j == 2) check++;
            }
        }
        return check == 3;
    }
    static boolean XCheckDiagLR(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && j == i) check++;
            }
        }
        return check == 3;
    }
    static boolean XCheckDiagRL(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'X' && ((j == 1 && i == 1) || (i == 2 && j == 0) || (j == 2 && i == 0))) check++;
            }
        }
        return check == 3;
    }

    // player 2 (O) win conditions
    static boolean OCheckRows0(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && i == 0) check++;
            }
        }
        return check == 3;
    }
    static boolean OCheckRows1(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && i == 1) check++;
            }
        }
        return check == 3;
    }
    static boolean OCheckRows2(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && i == 2) check++;
            }
        }
        return check == 3;
    }
    static boolean OCheckColumns0(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && j == 0) check++;
            }
        }
        return check == 3;
    }
    static boolean OCheckColumns1(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && j == 1) check++;
            }
        }
        return check == 3;
    }
    static boolean OCheckColumns2(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && j == 2) check++;
            }
        }
        return check == 3;
    }
    static boolean OCheckDiagLR(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && j == i) check++;
            }
        }
        return check == 3;
    }
    static boolean OCheckDiagRL(char[][] board){
        int check = 0;
        for(int i=0; i<board.length; i++){
            for (int j=0; j<board[i].length; j++){
                if(board[i][j] == 'O' && ((j == 1 && i == 1) || (i == 2 && j == 0) || (j == 2 && i == 0))) check++;
            }
        }
        return check == 3;
    }

}