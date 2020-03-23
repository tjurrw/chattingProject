import java.util.Scanner;

public class QuickSort {
    //배열 요소 교환
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //퀵 소트
    static void quickSort(int[] a, int left, int right){
        int pl = left; //0
        int pr = right; //n - 1
        int x = a[(pl + pr) / 2];

        do {
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;

            if(pl <= pr)
                swap(a, pl++, pr--);
        } while(pl <= pr);

        if(left < pr) quickSort(a, left, pr);
        if(pl < right) quickSort(a, pr, right);
    }

    //main
    public static void main(String[] args){
        Scanner sc= new Scanner(System.in);

        System.out.println("퀵 소트");
        System.out.print("요소수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }

        quickSort(x, 0, nx - 1);

        System.out.println("오름차순 정렬");
        for(int i = 0; i < nx; i++)
            System.out.println("x[" + i + "] = " + x[i]);
    }
}
