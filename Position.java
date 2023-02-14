public class Position {
    private int x;
    private int y;
    public Position(int x, int y){
        this.x = x;
        this.y = y;
    }

    public int getX(){
        return this.x;
    }

    public int getY(){
        return this.y;
    }

    public Position move(Direction direction){
        Position position;
        position = new Position(this.x, this.y);
        if(direction == Direction.UP)
            position = new Position(this.x-1, this.y);
        else if(direction == Direction.DOWN)
            position = new Position(this.x+1, this.y);
        else if(direction == Direction.STAND)
            position = new Position(this.x, this.y);

        return position;
    }
}
