import java.util.Scanner;

public class C071 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int bottomLine = sc.nextInt();
        int height = sc.nextInt();

        int rightAngledTriangleCount = 0;

        for(int i = 1; i <= bottomLine; i++){
            for(int j = 1; j <= height; j++){
                for(int k = 1; k < ((i * i) + (j + j)); k++){
                    if((k * k) == ((i * i) + (j + j))){
                        rightAngledTriangleCount += 1;
                    }
                }
            }
        }
        System.out.println(rightAngledTriangleCount);
    }
}

//