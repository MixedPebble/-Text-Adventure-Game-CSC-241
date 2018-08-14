package room_animal_class;

import java.util.HashMap;
import java.util.Map;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.Attributes;

public class MyHandler extends DefaultHandler {

    HashMap<String, Room> RoomMap = new HashMap<String, Room>();
    private Room currentRoom;
    private PC player;

    @Override
    public void startDocument() {
    }

    public PC getPlayer() {
        return player;
    }

    @Override
    public void startElement(String discard1, String discard2, String tagname, Attributes attr1) {

        if (tagname.equals("room")) {
            currentRoom = new Room(attr1.getValue("name"), attr1.getValue("state"), attr1.getValue("description"));
            RoomMap.put(currentRoom.getRoomName(), currentRoom);

            for (Map.Entry<String, Room> entry : RoomMap.entrySet()) {
                if (entry.getKey().equalsIgnoreCase(attr1.getValue("north"))) {
                    currentRoom.setNorth(entry.getValue());
                    entry.getValue().setSouth(currentRoom);
                }
                if (entry.getKey().equalsIgnoreCase(attr1.getValue("south"))) {
                    currentRoom.setSouth(entry.getValue());
                    entry.getValue().setNorth(currentRoom);
                }
                if (entry.getKey().equalsIgnoreCase(attr1.getValue("east"))) {
                    currentRoom.setEast(entry.getValue());
                    entry.getValue().setWest(currentRoom);
                }
                if (entry.getKey().equalsIgnoreCase(attr1.getValue("west"))) {
                    currentRoom.setWest(entry.getValue());
                    entry.getValue().setEast(currentRoom);
                }
            }
        } else if (tagname.equals("animal")) {
            currentRoom.CreatureMap.put(attr1.getValue("name"), new Animal(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "clean"));
            //currentRoom.creatures.add(new Animal(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "clean"));
        } else if (tagname.equals("NPC")) {
            //currentRoom.creatures.add(new NPC(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "dirty"));
            currentRoom.CreatureMap.put(attr1.getValue("name"), new NPC(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "dirty"));
        } else if (tagname.equals("PC")) {
            player = PC.getInstance(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "indifferent");
            currentRoom.CreatureMap.put(attr1.getValue("name"), player);
            //currentRoom.creatures.add(player);
        }
    }

 

    public void MethodToHideUnsightlyCommentsAndMethodsInIDEThatIMayWantToReferenceLater() {
//        package room_animal_class;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.ListIterator;
//import org.xml.sax.helpers.DefaultHandler;
//import org.xml.sax.Attributes;
//
//public class XMLHandler extends DefaultHandler {
//    HashMap RoomMap = new HashMap();
//
//    private Room currentRoom;
//    //MAKE HASHMAP
//    ArrayList<Room> allRooms = new ArrayList<Room>();
//    private PC player;
//
//    @Override
//    public void startDocument() {
//    }
//
//
//
//    public PC getPlayer() {
//        return player;
//    }
//
//    @Override
//    public void startElement(String discard1, String discard2, String tagname, Attributes attr1) {
//
//        if (tagname.equals("room")) {
//
//            currentRoom = new Room(attr1.getValue("name"), attr1.getValue("state"), attr1.getValue("description"));
//            allRooms.add(currentRoom);
//
//            for (ListIterator<Room> itr = allRooms.listIterator(); itr.hasNext();itr.next()) {
//                int i = itr.nextIndex();
//                if (allRooms.get(i).getRoomName().equals(attr1.getValue("north"))) {
//                    currentRoom.setNorth(allRooms.get(i));
//                    allRooms.get(i).setSouth(currentRoom);
//                }
//
//                if (allRooms.get(i).getRoomName().equals(attr1.getValue("south"))) {
//                    currentRoom.setSouth(allRooms.get(i));
//                    allRooms.get(i).setNorth(currentRoom);
//
//                }
//                if (allRooms.get(i).getRoomName().equals(attr1.getValue("east"))) {
//                    currentRoom.setEast(allRooms.get(i));
//                    allRooms.get(i).setWest(currentRoom);
//
//                }
//                if (allRooms.get(i).getRoomName().equals(attr1.getValue("west"))) {
//                    currentRoom.setWest(allRooms.get(i));
//                    allRooms.get(i).setEast(currentRoom);
//                }
//            }
//
//        } else if (tagname.equals("animal")) {
//            currentRoom.creatures.add(new Animal(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "clean"));
//        } else if (tagname.equals("NPC")) {
//            currentRoom.creatures.add(new NPC(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "dirty"));
//        } else if (tagname.equals("PC")) {
//            player = PC.getInstance(attr1.getValue("name"), attr1.getValue("description"), currentRoom, "indifferent");
//            currentRoom.creatures.add(player);
//        }
//    }
//
//    @Override
//    public void endDocument() {
//    }
//}
    }
}
