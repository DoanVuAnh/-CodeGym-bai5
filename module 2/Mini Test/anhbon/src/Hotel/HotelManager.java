package Hotel;

import Hotel.Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HotelManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Hotel> hotelList;
    public final HotelDao hotelDao;

    public HotelManager() {
        hotelList = new ArrayList<>();
        hotelDao = new HotelDao();

        hotelList = hotelDao.read();

    }

    public void addHotel() {
        int id = inputId();
        int type = inputType();
        String stt = inputStt();
        hotelList.add(new Hotel(id, type, stt));
        hotelDao.write(hotelList);

    }

    int inputId() {
        System.out.println("nhap id: ");
        int id = Integer.parseInt((scanner.nextLine()));
        return id;
    }


    private String inputStt() {
        System.out.println("nhap stt: ");
        String stt = scanner.nextLine();
        return stt;
    }

    private int inputType() {
        System.out.println("nhap type: ");
        int type = Integer.parseInt((scanner.nextLine()));
        return type;
    }

    public void editHotel(int id) {
        boolean isExisted = false;
        for (Hotel hotel : hotelList) {
            if (hotel.getId() == id) {
                isExisted = true;
                hotel.setType(inputType());
                hotel.setStt(inputStt());
                break;
            }
        }
        if (!isExisted){
            System.out.println("ko co");
        } else {
            hotelDao.write(hotelList);
        }
    }

    public void showHotel(){
        for (int i = 0; i < hotelList.size(); i++){
            System.out.println(hotelList.get(i).toString());
        }
    }


}
