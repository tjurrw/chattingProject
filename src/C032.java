import java.util.Scanner;

public class C032 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int goodsNumber;
        int moneyToPurchase;

        int totalFood = 0;
        int totalBook = 0;
        int totalClothe = 0;
        int totalEtc = 0;

        int totalPoint = 0;

        for(int i = 0; i < n; i++){
            goodsNumber = sc.nextInt();
            moneyToPurchase = sc.nextInt();

            if(goodsNumber == 0){
                totalFood += moneyToPurchase;
            } else if(goodsNumber == 1){
                totalBook += moneyToPurchase;
            } else if(goodsNumber == 2){
                totalClothe += moneyToPurchase;
            } else if(goodsNumber == 3){
                totalEtc += moneyToPurchase;
            }
        }

        int totalFoodPoint = calc(0, totalFood);
        int totalBookPoint = calc(1, totalBook);
        int totalClothePoint = calc(2, totalClothe);
        int totalEtcPoint = calc(3, totalEtc);

        totalPoint = totalFoodPoint + totalBookPoint + totalClothePoint + totalEtcPoint;

        System.out.println(totalPoint);
    }

    static int calc(int a, int b){
        int pointSum = 0;
        int divide = 0;

        if(a == 0){
            divide = (b / 100);
            pointSum += divide * 5;
        } else if(a == 1){
            divide = (b / 100);
            pointSum += divide * 3;
        } else if(a == 2){
            divide = (b / 100);
            pointSum += divide * 2;
        } else if(a == 3){
            divide = (b / 100);
            pointSum += divide * 1;
        }

        return pointSum;
    }
}