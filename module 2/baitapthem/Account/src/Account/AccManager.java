import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class AccManager implements Serializable {

    public Scanner scanner =  new Scanner(System.in);
    public List<Account> accountList;

    public Account account =new Account();
    public AccManager (){
        accountList = new ArrayList<>();
    }

    public void addAcc() throws ParseException {
        int id = inputId();
        String username = inputUsername();
        String password= inputPassword();
        int phone = inputPhone();
        Date birthday = inputBirthday();

        accountList.add(new Account( id, username,password ,phone,birthday));

    }



    public void editAcc(String username){

            Account account = null;
            int size = accountList.size();
            for (Account value : accountList) {
                if (value.getUsername() == username) {
                    username = String.valueOf(value);
                    break;
                }
            }
            if (account != null) {
                accountList.remove(account);
            } else {
                System.out.printf("id = %d not existed.\n", username);
            }
        }




    public void displayByName(){
        System.out.println("Enter character you want search: ");
        String search = scanner.nextLine();

        int count = 0;
        for (Account a : accountList){
            if (a.getUsername().contains(search)){
                System.out.println("List Acc have name contains: ");
                System.out.println(a);
                count ++;
            }
        } if (count == 0){
            System.out.println("No username on the list");
        }
    }

    public void displayAcc(){
        for (Account account : accountList){
            System.out.format("%10d | ", account.getId());
            System.out.format("%10s | ", account.getUsername());
            System.out.format("%10s | ", account.getPassword());
            System.out.format("%20d | ", account.getPhone());
            System.out.format("%20d%n | ", account.getBirthday());

        }
    }

    private int inputId() {
        System.out.printf("Nhập ID: ");
        int id = scanner.nextInt();
        return id;
    }


    private String inputUsername() {
        System.out.printf("Nhập Username: ");
        return scanner.nextLine();
    }


    private String inputPassword() {
        System.out.printf("Nhập Password: ");
        return scanner.nextLine();
    }


    private int inputPhone() {
        System.out.printf("Nhập Phone: ");
        int phone = scanner.nextInt();
        return phone;
    }

    private Date inputBirthday() throws ParseException {
        System.out.println("Nhập Ngày, tháng , Năm: ");
        String stringDate = String.valueOf(account.getBirthday());
        Date date1 = (Date) new SimpleDateFormat("dd/MM/yyyy").parse(stringDate);
        return date1;
    }


}
