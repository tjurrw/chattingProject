import java.util.Scanner;

public class EuclidGCD {
    //두 인수의 최대공약수를 반환
    static int gcd(int x, int y){
        if(y == 0)
            return x;
        else
            return gcd(y, x % y);
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.println("두 정수의 최대공약수를 구하시오.");

        System.out.print("정수를 입력하시오 : "); int x = sc.nextInt();
        System.out.print("정수를 입력하시오 : "); int y = sc.nextInt();

        System.out.println("최대공약수는 " + gcd(x, y) + "입니다.");
    }
}