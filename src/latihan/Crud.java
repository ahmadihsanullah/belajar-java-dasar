package latihan;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.Year;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

class Crud {
    public static void main(String[] args) throws IOException {

        try (Scanner terminalInput = new Scanner(System.in)) {
            String pilihanUser;
            boolean isLanjutkan = true;

            while (isLanjutkan) {
                clearScreen();
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
                        tampilkanData();
                        break;
                    case "2":
                        System.out.println("\n=========");
                        System.out.println("CARI BUKU");
                        System.out.println("=========");
                        cariData();
                        // cari data
                        break;
                    case "3":
                        System.out.println("\n================");
                        System.out.println("TAMBAH DATA BUKU");
                        System.out.println("================");
                        // tambah data
                        tambahData();
                        break;
                    case "4":
                        System.out.println("\n==============");
                        System.out.println("UBAH DATA BUKU");
                        System.out.println("==============");
                        // ubah data
                        break;
                    case "5":
                        System.out.println("\n===============");
                        System.out.println("HAPUS DATA BUKU");
                        System.out.println("===============");
                        // hapus data
                        break;
                    default:
                        System.err.println("\nInput anda tidak ditemukan\nSilahkan pilih [1-5]");
                }

                isLanjutkan = getYesorNo("Apakah Anda ingin melanjutkan");
            }
        }
    }

    private static void tampilkanData() throws IOException {
        FileReader fileInput;
        BufferedReader bufferedReader;

        try {
            fileInput = new FileReader("database.txt");
            bufferedReader = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("Database tidak ditemukan");
            System.err.println("Silahkan tambahkan database terlebih dahulu");
            return;
        }

        System.out.println("\n| No |\tTahun |\tPenulis                |\tPenerbit               |\tJudul Buku");
        System.out.println(
                "----------------------------------------------------------------------------------------------------------");

        String data = bufferedReader.readLine();
        int nomorData = 0;

        while (data != null) {
            StringTokenizer stringToken = new StringTokenizer(data, ",");
            nomorData++;
            stringToken.nextToken();
            System.out.printf("| %2d ", nomorData);
            System.out.printf("|\t%4s  ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%-20s   ", stringToken.nextToken());
            System.out.printf("|\t%s   ", stringToken.nextToken());
            System.out.print("\n");
            data = bufferedReader.readLine();
        }

        System.out.println(
                "----------------------------------------------------------------------------------------------------------");

    }

    private static void cariData() throws IOException {

        // membaca database ada
        try {
            File file = new File("database.txt");
        } catch (Exception e) {
            System.err.println("Database tidak ditemukan");
            System.err.println("Silahkan tambahkan database terlebih dahulu");
            return;
        }
        // kita ambil keyword dari user

        Scanner terminalInput = new Scanner(System.in);
        System.err.print("Masukan kata kunci untuk mencari buku: ");
        String cariString = terminalInput.nextLine();
        String[] keywords = cariString.split("\\s+");

        // kita cek keyword di database
        cekBukuDiDatabase(keywords, true);
    }

    private static void tambahData() throws IOException {

        FileWriter fileOutput = new FileWriter("Database.txt");
        BufferedWriter bufferedWriter = new BufferedWriter(fileOutput);

        // mengambil input dari user
        Scanner terminalInput = new Scanner(System.in);
        String penulis, judul, penerbit, tahun;

        System.out.print("Masukan nama penulis: ");
        penulis = terminalInput.nextLine();
        System.out.print("Masukan nama judul: ");
        judul = terminalInput.nextLine();
        System.out.print("Masukan nama penerbit: ");
        penerbit = terminalInput.nextLine();
        System.out.print("Masukan nama tahun terbit: ");
        tahun = terminalInput.nextLine();

        // cek buku didatabase
        String[] keywords = {tahun+","+penulis+","+penerbit+","+judul};
        System.out.println(Arrays.toString(keywords));

        boolean isExist = cekBukuDiDatabase(keywords, false);

        // menulis buku didatabase

        if(!isExist){
            // fiersabesari_2012_1,2012,fiersa besari,media kita,jejak langkah
            System.out.println("bukunya benlum ada");
        }

        // masukan buku ke database

    }

    private static String ambilTahun() throws IOException {
        boolean tahunValid = false;
        Scanner terminalInput = new Scanner(System.in);
        String tahunInput = terminalInput.nextLine();

        while (!tahunValid) {
            try {
            Year.parse(tahunInput);
            tahunValid = true;
            } catch (Exception e) {
                System.out.println("Format tahun yang anda masukan salah, format=(YYYY)");
                System.out.print("silahkan masukan tahun terbit lagi: ");
                tahunValid = false;
                tahunInput = terminalInput.nextLine();
            }
        }
    
        return tahunInput;
    }

    private static boolean cekBukuDiDatabase(String[] keywords, boolean isDisplay) throws IOException {

        FileReader fileInput = new FileReader("database.txt");
        BufferedReader bufferInput = new BufferedReader(fileInput);

        String data = bufferInput.readLine();
        boolean isExist = false;
        int nomorData = 0;

        if (isDisplay) {
            System.out.println("\n| No |\tTahun |\tPenulis                |\tPenerbit               |\tJudul Buku");
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }

        while(data != null){

            // cek keywords didalam baris
            isExist = true;

            for(String keyword:keywords){
                isExist = isExist && data.toLowerCase().contains(keyword.toLowerCase());
            }

            // jika keywordsnya cocok maka tampilkan

            if(isExist){
                if(isDisplay) {
                    nomorData++;
                    StringTokenizer stringToken = new StringTokenizer(data, ",");

                    stringToken.nextToken();
                    System.out.printf("| %2d ", nomorData);
                    System.out.printf("|\t%4s  ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%-20s   ", stringToken.nextToken());
                    System.out.printf("|\t%s   ", stringToken.nextToken());
                    System.out.print("\n");
                } else {
                    break;
                }
            }

            data = bufferInput.readLine();
        }

        if (isDisplay){
            System.out.println("----------------------------------------------------------------------------------------------------------");
        }

        return isExist;
    }

    private static boolean getYesorNo(String message) {
        Scanner terminalInput = new Scanner(System.in);
        System.out.print("\n" + message + " (y/n)? ");
        String pilihanUser = terminalInput.next();

        while (!pilihanUser.equalsIgnoreCase("y") && !pilihanUser.equalsIgnoreCase("n")) {
            System.err.println("Pilihan anda bukan y atau n");
            System.out.print("\n" + message + " (y/n)? ");
            pilihanUser = terminalInput.next();
        }

        return pilihanUser.equalsIgnoreCase("y");

    }

    private static void clearScreen() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                System.out.print("\033\143");
            }
        } catch (Exception ex) {
            System.err.println("tidak bisa clear screen");
        }
    }
}