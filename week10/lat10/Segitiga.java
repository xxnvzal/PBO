package lat10;

public class Segitiga extends BangunDatar {
    private int alas;
    private int tinggi;

    public Segitiga(int alas,int tinggi){
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public void luas(){
        System.out.println("Luas segitiga dg alas " +alas+" dan tinggi "+tinggi+" adalah "+(alas*tinggi)/2);
    }

    public void keliling(){
        double miring = Math.sqrt(alas * alas + tinggi * tinggi);
        double k = alas + tinggi + miring;
        System.out.printf("Keliling Segitiga adalah %.2f%n", k);
    }

    public int getTinggi(){
        return tinggi;
    }

    public int getAlas(){
        return alas;
    }
}