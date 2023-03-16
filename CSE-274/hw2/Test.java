// CSE 274

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * Class designed to test and print linked lists
 * using the generic linked list class.
 * @author koeppkm2
 *
 */
public class Test {
    
    /**
     * Main method to test and print the linked list.
     * @param args
     */
    public static void main(String[] args) {
        
        // Load items from file and test add method:
        GenLinkedList<Media> m = new GenLinkedList<Media>();
        m = readFromFile("mediaHw2.txt");
        System.out.println(m.size() + " items loaded into list.");
        
        // Print the whole list to string:
        System.out.println("\nThe whole list:\n");
        System.out.println(m.toString());
        
        // Add a new video and print it:
        System.out.println("\nTesting add method:\n"); 
        
        Video e = new Video("001", "Noragami", "video", "Adachitoka", "Blu-ray");
        m.add(e);
        System.out.println(m.toString());
        
        // Remove a media object:
        System.out.println("\nTesting remove method:\n"); 
        
        m.remove();
        System.out.println(m.toString());
        
        // Test the sort method with 7 items:
        System.out.println("\nTesting sort method with 7 items:\n");
        
        m.sort();
        System.out.println(m.toString());
        
        
        
    } // end main method.
    
    /**
     * Method returns a new Linked list with media objects
     * loaded from a file.
     * (Method taken from my hw1 solution)
     * 
     * @param fileName the name of the file to be scanned.
     * @return a linked list with loaded media objects.
     */
    public static GenLinkedList<Media> readFromFile(String fileName) {
        Scanner ip = null;
        GenLinkedList<Media> result = new GenLinkedList<Media>();
        
        try {
            ip = new Scanner(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // Create videos and books from file scanner:
        while (ip.hasNext()) {
            
            String uid = ip.nextLine();
            String title = ip.nextLine();
            String kind = ip.nextLine();
            
            if (kind.equalsIgnoreCase("video")) {
                
                String dir = ip.nextLine();
                String type = ip.nextLine();
                
                Video v = new Video(uid, title, kind, dir, type);
                result.add(v);
                
            } else {
                
                String auth = ip.nextLine();
                String publ = ip.nextLine();
                
                Book b = new Book(uid, title, kind, auth, publ);
                result.add(b);
            }
        }
        
        return result;  
        
    } // end readFromFile method.
} // end class.
