package Dat108;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class Servitor extends Thread {

    private final HamburgerBrett brett;
    private final String navn;
    public boolean flag = true;


    Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        while (flag) {
            slett();
            try {
                Thread.sleep(ThreadLocalRandom.current().nextLong(2, 4) * 1000);
            } catch (InterruptedException e) {
            }
        }
    }


    public void slett() {

        synchronized (brett) {
            while (brett.brettMedBurger().size() == 0) {
                System.out.println("Brett tomt");
                try {
                    brett.wait();
                } catch (Exception e) {
                }
            }

            Hamburger ny = brett.brettMedBurger().remove();
            int hamNummer = ny.getNummer();
            System.out.println(navn + " (Servitør) tar av hamburger ◖" + hamNummer + "◗. Brett: "
                    + Arrays.toString(brett.brettMedBurger().toArray()));
            brett.notifyAll();


        }
    }
}

