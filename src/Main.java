import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        int a[] = new int[] {5, 2, 4, 9, 3, 6, 2, 1, 11, 1, 10, 4, 7, 3};
        evenBeforeOdd(a);
        for (int num : a) {
            Print();
        }
    }

    public static void evenBeforeOdd(int[] a) {
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] % 2 != 0 && a[j] % 2 == 0) {
                    int temp = a[i];
                    a[i] = a[j];
                    a[j] = temp;
                }
            }
        }
    }

}