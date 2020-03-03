import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    static void bubblesort(int[] a, int n){
        for(int i = 0; i < n - 1; i++) {
            int exchg = 0;
            for (int j = n - 1; j > i; j--)
                if (a[j - 1] > a[j]) {
                    swap(a, j - 1, j);
                    exchg++;
                }
            if(exchg == 0) break;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("BubbleSort");
        System.out.print("요소 수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){
            System.out.print("x[" + i + "] :");
            x[i] = sc.nextInt();
        }

        bubblesort(x, nx);

        System.out.println("오름차순으로 정렬했습니다.");
        for(int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}