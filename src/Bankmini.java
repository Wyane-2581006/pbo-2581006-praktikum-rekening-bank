import jdk.swing.interop.SwingInterOpUtils;

import java.util.Scanner;

public class Bankmini {
    public static void main(String[] args) {

        Rekening rekening = new Rekening("0001", "Ani", 100000);

        Scanner input = new Scanner(System.in);
        int pilihan = -1;

        while (pilihan != 0) {
            System.out.println("\n======= BANK MINI =======");
            System.out.println("Nomor Rekening : " + rekening.getNomor());
            System.out.println("Pemilik        : " + rekening.getPemilik());
            System.out.println("---------------------------");
            System.out.println("1. Setor Uang");
            System.out.println("2. Tarik Uang");
            System.out.println("3. Informasi");
            System.out.println("0. Keluar");
            System.out.println("---------------------------");
            System.out.println("Pilih Menu: ");

            pilihan = input.nextInt();

            switch (pilihan) {

                case 1:
                    System.out.print("Masukkan Jumlah Setor: Rp");
                    int jumlahSetor = input.nextInt();

                    if (rekening.setor(jumlahSetor)) {
                        System.out.println("Setor BERHASIL!");
                    } else {
                        System.out.println("Setor GAGAL! Jumlah harus lebih dari 0.");
                    }
                    break;

                case 2:
                    System.out.print("Masukkan Jumlah Tarik: Rp");
                    int jumlahTarik = input.nextInt();

                    if (rekening.tarik(jumlahTarik)) {
                        System.out.println("Penarikan BERHASIL!");
                    } else {
                        System.out.println("Penarikan GAGAL! Periksa jumlah dan saldo anda");
                    }
                    break;

                case 3:
                    System.out.println("\n Informasi Rekening:");
                    rekening.cetakInfo();
                    break;

                case 0:
                    System.out.println("\nTerima kasih telah menggunakan Bank Mini!");
                    break;

                default:
                    System.out.println("PILIHAN TIDAK VALID!");
            }
        }
        System.out.println("\nInformasi Rekening Terakhir");
        rekening.cetakInfo();

        input.close();
    }
}
