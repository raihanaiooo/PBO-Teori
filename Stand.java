import java.util.ArrayList;

public class Stand {
    private static int counter = 1;
    private int id;
    private String name;
    private String phone;
    private ArrayList<Makanan> daftarMakanan;
    private ArrayList<Minuman> daftarMinuman;

    // Constructor
    public Stand() {
        this.id = counter++;
        daftarMakanan = new ArrayList<>();
        daftarMinuman = new ArrayList<>();
    }

    // Getter
    public int getId(){
        return id;
    }
    public String getName() {
        return name;
    }
    public String getPhone() {
        return phone;
    }
    public ArrayList<Makanan> getDaftarMakanan() {
        return daftarMakanan;
    }
    public ArrayList<Minuman> getDaftarMinuman() {
        return daftarMinuman;
    }

    // Setter
    public void setName(String newName) {
        name = newName;
    }
    public void setPhone(String newPhone) {
        phone = newPhone;
    }

    // Tambah menu
    public void addMakanan(Makanan m) {
        daftarMakanan.add(m);
    }
    public void addMinuman(Minuman m) {
        daftarMinuman.add(m);
    }

    // Display info
     public void display() {
        System.out.println("\n=== Info Stand ===");
        System.out.println("Nama Stand : " + name);
        System.out.println("No. HP     : " + phone);

        System.out.println("\n--- Menu Makanan ---");
        if (daftarMakanan.isEmpty()) {
            System.out.println("(Belum ada makanan)");
        } else {
            for (int i = 0; i < daftarMakanan.size(); i++) {
                Makanan m = daftarMakanan.get(i);
                System.out.println((i+1) + ". " + m.getNama() + " - Rp" + m.getHarga());
            }
        }

        System.out.println("\n--- Menu Minuman ---");
        if (daftarMinuman.isEmpty()) {
            System.out.println("(Belum ada minuman)");
        } else {
            for (int i = 0; i < daftarMinuman.size(); i++) {
                Minuman m = daftarMinuman.get(i);
                System.out.println((i+1) + ". " + m.getNama() + " - Rp" + m.getHarga());
            }
        }
        System.out.println("=======================");
    }
}
