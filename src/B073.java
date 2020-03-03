import java.util.Scanner;

public class B073 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int countTree = sc.nextInt(); //木の数
        int bulbCount = sc.nextInt(); //電球の平均数（安全個数）

        //各々の木に与える電球の数
        int[] arrayTree = new int[countTree];
        for (int i = 0; i < countTree; i++) {
            arrayTree[i] = sc.nextInt();
        }

        int exaSection = sc.nextInt(); //調査する区間の数
        for (int i = 0; i < exaSection; i++) {
            int startSection = sc.nextInt();
            int endSection = sc.nextInt();

            //安全個数に必要な電球の数
            int needToBulb = needBulb(arrayTree, bulbCount, startSection, endSection);

            if (needToBulb > 0) {
                for (int j = (startSection - 1); j < endSection; j++) {
                    arrayTree[j] += needToBulb;
                }
            }
        }

        //木の配列出力
        for (int i = 0; i < arrayTree.length; i++) {
            System.out.print(arrayTree[i]);
            if (i < arrayTree.length - 1) {
                System.out.print(" ");
            }
        }
    }

    //安全個数の平均を補う電球数を返還するメソット
    static int needBulb(int[] arrayTree, int bulbCount, int startSection, int endSection) {
        int allBulb = 0;
        int avg;
        int needToSafetyBulb;

        for (int i = (startSection - 1); i < endSection; i++) {
            allBulb += arrayTree[i];
        }

        avg = allBulb / ((endSection - startSection) + 1);

        if (bulbCount > avg) {
            needToSafetyBulb = bulbCount - avg;
        } else {
            needToSafetyBulb = 0;
        }

        return needToSafetyBulb;
    }
}