public class DoubleDirectionStack {
    private int max;
    private int ptrA; //순방향 포인터
    private int ptrB; //역방향 포인터
    private int[] stk;

    public enum AorB {stackA, stackB};

    //실행 시 스택이 empty
    public class EmptyIntStackException extends RuntimeException {
        public EmptyIntStackException(){}
    }

    //실행 시 스택이 full
    public class OverflowIntStackException extends RuntimeException {
        public OverflowIntStackException(){}
    }

    //생성자
    public DoubleDirectionStack(int capacity){
        ptrA = 0;
        ptrB = capacity - 1;
        max = capacity;

        try{
            stk = new int[max];
        } catch (OutOfMemoryError e){
            max = 0;
        }
    }

    public int push(AorB sw, int x) throws OverflowIntStackException{
        if(ptrA >= ptrB + 1) //스택이 full 일 경우
            throw new OverflowIntStackException();
        switch(sw){
            case stackA: stk[ptrA++] = x; break;
            case stackB: stk[ptrB--] = x; break;
        }

        return x;
    }

    public int pop(AorB sw) throws EmptyIntStackException{
        int x = 0;
        switch(sw){
            case stackA:
                if(ptrA <= 0)
                    throw new EmptyIntStackException();
                x = stk[--ptrA];
                break;
            case stackB:
                if(ptrB >= max - 1)
                    throw new EmptyIntStackException();
                x = stk[++ptrB];
                break;
        }
        return x;
    }

    //peek
    public int peek(AorB sw) throws EmptyIntStackException{
        int x = 0;
        switch (sw) {
            case stackA:
                if (ptrA <= 0)
                    throw new EmptyIntStackException();
                x = stk[ptrA - 1];
                break;
            case stackB:
                if (ptrB >= max - 1)
                    throw new EmptyIntStackException();
                x = stk[ptrB + 1];
                break;
        }
        return x;
    }

    //탐색
    public int indexOf(AorB sw, int x){
        switch (sw) {
            case stackA:
                for (int i = ptrA - 1; i >= 0; i--)
                    if (stk[i] == x)
                        return i;
                break;
            case stackB:
                for (int i = ptrB + 1; i < max; i++)
                    if (stk[i] == x)
                        return i;
                break;
        }
        return -1;
    }

    //전 요소 삭제
    public void clear(AorB sw){
        switch(sw){
            case stackA:
                ptrA = 0;
                break;
            case stackB:
                ptrB = max - 1;
                break;
        }
    }

    //스택 용량
    public int capacity(){
        return max;
    }

    //배열에 격납된 배열 요소수
    public int size(AorB sw){
        switch(sw){
            case stackA: return ptrA;
            case stackB: return max - ptrB - 1;
        }
        return 0;
    }

    //배열 empty 확인
    public boolean isEmpty(AorB sw){
        switch (sw) {
            case stackA: return ptrA <= 0;
            case stackB: return ptrB >= max - 1;
        }
        return true;
    }

    //배열 full 확인
    public boolean isFull(){
        return ptrA >= ptrB + 1;
    }

    //First in 데이터 부터 순서대로 전 요소 표시
    public void dump(AorB sw){
        switch (sw) {
            case stackA:
                if (ptrA <= 0)
                    System.out.println("スタックは空です。");
                else {
                    for (int i = 0; i < ptrA; i++)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
            case stackB:
                if (ptrB >= max - 1)
                    System.out.println("スタックは空です。");
                else {
                    for (int i = max - 1; i > ptrB; i--)
                        System.out.print(stk[i] + " ");
                    System.out.println();
                }
        }
    }
}