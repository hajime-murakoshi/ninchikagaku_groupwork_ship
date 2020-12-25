import java.io.File;
import java.util.Scanner;

class Myturn{
    if (MaxCountEnemy = 1 && ExistRange == 1){
        /*attack*/

        System.out.println(EnemyY + EnemyX "に攻撃")
    } else if (CornerAttack =1){
        /*corner attack*/

    } else{
        /*move*/

        if (0 <= num && num <= 49) {
            Ship2 = moveship;
        } else {
            Ship3 = moveship;
        }     /*ランダム（５０％）で２つから１つの船を選ぶ*/

        int MinCountEnemy = 0;
    int MoveRangeX,MoveRangeY;
    Random random = new Random();
    int num = random.nextInt(100);
    int moveship,Ship2,Ship3;　・/*使う変数の宣言*/


    if (0 <= num && num <= 49) {
        moveship = Ship2;
    } else {
        moveship = Ship3;
    }　/*ランダムで船を一つ選ぶ*/


    if (moveship = Ship2) {/*Ship2の場合*/

        for(MoveRangeY = y2-2; MoveRangeY <= y2+2; MoveRangeY++){
            if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y2){
                if(countmap[MoveRangeY][x2] < YMinCount){
                    YMinCount = countmap[MoveRangeY][x2];　
                }
            }
        }/*上下の4マスの中で一番カウントの小さいところを見つける*/

        for(MoveRangeX = x2-2; MoveRangeX <= x2+2; MoveRangeX++){
            if(MoveRangeX >= 0 && MoveRangeX <=4 && MoveRangeX != x2){
                if(countmap[y2][MoveRangeX] < XMinCount){
                    XMinCount = countmap[y2][MoveRangeX];
                }
            }
        }/*左右の4マスの中で一番カウントの小さいところを見つける*/


        if (YMinCount < XMinCount) {
            BeforeShip = map[y2][x2];
            AfterShip = YMinCount;
            map[MoveRangeY][x2] = BeforeShip;
            map[y2][x2] = AfterShip;
            Ship2 = AfterShip;
        } else {
            BeforeShip = map[y2][x2];
            AfterShip = XMinCount;
            map[y2][MoveRangeX2] = BeforeShip;
            map[y2][x2] = AfterShip;
            Ship2 = AfterShip;
        }　/*カウントが一番小さいところに移動*/
    }
        
    if (moveship = Ship3) {/*Ship3の場合*/

        for(MoveRangeY = y3-2; MoveRangeY <= y3+2; MoveRangeY++){
            if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y3){
                if(countmap[MoveRangeY][x2] < YMinCount){
                    YMinCount = countmap[MoveRangeY][x2];
                }
            }
        }/*上下の4マスの中で一番カウントの小さいところを見つける*/

            for(MoveRangeX = x3-2; MoveRangeX <= x3+2; MoveRangeX++){
                if(MoveRangeX >= 0 && MoveRangeX <=4 && MoveRangeX != x3){
                    if(countmap[y3][MoveRangeX] < XMinCount){
                        XMinCount = countmap[y3][MoveRangeX];
                    }
                }
            }/*左右の4マスの中で一番カウントの小さいところを見つける*/


                if (YMinCount < XMinCount) {
                    BeforeShip = map[y3][x3];
                    AfterShip = YMinCount;
                    map[MoveRangeY][x3] = BeforeShip;
                    map[y3][x3] = AfterShip;
                    Ship3 = AfterShip;
                } else {
                    BeforeShip = map[y3][x3];
                    AfterShip = XMinCount;
                    map[y3][MoveRangeX] = BeforeShip;
                    map[y3][x3] = AfterShip;
                    Ship3 = AfterShip;
                }
            }
        System.out.println(Ship3 + "に移動しました");/*移動したことを報告する*/
    }
class EnemyTurn{
    int CountRangeY, CountRangeX;
    Scanner sc = new Scanner(System.in);
    int i,j;
    System.err.print("敵の攻撃位置x座標: ");
    i = sc.nextInt();
    System.err.print("敵の攻撃位置y座標: ");
    j = sc.nextInt();
    System.out.println( i + "," + j );

