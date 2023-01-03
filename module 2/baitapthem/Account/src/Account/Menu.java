import java.text.ParseException;
import java.util.Scanner;

public class Menu {
    public static Scanner scanner ;
    AccManager accManager = new AccManager();
    public Menu(){
    }

    public void menuAcc() throws ParseException {
        String choose = null;
        boolean exit = false;

        String username = null;

        do {
            System.out.println("MENU");
            System.out.println("1. add acc");
            System.out.println("2. edit by Username");
            System.out.println("3. display by name");
            System.out.println("4. display acc");
            System.out.println("0. Exit");
            System.out.println("0. Exit");
            System.out.println("Please choose: ");

            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    accManager.addAcc();
                    break;
                case "2":
                    accManager.editAcc(username);
                    break;
                case "3":
                    accManager.displayByName();
                    break;
                case "4":
                    accManager.displayAcc();
                    break;
                case "0":
                    System.out.println("Exited!");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action in below menu:");
            }

        }while (!exit && choose != null);
}}
