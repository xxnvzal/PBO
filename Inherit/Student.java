package Inherit;
import java.util.Scanner;

public class Student extends Person{
	String nim;
	private double spp;
	private double sks;
	private double modul;

	public Student() {
		Scanner x = new Scanner(System.in);
		
		try {
			System.out.println("Masukkan nama:");
			super.name = x.next();
			
			System.out.println("Masukkan alamat:");
			super.address = x.next();
			
			System.out.println("Masukkan NIM:");
			this.nim = x.next();

            System.out.println("Hobi:");
			this.hobi = x.next();

			System.out.println("SPP:");
			this.spp = x.nextDouble();

			System.out.println("Jumlah SKS:");
			this.sks = x.nextDouble();

			System.out.println("Jumlah Modul:");
			this.modul = x.nextDouble();
		
		} finally {
			x.close();
		}
	}
	
	public String getNim() {
		return nim;
	}

	public double hitungPembayaran() {
		return this.spp + this.sks + this.modul;
	}
	
	@Override
	public void identity()
	{
        System.out.println("=======================");
		super.identity();
        System.out.println("NIM: "+getNim());
		System.out.println("Total pembayaran: "+hitungPembayaran());
		
	}
		
}