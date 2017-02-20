package mco364;

import static java.lang.Thread.sleep;
import java.util.Scanner;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        System.out.println("Please choose a pattern.");
        System.out.println("Press: ");
        System.out.println("1: Blinker");
        System.out.println("2: Toad");
        System.out.println("3: Beacon");
        System.out.println("4: Pulsar");
        System.out.println("5: Pentadecathlon");

        Scanner scan = new Scanner(System.in);
        choose(scan.nextInt());
        System.out.println("Press 'A' for automatic,");
        System.out.println("or 'M' for manual");
        String choice = scan.next();
        
        while (true) {
            printBoard();
            GameOfLife.nextGen();
            if(choice.toUpperCase().equals("A")){
                scan.next();
            }
            sleep(500);
            clearConsole();

        }
    }

    public static void printBoard() {

        for (int i = 0; i < GameOfLife.thisGen.length-2; i++) {
            for (int j = 0; j < GameOfLife.thisGen.length-2; j++) {
                System.out.print(GameOfLife.thisGen[i][j]);
            }
            System.out.println("");
        }

    }

    public final static void clearConsole() {
        for (int i = 0; i < 100; i++) { // safety net since next code only works on console not Netbeans output
            System.out.println();
        }
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {
                Runtime.getRuntime().exec("cls");
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                Runtime.getRuntime().exec("clear");
            }
        } catch (final Exception e) {
            //  Handle any exceptions.
        }
    }

    private static void sleep(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException ex) {
// ignore
        }
    }

    public static void choose(int i) {

        if (i == 1) {
            blinker();
        }

        if (i == 2) {
            toad();
        }

        if (i == 3) {
            beacon();
        }

        if (i == 4) {
            pulsar();
        }

        if (i == 5) {
            pentadecathlon();
        }

    }

    public static void blinker() {

        GameOfLife.thisGen[12][11] = '\u2588';
        GameOfLife.thisGen[12][12] = '\u2588';
        GameOfLife.thisGen[12][13] = '\u2588';

    }

    public static void toad() {
        GameOfLife.thisGen[12][12] = '\u2588';
        GameOfLife.thisGen[12][13] = '\u2588';
        GameOfLife.thisGen[12][14] = '\u2588';
        GameOfLife.thisGen[13][11] = '\u2588';
        GameOfLife.thisGen[13][12] = '\u2588';
        GameOfLife.thisGen[13][13] = '\u2588';

    }

    public static void beacon() {
        GameOfLife.thisGen[10][10] = '\u2588';
        GameOfLife.thisGen[10][11] = '\u2588';
        GameOfLife.thisGen[11][10] = '\u2588';
        GameOfLife.thisGen[11][11] = '\u2588';
        GameOfLife.thisGen[12][12] = '\u2588';
        GameOfLife.thisGen[12][13] = '\u2588';
        GameOfLife.thisGen[13][12] = '\u2588';
        GameOfLife.thisGen[13][13] = '\u2588';
    }

    public static void pulsar() {
        //Top Left
        GameOfLife.thisGen[7][9] = '\u2588';
        GameOfLife.thisGen[7][10] = '\u2588';
        GameOfLife.thisGen[7][11] = '\u2588';
        GameOfLife.thisGen[9][7] = '\u2588';
        GameOfLife.thisGen[10][7] = '\u2588';
        GameOfLife.thisGen[11][7] = '\u2588';
        GameOfLife.thisGen[12][9] = '\u2588';
        GameOfLife.thisGen[12][10] = '\u2588';
        GameOfLife.thisGen[12][11] = '\u2588';
        GameOfLife.thisGen[9][12] = '\u2588';
        GameOfLife.thisGen[10][12] = '\u2588';
        GameOfLife.thisGen[11][12] = '\u2588';

        //Bottom Left
        GameOfLife.thisGen[14][9] = '\u2588';
        GameOfLife.thisGen[14][10] = '\u2588';
        GameOfLife.thisGen[14][11] = '\u2588';
        GameOfLife.thisGen[15][7] = '\u2588';
        GameOfLife.thisGen[16][7] = '\u2588';
        GameOfLife.thisGen[17][7] = '\u2588';
        GameOfLife.thisGen[19][9] = '\u2588';
        GameOfLife.thisGen[19][10] = '\u2588';
        GameOfLife.thisGen[19][11] = '\u2588';
        GameOfLife.thisGen[15][12] = '\u2588';
        GameOfLife.thisGen[16][12] = '\u2588';
        GameOfLife.thisGen[17][12] = '\u2588';

        //Top Right
        GameOfLife.thisGen[7][15] = '\u2588';
        GameOfLife.thisGen[7][16] = '\u2588';
        GameOfLife.thisGen[7][17] = '\u2588';
        GameOfLife.thisGen[9][14] = '\u2588';
        GameOfLife.thisGen[10][14] = '\u2588';
        GameOfLife.thisGen[12][15] = '\u2588';
        GameOfLife.thisGen[12][16] = '\u2588';
        GameOfLife.thisGen[12][17] = '\u2588';
        GameOfLife.thisGen[9][19] = '\u2588';
        GameOfLife.thisGen[10][19] = '\u2588';
        GameOfLife.thisGen[11][19] = '\u2588';

        //Bottom Right
        GameOfLife.thisGen[14][15] = '\u2588';
        GameOfLife.thisGen[14][16] = '\u2588';
        GameOfLife.thisGen[14][17] = '\u2588';
        GameOfLife.thisGen[15][14] = '\u2588';
        GameOfLife.thisGen[16][14] = '\u2588';
        GameOfLife.thisGen[17][14] = '\u2588';
        GameOfLife.thisGen[19][15] = '\u2588';
        GameOfLife.thisGen[19][16] = '\u2588';
        GameOfLife.thisGen[19][17] = '\u2588';
        GameOfLife.thisGen[15][19] = '\u2588';
        GameOfLife.thisGen[16][19] = '\u2588';
        GameOfLife.thisGen[17][19] = '\u2588';

    }

    public static void pentadecathlon() {
        GameOfLife.thisGen[11][10] = '\u2588';
        GameOfLife.thisGen[11][15] = '\u2588';
        GameOfLife.thisGen[12][8] = '\u2588';
        GameOfLife.thisGen[12][9] = '\u2588';
        GameOfLife.thisGen[12][11] = '\u2588';
        GameOfLife.thisGen[12][12] = '\u2588';
        GameOfLife.thisGen[12][13] = '\u2588';
        GameOfLife.thisGen[12][14] = '\u2588';
        GameOfLife.thisGen[12][16] = '\u2588';
        GameOfLife.thisGen[12][17] = '\u2588';
        GameOfLife.thisGen[13][10] = '\u2588';
        GameOfLife.thisGen[13][15] = '\u2588';
    }

}
