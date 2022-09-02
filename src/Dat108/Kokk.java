package Dat108;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread {

    private HamburgerBrett brett;
    private String navn;
    public boolean flag = true;

    Kokk(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }



    @Override
    public void run() {

        while (flag) {
            lagBurger();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2,6) * 1000);
            } catch (InterruptedException e) {
            }
        }

    }


    public void lagBurger() {

        synchronized (brett) {

            try {

                while (brett.brettMedBurger().size() == brett.getKap()) {
                    System.out.println("Brett er fullt, "+ navn +" (Kokk) venter på servitør!");
                    brett.wait();

                }



                Hamburger hamseburger = new Hamburger();
                hamseburger.setNummer(brett.getCounter());
                brett.brettMedBurger().add(hamseburger);
                System.out.println(navn + " (Kokk) legger på hamburger ◖" + brett.getCounter() + "◗. Brett: " + Arrays.toString(brett.brettMedBurger().toArray()));
                brett.setCounter(brett.getCounter() + 1);
                brett.notifyAll();

            } catch (Exception e) {
            }

        }
    }
}

