import java.util.Scanner;
public static void Enemyturn(int turn){
        int countmap[][] = { {0,0,0,0,0},
                             {0,0,0,0,0},
                             {0,0,0,0,0},
                             {0,0,0,0,0},
                             {0,0,0,0,0}};
        int CountRangeY, CountRangeX;
        Scanner sc = new Scanner(System.in);
        int i,j;
        System.err.print("敵の攻撃位置x座標: ");
        i = sc.nextInt();
        System.err.print("敵の攻撃位置y座標: ");
        j = sc.nextInt();
        System.out.println( i + "," + j );
        int CornerAttack = 0;
        if(i = 0 && j = 0){
            CornerAttack += 1;
        }
        if(i = 4 && j = 4){
            CornerAttack += 1;
        }

        CountRangeY = j;
        CountRangeX = i;
        /*魚雷の周囲３＊３マスをカウント*/
        for(CountRangeY = j-1; CountRangeY <= j+1; CountRangeY++){
            for (CountRangeX = i-1;CountRangeX <= i+1; CountRangeX++) {
                /*マップ外を除外*/
                if(CountRangeX >= 0 && CountRangeY >= 0 && CountRangeX<= 4 && CountRangeY <= 4){
                    countmap[CountRangeY][CountRangeX] += 1;
                }
                if(CountRangeY = x1 && CountRangeX = y1){
                    System.out.print("波高し");
                }
                if(CountRangeY = x2 && CountRangeX = y2){
                    System.out.print("波高し");
                }
                if(CountRangeY = x3 && CountRangeX = y3){
                    System.out.print("波高し");
                }
                if(CountRangeY = x3 && CountRangeX = y3){
                    System.out.print("波高し");
                }
            }
        }
        /*魚雷着弾位置のカウント０*/
        countmap[j][i] = 0;

        if(j = y1 && i = x1){
            if(map[y1][x1] > 0){System.out.print("命中！");
            map[y1][x1] -= 1;
                if(map[y1][x1] = 0 ){
                    System.out.print("撃沈！")
                }
            }
        }else if(j = y2 && i = x2){
            if(map[y2][x2] > 0){System.out.print("命中！");
            map[y2][x2] -= 1;
                if(map[y2][x2] = 0 ){
                    System.out.print("撃沈！")
                }
            }
        }else if(j = y3 && i = x3){
            if(map[y3][x3] > 0){System.out.print("命中！");
            map[y3][x3] -= 1;
                if(map[y3][x3] = 0 ){
                    System.out.print("撃沈！")
                }
            }
        }else if(j = y4 && i = x4){
            if(map[y4][x4] > 0){System.out.print("命中！");
            map[y4][x4] -= 1;
                if(map[y4][x4] = 0 ){
                    System.out.print("撃沈！")
                }
            }
        }
        /*命中、撃沈したかどうか*/
        turn += 1;
        if( ship1 = 0 && ship2 = 0 && ship3 = 0 && ship4 = 0){
                turn = 0;
        }
}
