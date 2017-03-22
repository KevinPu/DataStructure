package kevin.sort;

import org.junit.Test;

public class TestSort {
	
	@Test
	public void test() {
		Integer[] a = {34, 8, 64, 51, 32, 21, 1, 13, 24, 26, 38, 15, 21, 82};
		
//		Sort.insertSort(a);
//		Sort.bubbleSort(a);
//		Sort.selectSort(a);
//		Sort.shellSort(a);
		Sort.mergeSort(a);
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}
}
