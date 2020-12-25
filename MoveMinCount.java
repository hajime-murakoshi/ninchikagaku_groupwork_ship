import java.util.Random;
class MoveMinCount{

    int MinCountEnemy = 0;
    int MoveRangeX,MoveRangeY;
    Random random = new Random();
    int num = random.nextInt(100);
    int moveship,Ship2,Ship3;


    if (0 <= num && num <= 49) {
        moveship = Ship2;
    } else {
        moveship = Ship3;
    }


    if (moveship = Ship2) {

        for(MoveRangeY = y2-2; MoveRangeY <= y2+2; MoveRangeY++){
            if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y2){
                if(countmap[MoveRangeY][x2] < YMinCount){
                    YMinCount = countmap[MoveRangeY][x2];
                }
            }
        }

        for(MoveRangeX = x2-2; MoveRangeX <= x2+2; MoveRangeX++){
            if(MoveRangeX >= 0 && MoveRangeX <=4 && MoveRangeX != x2){
                if(countmap[y2][MoveRangeX] < XMinCount){
                    XMinCount = countmap[y2][MoveRangeX];
                }
            }
        }


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
        }
    }
    if (moveship = Ship3) {

        for(MoveRangeY = y3-2; MoveRangeY <= y3+2; MoveRangeY++){
            if(MoveRangeY >= 0 && MoveRangeY <=4 && MoveRangeY != y3){
                if(countmap[MoveRangeY][x2] < YMinCount){
                    YMinCount = countmap[MoveRangeY][x2];
                }
            }
        }

            for(MoveRangeX = x3-2; MoveRangeX <= x3+2; MoveRangeX++){
                if(MoveRangeX >= 0 && MoveRangeX <=4 && MoveRangeX != x3){
                    if(countmap[y3][MoveRangeX] < XMinCount){
                        XMinCount = countmap[y3][MoveRangeX];
                    }
                }
            }


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
        }
