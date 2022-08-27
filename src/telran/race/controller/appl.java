package telran.race.controller;

import telran.race.model.Tarakan;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class appl {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("print tarakan amount");
        int amount = Integer.parseInt(reader.readLine());
        Thread[] tarakans = new Thread[amount];
        System.out.println("enter distance");
        int distance = Integer.parseInt(reader.readLine());
        for (int i = 0; i < tarakans.length; i++) {
            tarakans[i] = new Thread(new Tarakan(distance));
        }
        Arrays.stream(tarakans).forEach(t -> t.start());
        int winner = -1;
        while (winner == -1){
            winner = checkState(tarakans);
        }
        System.out.println("“Congratulations to tarakan #" + winner + "(winner)");
    }
    private static int checkState(Thread[] tarakans){
        for (int i = 0; i < tarakans.length; i++) {
            if(!tarakans[i].isAlive())
                return i;
        }
        return -1;
    }
}
