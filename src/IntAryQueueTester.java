import java.util.Scanner;

public class IntAryQueueTester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        IntAryQueue s = new IntAryQueue(10);

        while(true){
            System.out.println("현재 데이터의 수：" + s.size() + " / " + s.capacity());
            System.out.print("(1)Enqueue (2)Dequeue (3)clear (4)dump (5)검색 (0)종료   :");

            int menu = sc.nextInt();
            if(menu == 0) break;

            int x, n = 0;
            switch(menu){
                case 1:
                    System.out.print("입력치：");
                    x = sc.nextInt();
                    try {
                        s.Enqueue(x);
                    } catch (IntAryQueue.OverflowIntQueueException e) {
                        System.out.println("해당 큐는 이미 full입니다.");
                    }
                    break;

                case 2:
                    try{
                        x = s.Dequeue();
                        System.out.println("추출한 데이터는 " + x + "입니다.");
                    }catch(IntAryQueue.EmptyIntQueueException e){
                        System.out.println("해당 큐에 요소가 존재하지 않습니다.");
                    }
                    break;

                case 3:
                    s.clear();
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    System.out.print("검색값 입력：");
                    x = sc.nextInt();
                    n = s.indexOf(x);

                    if (n >= 0)
                        System.out.println("해당 데이터는 " + n + "번째 요소에 있습니다.");
                    else
                        System.out.println("해당 데이터는 존재하지 않습니다.");
                    break;
            }
        }
    }
}

