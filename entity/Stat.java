package entity;

import java.util.Random;

public class Stat {
    Random rand = new Random();

    String name;
    int value;
    int growth;

    public Stat(String name, int value, int growth) {
        this.name = name;
        this.value = value;
        this.growth = growth;
    }

    void calcStatGain() {
        int randomNum = rand.nextInt(100) + 1;
        int gained = 0;

        if (growth > randomNum) {
            value++;
            gained = 1;
        }

        if (gained == 1) {
            System.out.println("Gained " + name + ". Value is now " + value);
        }
    }

    public String getName() {
        return name;
    }

    public int getValue() {
        return value;
    }

    public int getGrowth() {
        return growth;
    }

    @Override
    public String toString() {
        return name + ": " + value + "growth: " + growth;
    }
}
