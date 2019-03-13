/**
* Dennis Lin
* 109426873
* Homework #7
* CSE214 R05 
* Recitation TA: Vladimir Yevseenko
* Grading TA: Xi Zhang
 */


import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.InputMismatchException;
import java.util.Scanner;

public class NeoViewer {

    public static void main(String[] args) {
        System.out.println("Welcome to NEO Viewer!");
        NeoDatabase neoDatabase = new NeoDatabase();
        System.setErr(new PrintStream(new OutputStream() {
            @Override
            public void write(int arg0) throws IOException {
                // keep empty
            }
        }));
        boolean programOn = true;
        System.out.println("\nOption Menu:\n" 
                        + "   A) Add a page to the database\n" 
                        + "   S) Sort the database \n" 
                        + "   P) Print the database as a table.\n" 
                        + "   Q) Quit");
        Scanner input = new Scanner(System.in);
        String response;
        String sortResponse;
            while (programOn) {
            System.out.println("\nPlease select an option:");
            response = input.next().toUpperCase();
            input.nextLine();
            System.out.println();                    
            try {
                switch (response) {
                    case "A":
                        try {
                            System.out.println("Enter the page to load:");
                            int pageNumber = input.nextInt();
                            neoDatabase.addAll(neoDatabase.buildQueryURL(pageNumber));
                            System.out.println("Page loaded successfully!");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Invalid Page Number.");
                        }catch (InputMismatchException e){
                            System.out.println("Not a Page Number. Please try again.");
                        }input.nextLine();
                        break;
                    case "S":
                        System.out.println("R) Sort by referenceID\n"                                 
                                        + "D) Sort by diameter\n" 
                                        + "A) Sort by approach date\n" 
                                        + "M) Sort by miss distance\n"                            
                                        + "\nSelect a Sorting Menu option:");
                        sortResponse = input.next().toUpperCase();
                            try {
                                switch(sortResponse){
                                    case "R":
                                        System.out.println("Table sorted on referenceID.");
                                        neoDatabase.aSort(new ReferenceIDComparator());
                                        break;
                                    case "D":
                                        System.out.println("Table sorted on diameter.");
                                        neoDatabase.aSort(new DiameterComparator());
                                        break;
                                    case "A":
                                        System.out.println("Table sorted on approach date.");
                                        neoDatabase.aSort(new ApproachDateComparator());
                                        break;
                                    case "M":
                                        System.out.println("Table sorted on miss distance.");
                                        neoDatabase.aSort(new MissDistanceComparator());
                                        break;
                                    default:
                                        System.out.println( sortResponse + " is not one of the Sorting Menu options.\n");
                                        break;
                                }
                            } catch (Exception e) {
                                }
                        break;
                    case "P":
                        neoDatabase.printTable();
                        break;
                    case "Q":
                        programOn = false;
                        break;
                    default:
                        System.out.println(response + " is not one of the Option Menu options.\n");
                }
            }catch (IllegalArgumentException e){
                System.out.println("Error");
            }catch(NullPointerException e){
                System.out.println("Page unable to load. Please try another page.");
            }
        }
        System.out.println("Program terminating normally...");
        input.close();
    }
}
