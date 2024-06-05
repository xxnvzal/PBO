package lat10;

public class Persegi extends BangunDatar{
    private int sisi;

    public Persegi(int sisi){
        this.sisi = sisi;
    }

    public void luas(){
        System.out.println("Luas Persegi dg sisi " +sisi+" adalah " +sisi*sisi);
    }

    public void keliling(){
        System.out.println("Keliling Persegi dg sisi " +sisi+" adalah " +4*sisi);
    }
    
    public int getSisi(){
        return sisi;
    }
}