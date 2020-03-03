import java.util.Scanner;

public class C050 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int S = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int t = 0;

        //a・bで所持金が最小の方を洗濯
        if(a > b){
            t = b;
        } else if(b > a){
            t = a;
        }

        int count = 0;

        //最初所持金の範囲でループを実行
        //countでA・Bを区分
        while (t > S) {
            if((count % 2) == 0){
                if((S + 10) > a){
                    break;
                } else {
                    S += 10;
                    count++;
                }
            } else if((count % 2) == 1){
                if((S + 1000) > b){
                    break;
                } else{
                    S += 1000;
                    count++;
                }
            }
        }

        if((count % 2) == 1){
            System.out.println("A"+ " " + S);
        } else if((count % 2) == 0){
            System.out.println("B"+ " " + S);
        }
    }
}

//