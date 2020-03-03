public class IntQueue {
    private int max; //큐의 용량
    private int front; //선두 요소의 인덱스
    private int rear; //후미 요소의 인덱스
    private int num; //현재의 데이터 수
    private int[] que; //큐를 격납하는 배열

    //실행시 예외:큐가 Empty 일 경우
    public class EmptyIntQueueException extends RuntimeException{
        public EmptyIntQueueException(){}
    }

    //실행시 예외:큐가 full 일 경우
    public class OverflowIntQueueException extends RuntimeException{
        public OverflowIntQueueException(){}
    }

    //생성자
    public IntQueue(int capacity){
        num = front = rear = 0;
        max = capacity;

        try{
            que = new int[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    //Enqueue
    public int enque(int x) throws OverflowIntQueueException{
        //큐가 full 일 경우
        if(num >= max)
            throw new OverflowIntQueueException();

        que[rear++] = x;
        num++;
        if(rear == max)
            rear = 0;
        return x;
    }

    //Dequeue
    public int deque() throws EmptyIntQueueException{
        //큐가 empty 일 경우
        if(num <= 0){
            throw new EmptyIntQueueException();
        }

        int x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    //peek, 선두 요소 반환
    public int peek() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    //해당 큐 검색
    public int indexOf(int x){
        for(int i = 0; i < num; i++){
            int idx = (i + front) % max;
            if(que[idx] == x)
                return idx;
        }
        return -1;
    }

    //큐 초기화
    public void clear(){
        num = front = rear = 0;
    }

    //배열의 크기
    public int capacity(){
        return max;
    }

    //큐의 크기
    public int size(){
        return num;
    }

    //큐의 상태 확인 : empty
    public boolean isEmpty(){
        return num <= 0;
    }

    //큐의 상태 확인 : full
    public boolean isFull(){
        return num >= max;
    }

    //큐의 전 요소 출력(front ~ rear)
    public void dump(){
        if(num <= 0)
            System.out.println("큐는 Empty 입니다.");
        else{
            for(int i = 0; i < num; i++)
                System.out.print(que[(i + front) % max] + " ");
            System.out.println();
        }
    }

    public int search(int x) throws EmptyIntQueueException{
        int count = 0;

        for(int i = 0; i < num; i++){
            int idx = (i + front) % max;
            count++;
            if(que[idx] == x)
                return count;
        }
        return 0;
    }
}