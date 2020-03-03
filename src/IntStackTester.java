import java.util.Scanner;

class IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        DoubleDirectionStack s = new DoubleDirectionStack(10);   // 最大10個プッシュできる両頭スタック

        while (true) {
            System.out.println("現在のデータ数："+
                    "Ａ：" + s.size(DoubleDirectionStack.AorB.stackA) +
                    "Ｂ：" + s.size(DoubleDirectionStack.AorB.stackB));
            System.out.print("(1)Ａにプッシュ (2)Ａからポップ (3)Ａからピーク " +
                    "(4)Ａをダンプ (5)Ａから探索 (6)Ａを空にする\n" +
                    "(7)Ｂにプッシュ (8)Ｂからポップ (9)Ｂからピーク " +
                    "(10)Ｂをダンプ (11)Ｂから探索 (12)Ｂを空にする\n" +
                    "(13)情報表示 (0)終了：");

            int menu = stdIn.nextInt();
            if (menu == 0) break;

            int n, x = 0;
            switch (menu) {
                case 1:                        // Ａにプッシュ
                    System.out.print("データ：");
                    x = stdIn.nextInt();
                    try {
                        s.push(DoubleDirectionStack.AorB.stackA, x);
                    } catch (DoubleDirectionStack.OverflowIntStackException e) {
                        System.out.println("スタックが満杯です。");
                    }
                    break;

                case 2:                         // Ａからポップ
                    try {
                        x = s.pop(DoubleDirectionStack.AorB.stackA);
                        System.out.println("ポップしたデータは" + x + "です。");
                    } catch (DoubleDirectionStack.EmptyIntStackException e) {
                        System.out.println("スタックが空です。");
                    }
                    break;

                case 3:                         // Ａからピーク
                    try {
                        x = s.peek(DoubleDirectionStack.AorB.stackA);
                        System.out.println("ピークしたデータは" + x + "です。");
                    } catch (DoubleDirectionStack.EmptyIntStackException e) {
                        System.out.println("スタックが空です。");
                    }
                    break;

                case 4:                         // Ａをダンプ
                    s.dump(DoubleDirectionStack.AorB.stackA);
                    break;

                case 5:                         // Ａから探索
                    System.out.print("探索するデータ：");
                    x = stdIn.nextInt();
                    n = s.indexOf(DoubleDirectionStack.AorB.stackA, x);
                    if (n >= 0)
                        System.out.println("頂上から" + (s.size(DoubleDirectionStack.AorB.stackA) - n) +"番目に存在します。");
                    else
                        System.out.println("そのデータはありません。");
                    break;

                case 6:                      // 空にする
                    s.clear(DoubleDirectionStack.AorB.stackA);
                    break;

                case 7:                        // Ｂにプッシュ
                    System.out.print("データ：");
                    x = stdIn.nextInt();
                    try {
                        s.push(DoubleDirectionStack.AorB.stackB, x);
                    } catch (DoubleDirectionStack.OverflowIntStackException e) {
                        System.out.println("スタックが満杯です。");
                    }
                    break;

                case 8:                         // Ｂからポップ
                    try {
                        x = s.pop(DoubleDirectionStack.AorB.stackB);
                        System.out.println("ポップしたデータは" + x + "です。");
                    } catch (DoubleDirectionStack.EmptyIntStackException e) {
                        System.out.println("スタックが空です。");
                    }
                    break;

                case 9:                         // Ｂからピーク
                    try {
                        x = s.peek(DoubleDirectionStack.AorB.stackB);
                        System.out.println("ピークしたデータは" + x + "です。");
                    } catch (DoubleDirectionStack.EmptyIntStackException e) {
                        System.out.println("スタックが空です。");
                    }
                    break;

                case 10:                         // Ｂをダンプ
                    s.dump(DoubleDirectionStack.AorB.stackB);
                    break;

                case 11:                         // Ｂから探索
                    System.out.print("探索するデータ：");
                    x = stdIn.nextInt();
                    n = s.indexOf(DoubleDirectionStack.AorB.stackB, x);
                    if (n >= 0)
                        System.out.println("頂上から" + (s.size(DoubleDirectionStack.AorB.stackB) - (s.capacity() - n) + 1) +"番目に存在します。");
                    else
                        System.out.println("そのデータはありません。");
                    break;

                case 12:                      // 空にする
                    s.clear(DoubleDirectionStack.AorB.stackB);
                    break;

                case 13:                      // 情報表示
                    System.out.println("容量：" + s.capacity());
                    System.out.println("Ａのデータ数：" + s.size(DoubleDirectionStack.AorB.stackA));
                    System.out.println("Ｂのデータ数：" + s.size(DoubleDirectionStack.AorB.stackB));
                    System.out.println("Ａは空" + (s.isEmpty(DoubleDirectionStack.AorB.stackA)  ? "です。"
                            : "ではありません。"));
                    System.out.println("Ｂは空" + (s.isEmpty(DoubleDirectionStack.AorB.stackB)  ? "です。"
                            : "ではありません。"));
                    System.out.println("満杯" + (s.isFull() ? "です。"
                            : "ではありません。"));
                    break;
            }
        }
    }
}

