import java.util.List;

public class Main {
    public static void main(String[] args) {
        CharacterManager manager = new CharacterManager();

        System.out.println("=== 1. UJI PENAMBAHAN DAN VALIDASI DUPLIKAT (Bagian A) ===");
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 10));
        manager.addCharacter(new Character("Merlin", CharacterType.MAGE, 15));
        manager.addCharacter(new Character("Robin", CharacterType.ARCHER, 8));
        
        // Penambahan duplikat (harus ditolak)
        manager.addCharacter(new Character("Arthur", CharacterType.WARRIOR, 20));

        System.out.println("\n=== 2. EKSPERIMEN REFERENCE / DEFENSIVE COPY (Bagian A No 4) ===");
        List<Character> externalList = manager.getAllCharacters();
        System.out.println("Jumlah karakter sebelum diubah dari luar: " + manager.getTotalCharacters());
        
        // Mencoba memanipulasi list dari luar
        externalList.clear(); 
        System.out.println("Jumlah karakter setelah externalList.clear(): " + manager.getTotalCharacters());
        System.out.println("(Terbukti internal list aman dari manipulasi luar!)");

        System.out.println("\n=== 3. UJI MINI-CHALLENGE (Bagian B) ===");
        System.out.println("Rata-rata level karakter: " + manager.getAverageLevel());

        System.out.println("\nKarakter bertipe MAGE:");
        List<Character> mages = manager.findByType(CharacterType.MAGE);
        for (Character c : mages) {
            System.out.println("- " + c.getName() + " (Lvl " + c.getLevel() + ")");
        }

        System.out.println("\n=== 4. UJI FITUR ANALITIK / RANCANGAN SENDIRI (Bagian C) ===");
        Character strongest = manager.findStrongest();
        if (strongest != null) {
            System.out.println("Karakter terkuat saat ini: " + strongest.getName() + " dengan level " + strongest.getLevel());
        }

        System.out.println("\n=== UJI LIST KOSONG PADA AVERAGE LEVEL ===");
        CharacterManager emptyManager = new CharacterManager();
        System.out.println("Rata-rata level pada list kosong: " + emptyManager.getAverageLevel());
    }
}