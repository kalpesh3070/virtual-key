package mypackage;
import java.io.*;
import java.util.*;

public class Assesmnet {

    public static void main(String[] args)throws IOException {
        Scanner scanner = new Scanner(System.in);
        Scanner scanner1 = new Scanner(System.in);
        int option;
        int suboption;
        System.out.println("Locked.me.com");
        System.out.println("Developer: Kalpesh B Prajapati");
        System.out.println("Contact:kalpesh.prajapati.51435@gmail.com");
        System.out.println();
        while (true) {//Starting of the  WHILE Loop
            System.out.println("Please select one of the options below:");
            System.out.println("1. Display the current file name.");
            System.out.println("2. Display User Interfaces");
            System.out.println("3. Exit");
            option = scanner.nextInt();
            switch (option) {
                case 1:

                    //Taking path as input from the user
                    System.out.print("Enter the path to get the list of files:");
                    String filePath = scanner.next();
                    displayFiles(filePath);
                    break;
                case 2:

                    //Need to write this logic to display the user interface options
                    //Opening of second do while loop
                    do {
                        System.out.println("=====================================================");
                        System.out.println("Select an option to perform the respective task:");
                        System.out.println("11. Add a file");
                        System.out.println("12. Delete file");
                        System.out.println("13. Search file");
                        System.out.println("14. Go Back to Main Menu");
                        System.out.println("0. Exit");
                        System.out.println("=====================================================");
                        suboption = scanner1.nextInt();
                        switch (suboption) {
                            case 11: //Logic for creating a file based on the name given by user
                            {
                                System.out.println("Give a name for your file that you want to add:");
                                String str = scanner.next();
                                str = str + ".txt";
                                File newFile = new File(str); //Creating File object with name newFile
                                if (newFile.createNewFile()) //calling create method of File class
                                {
                                    System.out.println("======================================================================");
                                    System.out.println("your file with file name " + str + " has been added.");
                                    System.out.println("======================================================================");
                                } else {
                                    System.out.println("======================================================================");
                                    System.err.println("File with given name already exists in this directory.");
                                    System.out.println("======================================================================");

                                }
                                break; //Breaking from the case 1 of case 2
                            }
                            case 12://Logic for deleting a file based on given input by user
                            {
                                System.out.println("Please enter the file name that you would like to be deleted");
                                System.err.println("!File names are case sensitive, please enter exact file name!");
                                String str = scanner.next();
                                File remFile = new File(str); // Creating File object with name remFile
                                if (remFile.delete()) //calling delete method of File class
                                {
                                    System.out.println("======================================================================");
                                    System.out.println("your file with file name " + str + " has been deleted.");
                                    System.out.println("======================================================================");
                                } else {
                                    System.err.println("File not Found");
                                }
                                break; //breaking from the inner case 2 of outer case 2
                            }
                            case 13: {//Searching the file by given user in the current directory
                                System.out.println("Enter the file name to be searched in this directory:");
                                System.err.println("!File names are case sensitive, please enter exact file name!");
                                String str = scanner.next();
                                File search = new File(str); //Creating File object with name search
                                //search.getAbsoluteFile();
                                if (search.exists()) {
                                    //If file with given name is not null and exists it will execute below
                                    //else will execute the else statement
                                    System.out.println("======================================================================");
                                    System.out.println("File has been found in " + search.getAbsolutePath());
                                    System.out.println("======================================================================");
                                } else {
                                    System.err.println(" File not found");
                                }
                                break; //breaking from the inner case 3 of the outer case 2
                            }
                            case 14: { //Logic for going back to main menu
                                System.err.println("Returning to the main menu!");
                                break;
                                //returning back to the main switch case i.e coming out of the do while loop of case 2
                            }
                            default:
                                if (suboption == 0) {
                                    System.out.println("Thanks for choosing Lockers Pvt. Ltd.");
                                    System.out.println("Exiting from the application");
                                    return;
                                } else {
                                    System.err.println("!!you have entered an invalid option, please try again!!");
                                }

                        }


                    } //Closing of do
                    while (suboption != 14);

                default:
                    if (option == 3) {
                        System.out.println("Thanks for choosing Lockers Pvt. Ltd.");
                        System.out.println("Exiting from the application");
                        return; //Closing the application and exiting the loop
                    } else {
                        System.err.println("you have entered an invalid option, please try again!!");
                    }

            }
        }
    }
    private static void displayFiles(String path) {
        String[] s;
        File f = new File(path);
        s=f.list();
        assert s != null;
        Arrays.sort(s);
        for (String x:s)
        {
            System.out.println(x);
        }

    }
}
