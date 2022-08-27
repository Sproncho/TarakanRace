package telran.race.model;

import java.util.List;
import java.util.Random;

public class Tarakan implements Runnable{
    int distance;

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public Tarakan(int distance) {
        this.distance = distance;

    }

    @Override
    public void run() {
        int sleep = new Random().nextInt(distance - 2 + 1) + 2;
        for (int i = 0; i < distance; i++) {
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