    CountRangeY = j;
    CountRangeX = i;
    /*魚雷の周囲３＊３マスをカウント*/
    for(CountRangeY = j-1; CountRangeY <= j+1; CountRangeY++){
        for (CountRangeX = i-1;CountRangeX <= i+1; CountRangeX++) {
            /*マップ外を除外*/
            if(CountRangeX >= 0 && CountRangeY >= 0 && CountRangeX<= 4 && CountRangeY <= 4){
                countmap[CountRangeY][CountRangeX] += 1;
            }
        }
    }
    /*魚雷着弾位置のカウント０*/
    countmap[j][i] = 0;
    int CornerAttack = 0;
    if(countmap[0][0] || countmap[4][4]){
        CornerAttack = 1;
    }
}

class Field{
    int x,y;
    int MaxCountEnemy;
    int ExistRange = 0;
    int Ship1,Ship2,Ship3,Ship4;/*自分の艦の位置を示す*/
    int y1,x1,y2,x2,y3,x3,y4,x4;
    y1 = 0;
    x1 = 0;
    y2 = 1;
    x2 = 2;
    y3 = 3;
    x3 = 1;
    y4 = 4;
    x4 = 4;
    Ship1 = map[y1][x1];
    Ship2 = map[y2][x2];
    Ship3 = map[y3][x3];
    Ship4 = map[y4][x4];
    BeforeShip = map[y1][x1];
    AfterShip = map[y1+1][x1];
    map[y1+1][x1] = BeforeShip;
    map[y1][x1] = AfterShip;
    Ship1 = AfterShip;
    int map[][] =      { {3,0,0,0,0},
                         {0,0,0,3,0},
                         {0,3,0,0,0},
                         {0,0,0,0,0},
                         {0,0,0,0,3}};
    int countmap[][] = { {1,0,0,0,0},
                         {0,1,0,0,0},
                         {0,0,1,0,0},
                         {0,0,0,1,0},
                         {0,0,0,0,1}};
    MaxCountEnemy = 0;
    int MaxEnemy = 0;
    for( y = 0; y < 5; y++) {
        for( x = 0; x < 5; x++) {
            if( countmap[y][x] > max ) {
                MaxEnemy = countmap[y][x];
                MaxCountEnemy = 1;
            } else if(countmap[y][x] == max){
                MaxCountEnemy += 1;
            }
        }
    }
    int i,j;
    int RangeY,RangeX;
    int EnemyY,EnemyX;
    if(MaxCountEnemy == 1){
        for( j = 0; j < 5; j++) {
            for( i = 0; i < 5; i++) {
                if(MaxEnemy == countmap[j][i]){
                    String EnemyY = j;
                    String EnemyX = i;
                }
            }
        }
        for(RangeY = y1-1; RangeY <= y1+1; RangeY++){
            for (RangeX = x1-1;RangeX = x1+1; RangeX++) {
                if(EnemyY == RangeY && EnemyX == RangeX) {
                    ExistRange = 1;
                }
            }
        }
        for(RangeY = y2-1; RangeY <= y2+1; RangeY++){
            for (RangeX = x2-1;RangeX = x2+1; RangeX++) {
                if(EnemyY == RangeY && EnemyX == RangeX) {
                    ExistRange = 1;
                }
            }
        }
        for(RangeY = y3-1; RangeY <= y3+1; RangeY++){
            for (RangeX = x3-1;RangeX = x3+1; RangeX++) {
                if(EnemyY == RangeY && EnemyX == RangeX) {
                    ExistRange = 1;
                }
            }
        }
        for(RangeY = y4-1; RangeY <= y4+1; RangeY++){
            for (RangeX = x4-1;RangeX = x4+1; RangeX++) {
                if(EnemyY == RangeY && EnemyX == RangeX) {
                    ExistRange = 1;
                }
            }
        }
        if(EnemyY == y1 && EnemyX == x1){
            ExistRange = 0;
        }
    }
}

class sub_1 {
    public static void main(String[] args) {
        MyTurn my = new MyTurn();
        EnemyTurn enemy = new EnemyTurn();

    }
}
