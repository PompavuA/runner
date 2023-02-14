
public class test {
    private static GameMap gameMap;
    private static Position position;
    private static int player[];
    public static void main(String[] args){
        player = new int[2];
        gameMap = new GameMap(4, 0, player);
        position = gameMap.findPlayer();
        System.out.print(position.getX());
    }
}
