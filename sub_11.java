import java.util.Scanner;
import java.util.Random;

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


        System.out.println("移動しました");/*移動できるマスの中からカウントが少ない方へと移動する*/
    }
}
class EnemyTurn{
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
    int countmap[][] = { {0,0,0,0,0},
                         {0,0,0,0,0},
                         {0,0,0,0,0},
                         {0,0,0,0,0},
                         {0,0,0,0,0}};
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
    int i,j;
    int RangeY,RangeX;
    int EnemyY,EnemyX;
    /*敵の最大カウントの数が１の時*/
    if(MaxCountEnemy == 1){
        /*敵の最大カウントのある座標を調べる*/
        for( j = 0; j < 5; j++) {
            for( i = 0; i < 5; i++) {
                if(MaxEnemy == countmap[j][i]){
                    String EnemyY = j;
                    String EnemyX = i;
                }
            }
        }
        /*自分の艦の周囲３＊３マスに敵の最大カウントの座標があるか調べる*/
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
}

class sub_1 {
    public static void main(String[] args) {
        while(true){
            MyTurn my = new MyTurn();
            EnemyTurn enemy = new EnemyTurn();
            System.out.println("myturn実行");
            my.method();
            System.out.println("enemyturn実行");
            enemy.method();
        }
    }
}
