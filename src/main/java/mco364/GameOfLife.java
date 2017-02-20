/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mco364;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 *
 * @author yrobi
 */
class MyThread extends Thread implements Runnable {

    private int row, count;
    static char[][] nextGen;

    MyThread(int row, char[][] nextGen) {
        this.row = row;
        this.nextGen = nextGen;

    }

    @Override
    public void run() {
        checkRow();
    }

    private void checkRow() {
        for (int i = 1; i < GameOfLife.thisGen.length - 2; i++) {
            count = GameOfLife.neighborCount(row, i);
            if (GameOfLife.isAliveNextGeneration(row, i, count)) {
                nextGen[row][i] = '\u2588';
            }
        }
    }
}

public class GameOfLife {

    ScheduledThreadPoolExecutor pool;

    static char[][] board1 = new char[27][27];
    static char[][] board2 = new char[27][27];
    static char[][] nextGen = board1;
    static char[][] thisGen = board2;

    static boolean isThisGen;
    int totalNeighbors;

    public static int neighborCount(int row, int col) {
        int counter = 0;

        if (thisGen[row - 1][col - 1] == '\u2588') {
            counter++;
        }

        if (thisGen[row - 1][col] == '\u2588') {
            counter++;
        }
        if (thisGen[row - 1][col + 1] == '\u2588') {
            counter++;
        }
        if (thisGen[row][col - 1] == '\u2588') {
            counter++;
        }
        if (thisGen[row][col + 1] == '\u2588') {
            counter++;
        }
        if (thisGen[row + 1][col - 1] == '\u2588') {
            counter++;
        }
        if (thisGen[row + 1][col] == '\u2588') {
            counter++;
        }
        if (thisGen[row + 1][col + 1] == '\u2588') {
            counter++;
        }

        return counter;
    }

    public static boolean isAliveNextGeneration(int row, int col, int neighborCount) {
        thisGen = isThisGen ? board1 : board2;

        if (thisGen[row][col] == '\u2588') {

            return neighborCount == 2 || neighborCount == 3;

        } else {
            return neighborCount == 3;

        }

    }

    public static void nextGen() {
        isThisGen = !isThisGen;
        nextGen = isThisGen ? board2 : board1;
        ScheduledThreadPoolExecutor pool;
        pool = new ScheduledThreadPoolExecutor(10);

        for (int i = 1; i < 27; i++) {
            pool.execute(new MyThread(i, nextGen));
        }

    }
}
