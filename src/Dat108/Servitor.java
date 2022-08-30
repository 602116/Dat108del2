package Dat108;

import java.util.Arrays;

public class Servitor extends Thread {

    private HamburgerBrett brett;
    private String navn;
    public boolean flag = true;


    Servitor(HamburgerBrett brett, String navn) {
        this.brett = brett;
        this.navn = navn;
    }

    @Override
    public void run() {
        while (flag) {
            System.out.println(navn + " (Servitør) tar av hamburger ◖" + slett() + "◗. Brett: "
                    + Arrays.toString(brett.brettMedBurger().toArray()));
        }
    }


    public int slett() {

        synchronized (brett) {
            brett.notify();
            if (brett.brettMedBurger().size() == 0) {
                System.out.println("Brett tomt");
                try {
                    wait();
                } catch (Exception e) {
                }
            }
            Hamburger ny = brett.brettMedBurger().remove();
            int hamNummer = ny.getNummer();
            return hamNummer;

        }
    }
}

