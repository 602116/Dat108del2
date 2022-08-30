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

    Random random = ThreadLocalRandom.current();
    int randomNumber = random.nextInt();

    @Override
    public void run() {

        while (flag) {
            lagBurger();
        }

    }


    public void lagBurger() {

        synchronized (brett) {
            brett.notify();

            try {

                if (brett.brettMedBurger().size() == brett.getKap()) {
                    wait();
                }
                randomNumber = 2 + random.nextInt(4);
                Thread.sleep(randomNumber * 1000);

                Hamburger hamseburger = new Hamburger();
                hamseburger.setNummer(brett.getCounter());
                brett.brettMedBurger().add(hamseburger);
                System.out.println(navn + " (Kokk) legger på hamburger ◖" + brett.getCounter() + "◗. Brett: " + Arrays.toString(brett.brettMedBurger().toArray()));
                brett.setCounter(brett.getCounter() + 1);

            } catch (Exception e) {
            }

        }
    }
}

