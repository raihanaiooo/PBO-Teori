public class Pesanan {
    private String namaItem;
    private double harga;
    private int jumlah;

    // Constructor
    public Pesanan(String namaItem, double harga, int jumlah) {
        this.namaItem = namaItem;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    // Getter
    public String getNamaItem() {
        return namaItem;
    }

    public double  getHarga() {
        return harga;
    }

    public int getJumlah() {
        return jumlah;
    }

    public double  getSubtotal() {
        return harga * jumlah;
    }

    // Behavior
    public void display() {
        System.out.println(namaItem + " x" + jumlah + " = Rp " + getSubtotal());
    }
}

