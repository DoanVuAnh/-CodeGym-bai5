package Hotel;

public class Hotel {
    private int id;
    private int type;
    private String stt;

    public Hotel() {
    }

    public Hotel(int id, int type, String stt) {
        this.id = id;
        this.type = type;
        this.stt = stt;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getSst() {
        return stt;
    }

    public void setStt(String stt) {
        this.stt = stt;
    }

    @Override
    public String toString() {
        return "Hotel.Hotel{" +
                "id=" + id +
                ", type=" + type +
                ", sst=" + stt +
                '}';
    }
}
