package Hotel;

import Hotel.HotelManager;

import java.util.Scanner;

public class HotelMenu {
    public static Scanner scanner = new Scanner(System.in);
    HotelManager hotelManager = new HotelManager();

    public void menuHotel(){
        String choose =null;
        boolean exit = false;
        int hotelId;
        do{
            System.out.println("1 add");
            System.out.println("2 edit");
            System.out.println("3 show");
            System.out.println("0 thoat");
            System.out.println("---- chon: ");
            choose = scanner.nextLine();
            switch (choose){
                case "1":
                    hotelManager.addHotel();
                    break;
                case "2":
                    hotelId = hotelManager.inputId();
                    hotelManager.editHotel(hotelId);
                    break;
                case "3":
                    hotelManager.showHotel();
                    break;
                case "0":
                    System.out.println("Exited");
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid! Please choose action in below menu: ");
            } if (exit){
                break;
            }
        } while (choose != null);
    }
}
