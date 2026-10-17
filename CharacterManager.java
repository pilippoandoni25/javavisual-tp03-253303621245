import java.util.ArrayList;
import java.util.List;

public class CharacterManager {
    private List<Character> characterList;
    private static int totalCharacterCreated = 0; // Static counter

    public CharacterManager() {
        this.characterList = new ArrayList<>();
    }

    public static int getTotalCharacterCreated() {
        return totalCharacterCreated;
    }

    // Bagian A No 2 & 3: Tambah karakter dengan validasi duplikat nama[cite: 1]
    public boolean addCharacter(Character character) {
        if (character == null) return false;
        
        // Cek duplikat menggunakan equals()
        for (Character c : characterList) {
            if (c.equals(character)) {
                System.out.println("Gagal menambahkan: Karakter dengan nama '" + character.getName() + "' sudah ada!");
                return false;
            }
        }
        
        characterList.add(character);
        totalCharacterCreated++;
        System.out.println("Berhasil menambahkan: " + character.getName());
        return true;
    }

    // Bagian A No 2: Cari karakter berdasarkan nama[cite: 1]
    public Character findByName(String name) {
        for (Character c : characterList) {
            if (c.getName().equalsIgnoreCase(name)) {
                return c;
            }
        }
        return null;
    }

    // Bagian A No 2: Hapus karakter berdasarkan nama[cite: 1]
    public boolean removeCharacter(String name) {
        Character c = findByName(name);
        if (c != null) {
            characterList.remove(c);
            System.out.println("Berhasil menghapus: " + name);
            return true;
        }
        System.out.println("Gagal menghapus: Karakter '" + name + "' tidak ditemukan.");
        return false;
    }

    // Bagian A No 2: Total karakter di list[cite: 1]
    public int getTotalCharacters() {
        return characterList.size();
    }

    // Bagian A No 4: Mengembalikan SALINAN (Shallow Copy/Defensive Copy) agar Encapsulation terjaga[cite: 1]
    public List<Character> getAllCharacters() {
        return new ArrayList<>(characterList);
    }

    // ==========================================
    // Bagian B — Mini-Challenge[cite: 2]
    // ==========================================

    // Bagian B No 1: Mengembalikan 0 jika list kosong tanpa error pembagian nol[cite: 2]
    public double getAverageLevel() {
        if (characterList.isEmpty()) {
            return 0.0;
        }
        int sum = 0;
        for (Character c : characterList) {
            sum += c.getLevel();
        }
        return (double) sum / characterList.size();
    }

    // Bagian B No 2: Mengembalikan ArrayList semua karakter bertipe tertentu[cite: 2]
    public List<Character> findByType(CharacterType type) {
        List<Character> result = new ArrayList<>();
        for (Character c : characterList) {
            if (c.getType() == type) {
                result.add(c);
            }
        }
        return result;
    }

    // ==========================================
    // Bagian C — Fitur Analitik Rancangan Sendiri
    // ==========================================

    /**
     * Mencari karakter dengan level tertinggi di dalam manager.
     * Menjaga enkapsulasi dengan tidak mengekspos ArrayList utama secara langsung.[cite: 3]
     *
     * @return Character dengan level paling tinggi, atau null jika list kosong.
     */
    public Character findStrongest() {
        if (characterList.isEmpty()) {
            return null;
        }
        Character strongest = characterList.get(0);
        for (Character c : characterList) {
            if (c.getLevel() > strongest.getLevel()) {
                strongest = c;
            }
        }
        return strongest;
    }
}