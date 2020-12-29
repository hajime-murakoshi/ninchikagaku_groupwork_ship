import java.util.Scanner;
import java.util.Random;

class sub_2e{
    public static void main(String[] args) {
        int map[][] =      { {3,0,0,0,0},
        {0,0,0,3,0},
        {0,3,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,3}};
        int countmap[][] = { {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0},
        {0,0,0,0,0}};
        int x,y;
        int MaxCountEnemy;
        int ExistRange = 0;
        int Ship1,Ship2,Ship3,Ship4;/*自分の艦の位置を示す*/
        int y1,x1,y2,x2,y3,x3,y4,x4;
        int MinCountEnemy = 0;
        int MoveRangeX = 0;
        int MoveRangeY = 0;
        int YMinCount = 10;
        int XMinCount = 10;
        int XMinMass = 0;
        int YMinMass = 0;
        int BeforeShip,AfterShip;
        int moveship = 0;
        int CornerAttack1 = 0;
        int CornerAttack4 = 0;/*使う変数の宣言*/

        y1 = 0;
        x1 = 0;
        y2 = 2;
        x2 = 1;
        y3 = 1;
        x3 = 3;
        y4 = 4;
        x4 = 4;
        Ship1 = map[y1][x1];
        Ship2 = map[y2][x2];
        Ship3 = map[y3][x3];
        Ship4 = map[y4][x4];
        Scanner turn = new Scanner(System.in);
        int t;
        int TurnCount = 0;
        System.err.print("先攻【m:1】or【e:2】: ");
        t = turn.nextInt();
        if(t == 1){
            TurnCount += 1;
        }
        while(true){
            if(TurnCount % 2 == 1){
                System.out.println("myturn");
                MaxCountEnemy = 0;
                int MaxEnemy = 0;
                /*敵の最大カウントの数と最大カウントの値を調べる*/
                for( y = 0; y < 5; y++) {
                    for( x = 0; x < 5; x++) {
                        if( countmap[y][x] > MaxEnemy ) {
                            MaxEnemy = countmap[y][x];
                            MaxCountEnemy = 1;
                        } else if(countmap[y][x] == MaxEnemy){
                            MaxCountEnemy += 1;
                        }
                    }
                }
                int k,l;
                int RangeY,RangeX;
                int EnemyY = 100;
                int EnemyX = 100;
                int EY = 100;
                int EX = 100;
                /*敵の最大カウントの数が１の時*/
                if(MaxCountEnemy == 1){
                    /*敵の最大カウントのある座標を調べる*/
                    for( l = 0; l < 5; l++) {
                        for( k = 0; k < 5; k++) {
                            if(MaxEnemy == countmap[l][k]){
                                EY = l;
                                EX = k;
                            }
                        }
                    }
                    EnemyY = EY;
                    EnemyX = EX;
                    /*自分の艦の周囲３＊３マスに敵の最大カウントの座標があるか調べる*/
                    for(RangeY = y1-1; RangeY <= y1+1; RangeY++){
                        for (RangeX = x1-1;RangeX <= x1+1; RangeX++) {
                            if(EnemyY == RangeY && EnemyX == RangeX) {
                                ExistRange = 1;
                            }
                        }
                    }
                    for(RangeY = y2-1; RangeY <= y2+1; RangeY++){
                        for (RangeX = x2-1;RangeX <= x2+1; RangeX++) {
                            if(EnemyY == RangeY && EnemyX == RangeX) {
                                ExistRange = 1;
                            }
                        }
                    }
                    for(RangeY = y3-1; RangeY <= y3+1; RangeY++){
                        for (RangeX = x3-1;RangeX <= x3+1; RangeX++) {
                            if(EnemyY == RangeY && EnemyX == RangeX) {
                                ExistRange = 1;
                            }
                        }
                    }
                    for(RangeY = y4-1; RangeY <= y4+1; RangeY++){
                        for (RangeX = x4-1;RangeX <= x4+1; RangeX++) {
                            if(EnemyY == RangeY && EnemyX == RangeX) {
                                ExistRange = 1;
                            }
                        }
                    }
                    /*自分の艦と同じ位置に敵の最大カウントの座標がある場合を除外*/
                    if(EnemyY == y1 && EnemyX == x1){
                        ExistRange = 0;
                    }
                    if(EnemyY == y2 && EnemyX == x2){
                        ExistRange = 0;
                    }
                    if(EnemyY == y3 && EnemyX == x3){
                        ExistRange = 0;
                    }
                    if(EnemyY == y4 && EnemyX == x4){
                        ExistRange = 0;
                    }
                }
                if (MaxCountEnemy == 1 && ExistRange == 1){
                    /*attack*/

                    System.out.println(EnemyY + "," + EnemyX + "に攻撃");

                } else if (CornerAttack1 == 1){
                    /*ship1 corner attack*/
                    Random RA1 = new Random();
                    int RandomAttack1 = RA1.nextInt(3);
                    if (RandomAttack1 == 1) {
                        System.out.println("0,1に攻撃");
                    } else if (RandomAttack1 == 2) {
                        System.out.println("1,0に攻撃");
                    } else
                    System.out.println("1,1に攻撃");
                    CornerAttack1 = 0;

                } else if (CornerAttack4 == 1){
                    /*ship4 corner attack*/
                    Random RA4 = new Random();
                    int RandomAttack4 = RA4.nextInt(3);
                    if (RandomAttack4 == 1) {
                        System.out.println("3,3に攻撃");
                    } else if (RandomAttack4 == 2) {
                        System.out.println("3,4に攻撃");
                    } else
                    System.out.println("4,3に攻撃");
                    CornerAttack4 = 0;

                } else{
                    /*move*/
                    System.out.print("move:");
                    Random random = new Random();
                    int num = random.nextInt(100);
                    System.out.println("乱数表示：" + num); /*乱数作成・表示*/

                    if (0 <= num && num <= 49) {
                        moveship = 2;
                    }
                    if (num >=50 && num <= 99) {
                        moveship = 3;
                    }/*ランダムで船を一つ選ぶ*/

                    if (moveship == 2) {/*Ship2の場合*/

                        for(MoveRangeY = y2-2; MoveRangeY <= y2+2; MoveRangeY++){
                            if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y2){
                                if(countmap[MoveRangeY][x2] <= YMinCount){
                                    YMinCount = countmap[MoveRangeY][x2];
                                    YMinMass = MoveRangeY;
                                }
                            }

                            if (MoveRangeY == -1 && MoveRangeY == -2 && MoveRangeY == 5 && MoveRangeY == 6 && MoveRangeY == x2 && countmap[MoveRangeY][x2] > YMinCount){
                                MoveRangeY = MoveRangeY + 1;
                            }
                        }  /*上下の4マスの中で一番カウントの小さいところを見つける*/


                        for(MoveRangeX = x2-2; MoveRangeX <= x2+2; MoveRangeX++){

                            if(MoveRangeX >= 0 && MoveRangeX <=4 && MoveRangeX != x2){
                                if(countmap[y2][MoveRangeX] <= XMinCount){
                                    XMinCount = countmap[y2][MoveRangeX];
                                    XMinMass = MoveRangeX;
                                }
                            }

                            if (MoveRangeX == -1 && MoveRangeX == -2 && MoveRangeX == 5 && MoveRangeX == 6 && MoveRangeX == x2 && countmap[y2][MoveRangeX] > XMinCount){
                                MoveRangeX = MoveRangeX + 1;
                            }

                        }  /*左右の4マスの中で一番カウントの小さいところを見つける*/

                        if (YMinCount < XMinCount) {
                            BeforeShip = map[y2][x2];
                            AfterShip = YMinCount;
                            map[YMinMass][x2] = BeforeShip;
                            map[y2][x2] = AfterShip;
                            Ship2 = AfterShip;
                            System.out.println("Ship2: y = "+ YMinMass +",x = "+ x2 +"に移動しました");/*移動したことを報告する*/
                        } else {
                            BeforeShip = map[y2][x2];
                            AfterShip = XMinCount;
                            map[y2][XMinMass] = BeforeShip;
                            map[y2][x2] = AfterShip;
                            Ship2 = AfterShip;
                            System.out.println("Ship2: y = "+ y2 +",x = "+ XMinMass +"に移動しました");/*移動したことを報告する*/
                        }/*カウントが一番小さいところに移動*/
                    }

                    if (moveship == 3) {/*Ship3の場合*/

                        for(MoveRangeY = y3-2; MoveRangeY <= y3+2; MoveRangeY++){
                            if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y3){
                                if(countmap[MoveRangeY][x2] <= YMinCount){
                                    YMinCount = countmap[MoveRangeY][x2];
                                    YMinMass = MoveRangeY;
                                }
                            }

                            if (MoveRangeY == -1 && MoveRangeY == -2 && MoveRangeY == 5 && MoveRangeY == 6 && MoveRangeY == x3 && countmap[MoveRangeY][x3] > YMinCount){
                                MoveRangeY = MoveRangeY + 1;
                            }
                        }  /*上下の4マスの中で一番カウントの小さいところを見つける*/



                        for(MoveRangeX = x3-2; MoveRangeX <= x3+2; MoveRangeX++){

                            if(MoveRangeX >= 0 && MoveRangeX <=4 && MoveRangeX != x3){
                                if(countmap[y3][MoveRangeX] <= XMinCount){
                                    XMinCount = countmap[y3][MoveRangeX];
                                    XMinMass = MoveRangeX;
                                }
                            }

                            if (MoveRangeX == -1 && MoveRangeX == -2 && MoveRangeX == 5 && MoveRangeX == 6 && MoveRangeX == x3 && countmap[y3][MoveRangeX] > XMinCount){
                                MoveRangeX = MoveRangeX + 1;
                            }

                        }  /*左右の4マスの中で一番カウントの小さいところを見つける*/

                        if (YMinCount < XMinCount) {
                            BeforeShip = map[y3][x3];
                            AfterShip = YMinCount;
                            map[YMinMass][x3] = BeforeShip;
                            map[y3][x3] = AfterShip;
                            Ship3 = AfterShip;
                            System.out.println("Ship3: y = "+ YMinMass +",x = "+ x2 +"に移動しました");/*移動したことを報告する*/
                        } else {
                            BeforeShip = map[y3][x3];
                            AfterShip = XMinCount;
                            map[y3][XMinMass] = BeforeShip;
                            map[y3][x3] = AfterShip;
                            Ship3 = AfterShip;
                            System.out.println("Ship3: y = " + y2 +",x = "+XMinMass+"に移動しました");/*移動したことを報告する*/
                        }

                    }
                    TurnCount += 1;
                    System.out.print("\n");
                }
            }
            if(TurnCount % 2 == 0){
                System.out.println("enemyturn");
                int CountRangeY, CountRangeX;
                Scanner sc = new Scanner(System.in);
                int EnemyAction;
                System.err.print("敵の行動(0:移動,1:攻撃)");
                EnemyAction = sc.nextInt();
                if(EnemyAction == 0){
                    TurnCount +=1;
                }else{
                    /*敵の行動を確認する*/
                    int i,j;
                    System.err.print("敵の攻撃位置y座標: ");
                    j = sc.nextInt();
                    System.err.print("敵の攻撃位置x座標: ");
                    i = sc.nextInt();
                    System.out.println( j + "," + i );


                    CountRangeY = j;
                    CountRangeX = i;
                    /*魚雷の周囲３＊３マスをカウント*/

                    /*敵が移動した場合はj,iにそれぞれ100を代入し、ターンを返す。*/
                    if(j == y1 && i == x1){
                        if(map[y1][x1] > 0){
                            System.out.print("命中！");
                            map[y1][x1] -= 1;
                            CornerAttack1 = 1;
                            if(map[y1][x1] == 0 ){
                                System.out.print("撃沈！");
                                CornerAttack1 = 0;
                            }
                        }
                    }else if(j == y2 && i == x2){
                        if(map[y2][x2] > 0){
                            System.out.print("命中！");
                            map[y2][x2] -= 1;
                            if(map[y2][x2] == 0 ){
                                System.out.print("撃沈！");
                            }
                        }
                    }else if(j == y3 && i == x3){
                        if(map[y3][x3] > 0){
                            System.out.print("命中！");
                            map[y3][x3] -= 1;
                            if(map[y3][x3] == 0 ){
                                System.out.print("撃沈！");
                            }
                        }
                    }else if(j == y4 && i == x4){
                        if(map[y4][x4] > 0){
                            System.out.print("命中！");
                            map[y4][x4] -= 1;
                            CornerAttack4 = 1;
                            if(map[y4][x4] == 0 ){
                                System.out.print("撃沈！");
                                CornerAttack4 = 0;
                            }
                        }
                    }
                    for(CountRangeY = j-1; CountRangeY <= j+1; CountRangeY++){
                        for (CountRangeX = i-1;CountRangeX <= i+1; CountRangeX++){
                            /*マップ外を除外*/
                            if(CountRangeX >= 0 && CountRangeY >= 0 && CountRangeX<= 4 && CountRangeY <= 4){
                                countmap[CountRangeY][CountRangeX] += 1;
                            }
                            if(CountRangeY == x1 && CountRangeX == y1){
                                System.out.print("波高し");
                            }
                            if(CountRangeY == x2 && CountRangeX == y2){
                                System.out.print("波高し");
                            }
                            if(CountRangeY == x3 && CountRangeX == y3){
                                System.out.print("波高し");
                            }
                            if(CountRangeY == x3 && CountRangeX == y3){
                                System.out.print("波高し");
                            }
                        }
                    }
                    /*魚雷着弾位置のカウント０*/
                    countmap[j][i] = 0;

                    TurnCount += 1;
                    System.out.print("\n");
                }
            }
        }
    }
}
