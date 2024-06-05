package lat10;

public class PersegiPanjang {
    private int panjang;
    private int lebar;

    public PersegiPanjang(int panjang, int lebar) {
        this.panjang = panjang;
        this.lebar = lebar;
    }

    public void luas(){
        System.out.println("Luas PersegiPanjang dg panjang " +panjang+" dan lebar "+lebar+" adalah "+panjang*lebar);
    }

    public void keliling(){
        System.out.println("Keliling PersegiPanjang dg panjang " +panjang+" dan lebar "+lebar+" adalah "+2*(panjang + lebar));
    }

    public int getPanjang(){
        return panjang;
    }

    public int getLebar(){
        return lebar;
    }

}