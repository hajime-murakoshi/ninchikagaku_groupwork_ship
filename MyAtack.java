import java.util.Scanner;

class MyAtack {
    public static void main(String[] args) {
        int countmap[][] = { {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0}};
        int MyAction;
        int CountMyRangeY;
        int CountMyRangeX;
        int EnemyY;
        int EnemyX;
        Scanner sc = new Scanner(System.in);
        System.err.print("EnemyY:");
        EnemyY = sc.nextInt();
        System.err.print("EnemyX:");
        EnemyX = sc.nextInt();
        System.err.print("攻撃の結果(命中:0,波高:1,無反応:2,撃沈:3):");
        MyAction = sc.nextInt();
        if(MyAction == 0){
            countmap[EnemyY][EnemyX] += 2;
            System.err.print(countmap[EnemyY][EnemyX]);
            /*命中した場合、着弾地点のカウントを2上げる。*/
        } else if (MyAction == 1){
            /*波高しのとき、着弾地点のカウントを０に、着弾地点の周囲を+1する。*/
            CountMyRangeY = EnemyY;
            CountMyRangeX = EnemyX;
            for(CountMyRangeY = EnemyY-1; CountMyRangeY <= EnemyY+1; CountMyRangeY++){
                for (CountMyRangeX = EnemyX-1;CountMyRangeX <= EnemyX+1; CountMyRangeX++){
                    /*マップ外を除外*/
                    if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                        countmap[CountMyRangeY][CountMyRangeX] += 1;
                    }
                }

            }
            countmap[EnemyY][EnemyX] = 0;
        } else if (MyAction == 2){
            CountMyRangeY = EnemyY;
            CountMyRangeX = EnemyX;
            for(CountMyRangeY = EnemyY-1; CountMyRangeY <= EnemyY+1; CountMyRangeY++){
                for (CountMyRangeX = EnemyX-1;CountMyRangeX <= EnemyX+1; CountMyRangeX++){
                    /*マップ外を除外*/
                    if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                        countmap[CountMyRangeY][CountMyRangeX] = 0;
                    }
                    /*無反応の時は、着弾地点とその周囲のカウントを0にする。*/
                }
            }
        } else if (MyAction == 3){
            countmap[EnemyY][EnemyX] = 0;
        }
    }
}
