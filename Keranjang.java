import java.util.ArrayList;

public class Keranjang {
    private ArrayList<Pesanan> daftarPesanan = new ArrayList<>();

    // Behavior
    public void tambahPesanan(Pesanan p) {
        daftarPesanan.add(p);
    }

    public void tampilkanRincian() {
        System.out.println("\n===== RINCIAN PESANAN =====");
        int total = 0;
        for (Pesanan p : daftarPesanan) {
            p.display();
            total += p.getSubtotal();
        }
        System.out.println("TOTAL : Rp " + total);
        System.out.println("===========================\n");
    }

    public boolean isEmpty() {
        return daftarPesanan.isEmpty();
    }
}
