public class Game {
    private GameMap gameMap;
    private int player[];
    private Position position;
    public Game(){
        player = new int[2];
        gameMap = new GameMap(0, 0, player);
    }

    public FieldType getFieldUnderPlayer(){
        position = new Position(gameMap.findPlayer().getX(),gameMap.findPlayer().getY());
        return gameMap.getFieldByPosition(position);
    }

    public void computeInput(Direction direction){
        Position player;
        Position newPlayerPosition;
        if(direction == Direction.UP && gameMap.findPlayer().getX() == 0)
            direction = Direction.STAND;
        if(direction == Direction.DOWN && gameMap.findPlayer().getX() == 10)
            direction = Direction.STAND;
        player = gameMap.findPlayer();
        newPlayerPosition = player.move(direction);
        gameMap.movePlayer(newPlayerPosition);
        gameMap.shiftRows();
        System.out.print(gameMap.findPlayer().getX());System.out.print(" "); System.out.print(gameMap.findPlayer().getY());System.out.println();
        
    }


    public void printMap(){
        gameMap.printMap();
    }
    
}
