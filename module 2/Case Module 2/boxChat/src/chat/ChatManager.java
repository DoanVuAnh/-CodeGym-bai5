import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ChatManager {
    public static Scanner scanner = new Scanner(System.in);
    private List<Chat> chatList;
    private final ChatDao chatDao;

    public ChatManager() {
        chatList = new ArrayList<>();
        chatDao = new ChatDao();
        chatList = chatDao.read();
    }

    public void addChat() {
        String chat = inputChat();
        chatList.add(new Chat(chat));
        chatDao.write(chatList);
    }

    private String inputChat() {
        System.out.println("Input student chat: ");
        return scanner.nextLine();
    }
}
