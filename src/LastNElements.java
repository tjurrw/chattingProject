import java.util.Scanner;

public class LastNElements {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        final int N = 10;
        int[] a = new int[N];
        int cnt = 0;
        int retry;

        System.out.println("정수를 입력해 주세요.");

        do {
            System.out.printf("%d번 째 정수 : ", cnt + 1);
            a[cnt++ % N] = sc.nextInt();

            System.out.print("계속하시겠습니까? (Yes...1 / No...0) : ");
            retry = sc.nextInt();
        } while (retry == 1);

        int i = cnt - N;
        if(i < 0) i = 0;

        for(; i < cnt; i++)
            System.out.printf("%2d번 쨰 = %d\n", i + 1, a[i % N]);
    }
}