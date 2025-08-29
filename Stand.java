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
    public String getName(){ 
        return name; 
    }
    public String getPhone(){ 
        return phone; 
    }
    public ArrayList<Makanan> getDaftarMakanan(){ 
        return daftarMakanan; 
    }
    public ArrayList<Minuman> getDaftarMinuman(){ 
        return daftarMinuman; 
    }

    // Setter
    public void setName(String newName){ 
        name = newName; 
    }
    public void setPhone(String newPhone){ 
        phone = newPhone; 
    }

    public void addMakanan(Makanan m){ 
        daftarMakanan.add(m);
    }
    public void addMinuman(Minuman m){ 
        daftarMinuman.add(m); 
    }

    // Behahvior
    public void displayMenuMakanan() {
        for (int i = 0; i < daftarMakanan.size(); i++) {
            System.out.println((i+1) + ". " + daftarMakanan.get(i).getNama() +
                    " - Rp" + daftarMakanan.get(i).getHarga());
        }
    }

    public void displayMenuMinuman() {
        for (int i = 0; i < daftarMinuman.size(); i++) {
            System.out.println((i+1) + ". " + daftarMinuman.get(i).getNama() +
                    " - Rp" + daftarMinuman.get(i).getHarga());
        }
    }

    public void display() {
        System.out.println("\n=== Info Stand ===");
        System.out.println("Nama Stand : " + name);
        System.out.println("No. HP     : " + phone);

        System.out.println("\n--- Menu Makanan ---");
        if (daftarMakanan.isEmpty()) {
            System.out.println("(Belum ada makanan)");
        } else {
            displayMenuMakanan();
        }

        System.out.println("\n--- Menu Minuman ---");
        if (daftarMinuman.isEmpty()) {
            System.out.println("(Belum ada minuman)");
        } else {
            displayMenuMinuman();
        }
        System.out.println("=======================");
    }
}