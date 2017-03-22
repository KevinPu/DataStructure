package kevin.sort;

/**
 * @author Kevin
 *
 */

public class Sort {

	//冒泡排序
	public static <T extends Comparable<? super T>> void bubbleSort(T[] a) {
		int N = a.length;
		boolean sorted = false;
		for (int i = 0; i < N - 1 && !sorted; i++) {
			sorted = true;
			for (int j = N - 1; j > i; j--) {
				if (less(a[j], a[j - 1])) {
					exch(a, j, j - 1);
					sorted = false;
				}
			}
		}
	}
	//选择排序
	public static <T extends Comparable<? super T>> void selectSort(T[] a) {
		int N = a.length;
		for (int i = 0; i < N; i++) {
			int min = i;
			for (int j = i + 1; j < N; j++)
				if (less(a[j], a[min]))
					min = j;
			exch(a, i, min);
		}
	}
	//插入排序
	public static <T extends Comparable<? super T>> void insertSort(T[] a) {
		int N = a.length;
		int j;
		for (int i = 1; i < N; i++) {
			T tmp = a[i];
			for (j = i; j > 0 && less(tmp, a[j - 1]); j--) {
				a[j] = a[j - 1];
			}
			a[j] = tmp;
		}
	}

	// 希尔排序
	public static <T extends Comparable<? super T>> void shellSort(T[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3)
			h = 3 * h + 1; // 1, 4, 13, 40, 121, 364, 1093, ...
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j -= h) {
					exch(a, j, j - h);
				}
			}
			h /= 3;
		}
	}

	// 归并排序
	@SuppressWarnings("unchecked")
	public static <T extends Comparable<? super T>> void mergeSort(T[] a) {

		T[] tmp = (T[]) new Comparable[a.length];

		mergeSort(a, tmp, 0, a.length);
	}

	private static <T extends Comparable<? super T>> void mergeSort(T[] a, T[] tmp, int left, int right) {
		if (right - left < 2)
			return;
		int mid = (right + left) >> 1;
		mergeSort(a, tmp, left, mid);
		mergeSort(a, tmp, mid, right);
		merge(a, tmp, left, mid, right);
	}

	private static <T extends Comparable<? super T>> void merge(T[] a, T[] tmp, int left, int mid, int right) {
		for (int i = left; i < mid; i++) {
			tmp[i] = a[i];
		}
		for (int i = left, j = left, k = mid; (j < mid || k < right);) {
			if (j < mid && (!(k < right) || less(tmp[j], a[k])))
				a[i++] = tmp[j++];
			if (k < right && (!(j < mid) || !less(tmp[j], a[k])))
				a[i++] = a[k++];
		}
	}

	private static <T extends Comparable<? super T>> boolean less(T v, T w) {
		return v.compareTo(w) < 0;
	}

	private static <T extends Comparable<? super T>> void exch(T[] a, int i, int j) {
		T tmp = a[i];
		a[i] = a[j];
		a[j] = tmp;
	}

}