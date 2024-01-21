package latihan;
//import library
import java.io.IOException;
import java.util.Scanner;

// import CRUD Library
import latihan.CRUD.Operation;
import latihan.CRUD.Utils;

class Crud {
    public static void main(String[] args) throws IOException {

        try (Scanner terminalInput = new Scanner(System.in)) {
            String pilihanUser;
            boolean isLanjutkan = true;

            while (isLanjutkan) {
                Utils.clearScreen();
                System.out.println("Database Perpustakaan\n");
                System.out.println("1.\tLihat seluruh buku");
                System.out.println("2.\tCari data buku");
                System.out.println("3.\tTambah data buku");
                System.out.println("4.\tUbah data buku");
                System.out.println("5.\tHapus data buku");

                System.out.print("\n\nPilihan anda: ");
                pilihanUser = terminalInput.next();

                switch (pilihanUser) {
                    case "1":
                        System.out.println("\n=================");
                        System.out.println("LIST SELURUH BUKU");
                        System.out.println("=================");
                        Operation.tampilkanData();
                        break;
                    case "2":
                        System.out.println("\n=========");
                        System.out.println("CARI BUKU");
                        System.out.println("=========");
                        Operation.cariData();
                        // cari data
                        break;
                    case "3":
                        System.out.println("\n================");
                        System.out.println("TAMBAH DATA BUKU");
                        System.out.println("================");
                        // tambah data
                        Operation.tambahData();
                        break;
                    case "4":
                        System.out.println("\n==============");
                        System.out.println("UBAH DATA BUKU");
                        System.out.println("==============");
                        // ubah data
                        Operation.updateData();
                        break;
                    case "5":
                        System.out.println("\n===============");
                        System.out.println("HAPUS DATA BUKU");
                        System.out.println("===============");
                        // hapus data
                        Operation.hapusData();
                        break;
                    default:
                        System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-5]");
                }

                isLanjutkan = Utils.getYesorNo("Apakah Anda ingin melanjutkan");
            }
        }
    }

  
 
}