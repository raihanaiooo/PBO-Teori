public class Pesanan {
    private String namaItem;
    private int harga;
    private int jumlah;

    public Pesanan(String namaItem, int harga, int jumlah) {
        this.namaItem = namaItem;
        this.harga = harga;
        this.jumlah = jumlah;
    }

    public String getNamaItem(){
        return namaItem;
    }
    public int getHarga(){
        return harga;
    }
    public int getJumlah(){
        return jumlah;
    }
    public int getSubtotal(){
        return harga*jumlah;
}
}
