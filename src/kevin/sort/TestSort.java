package kevin.sort;

public class TestSort {

    public static void main(String[] args) {
        int[] a = {34, 8, 64, 51, 32, 21, 1, 13, 24, 26, 38, 15, 21, 82};

//		Sort.insertSort(a);
//		Sort.bubbleSort(a);
//		Sort.selectSort(a);
//		Sort.shellSort(a);
//        Sort.mergeSort(a);

        Sort.quickSort(a);

        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
