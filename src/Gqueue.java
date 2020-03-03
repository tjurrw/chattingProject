//큐 클래스의 제너릭화

public class Gqueue<E> {
    private int max;
    private int num;
    private int front;
    private int rear;
    private E[] que;

    //생성자
    public Gqueue(int capacity){
        num = front = rear = 0;
        max = capacity;

        try{
            que = (E[])new Object[max];
        }catch(OutOfMemoryError e){
            max = 0;
        }
    }

    //Enqueue
    public E enque(E x) throws OverflowIntQueueException{
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
    public E deque() throws EmptyIntQueueException{
        //큐가 empty 일 경우
        if(num <= 0){
            throw new EmptyIntQueueException();
        }

        E x = que[front++];
        num--;
        if(front == max)
            front = 0;
        return x;
    }

    //peek, 선두 요소 반환
    public E peek() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        return que[front];
    }

    //해당 큐 검색
    public int indexOf(E x){
        for(int i = 0; i < num; i++){
            if(que[(i + front) % max] == x)
                return (i + front) % max;
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

    public int search(E x) throws EmptyIntQueueException{
        for(int i = 0; i < num; i++){
            if(que[(i + front) % max] == x)
                return i + 1;
        }
        return 0;
    }
}

//
//
//