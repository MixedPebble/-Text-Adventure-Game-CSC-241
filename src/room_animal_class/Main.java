package room_animal_class;
import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {



            public static void main(String[] args) throws Exception {
        
                PC player;
        Scanner kb = new Scanner(System.in);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        MyHandler handler = new MyHandler();
        
        System.out.println("Enter the name of the xml file you wish to use or type quit.");
        System.out.println("Hi Amanda! I miss you. The name of the XML file is: HI_AMANDA.xml");
                String command = kb.nextLine();
        while (!command.equals("quit")) {
            try {
                saxParser.parse(command, handler);
                player = handler.getPlayer();
                System.out.println("Enter in a command or type help to see a list of potential inputs");
                boolean test = true;
                while(test ==true){
                    String input = kb.nextLine();
                    player.play(input);
                }
                break;
            } catch (FileNotFoundException e) {
                System.out.println("I could not find the file. Please try again or type quit.");
                command = kb.nextLine();
            }
            
        }
    }
}