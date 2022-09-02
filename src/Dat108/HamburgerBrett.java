package Dat108;

import java.util.LinkedList;
import java.util.Queue;

public class HamburgerBrett {

    private int counter = 1;
    private final int kap;

    public HamburgerBrett(int kap) {
        this.kap = kap;
    }

    private final Queue<Hamburger> ko = new LinkedList<>();

    public Queue<Hamburger> brettMedBurger() {
        return ko;
    }

    public int getKap() {
        return kap;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counteren) {
        counter = counteren;
    }


}
