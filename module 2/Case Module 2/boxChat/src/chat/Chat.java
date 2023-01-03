public class Chat {
    private String chat;

    public Chat (){
    }

    public Chat(String chat) {
        this.chat = chat;
    }

    @Override
    public String toString() {
        return "Chat{" +
                "chat='" + chat + '\'' +
                '}';
    }
}
