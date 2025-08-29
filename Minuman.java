public class Minuman{
    private static int counter = 1;
    private int id;
    private String nama;
    private double harga;

    // Constructor
    public Minuman(){
        this.id = counter++;
    }
    // Getter
    public int getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public double getHarga(){
        return harga;
    }

    // Setter
    public void setNama(String newNama){
        nama = newNama;
    }
    public void setHarga(double newHarga){
        harga = newHarga;
    }

    // Behavior
    public void tampilkanMenu(int nomor) {
        System.out.println(nomor + ". " + nama + " - Rp" + harga);
    }
}