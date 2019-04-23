package main;

public enum Command {

    NEW_GAME("Start new game"),
    LOAD_GAME("Load game state"),
    SAVE_GAME("Save game state"),
    MOVE_ORANGUTAN("Move orangutan"),
    MOVE_PANDA("Move panda"),
    ADD_TILE("Add tile"),
    SELECT_ENTRY("Select entry"),
    LIST_TILES("List tiles"),
    ADD_PLAYER("Add player"),
    CONNECT_TILES("Connect tiles"),
    CONNECT_CLOSETS("Connect closets"),
    LIST_PLAYERS("List players"),
    RELEASE_PANDAS("Release pandas"),
    PLACE_PANDA("Place panda"),
    LIST_PANDAS("List pandas"),
    CONTROL_THINGS("Control things"),
    CONNECT_ORANGUTAN_PANDA("Connect oragutan panda"),

    ;

    private String command;

    Command(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public static Command getCommandByValue(String cmd){
        for(Command c : values()){
            if(c.getCommand().equals(cmd)){
                return c;
            }
        }
        return null;
    }

}
