/* import java.util.Scanner;

public class B013 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int houseToStation = sc.nextInt();  //집에서 역까지
        int stationToStaion = sc.nextInt(); //시발역에서 목적역까지
        int walkToCompany = sc.nextInt(); //역에서 회사까지

        int trainCount = sc.nextInt(); //전차의 숫자

        for(int i = 0; i < trainCount; i++){
            int time = sc.nextInt();
            int minute = sc.nextInt();
        }


    }
} */

/*

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
​
public class Main {
    static public void Main(String[] args) {
    const int last_hour = 8;
    const int last_min = 59;
​
        int a = 0, b = 0, c = 0;
        int n = 0;
​
        Scanner sc = new Scanner(System.in);
​
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        n = sc.nextInt();
​
        ArrayList<Pair<Integer, Integer>> time = new ArrayList<Pair<Integer, Integer>>(); //Pair클래스는 javafx 라이브러리 인듯?
​
        for (int i = 0; i < n; ++i) {
            int h = 0, m = 0;
            h = sc.nextInt();
            m = sc.nextInt();
            time.add(new Pair(h, m));
        }
​
        int remain_time = b + c;
​
        int train_hour = 0;
        int train_min = 0;

        for (int i = n - 1; i >= 0; --i) {
            Pair<int, int> last_time = time.get(i);
            int hour = last_time.getKey();
            int min = last_time.getValue();
​
            if ( (min + remain_time) >= 60 ) {
                hour++;
                min = min + remain_time - 60;
            } else {
                min = min + remain_time;
            }
​
            if ( hour <= last_hour ) {
                if ( min <+ last_min ) {
                    train_hour = last_time.first;
                    train_min = last_time.second;
                    break;
                }
            }
        }

        int depart_hour = 0;
        int depart_min = 0;
​
        if ( (train_min - a) < 0 ) {
            depart_hour = train_hour - 1;
            depart_min = 60 + (train_min -a);
        } else {
            depart_hour = train_hour;
            depart_min = train_min - a;
        }
​
        if ( depart_hour < 10 ) {
            System.out.print("0" + depart_hour);
        } else {
            System.out.print(depart_hour);
        }
        System.out.print(":");
        if ( depart_hour < 10 ) {
            System.out.println("0" + depart_min);
        } else {
            System.out.println(depart_min);
        }
    }
} */