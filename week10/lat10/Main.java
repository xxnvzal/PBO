package lat10;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("======Pilih Bangun Datar=====");
            System.out.println("1. Persegi \n2. Lingkaran \n3. Segitiga \n4. Exit");
            System.out.print("Masukkan Pilihan : ");
            int pilihan = scanner.nextInt();

            switch (pilihan) {
                case 1:
                    System.out.print("Masukkan sisi persegi: ");
                    int sisi = scanner.nextInt();
                    Persegi persegi = new Persegi(sisi);
                    persegi.luas();
                    persegi.keliling();
                    System.out.println("=============================");
                    break;

                case 2:
                    System.out.print("Masukkan radius lingkaran: ");
                    int radius = scanner.nextInt();
                    Lingkaran lingkaran = new Lingkaran(radius);
                    lingkaran.luas();
                    lingkaran.keliling();
                    System.out.printf("Luas Lingkaran: %.2f%n", lingkaran.luas());
                    System.out.printf("Keliling Lingkaran: %.2f%n", lingkaran.keliling());
                    System.out.println("=============================");
                    break;

                case 3:
                    System.out.print("Masukkan alas segitiga: ");
                    int alas = scanner.nextInt();
                    System.out.print("Masukkan tinggi segitiga: ");
                    int tinggi = scanner.nextInt();
                    Segitiga segitiga = new Segitiga(alas, tinggi);
                    segitiga.luas();
                    segitiga.keliling();
                    System.out.println("=============================");
                    break;

                case 4:
                    running = false;
                    System.out.println("Terima kasih telah menggunakan program ini.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid.");
            }
        }

        scanner.close();
    }
}