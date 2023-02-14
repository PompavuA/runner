import java.util.*;

public class Main {
    private static Game game;
    private static Scanner sc;
    public static void main(String[] args) {
        game = new Game();


        while(true){
            game.printMap();
            if(game.getFieldUnderPlayer() == FieldType.EXIT){
                System.out.println("You've WON");
                break;
            }
            if(game.getFieldUnderPlayer() == FieldType.TRAP){
                System.out.print("you've LOST");
                break;
            }
            sc = new Scanner(System.in);
            char input = sc.next().charAt(0);
            if(input == 'w')
                game.computeInput(Direction.UP);
            else if(input == 's')
                game.computeInput(Direction.DOWN);
            else
                game.computeInput(Direction.STAND);
        }
    }
}
