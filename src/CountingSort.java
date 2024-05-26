
import java.util.Arrays;

public class CountingSort {
    public void countingSort(int[] arr) {
        int n = arr.length;

        // Mencari nilai maksimum dalam array
        int max = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        // Membuat array count dengan ukuran (max + 1)
        int[] count = new int[max + 1];

        // Menghitung frekuensi kemunculan setiap elemen dalam array
        for (int i = 0; i < n; i++) {
            count[arr[i]]++;
        }

        // Mengakumulasikan frekuensi kemunculan
        for (int i = 1; i <= max; i++) {
            count[i] += count[i - 1];
        }

        // Membuat array hasil dengan ukuran n
        int[] hasil = new int[n];

        // Menempatkan elemen-elemen array ke posisi yang tepat dalam array hasil
        for (int i = n - 1; i >= 0; i--) {
            hasil[count[arr[i]] - 1] = arr[i];
            count[arr[i]]--;
        }

        // Menyalin elemen-elemen dari array hasil ke array asli
        System.arraycopy(hasil, 0, arr, 0, n);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 7, 1, 3, 6};
        System.out.println("Data array senbelum diurutkan menggunakan countingsort :");
        System.out.println(Arrays.toString(arr));
        
        CountingSort cs = new CountingSort();
        cs.countingSort(arr);
        
        System.out.println("Data array setelah diurutkan menggunakan countingsort :");
        System.out.println(Arrays.toString(arr));

    }
}
