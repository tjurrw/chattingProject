import java.util.Scanner;

public class GqueueTester {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Gqueue<String> s = new Gqueue(1);

        while(true){
            System.out.println("현재 데이터 수 : " + s.size() + " / " + s.capacity());
            System.out.print("(1)Enqueue (2)Dequeue (3)Peek (4)Dump (5)search (0)Exit : ");

            int menu = sc.nextInt();
            if(menu == 0) break;

            String x;

            switch(menu){
                case 1: //Enqueue
                    System.out.print("데이터 : ");
                    x = sc.next();

                    try{
                        s.enque(x);
                    } catch(OverflowIntQueueException e){
                        System.out.println("큐가 full 입니다.");
                    }
                    break;

                case 2: //Dequeue
                    try{
                        x = s.deque();
                        System.out.println("Dequeue 값은 " + x + " 입니다.");
                    } catch(EmptyIntQueueException e){
                        System.out.println("큐가 empty 입니다.");
                    }
                    break;

                case 3: //Peek
                    try{
                        x = s.peek();
                        System.out.println("Peek 값은 " + x + " 입니다.");
                    } catch(EmptyIntQueueException e){
                        System.out.println("큐가 empty 입니다.");
                    }
                    break;

                case 4:
                    s.dump();
                    break;

                case 5:
                    System.out.print("검색값을 입력해 주세요 : ");
                    x = sc.next();

                    int n = s.search(x);
                    if(n > 0)
                        System.out.println("검색값은 " + n + "번째 큐에 있습니다.");
                    else
                        System.out.println("해당 검색값은 존재하지 않습니다.");
            }
        }
    }
}
