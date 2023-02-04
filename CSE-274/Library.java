
// Kevin, CSE 274

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Library class loads media from a file to add, removes,
 * and saves Media from an Arraylist to a new file.
 * Users are able to select options from a given interface.
 *
 */
public class Library {
    
    /**
     * Main method used to execute the menu.
     */
    public static void main(String[] args) {
        
        // call LoadMedia method:
        ArrayList<Media> library = loadMedia();
        
        Scanner ip = new Scanner(System.in);
        int input = 0;
        
        do {
            System.out.println("\n===== Welcome to the Media Library! =====");
            System.out.println("Enter a number to select your option:");
            System.out.println("1. Show Media List \n2. Add Media \n3. "
                    + "Delete Media \n4. Save Media to File \n5. " 
                    + "Exit the Program");
            input = ip.nextInt();
            
            System.out.println();
            
            // Call branch method:
            branch(input, library, ip);
        
        // Close scanner and terminate program when input is 5:
        } while (input != 5);
        
        ip.close();
            
    } // end main method.
    
    /**
     * Helper method for calling options based on menu input.
     * @param x the user input.
     * @param y the media library.
     * @param ip the input scanner.
     */
    public static void branch(int x, ArrayList<Media> y, Scanner ip) {
        switch (x) {
        case 1: showLibrary(y);
            break; 
        case 2: addMedia(y, ip);
            break;
        case 3: deleteMedia(y, ip);
            break;
        case 4: saveListToFile(y, ip);
            break;
        default: return;
        }
        
    } // end branch method.
    
    /**
     * This method prints the entire media library
     * in readable format.
     * @param y the media library.
     */
    public static void showLibrary(ArrayList<Media> y) {
        
        int count = 0;
        for (Media m : y) {
            System.out.println(m.toString());
            count++;
        }
        
        // Print number of items in list:
        System.out.println("\nLoaded " + count + " items.");
        
    } // end showLibrary method.
    
    /**
     * This method adds media to the library.
     * @param y the media library.
     * @param ip the scanner for user input.
     */
    public static void addMedia(ArrayList<Media> y, Scanner ip) {
        
        String id = setUid(y);
        System.out.print("Set title of media: ");
        ip.nextLine();
        String title = ip.nextLine();
        
        // Prompt until "book" or "video" is typed:
        while (true) {
            
            System.out.print("Book or Video: ");
            String kind = ip.nextLine();
            
            if (kind.equalsIgnoreCase("book")) {
                
                makeBook(id, title, kind, y, ip);
                break;
                
            } else if (kind.equalsIgnoreCase("video")) {
                
                makeVideo(id, title, kind, y, ip);
                break;
                
            } else {
                
                System.out.println("\nError: Please enter a "
                        + " book or a video!\n");
                continue;
            }
        } 
        
        System.out.println("Media successfully added.");
    }
    
    /**
     * Helper method for adding books.
     * @param w the media's UID.
     * @param x the media's title.
     * @param z the media's type "book".
     * @param y the media library.
     * @param ip the scanner for user input.
     */
    public static void makeBook(String w, String x, String z, 
            ArrayList<Media> y, Scanner ip) {
        
        System.out.print("Set author: ");
        String auth = ip.nextLine();
        System.out.print("Set publisher: ");
        String publ = ip.nextLine();
        Book b = new Book(w, x, z, auth, publ);
        
        // Add to list in order of UID:
        if (Integer.parseInt(w) > y.size()) {
            y.add(b);
        } else {
            y.add(Integer.parseInt(w) - 1, b);
        }      
    } // end makeBook method.
    
    /**
     * Helper method for adding videos.
     * @param w the media's UID.
     * @param x the media's title.
     * @param z the media's type "video".
     * @param y the media library.
     * @param ip the Scanner for user input.
     */
    public static void makeVideo(String w, String x, String z,
            ArrayList<Media> y, Scanner ip) {
        
        System.out.print("Set director: ");
        String dir = ip.nextLine();
        String type = "";
        
        while (true) {
            System.out.print("Set type (DVD, Blu-ray, or Digital): ");
            type = ip.next();
            
            // if user does not specify either of the three, continue loop:
            if (!type.equalsIgnoreCase("DVD") 
                    && !type.equalsIgnoreCase("Digital") 
                    && !type.equalsIgnoreCase("Blu-ray")) {
                
                System.out.println("\nError: Invalid type!\n");
                continue;
            }
            
            break; 
        }
        
        Video v = new Video(w, x, z, dir, type);
        
        // Add to list in order of UID:
        if (Integer.parseInt(w) > y.size()) {
            y.add(v);
        } else {
            y.add(Integer.parseInt(w) - 1, v);
        } 
    } // end makeVideo method.
    
