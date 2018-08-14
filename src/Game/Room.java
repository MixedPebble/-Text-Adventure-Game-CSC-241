import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;

public class Room {
    HashMap<String, Creature> CreatureMap = new HashMap<String, Creature>();
    private String roomName;
    private String roomState;
    private String roomDescription;
    private Room north, south, east, west;
    public int startIndex;

    public int getStartIndex() {
        return startIndex;

    }

    public Room(String rn, String rs, String rd) {
        this.roomName = rn;
        this.roomState = rs;
        this.roomDescription = rd;

    }

    @Override
    public String toString() {
        String append = "";
        for (Map.Entry<String, Creature> entry : CreatureMap.entrySet()) {
            append += "\n " + entry.getValue();
        }
        return "RoomName: " + roomName + ". "
                + "\nRoomState: " + roomState + ". "
                + "\nRoom Description: " + roomDescription + ". "
                + "\nNorth Neighbor: " + getRoomName(north) + ". "
                + "\nSouth Neighbor: " + getRoomName(south) + ". "
                + "\nEast Neighbor: " + getRoomName(east) + ". "
                + "\nWest Neighbor: " + getRoomName(west)
                + "\nCreatures: \n" + append;

    }

    public void setNorth(Room n) {
        north = n;
    }

    public void setSouth(Room s) {
        south = s;
    }

    public void setEast(Room e) {
        east = e;
    }

    public void setWest(Room w) {
        west = w;
    }

    public Room getNorth() {
        return north;
    }

    public Room getSouth() {
        return south;
    }

    public Room getEast() {
        return east;
    }

    public Room getWest() {
        return west;
    }

    public String getRoomName() {
        // Returns room's name reference
        return roomName;
    }

    public String getRoomName(Room r) {
        if (r == null) {
            return "does not exist";
        } else {
            return r.roomName;
        }
    }

    public String getRoomState() {
        return roomState;
    }

    public void creatureNotify(String n, Creature c) {
        //makes animals react and move rooms
        //where n is a roomstate
        //Where c is the creature performing the action

        Collection<Creature> entries = CreatureMap.values();
        Iterator<Creature> itr = entries.iterator();
        while (itr.hasNext()) {
            Creature critter = itr.next();
            if (critter.getPreference().equalsIgnoreCase(n)) {
                if (critter.equals(c)) {
                    critter.angryReaction();
                    critter.angryReaction();
                    critter.angryReaction();
                } else {
                    critter.angryReaction();
                }
                Room r = getRandomRoom();
                if (r == null) {
                    System.out.println(critter.getName() + " has escaped!");
                    itr.remove();
                    for (Map.Entry<String, Creature> entry : CreatureMap.entrySet()) {
                        entry.getValue().angryReaction();

                    }
                } else {
                    if (!r.getRoomState().equalsIgnoreCase(critter.getPreference())) {
                        if (!r.getRoomState().equalsIgnoreCase("half-dirty")) {
                            r.setStateHalfDirty();
                        }
                    }
                    critter.currentRoom.equals(r);
                    System.out.println(critter.getName() + " has left the room.");
                    r.CreatureMap.put(critter.getName(), critter);
                    itr.remove();
                }
            } else {
                if (critter.equals(c)) {
                    critter.happyReaction();
                    critter.happyReaction();
                    critter.happyReaction();
                } else {
                    critter.happyReaction();
                }

            }
        }
    }
    public void setStateClean() {
        this.roomState = "clean";
    }

    public void setStateDirty() {
        this.roomState = "dirty";
    }

    public void setStateHalfDirty() {
        this.roomState = "half-dirty";
    }

    public Room getRoom(String n) {
        if (n.equals("north")) {
            return this.getNorth();
        } else if (n.equals("south")) {
            return this.getSouth();
        } else if (n.equals("east")) {
            return this.getEast();
        } else if (n.equals("west")) {
            return this.getWest();
        }
        return null;
    }

    public Room getRandomRoom() {

        ArrayList<String> temp = new ArrayList<String>();
        int roomCount = 0;
        Random r = new Random();

        if (this.north != null) {
            if (this.north.CreatureMap.size() != 10) {
                temp.add("north");
                roomCount++;
            }
        }
        if (this.south != null) {
            if (this.south.CreatureMap.size() != 10) {
                temp.add("south");
                roomCount++;
            }
        }
        if (this.east != null) {
            if (this.east.CreatureMap.size() != 10) {
                temp.add("east");
                roomCount++;
            }
        }
        if (this.west != null) {
            if (this.west.CreatureMap.size() != 10) {
                temp.add("west");
                roomCount++;
            }
        }
        if (roomCount == 0) {
            System.out.println("All neighboring rooms are full! Oh no!");
            return null;
        } else {
            int n = r.nextInt(roomCount);
            return getRoom(temp.get(n));
        }
    }


    public void MethodToHideUnsightlyCommentsAndMethodsInIDEThatIMayWantToReferenceLater() {
        //This method will hide all unsightly comments/code that I want to be hidden within the Room class by putting
        //In the Body of the method then minimizing the method in the IDE
        //    public Creature BinarySearch(String c, int start, int end) {
//        Creature temp = null;
//        int middle = (start + end) / 2;
//        if (start != end) {
//            if (creatures[middle].getName().equalsIgnoreCase(c)) {
//                System.out.println("Creature found");
//                temp = creatures[middle];
//            } else if (creatures[middle].getName().compareTo(c) >= 1) {
//                BinarySearch(c, start, middle);
//            } else if (creatures[middle].getName().compareTo(c) <= -1) {
//                BinarySearch(c, middle, end);
//            }
//
//        }
//        return temp;
//    }
//    public int partition(ArrayList<Creature> array, int start, int end) {
//        int i = start;
//        int j = end;
//        Creature tmp;
//
//
//        String pivot = array.get((start + end) / 2).getName();
//        for (int a = 0; a < array.size(); a++) {
//            if (creatures.get(a) == null) {
//            } else {
//            }
//        }
//        while (i <= j) {
//            while (array.get(i).getName().compareTo(pivot) <= -1) {
//                i++;
//            }
//            if (array.get(j) == null) {
//            }
//            while (array.get(j).getName().compareTo(pivot) >= 1) {
//                j--;
//            }
//            if (i <= j) {
//
//                tmp = array.get(i);
//                array.set(i, array.get(j));
//                array.set(j, tmp);
//                i++;
//                j--;
//            }
//        }
//        return i;
//    }
//
//    public void quickSort(ArrayList<Creature> array, int left, int right) {
//        //Partitions and calls quicksort on each half of the previous array being used.
//        int index = partition(array, left, right);
//        if (left < index - 1) {
//            quickSort(array, left, index - 1);
//        }
//        if (index < right) {
//            quickSort(array, index, right);
//        }
//    }
        
        
//    public void addCreature(Creature a) {
//
//        for (int i = 0; i < creatures.size(); i++) {
//            if (creatures.get(i) == null) {
//                creatures.add(a);
//                break;
//            }
//        }
//    }
//    public void removeCreature(Creature c) {
//        for (int i = 0; i < creatures.size(); i++) {
//            if (creatures.get(i).getName().equals(c.getName())) {
//                creatures.remove(i);
//            }
//        }
//    }
        //    public Creature CreatureCheck(String c) {
//
//        for (int i = 0; i < creatures.size(); i++) {
//            if (creatures.get(i) != null) {
//                if (creatures.get(i).getName().equalsIgnoreCase(c)) {
//                    return creatures.get(i);
//                }
//            }
//        }
//        return null;
//    }
    }
}
