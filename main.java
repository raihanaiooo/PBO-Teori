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

            if (role == 1) {  // ADMIN
                while (true) {
                    System.out.println("\n=== MENU ADMIN ===");
                    System.out.println("1. Tambah Stand");
                    System.out.println("2. Lihat Semua Stand");
                    System.out.println("3. Kembali");
                    System.out.print("Pilih menu: ");
                    int menuAdmin = sc.nextInt();
                    sc.nextLine();

                    if (menuAdmin == 1) {
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

                    } else if (menuAdmin == 2) {
                        if (daftarStand.isEmpty()) {
                            System.out.println("Belum ada stand terdaftar.\n");
                        } else {
                            for (Stand s : daftarStand) {
                                s.display();
                            }
                        }
                    } else if (menuAdmin == 3) {
                        break;
                    } else {
                        System.out.println("Pilihan tidak valid.\n");
                    }
                }

            } else if (role == 2) {  // USER
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

                        ArrayList<Pesanan> keranjang = new ArrayList<>();

                        while (true) {
                            System.out.println("\nMau pesan apa?");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.print("Pilih jenis (1/2): ");
                            int jenis = sc.nextInt();
                            sc.nextLine();

                            if (jenis == 1) {
                                ArrayList<Makanan> daftarMakanan = chosenStand.getDaftarMakanan();
                                for (int i = 0; i < daftarMakanan.size(); i++) {
                                    System.out.println((i+1) + ". " + daftarMakanan.get(i).getNama() +
                                            " - Rp" + daftarMakanan.get(i).getHarga());
                                }
                                System.out.print("Pilih makanan (nomor): ");
                                int idx = sc.nextInt();
                                sc.nextLine();

                                if (idx >= 1 && idx <= daftarMakanan.size()) {
                                    Makanan m = daftarMakanan.get(idx-1);
                                    System.out.print("Masukkan kuantitas: ");
                                    int qty = sc.nextInt();
                                    sc.nextLine();

                                    keranjang.add(new Pesanan(m.getNama(), m.getHarga(), qty));
                                }

                            } else if (jenis == 2) {
                                ArrayList<Minuman> daftarMinuman = chosenStand.getDaftarMinuman();
                                for (int i = 0; i < daftarMinuman.size(); i++) {
                                    System.out.println((i+1) + ". " + daftarMinuman.get(i).getNama() +
                                            " - Rp" + daftarMinuman.get(i).getHarga());
                                }
                                System.out.print("Pilih minuman (nomor): ");
                                int idx = sc.nextInt();
                                sc.nextLine();

                                if (idx >= 1 && idx <= daftarMinuman.size()) {
                                    Minuman m = daftarMinuman.get(idx-1);
                                    System.out.print("Masukkan kuantitas: ");
                                    int qty = sc.nextInt();
                                    sc.nextLine();

                                    keranjang.add(new Pesanan(m.getNama(), m.getHarga(), qty));
                                }
                            } else {
                                System.out.println("Pilihan tidak valid.");
                            }

                            System.out.print("Mau pesan menu lain? (y/n): ");
                            String lagi = sc.nextLine();
                            if (!lagi.equalsIgnoreCase("y")) {
                                break;
                            }
                        }

                        // Tampilkan rincian keranjang
                        System.out.println("\n===== RINCIAN PESANAN =====");
                        int total = 0;
                        for (Pesanan p : keranjang) {
                            System.out.println(p.getNamaItem() + " x" + p.getJumlah() +
                                               " = Rp " + p.getSubtotal());
                            total += p.getSubtotal();
                        }
                        System.out.println("TOTAL : Rp " + total);
                        System.out.println("===========================\n");
                    }
                }

            } else if (role == 3) {
                System.out.println("Terima kasih!");
                break;
            } else {
                System.out.println("Pilihan tidak valid.\n");
            }
        }

        sc.close();
    }
}