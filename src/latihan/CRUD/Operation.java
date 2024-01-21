package latihan.CRUD;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Operation {
    public static void updateData() throws IOException {
        //kita ambil database original 
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput); 

        //kita buat database sementara
        File tempDB = new File("tempDB.txt");
        FileWriter fileOtput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOtput);

        //tampilkan data
        System.out.println("List Buku");
        tampilkanData();

        //ambil user input
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("Masukan no buku yang ingin diupdate : ");
        int updateNum = terminalInput.nextInt();

        //tampilkan data yang ingin diupdate
        String data = bufferedInput.readLine();
        int entryCounts = 0;

        while(data!=null){
            entryCounts++;

            StringTokenizer st = new StringTokenizer(data,",");

            if(updateNum == entryCounts){
                System.out.println("\nData yang ingin anda update adalah:");
                System.out.println("---------------------------------------");
                System.out.println("Referensi           : " + st.nextToken());
                System.out.println("Tahun               : " + st.nextToken());
                System.out.println("Penulis             : " + st.nextToken());
                System.out.println("Penerbit            : " + st.nextToken());
                System.out.println("Judul               : " + st.nextToken());

                //update - ngambil data dari input user
                String[] fields = {"tahun","penulis","penerbit","judul"};
                String[] tempData = new String[4];

                st = new StringTokenizer(data,",");
                String originalData = st.nextToken();

                for(int i = 0; i < fields.length; i++){
                    boolean isUpdate = Utils.getYesorNo("apakah anda ingin merubah " + fields[i]);
                    originalData = st.nextToken();
                    if(isUpdate){
                        //user input 
                        if(fields[i].equalsIgnoreCase("tahun")){
                            System.out.print("masukan tahun terbit, format=(YYYY): ");
                            tempData[i] =  Utils.ambilTahun();
                        }else{
                            terminalInput = new Scanner(System.in);
                            System.out.println(("\nMasukan " + fields[i] + " baru : "));
                            tempData[i] = terminalInput.nextLine();
                        }
                    }else{
                        tempData[i] = originalData;
                    }                    
                }

                // tampilkan data baru ke layar
                st = new StringTokenizer(data,",");
                st.nextToken();
                System.out.println("\nData baru anda adalah ");
                System.out.println("---------------------------------------");
                System.out.println("Tahun               : " + st.nextToken() + " --> " + tempData[0]);
                System.out.println("Penulis             : " + st.nextToken() + " --> " + tempData[1]);
                System.out.println("Penerbit            : " + st.nextToken() + " --> " + tempData[2]);
                System.out.println("Judul               : " + st.nextToken() + " --> " + tempData[3]);

                boolean isUpdate =  Utils.getYesorNo("apakah anda yakin ingin mengupdate data tersebut");

                if(isUpdate){
                    // cek data baru di database
                    boolean isExist =  Utils.cekBukuDiDatabase(tempData,false);
                    if(isExist){
                        System.err.println("data buku sudah ada di database, proses update dibatalkan, \nsilahkan delete data yang bersangkutan");
                        // copy data
                        bufferedOutput.write(data);

                    } else {

                        // format data baru kedalam database
                        String tahun = tempData[0];
                        String penulis = tempData[1];
                        String penerbit = tempData[2];
                        String judul = tempData[3];

                        // kita bikin primary key
                        long nomorEntry =  Utils.ambilEntryPerTahun(penulis, tahun) + 1;

                        String punulisTanpaSpasi = penulis.replaceAll("\\s+","");
                        String primaryKey = punulisTanpaSpasi+"_"+tahun+"_"+nomorEntry;

                        // tulis data ke database
                        bufferedOutput.write(primaryKey + "," + tahun + ","+ penulis +"," + penerbit + ","+judul);
                    }
                }else{
                    // copy data
                    bufferedOutput.write(data);
                }
            }else{
                 // copy data
                 bufferedOutput.write(data);
            }
            bufferedOutput.newLine();

            //baca data lagi
            data = bufferedInput.readLine();
        }
        // menulis data ke file
        bufferedOutput.flush();

        // delete original database
        database.delete();
        // rename file tempDB menjadi database
        tempDB.renameTo(database);
    }

    public static void hapusData() throws IOException {
        //membaca database original
        File database = new File("database.txt");
        FileReader fileInput = new FileReader(database);
        BufferedReader bufferedInput = new BufferedReader(fileInput);

        //membuat database temporary
        File tempDB = new File("tempDB.txt");
        FileWriter fileOutput = new FileWriter(tempDB);
        BufferedWriter bufferedOutput = new BufferedWriter(fileOutput);

        //tampilkan data
        System.out.println("List Buku");
        tampilkanData();

        //kita ambil user input berupa data yang ingin dihapus
        Scanner terminalInput = new Scanner(System.in);
        System.out.println("\nMasukan no buku yang akan dihapus: ");
        int deleteNumber = terminalInput.nextInt();

        //looping tiap data untuk membaca tiap baris dan skip data yang didelete
        boolean isFound = false;
        int entryCounts = 0;

        String data = bufferedInput.readLine();

        while(data!=null){
            entryCounts++;
            boolean isDelete = false;

            StringTokenizer st = new StringTokenizer(data,",");
            
            if(deleteNumber == entryCounts){
                System.out.println("\nData yang ingin anda hapus");
                System.out.println("-----------------------");
                System.out.println("Referensi       : "+ st.nextToken());
                System.out.println("Tahun           : "+ st.nextToken());
                System.out.println("Penulis         : "+ st.nextToken());
                System.out.println("Penerbit        : "+ st.nextToken());
                System.out.println("Judul           : "+ st.nextToken());

                isDelete =  Utils.getYesorNo("Apakah anda yakin akan menghapus?");
                isFound = true;
            }

            if(isDelete){
                //skip pindahkan data dari original ke sementara
                System.out.println("Data berhasil dihapus");
            }else{
                //kita pindahkan ke temporary, skip yang dia pilih
                bufferedOutput.write(data);
                bufferedOutput.newLine();
            }
            data = bufferedInput.readLine();
        }
        if(!isFound){
            System.out.println("Buku tidak ditemukan");
        }

        //menulis ke database temporary
        bufferedOutput.flush();
        //delete database original
        database.delete();
        //rename database temporary ke original
        tempDB.renameTo(database);
    }

    public static void tampilkanData() throws IOException {
        FileReader fileInput;
        BufferedReader bufferedReader;

        try {
            fileInput = new FileReader("database.txt");
            bufferedReader = new BufferedReader(fileInput);
        } catch (Exception e) {
            System.err.println("Database tidak ditemukan");
            System.err.println("Silahkan tambahkan database terlebih dahulu");
            tambahData();
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

    public static void cariData() throws IOException {

        // membaca database ada
        try {
            File file = new File("database.txt");
        } catch (Exception e) {
            System.err.println("Database tidak ditemukan");
            System.err.println("Silahkan tambahkan database terlebih dahulu");
            tambahData();
            return;
        }
        // kita ambil keyword dari user

        Scanner terminalInput = new Scanner(System.in);
        System.err.print("Masukan kata kunci untuk mencari buku: ");
        String cariString = terminalInput.nextLine();
        String[] keywords = cariString.split("\\s+");

        // kita cek keyword di database
        Utils.cekBukuDiDatabase(keywords, true);
    }

    public static void tambahData() throws IOException {

        FileWriter fileOutput = new FileWriter("Database.txt", true);
        BufferedWriter bufferOutput = new BufferedWriter(fileOutput);

        // mengambil input dari user
        Scanner terminalInput = new Scanner(System.in);
        String penulis, judul, penerbit, tahun;

        System.out.print("Masukan nama penulis: ");
        penulis = terminalInput.nextLine();
        System.out.print("Masukan nama judul: ");
        judul = terminalInput.nextLine();
        System.out.print("Masukan nama penerbit: ");
        penerbit = terminalInput.nextLine();
        System.out.print("Masukan tahun terbit: ");
        tahun = Utils.ambilTahun();

        // cek buku didatabase
        String[] keywords = {tahun+","+penulis+","+penerbit+","+judul};
        System.out.println(Arrays.toString(keywords));

        boolean isExist = Utils.cekBukuDiDatabase(keywords, false);

        // menulis buku didatabase

        if(!isExist){
            // fiersabesari_2012_1,2012,fiersa besari,media kita,jejak langkah
            // System.out.println(ambilEntryPerTahun(penulis, tahun));
            long nomorEntry = Utils.ambilEntryPerTahun(penulis, tahun) + 1;
            

            String penulisTanpaSpasi = penulis.replaceAll("\\s+","");
            String primaryKey = penulisTanpaSpasi+"_"+tahun+"_"+nomorEntry;
            System.out.println("\nData yang akan anda masukan adalah");
            System.out.println("----------------------------------------");
            System.out.println("primary key  : " + primaryKey);
            System.out.println("tahun terbit : " + tahun);
            System.out.println("penulis      : " + penulis);
            System.out.println("judul        : " + judul);
            System.out.println("penerbit     : " + penerbit);
            boolean isTambah = Utils.getYesorNo("Apakah akan ingin menambah data tersebut? ");
            // masukan buku ke database

            if(isTambah){
                bufferOutput.write(primaryKey + "," + tahun + ","+ penulis +"," + penerbit + ","+judul);
                bufferOutput.newLine();
                bufferOutput.flush();
            }

        }else{
            System.out.println("buku yang anda akan masukan sudah tersedia di database dengan data berikut:");
            Utils.cekBukuDiDatabase(keywords,true);
        }

        bufferOutput.close();
    }

}
