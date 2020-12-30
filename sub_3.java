
import java.util.Scanner;
import java.util.Random;

class sub_3{
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
    int MoveRangeY = 0;
    int YMinCount = 10;
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
        /*角以外の自分の艦の数を調べる*/
        int q,r;
        int CountInsideShip = 0;
        if (map[0][0] > 0){
          CountInsideShip -= 1;
        }
        if (map[4][4] > 0){
          CountInsideShip -= 1;
        }
        for (r = 0; r <= 4; r++){
          for (q = 0; q <=4 ;q++ ) {
            if (map[r][q] > 0){
              CountInsideShip += 1;
            }
          }
        }
        /*角以外に艦が残っている場合*/
        if (CountInsideShip > 0) {
          if (MaxCountEnemy == 1 && ExistRange == 1){
            /*attack*/
            System.out.println(EnemyY + "," + EnemyX + "に攻撃");
            int MyAction;
            int CountMyRangeX;
            int CountMyRangeY;
            Scanner sc = new Scanner(System.in);
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

          } else if (CornerAttack1 == 1){
            int C1AtackY;
            int C1AtackX;
            int CountMyRangeX;
            int CountMyRangeY;
            int MyAction;
            /*ship1 corner attack*/
            Random RA1 = new Random();
            int RandomAttack1 = RA1.nextInt(3);
            if (RandomAttack1 == 1) {
              System.out.println("0,1に攻撃");
              C1AtackY = 0;
              C1AtackX = 1;
            } else if (RandomAttack1 == 2) {
              System.out.println("1,0に攻撃");
              C1AtackY = 1;
              C1AtackX = 0;
            } else {
              System.out.println("1,1に攻撃");
              C1AtackY = 1;
              C1AtackX = 1;
            }
            CornerAttack1 = 0;
            Scanner sc = new Scanner(System.in);
            System.err.print("攻撃の結果(命中:0,波高:1,無反応:2,撃沈:3):");
            MyAction = sc.nextInt();
            if(MyAction == 0){
              countmap[C1AtackY][C1AtackX] += 2;
              System.err.print(countmap[C1AtackY][C1AtackX]);
              /*命中した場合、着弾地点のカウントを2上げる。*/
            } else if (MyAction == 1){
              /*波高しのとき、着弾地点のカウントを０に、着弾地点の周囲を+1する。*/
              CountMyRangeY = C1AtackY;
              CountMyRangeX = C1AtackX;
              for(CountMyRangeY = C1AtackY-1; CountMyRangeY <= C1AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C1AtackX-1;CountMyRangeX <= C1AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] += 1;
                  }
                }

              }
              countmap[C1AtackY][C1AtackX] = 0;
            } else if (MyAction == 2){
              CountMyRangeY = C1AtackY;
              CountMyRangeX = C1AtackX;
              for(CountMyRangeY = C1AtackY-1; CountMyRangeY <= C1AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C1AtackX-1;CountMyRangeX <= C1AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] = 0;
                  }
                  /*無反応の時は、着弾地点とその周囲のカウントを0にする。*/
                }
              }
            } else if (MyAction == 3){
              countmap[C1AtackY][C1AtackX] = 0;
            }

          } else if (CornerAttack4 == 1){
            int C4AtackY;
            int C4AtackX;
            int CountMyRangeX;
            int CountMyRangeY;
            int MyAction;
            /*ship4 corner attack*/
            Random RA4 = new Random();
            int RandomAttack4 = RA4.nextInt(3);
            if (RandomAttack4 == 1) {
              System.out.println("3,3に攻撃");
              C4AtackY = 3;
              C4AtackX = 3;
            } else if (RandomAttack4 == 2) {
              System.out.println("3,4に攻撃");
              C4AtackY = 3;
              C4AtackX = 4;
            } else {
              System.out.println("4,3に攻撃");
              C4AtackY = 4;
              C4AtackX = 3;
            }
            CornerAttack4 = 0;
            Scanner sc = new Scanner(System.in);
            System.err.print("攻撃の結果(命中:0,波高:1,無反応:2,撃沈:3):");
            MyAction = sc.nextInt();
            if(MyAction == 0){
              countmap[C4AtackY][C4AtackX] += 2;
              System.err.print(countmap[C4AtackY][C4AtackX]);
              /*命中した場合、着弾地点のカウントを2上げる。*/
            } else if (MyAction == 1){
              /*波高しのとき、着弾地点のカウントを０に、着弾地点の周囲を+1する。*/
              CountMyRangeY = C4AtackY;
              CountMyRangeX = C4AtackX;
              for(CountMyRangeY = C4AtackY-1; CountMyRangeY <= C4AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C4AtackX-1;CountMyRangeX <= C4AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] += 1;
                  }
                }

              }
              countmap[C4AtackY][C4AtackX] = 0;
            } else if (MyAction == 2){
              CountMyRangeY = C4AtackY;
              CountMyRangeX = C4AtackX;
              for(CountMyRangeY = C4AtackY-1; CountMyRangeY <= C4AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C4AtackX-1;CountMyRangeX <= C4AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] = 0;
                  }
                  /*無反応の時は、着弾地点とその周囲のカウントを0にする。*/
                }
              }
            } else if (MyAction == 3){
              countmap[C4AtackY][C4AtackX] = 0;
            }
          } else{
            /*move*/
            System.out.print("move:");
            Random random = new Random();
            int num = random.nextInt(100);
            System.out.println("乱数表示：" + num); /*乱数作成・表示*/

            if (map[y2][x2] == 0){
              moveship = 3;
            } else if (map[y3][x3] == 0){
              moveship = 2;
            } else {
              if (0 <= num && num <= 49) {
                moveship = 2;
              }
              if (num >=50 && num <= 99) {
                moveship = 3;
              }/*ランダムで船を一つ選ぶ*/
            }
            if (moveship == 2) {/*Ship2の場合*/

              for(MoveRangeY = y2-2; MoveRangeY <= y2+2; MoveRangeY++){
                if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y2){
                  if(countmap[MoveRangeY][x2] <= YMinCount){
                    YMinCount = countmap[MoveRangeY][x2];
                    YMinMass = MoveRangeY;
                  }
                  if (countmap[MoveRangeY][x2] > YMinCount) {
                    MoveRangeY = MoveRangeY;
                  }
                }
                if (MoveRangeY == y2) {
                  MoveRangeY = MoveRangeY;
                }
                if (MoveRangeY == -1 || MoveRangeY == -2 || MoveRangeY == 5 || MoveRangeY == 6){
                  MoveRangeY = MoveRangeY;
                }
              }
              /*上下の4マスの中で一番カウントの小さいところを見つける*/

              BeforeShip = map[y2][x2];
              AfterShip = YMinCount;
              map[YMinMass][x2] = BeforeShip;
              map[y2][x2] = AfterShip;
              if (y2 - YMinMass <= 0) {
                System.out.println("Ship2: y = "+ YMinMass +",x = "+ x2 +"に移動しました" + "（下に" + Math.abs(y2 - YMinMass) + "移動しました）");
              }
              if (y2 - YMinMass > 0) {
                System.out.println("Ship2: y = "+ YMinMass +",x = "+ x2 +"に移動しました" + "（上に" + Math.abs(y2 - YMinMass) + "移動しました）");
              }
              y2 = YMinMass;
            }
            /*移動したことを報告する*/

            if (moveship == 3) {/*Ship3の場合*/

              for(MoveRangeY = y3-2; MoveRangeY <= y3+2; MoveRangeY++){
                if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y3){
                  if(countmap[MoveRangeY][x3] <= YMinCount){
                    YMinCount = countmap[MoveRangeY][x3];
                    YMinMass = MoveRangeY;
                  }
                  if (countmap[MoveRangeY][x3] > YMinCount) {
                    MoveRangeY = MoveRangeY;
                  }
                }
                if (MoveRangeY == y3 ) {
                  MoveRangeY = MoveRangeY;
                }

                if (MoveRangeY == -1 || MoveRangeY == -2 || MoveRangeY == 5 || MoveRangeY == 6){
                  MoveRangeY = MoveRangeY;
                }
              }  /*上下の4マスの中で一番カウントの小さいところを見つける*/

              BeforeShip = map[y3][x3];
              AfterShip = YMinCount;
              map[YMinMass][x3] = BeforeShip;
              map[y3][x3] = AfterShip;
              if (y3 - YMinMass <= 0) {
                System.out.println("Ship3: y = "+ YMinMass +",x = "+ x3 +"に移動しました" + "（下に" + Math.abs(y3 - YMinMass) + "移動しました）");
              }
              if (y3 - YMinMass > 0) {
                System.out.println("Ship3: y = "+ YMinMass +",x = "+ x3 +"に移動しました" + "（上に" + Math.abs(y3 - YMinMass) + "移動しました）");
              }
              y3 = YMinMass;/*移動したことを報告する*/
            }
          }/*自分の艦が角のみの時*/
        } else {
          if (MaxCountEnemy == 1 && ExistRange == 1){
            /*attack*/
            System.out.println(EnemyY + "," + EnemyX + "に攻撃");
            int MyAction;
            int CountMyRangeX;
            int CountMyRangeY;
            Scanner sc = new Scanner(System.in);
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

          } else if (CornerAttack1 == 1){
            int C1AtackY;
            int C1AtackX;
            int CountMyRangeX;
            int CountMyRangeY;
            int MyAction;
            /*ship1 corner attack*/
            Random RA1 = new Random();
            int RandomAttack1 = RA1.nextInt(3);
            if (RandomAttack1 == 1) {
              System.out.println("0,1に攻撃");
              C1AtackY = 0;
              C1AtackX = 1;
            } else if (RandomAttack1 == 2) {
              System.out.println("1,0に攻撃");
              C1AtackY = 1;
              C1AtackX = 0;
            } else {
              System.out.println("1,1に攻撃");
              C1AtackY = 1;
              C1AtackX = 1;
            }
            CornerAttack1 = 0;
            Scanner sc = new Scanner(System.in);
            System.err.print("攻撃の結果(命中:0,波高:1,無反応:2,撃沈:3):");
            MyAction = sc.nextInt();
            if(MyAction == 0){
              countmap[C1AtackY][C1AtackX] += 2;
              System.err.print(countmap[C1AtackY][C1AtackX]);
              /*命中した場合、着弾地点のカウントを2上げる。*/
            } else if (MyAction == 1){
              /*波高しのとき、着弾地点のカウントを０に、着弾地点の周囲を+1する。*/
              CountMyRangeY = C1AtackY;
              CountMyRangeX = C1AtackX;
              for(CountMyRangeY = C1AtackY-1; CountMyRangeY <= C1AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C1AtackX-1;CountMyRangeX <= C1AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] += 1;
                  }
                }

              }
              countmap[C1AtackY][C1AtackX] = 0;
            } else if (MyAction == 2){
              CountMyRangeY = C1AtackY;
              CountMyRangeX = C1AtackX;
              for(CountMyRangeY = C1AtackY-1; CountMyRangeY <= C1AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C1AtackX-1;CountMyRangeX <= C1AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] = 0;
                  }
                  /*無反応の時は、着弾地点とその周囲のカウントを0にする。*/
                }
              }
            } else if (MyAction == 3){
              countmap[C1AtackY][C1AtackX] = 0;
            }

          } else if (CornerAttack4 == 1){
            int C4AtackY;
            int C4AtackX;
            int CountMyRangeX;
            int CountMyRangeY;
            int MyAction;
            /*ship4 corner attack*/
            Random RA4 = new Random();
            int RandomAttack4 = RA4.nextInt(3);
            if (RandomAttack4 == 1) {
              System.out.println("3,3に攻撃");
              C4AtackY = 3;
              C4AtackX = 3;
            } else if (RandomAttack4 == 2) {
              System.out.println("3,4に攻撃");
              C4AtackY = 3;
              C4AtackX = 4;
            } else {
              System.out.println("4,3に攻撃");
              C4AtackY = 4;
              C4AtackX = 3;
            }
            CornerAttack4 = 0;
            Scanner sc = new Scanner(System.in);
            System.err.print("攻撃の結果(命中:0,波高:1,無反応:2,撃沈:3):");
            MyAction = sc.nextInt();
            if(MyAction == 0){
              countmap[C4AtackY][C4AtackX] += 2;
              System.err.print(countmap[C4AtackY][C4AtackX]);
              /*命中した場合、着弾地点のカウントを2上げる。*/
            } else if (MyAction == 1){
              /*波高しのとき、着弾地点のカウントを０に、着弾地点の周囲を+1する。*/
              CountMyRangeY = C4AtackY;
              CountMyRangeX = C4AtackX;
              for(CountMyRangeY = C4AtackY-1; CountMyRangeY <= C4AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C4AtackX-1;CountMyRangeX <= C4AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] += 1;
                  }
                }

              }
              countmap[C4AtackY][C4AtackX] = 0;
            } else if (MyAction == 2){
              CountMyRangeY = C4AtackY;
              CountMyRangeX = C4AtackX;
              for(CountMyRangeY = C4AtackY-1; CountMyRangeY <= C4AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C4AtackX-1;CountMyRangeX <= C4AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] = 0;
                  }
                  /*無反応の時は、着弾地点とその周囲のカウントを0にする。*/
                }
              }
            } else if (MyAction == 3){
              countmap[C4AtackY][C4AtackX] = 0;
            }
          } else {
            int C34AtackY;
            int C34AtackX;
            int CountMyRangeX;
            int CountMyRangeY;
            int MyAction;
            /*ship4 corner attack*/
            Random RA34 = new Random();
            int RandomAttack34 = RA34.nextInt(6);
            if (RandomAttack34 == 1) {
              System.out.println("0,1に攻撃");
              C34AtackY = 0;
              C34AtackX = 1;
            } else if (RandomAttack34 == 2) {
              System.out.println("1,0に攻撃");
              C34AtackY = 1;
              C34AtackX = 0;
            } else if (RandomAttack34 == 3) {
              System.out.println("1,1に攻撃");
              C34AtackY = 1;
              C34AtackX = 1;
            }else if (RandomAttack34 == 4) {
              System.out.println("3,3に攻撃");
              C34AtackY = 3;
              C34AtackX = 3;
            } else if (RandomAttack34 == 5) {
              System.out.println("3,4に攻撃");
              C34AtackY = 3;
              C34AtackX = 4;
            } else {
              System.out.println("4,3に攻撃");
              C34AtackY = 4;
              C34AtackX = 3;
            }
            Scanner sc = new Scanner(System.in);
            System.err.print("攻撃の結果(命中:0,波高:1,無反応:2,撃沈:3):");
            MyAction = sc.nextInt();
            if(MyAction == 0){
              countmap[C34AtackY][C34AtackX] += 2;
              System.err.print(countmap[C34AtackY][C34AtackX]);
              /*命中した場合、着弾地点のカウントを2上げる。*/
            } else if (MyAction == 1){
              /*波高しのとき、着弾地点のカウントを０に、着弾地点の周囲を+1する。*/
              CountMyRangeY = C34AtackY;
              CountMyRangeX = C34AtackX;
              for(CountMyRangeY = C34AtackY-1; CountMyRangeY <= C34AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C34AtackX-1;CountMyRangeX <= C34AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] += 1;
                  }
                }

              }
              countmap[C34AtackY][C34AtackX] = 0;
            } else if (MyAction == 2){
              CountMyRangeY = C34AtackY;
              CountMyRangeX = C34AtackX;
              for(CountMyRangeY = C34AtackY-1; CountMyRangeY <= C34AtackY+1; CountMyRangeY++){
                for (CountMyRangeX = C34AtackX-1;CountMyRangeX <= C34AtackX+1; CountMyRangeX++){
                  /*マップ外を除外*/
                  if(CountMyRangeX >= 0 && CountMyRangeY >= 0 && CountMyRangeX<= 4 && CountMyRangeY <= 4){
                    countmap[CountMyRangeY][CountMyRangeX] = 0;
                  }
                  /*無反応の時は、着弾地点とその周囲のカウントを0にする。*/
                }
              }
            } else if (MyAction == 3){
              countmap[C34AtackY][C34AtackX] = 0;
            }
          }
        }
        TurnCount += 1;
        System.out.print("\n");
      }
      if(TurnCount % 2 == 0){
        System.out.println("enemyturn");
        int CountRangeY, CountRangeX;
        Scanner sc = new Scanner(System.in);
        int EnemyAction;
        /*敵の行動を確認する*/
        System.err.print("敵の行動(0:移動,1:攻撃)");
        EnemyAction = sc.nextInt();
        if(EnemyAction == 0){
          TurnCount +=1;
        }else{
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
        }
        System.out.print("\n");
      }
    }
  }
}
