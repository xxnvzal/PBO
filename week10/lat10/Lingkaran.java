package lat10;

public class Lingkaran{
    private int radius;
    private static final float pi = 3.14f;

    public Lingkaran (int radius){
        this.radius = radius;
    }

    public double luas(){
        return radius*radius*pi;
    }

    public double keliling() {
        return 2*pi*radius;
    }

    public int getRadius(){
        return radius;
    }
}