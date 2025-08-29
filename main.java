import java.util.ArrayList;
import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Stand> daftarStand = new ArrayList<>();

        while (true) {
            System.out.println("=== MENU UTAMA ===");
            System.out.println("1. Admin");
            System.out.println("2. User");
            System.out.println("3. Keluar");
            System.out.print("Pilih role: ");
            int role = sc.nextInt();
            sc.nextLine();

            switch (role) {
                case 1 -> {
                    // ADMIN
                    while (true) {
                        System.out.println("\n=== MENU ADMIN ===");
                        System.out.println("1. Tambah Stand");
                        System.out.println("2. Lihat Semua Stand");
                        System.out.println("3. Kembali");
                        System.out.print("Pilih menu: ");
                        int menuAdmin = sc.nextInt();
                        sc.nextLine();

                        switch (menuAdmin) {
                            case 1 -> {
                                Stand stand = new Stand();

                                System.out.print("Masukkan Nama Stand: ");
                                stand.setName(sc.nextLine());

                                System.out.print("Masukkan No. HP: ");
                                stand.setPhone(sc.nextLine());

                                // Tambah makanan
                                while (true) {
                                    Makanan makanan = new Makanan();
                                    System.out.print("Masukkan Nama Makanan: ");
                                    makanan.setNama(sc.nextLine());
                                    System.out.print("Masukkan Harga Makanan: ");
                                    makanan.setHarga(sc.nextInt());
                                    sc.nextLine();
                                    stand.addMakanan(makanan);

                                    System.out.print("Tambah makanan lagi? (y/n): ");
                                    String lagi = sc.nextLine();
                                    if (!lagi.equalsIgnoreCase("y")) break;
                                }

                                // Tambah minuman
                                while (true) {
                                    Minuman minuman = new Minuman();
                                    System.out.print("Masukkan Nama Minuman: ");
                                    minuman.setNama(sc.nextLine());
                                    System.out.print("Masukkan Harga Minuman: ");
                                    minuman.setHarga(sc.nextInt());
                                    sc.nextLine();
                                    stand.addMinuman(minuman);

                                    System.out.print("Tambah minuman lagi? (y/n): ");
                                    String lagi = sc.nextLine();
                                    if (!lagi.equalsIgnoreCase("y")) break;
                                }

                                daftarStand.add(stand);
                                System.out.println("Stand berhasil ditambahkan!\n");
                            }

                            case 2 -> {
                                if (daftarStand.isEmpty()) {
                                    System.out.println("Belum ada stand terdaftar.\n");
                                } else {
                                    for (Stand s : daftarStand) {
                                        s.display();
                                    }
                                }
                            }

                            case 3 -> System.out.println("Kembali ke menu utama...\n");

                            default -> System.out.println("Pilihan tidak valid.\n");
                        }

                        if (menuAdmin == 3) break; // keluar dari while admin
                    }
                }

                case 2 -> {
                    // USER
                    if (daftarStand.isEmpty()) {
                        System.out.println("Belum ada stand, silakan tunggu admin menambahkan.\n");
                    } else {
                        System.out.println("\n=== DAFTAR STAND ===");
                        for (int i = 0; i < daftarStand.size(); i++) {
                            System.out.println((i+1) + ". " + daftarStand.get(i).getName());
                        }

                        System.out.print("Pilih stand (nomor): ");
                        int pilihanStand = sc.nextInt();
                        sc.nextLine();

                        if (pilihanStand < 1 || pilihanStand > daftarStand.size()) {
                            System.out.println("Stand tidak ditemukan!\n");
                        } else {
                            Stand chosenStand = daftarStand.get(pilihanStand-1);
                            chosenStand.display();

                            Keranjang keranjang = new Keranjang();

                            while (true) {
                                System.out.println("\nMau pesan apa?");
                                System.out.println("1. Makanan");
                                System.out.println("2. Minuman");
                                System.out.print("Pilih jenis (1/2): ");
                                int jenis = sc.nextInt();
                                sc.nextLine();

                                switch (jenis) {
                                    case 1 -> {
                                        chosenStand.displayMenuMakanan();
                                        System.out.print("Pilih makanan (nomor): ");
                                        int idxM = sc.nextInt();
                                        sc.nextLine();

                                        if (idxM >= 1 && idxM <= chosenStand.getDaftarMakanan().size()) {
                                            Makanan m = chosenStand.getDaftarMakanan().get(idxM-1);
                                            System.out.print("Masukkan kuantitas: ");
                                            int qty = sc.nextInt();
                                            sc.nextLine();

                                            keranjang.tambahPesanan(new Pesanan(m.getNama(), m.getHarga(), qty));
                                        }
                                    }

                                    case 2 -> {
                                        chosenStand.displayMenuMinuman();
                                        System.out.print("Pilih minuman (nomor): ");
                                        int idxN = sc.nextInt();
                                        sc.nextLine();

                                        if (idxN >= 1 && idxN <= chosenStand.getDaftarMinuman().size()) {
                                            Minuman minuman = chosenStand.getDaftarMinuman().get(idxN-1);
                                            System.out.print("Masukkan kuantitas: ");
                                            int qty = sc.nextInt();
                                            sc.nextLine();

                                            keranjang.tambahPesanan(new Pesanan(minuman.getNama(), minuman.getHarga(), qty));
                                        }
                                    }

                                    default -> System.out.println("Pilihan tidak valid.");
                                }

                                System.out.print("Mau pesan menu lain? (y/n): ");
                                String lagi = sc.nextLine();
                                if (!lagi.equalsIgnoreCase("y")) {
                                    break;
                                }
                            }

                            keranjang.tampilkanRincian();
                        }
                    }
                }

                case 3 -> {
                    // Keluar
                    System.out.println("Terima kasih!");
                    sc.close();
                    return;
                }

                default -> System.out.println("Pilihan tidak valid.\n");
            }
        }
    }
}
