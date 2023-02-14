public class GameMap {
    final int DIMENTION = 11;
    private FieldType fieldType[][];
    private int player[];
    public GameMap(int playerPositionX, int playerPositionY, int player[]){
        this.player = player;
        this.player[0] = playerPositionX; this.player[1] = playerPositionY;
        fieldType = new FieldType[DIMENTION][DIMENTION];
        for(int i = 0; i < DIMENTION;i++){
            for(int j = 0; j < DIMENTION;j++){
                fieldType[i][j] = FieldType.EMPTY;
                if(i == 0 || i == DIMENTION-1)
                    fieldType[i][j] = FieldType.EMPTY;
                else if(i == j)
                    fieldType[i][j] = FieldType.TRAP;
                if((i == 1 && j == 9) || (i == 2 && j == 8) || (i == 3 && j == 7) || (i == 4 && j == 6) || (i == 6 && j == 4) || (i == 7 && j == 3) || (i == 8 && j == 2) || (i == 9 && j == 1))
                    fieldType[i][j] = FieldType.TRAP;
                fieldType[DIMENTION-1][DIMENTION-1] = FieldType.EXIT;
            }
        }
    }

    public Position findPlayer(){
        return new Position(player[0], player[1]);
    }

    public FieldType getFieldByPosition(Position position){
        return fieldType[position.getX()][position.getY()];
    }

    public void shiftRows(){
        for(int i = 0;i < DIMENTION; i++){
            FieldType row[];
            row = new FieldType[DIMENTION];
            for(int j = 0; j < DIMENTION; j++){
                row[j] = fieldType[i][j];
            }
            if(i % 2 != 0){
                fieldType[i][0] = row[DIMENTION-1];
                if(findPlayer().getX() == i)
                    this.player[1] +=1;
                if(this.player[1] > 10)
                    this.player[1] = 0;
                for(int j = 1; j < DIMENTION; j++){
                    fieldType[i][j] = row[j-1];
                }
            }
            else{
                fieldType[i][DIMENTION-1] = row[0];
                if(findPlayer().getX() == i)
                    this.player[1] -=1;
                if(this.player[1] < 0)
                    this.player[1] = 10;
                for(int j = DIMENTION-2;j >= 0;j--){
                    fieldType[i][j] = row[j+1]; 
                }
            }
        }
    }




    public void movePlayer(Position newPlayerPosition){
        player[0] = newPlayerPosition.getX();
        player[1] = newPlayerPosition.getY();
    }




    public void printMap(){
        for(int i = 0;i < DIMENTION;i++){

            if(i == 0 || (i % 2 == 0))
                System.out.print("< ");
            else
                System.out.print("> ");
            for(int j = 0;j < DIMENTION;j++){
                if(player[0] == i && player[1] == j)
                    System.out.print(FieldType.getSignOnMap(FieldType.PLAYER));
                else
                    System.out.print(FieldType.getSignOnMap(fieldType[i][j]));
                System.out.print(" ");
            }
            System.out.println("");

        }
    }
}
