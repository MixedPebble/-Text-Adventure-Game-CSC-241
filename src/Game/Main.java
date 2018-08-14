import java.io.FileNotFoundException;
import java.util.Scanner;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

public class Main {



    public static void main(String[] args) throws Exception {
        
        PC player = null;
        Scanner kb = new Scanner(System.in);
        SAXParserFactory saxParserFactory = SAXParserFactory.newInstance();
        SAXParser saxParser = saxParserFactory.newSAXParser();
        XMLHandler handler = new XMLHandler();
        
        System.out.println("Enter the name of the xml file you wish to use or type quit.");
        String command = kb.nextLine();
        while (!command.equals("quit")) {
            try {
                saxParser.parse(command, handler);
                player = handler.getPlayer();

                break;
            } catch (FileNotFoundException e) {
                System.out.println("I could not find the file. Please try again or type quit.");
                command = kb.nextLine();
            }
            
        }
        System.out.println(
                "Welcome! " +
                "This is a virtual world simulation that allows a human user to interact with it through a text-based, command-line interface.\n" +
                "You win if your respect raises above 80 and lose if it falls below 0."
        );

        while (!command.equals("quit")) {
            System.out.println("Enter in a command or type help to see a list of potential inputs");
            String input = kb.nextLine();
            player.play(input);
        }
    }
}