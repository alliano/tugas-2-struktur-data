
import java.util.Arrays;

public class MergeSort {
    // Fungsi merge untuk menggabungkan dua bagian terurut dari array
    /**
     * 
     * @param arr data array mentah(nelum terurut)
     * @param l sisi kiri data array
     * @param m sisi indexs tengah atau pemabatas array kanan dan kiri
     * @param r sisi array kanan
     */
    public static void merge(int arr[], int l, int m, int r) {
        // Mendapatkan ukuran bagian kiri dan kanan
        int n1 = m - l + 1;
        int n2 = r - m;

        // Membuat array sementara untuk bagian kiri dan kanan
        int L[] = new int[n1];
        int R[] = new int[n2];

        // Menyalin elemen-elemen bagian kiri ke array sementara L
        for (int i = 0; i < n1; ++i)
            L[i] = arr[l + i];

        // Menyalin elemen-elemen bagian kanan ke array sementara R
        for (int j = 0; j < n2; ++j)
            R[j] = arr[m + 1 + j];

        // Menggabungkan kembali dua bagian terurut ke dalam array utama secara berurutan
        int i = 0, j = 0;
        int k = l;
        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        // Menyalin sisa elemen-elemen dari bagian kiri jika ada
        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        // Menyalin sisa elemen-elemen dari bagian kanan jika ada
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    // Fungsi rekursif untuk membagi array menjadi bagian-bagian yang lebih kecil
    public static int[] sort(int arr[], int l, int r) {
        // Basis rekursif: jika bagian yang akan diurutkan hanya memiliki satu elemen
        if (l < r) {
            // Menentukan titik tengah array
            int m = (l + r) / 2;

            // Memanggil rekursif untuk membagi dan mengurutkan bagian kiri
            sort(arr, l, m);

            // Memanggil rekursif untuk membagi dan mengurutkan bagian kanan
            sort(arr, m + 1, r);

            // Menggabungkan dua bagian yang sudah terurut
            merge(arr, l, m, r);

        }
        return arr;
    }

    // Fungsi utama untuk menguji algoritma Merge-sort
    public static void main(String args[]) {
        // Inisialisasi array dengan nilai-nilai yang akan diurutkan,
        int arr[] = {12, 11, 13, 5, 6, 7};
        // System.out.println("Data array senelum diurutkan menggunakan mergesort :");
        // System.out.println(Arrays.toString(arr));

        // Memanggil fungsi sort untuk mengurutkan array
        int[] dataMergersort = MergeSort.sort(arr, 0, arr.length - 1);

        System.out.println(Arrays.toString(dataMergersort));

        // Menampilkan hasil pengurutan
        // System.out.println("Data array setelah diurutkan menggunakan mergesort :");
        // System.out.println(Arrays.toString(arr));
    }
}
