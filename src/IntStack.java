//int형 스택

public class IntStack {
    private int max; //스택 용량
    private int ptr; //스택 포인터
    private int[] stk; //스택

    //실행 시 스택이 empty
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException(){}
    }

    //실행 시 스택이 full
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException(){}
    }

    //생성자
    public IntStack(int capacity){
        ptr = 0;
        max = capacity;

        try{
            stk = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    //push
    public int push(int x) throws OverflowIntStackException{
        if(ptr >= max)
            throw new OverflowIntStackException();
        return stk[ptr++] = x;
    }

    //pop
    public int pop() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stk[--ptr];
    }

    //peek
    public int peek() throws EmptyIntStackException{
        if(ptr <= 0)
            throw new EmptyIntStackException();
        return stk[ptr - 1];
    }

    //탐색
    public int indexOf(int x){
        for(int i = ptr - 1; i >= 0; i--)
            if(stk[i] == x)
                return i; //탐색 성공
        return -1; //탐색 실패
    }

    //전 요소 삭제
    public void clear(){
        ptr = 0;
    }

    //스택 용량
    public int capacity(){
        return max;
    }

    //배열에 격납된 배열 요소수
    public int size(){
        return ptr;
    }

    //배열 empty 확인
    public boolean isEmpty(){
        return ptr <= 0;
    }

    //배열 full 확인
    public boolean isFull(){
        return ptr >= max;
    }

    //First in 데이터 부터 순서대로 전 요소 표시
    public void dump(){
        if(ptr <= 0)
            System.out.println("해당 스택은 비어 있습니다.");
        else{
            for(int i = 0; i < ptr; i++)
                System.out.print(stk[i] + " ");
            System.out.println();
        }
    }
}