package Dat108;

import java.util.Arrays;

public class Main extends Thread {

    public static void main(String[] args) {

        final String[] kokker = {"Anne", "Erik", "Knut"};
        final String[] servitorer = {"Mia", "Per"};
        final int KAPASITET = 4;

        skrivUtHeader(kokker, servitorer, KAPASITET);

        HamburgerBrett brett = new HamburgerBrett(KAPASITET);

        for (String navn : kokker) {

            new Kokk(brett, navn).start();

        }

        for (String navn : servitorer) {

            new Servitor(brett, navn).start();

        }
    }

    public static void skrivUtHeader(String[] kokker, String[] servitorer, int kapasitet) {
        System.out.println("I denne simuleringen har vi");
        System.out.println(kokker.length + " Kokker " + Arrays.toString(kokker));
        System.out.println(servitorer.length + " Servitører " + Arrays.toString(servitorer));
        System.out.println("Kapasitetet til brettet er " + kapasitet + " hamburgere");
        System.out.println("Vi starter....");
    }
}
