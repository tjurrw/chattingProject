public class IntAryQueue {
    private int max;
    private int num;
    private int[] que;

    //실행 시 큐가 empty
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException(){}
    }

    //실행 시 큐가 full
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException(){}
    }

    public IntAryQueue(int capacity){
        num = 0;
        max = capacity;

        try{
            que = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    //Enqueue 데이터 입력
    public void Enqueue(int x) throws OverflowIntQueueException{
        if(num >= max)
            throw new OverflowIntQueueException();
        que[num++] = x;
    }

    //Dequeue 데이터 추출
    public int Dequeue() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();

        int result = que[0];
        for(int i = 0; i <= num - 1; i++){
            que[i] = que[i + 1];
        }
        num--;

        return result;
    }

    //peek
    public int peek() throws EmptyIntQueueException{
        if(num <= 0)
            throw new EmptyIntQueueException();
        return que[num - 1];
    }

    //요소 검색
    public int indexOf(int x){
        for(int i = 0; i < num; i++)
            if(que[i] == x)
                return i; //탐색 성공
        return -1; //탐색 실패
    }

    public void clear(){
        num = 0;
    }

    //배열 용량
    public int capacity(){
        return max;
    }

    //큐의 길이
    public int size(){
        return num;
    }

    //큐 empty 확인
    public boolean isEmpty(){
        return num <= 0;
    }

    //큐 full 확인
    public boolean isFull(){
        return num >= max;
    }

    public void dump(){
        if(num <= 0)
            System.out.println("해당 스택은 비어 있습니다.");
        else{
            for(int i = 0; i < num; i++)
                System.out.print(que[i] + " ");
            System.out.println();
        }
    }
}
