import java.util.Scanner;

public class Partition {
    //배열의 요소 교환
    static void swap(int[] a, int idx1, int idx2){
        int t = a[idx1];
        a[idx1] = a[idx2];
        a[idx2] = t;
    }

    //배열을 분할
    static void partition(int[] a, int n){
        int pl = 0; //왼쪽 포인터
        int pr = n - 1; //오른쪽 포인터
        int x = a[n / 2]; //중앙의 요소

        do{
            while(a[pl] < x) pl++;
            while(a[pr] > x) pr--;
            if(pl <= pr)
                swap(a, pl++, pr--);
        }while(pl <= pr);

        System.out.println("중앙의 요소는 " + x + "입니다.");

        System.out.println("중앙치 이하의 요소들의 그룹");
        for(int i = 0; i <= pl - 1; i++)
            System.out.print(a[i] + " ");
        System.out.println();

        if(pl > pr + 1){
            System.out.println("중앙치와 일치하는 그룹");
            for(int i = pr + 1; i <= pl - 1; i++)
                System.out.print(a[i] + " ");
            System.out.println();
        }

        System.out.println("중앙치 이상의 요소들의 그룹");
        for(int i = pr + 1; i < n; i++)
            System.out.print(a[i] + " ");
        System.out.println();
   }

   public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("배열을 분할 합니다.");
        System.out.print("요소 수 : ");
        int nx = sc.nextInt();
        int[] x = new int[nx];

        for(int i = 0; i < nx; i++){
            System.out.print("x[" + i + "] : ");
            x[i] = sc.nextInt();
        }
        partition(x, nx);
   }
}
