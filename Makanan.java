public class Makanan{
    private static int counter = 1;
    private int id;
    private String nama;
    private int harga;

    // Constructor
    public Makanan(){
       this.id = counter++;
    }
    // Getter
    public int getId(){
        return id;
    }
    public String getNama(){
        return nama;
    }
    public int getHarga(){
        return harga;
    }

    // Setter
    public void setNama(String newNama){
        nama = newNama;
    }
    public void setHarga(int newHarga){
        harga = newHarga;
    }

    
}