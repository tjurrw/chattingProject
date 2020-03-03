import java.util.Scanner;

public class C010 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        int distance = sc.nextInt();

        int shadeOfTree = sc.nextInt();

        int[] shadeLocationX = new int[shadeOfTree];
        int[] shadeLocationY = new int[shadeOfTree];
        String[] judgeLocation = new String[shadeOfTree];
        for(int i = 0; i < shadeOfTree; i++){
            shadeLocationX[i] = sc.nextInt();
            shadeLocationY[i] = sc.nextInt();
            if((Math.pow((shadeLocationX[i] - x), 2) + Math.pow((shadeLocationY[i]) - y, 2)) >= Math.pow(distance, 2)){
                judgeLocation[i] = "silent";
            }  else {
                judgeLocation[i] = "noisy";
            }
        }

        for(int i = 0; i < shadeOfTree; i++){
            System.out.println(judgeLocation[i]);
        }
    }
}