public class Gstack<E> {
    private int max;
    private int ptr;
    private E[] stk;

    //실행 시 스택이 empty
    public static class EmptyGStackException extends RuntimeException {
        public EmptyGStackException(){}
    }

    //실행 시 스택이 full
    public static class OverflowGStackException extends RuntimeException {
        public OverflowGStackException(){}
    }

    //생성자
    public Gstack(int capacity){
        ptr = 0;
        max = capacity;

        try{
            stk = (E[])new Object[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    //push
    public E push(E x) throws OverflowGStackException{
        if(ptr >= max)
            throw new OverflowGStackException();
        return stk[ptr++] = x;
    }

    //pop
    public E pop() throws EmptyGStackException{
        if(ptr <= 0)
            throw new EmptyGStackException();
        return stk[--ptr];
    }

    //peek
    public E peek() throws EmptyGStackException{
        if(ptr <= 0)
            throw new EmptyGStackException();
        return stk[ptr - 1];
    }

    //탐색
    public int indexOf(E x){
        for(int i = ptr - 1; i >= 0; i--)
            if(stk[i].equals(x))
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
