package room_animal_class;

import java.util.Scanner;

public class PC extends Creature {

    private int respect = 40;
    private static PC instance;

    private PC(String n, String d, Room c, String p) {
        super(n, d, c, p);
    }

    public static PC getInstance(String n, String d, Room c, String p) {
        if (instance == null) {
            instance = new PC(n, d, c, p);
        }
        return instance;
    }

    public static PC getInstance() {
        return instance;
    }

    @Override
    public String toString() {
        return getName() + ", PC, " + getDescription();
    }
    public void play(String command) {
        if (!command.equalsIgnoreCase("quit")) {
            String[] CC = command.split(":");
            if (CC.length == 1) {
                if (command.equalsIgnoreCase("help")) {
                    System.out.println("Help:\n help: Redundant. \n look: Displays information pertaining to the room the PC is currently in."
                            + "\nclean: Attempts to change the state of the room to clean/half-dirty. May alter PC respect level."
                            + "\n dirty: Attempts to change the state of the room to dirty/half-dirty. May alter PC respect level."
                            + "\n north, south, east, or west: Attempts to move the PC to a respect room. \n quit: Ends the game."
                            + "\nType a creature's name followed by a colon then the command to make a creature perform an action.EX: DougLea:clean");
                } else if (command.equalsIgnoreCase("look")) {
                    System.out.println(currentRoom.toString());
                } else if (command.equalsIgnoreCase("clean")) {
                    this.cleanRoom(this);
                } else if (command.equalsIgnoreCase("dirty")) {
                    this.dirtyRoom(this);
                } else if (command.equalsIgnoreCase("north") || command.equalsIgnoreCase("south") || command.equalsIgnoreCase("east") || command.equalsIgnoreCase("west")) {
                    if (currentRoom.getRoom(command) == null) {
                        System.out.println("That room doesn't exist");
                    } else if (currentRoom.getRoom(command).CreatureMap.size() == 10) {
                        System.out.println("That room is full.");
                    } else {
                        this.roomSwitch(command);
                        System.out.println("switched rooms");
                    }
                } else {
                    System.out.println("I do not speak jibberish. Be more careful about your commands, they do not need to be case sensitive.");
                }
            } else if (CC.length == 2) {

                if (currentRoom.CreatureMap.containsKey(CC[0])) {
                    Creature slave = currentRoom.CreatureMap.get(CC[0]);
                    if (CC[1].equalsIgnoreCase("Look")) {
                        System.out.println((slave.getName() + " looked around the room and saw: \n" + slave.look()));
                    } else if (CC[1].equalsIgnoreCase("clean")) {
                        slave.cleanRoom(slave);
                    } else if (CC[1].equalsIgnoreCase("dirty")) {
                        slave.dirtyRoom(slave);
                    } else if (CC[1].equalsIgnoreCase("north") || CC[1].equalsIgnoreCase("south") || CC[1].equalsIgnoreCase("east") || CC[1].equalsIgnoreCase("west")) {
                        if (!slave.getPreference().equals(currentRoom.getRoom(CC[1]).getRoomState())) {
                            currentRoom.getRoom(CC[1]).setStateHalfDirty();
                        }
                        slave.roomSwitch(CC[1]);
                    } else {
                        System.out.println(CC[0] + " looks at you like you are speaking jibberish.");
                    }
                } else {
                    System.out.println("That creature does not exist in this room");
                }
            }
            endgame();
        } else {
            endgame();
            System.exit(0);

        }
    }

    @Override
    public void angryReaction() {
    }

    @Override
    public void happyReaction() {
    }

    public void alterRespect(int a) {
        respect += a;
    }

    public void endgame() {
        if (respect <= 0) {
            System.out.println("You lost the game. You're respect level fell to " + respect);
            System.exit(0);
        } else if (respect > 80) {
            System.out.println("You have won the game. You're respect level is now " + respect);
            System.exit(0);

        } else {
            System.out.println("You're respect level is " + respect);

        }
    }
}
