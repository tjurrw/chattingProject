/*

import java.util.Scanner;

public class C072 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int atk = sc.nextInt();
        int def = sc.nextInt();
        int spd = sc.nextInt();

        int countOfEvolMonster = sc.nextInt();

        String[] monsterName = new String[countOfEvolMonster];
        int[] min_atk = new int[countOfEvolMonster];
        int[] max_atk = new int[countOfEvolMonster];
        int[] min_def = new int[countOfEvolMonster];
        int[] max_def = new int[countOfEvolMonster];
        int[] min_spd = new int[countOfEvolMonster];
        int[] max_spd = new int[countOfEvolMonster];

        for(int i = 0; i < countOfEvolMonster; i++){
            monsterName[i] = sc.next();
            min_atk[i] = sc.nextInt();
            max_atk[i] = sc.nextInt();
            min_def[i] = sc.nextInt();
            max_def[i] = sc.nextInt();
            min_spd[i] = sc.nextInt();
            max_spd[i] = sc.nextInt();
        }
    }

    String statusCalc(int Atk, int Def, int Spd, String name, int minAtk, int maxAtk, int minDef, int maxDef, int minSpd, int maxSpd){
        int atk = Atk;
        int def = Def;

        String mName = name;
        int minatk = minAtk;
        int maxatk = maxAtk;
        int mindef = minDef;
        int maxdef = maxDef;
        int minspd = minSpd;
        int maxspd = maxSpd;

        String returnMsg = "";
    }
}


 */