    /**
     * This method automatically assigns a Unique ID
     * for the user.
     * @param y the media library.
     * @return
     */
    public static String setUid(ArrayList<Media> y) {
        
        // Initialize the String:
        String key = "";
        int i = 0;
        
        for (Media m : y) {
            
            i++;
            
            // If "i" matches the last uid in list:
            if (i == y.size() 
                    && i == Integer.parseInt(m.getUid())) {
                
                // make UID +1 higher than the last digit:
                i = y.size() + 1;   
            }
               
            // search for an available UID within the list:
            if (Integer.parseInt(m.getUid()) != i) {
                
                // Key is based on number of digits in "i":
                if (i < 10) {
                    key = "00" + Integer.toString(i);
                    break;
                        
                } else if (i < 100) {
                    key = "0" + Integer.toString(i);
                    break;
                        
                } else {
                    key = Integer.toString(i);
                        
                }
                
            }
            
        }
        
        // Assign the new UID to the media being added:
        System.out.println("UID " + key + " will be automatically assigned "
                + "to the added media.");
        return key;
    } // end setUid method.
    
    /**
     * This method deletes a media from the library
     * given a specific uid.
     * @param y the media library.
     * @param ip Scanner for user input.
     */
    public static void deleteMedia(ArrayList<Media> y, Scanner ip) {
        System.out.print("Enter unique ID of media to delete: ");
        String uid = ip.next();
        
        for (Media m : y) {
            
            // i.e: "001" and "1" are both acceptable inputs.
            if (m.getUid().equals(uid) 
                    || Integer.parseInt(m.getUid()) == Integer.parseInt(uid)) {
                
                y.remove(m);
                System.out.println("Media successfully removed!");
                return;  
            }
        }
        
        // Print if specified UID wasn't found.
        System.out.println("Media with UID " + uid + " not found.");
    } // end deleteMedia method.
    
    /**
     * This method saves the library to a file.
     * @param y the media library.
     * @param ip Scanner for user input.
     */
    public static void saveListToFile(ArrayList<Media> y, Scanner ip) {
        
        System.out.print("Enter a file name: ");
        String fileName = ip.next();
        PrintWriter f = null;
        
        // IO Exception handler:
        try {
            f = new PrintWriter(new File(fileName));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        for (Media m : y) {
            
            f.println(m.getUid());
            f.println(m.getTitle());
            f.println(m.getKind());
            
            // Print book/video attributes specified by kind:
            if (m.getKind().equalsIgnoreCase("book")) {
                
                Book b = (Book)m;
                f.println(b.getAuthor());
                f.println(b.getPublisher());
                
            } else if (m.getKind().equalsIgnoreCase("video")) {
                
                Video v = (Video)m;
                f.println(v.getDirector());
                f.println(v.getType());
            }
        }
        
        f.close();
        System.out.println("List saved to " + fileName);
    } // end saveListToFile method.
    
    /**
     * This method loads the media when the program
     * is executed.
     * @return the media contents from file into the library.
     */
    public static ArrayList<Media> loadMedia() {
        
        ArrayList<Media> library = new ArrayList<Media>();
        Scanner in = null;
        
        // IO Exception handler:
        try {
            in = new Scanner(new File("media.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        
        // Create videos and books from file scanner:
        while (in.hasNext()) {
            
            String uid = in.nextLine();
            String title = in.nextLine();
            String kind = in.nextLine();
            
            if (kind.equalsIgnoreCase("video")) {
                
                String dir = in.nextLine();
                String type = in.nextLine();
                
                Video v = new Video(uid, title, kind, dir, type);
                library.add(v);
                
            } else {
                
                String auth = in.nextLine();
                String publ = in.nextLine();
                
                Book b = new Book(uid, title, kind, auth, publ);
                library.add(b);
            }
        }
        
        in.close();
        return library;     
    } // end loadMedia method.
} // end class.