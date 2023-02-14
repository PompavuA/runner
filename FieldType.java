public enum FieldType {
    EMPTY,
    TRAP,
    EXIT,
    PLAYER;

    public static char getSignOnMap(FieldType fieldType){
        if(fieldType == EMPTY)
            return '.';
        if(fieldType == TRAP)
            return 'X';
        if(fieldType == EXIT)
            return 'E';
        if(fieldType == PLAYER)
            return 'A';
        return 'e';
    }

}
