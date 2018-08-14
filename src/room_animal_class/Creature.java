package room_animal_class;

public abstract class Creature {

    protected Room currentRoom;
    private String creatureName;
    private String creatureDescription;
    private String preference;

    public Creature(String n, String d, Room r, String p) {
        creatureName = n;
        creatureDescription = d;
        currentRoom = r;
        preference = p;
    }

    public Creature() {
    }

    public Room getRoom() {
        return currentRoom;
    }

    public String getName() {
        return creatureName;
    }

    public String getDescription() {
        return creatureDescription;
    }

    public String getPreference() {
        return preference;
    }

    public String look() {
        String roomInfo;
        roomInfo = currentRoom.toString();
        return roomInfo;
    }

    @Override
    public abstract String toString();

    public void roomSwitch(String r) {
        if (r.equalsIgnoreCase("north") || r.equalsIgnoreCase("south") || r.equalsIgnoreCase("east") || r.equalsIgnoreCase("west")) {
            if (currentRoom.getRoom(r).CreatureMap.size()==10) {
                System.out.println("That room is full");
            } else {
                currentRoom.getRoom(r).CreatureMap.put(creatureName, this);
                currentRoom.CreatureMap.remove(this.creatureName);
                this.currentRoom = currentRoom.getRoom(r);
            }

        } else {
            System.out.println("Does not exist");
        }
    }

    public void cleanRoom(Creature c) {
        if (currentRoom.getRoomState().equals("clean")) {
            System.out.println("The room is already clean");
        } else if (currentRoom.getRoomState().equals("half-dirty")) {
            currentRoom.setStateClean();
            currentRoom.creatureNotify("dirty", c);
        } else if (currentRoom.getRoomState().equals("dirty")) {
            currentRoom.setStateHalfDirty();
            System.out.println(this.getName() + " has made the room somewhat dirty.");
        }
    }

    public void dirtyRoom(Creature c) {
        if (currentRoom.getRoomState().equals("dirty")) {
            System.out.println("The room is already dirty");
        } else if (currentRoom.getRoomState().equals("half-dirty")) {

            currentRoom.setStateDirty();
            System.out.println(this.getName() + " has made the room filthy.");

            currentRoom.creatureNotify("clean", c);
        } else if (currentRoom.getRoomState().equals("clean")) {
            currentRoom.setStateHalfDirty();
            System.out.println(this.getName() + " has partially cleaned the room.");
        }
    }

    public abstract void happyReaction();

    public abstract void angryReaction();
}
