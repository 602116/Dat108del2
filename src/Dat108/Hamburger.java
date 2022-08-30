package Dat108;

public class Hamburger {
    private int nummer = 0;

    public int getNummer() {
        return nummer;
    }

    public void setNummer(int nummer) {
        this.nummer = nummer;
    }

    public String toString() {
        return String.format("◖%d◗", nummer);
    }
}
