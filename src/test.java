public class test {

    public static void main(String[] args) {
        int total = 0;
        for (int i = 1; i < 1000000; i++) {
            if (cal(i) == 7) {
                System.out.println(i);
                total++;
            }

        }
        System.out.println(total);
    }

    public static int cal(int a) {
        // 자릿수가 1이 되면 반환 시작
        if (a < 10) {
            return 0;
        } else {
            int total = 1;
            while (a >= 10) {
                total *= (a % 10);
                a /= 10;
            }

            total *= a;
            return cal(total) + 1;
        }
    }
}