package mco364;

import java.util.ArrayList;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class MyThread extends Thread {

    MyThread() {
        BlockingQueue<Runnable> que = (BlockingQueue) new ArrayList<>();
        ThreadPoolExecutor execute = new ThreadPoolExecutor(10, 10, 10000, TimeUnit.MILLISECONDS, que);
    }
    
    @Override
    public void run(){
        
        
        
    }
    
    
    
    
}

public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int[][] board = new int[100][100];

        clearConsole();

        for (int i = 0; i < 10; i++) {
            System.out.println(i);

            sleep(500);
            clearConsole();
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
}
