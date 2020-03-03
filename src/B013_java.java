import java.util.Scanner;

public class B013_java {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();

        int N = sc.nextInt();

        //電車の時刻表
        int[] h = new int[N];
        int[] m = new int[N];
        for(int i = 0; i < N; i++){
            h[i] = sc.nextInt();
            m[i] = sc.nextInt();
        }

        //出勤時刻

    }
}