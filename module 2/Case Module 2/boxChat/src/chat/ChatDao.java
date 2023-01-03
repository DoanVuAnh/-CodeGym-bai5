import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class ChatDao {
    private static final String STUDENT_FILE_NAME = "src/chat.txt";

    public void write(List<Chat> studentList){
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try{
            fos = new FileOutputStream(new File(STUDENT_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(studentList);
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    public List<Chat> read(){
        List<Chat> studentList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(STUDENT_FILE_NAME));
            ois = new ObjectInputStream(fis);
            studentList = (List<Chat>) ois.readObject();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (EOFException e){
            System.out.println("file rong");
        } catch (IOException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        finally {
            closeStream(fis);
            closeStream(ois);
        }
        return studentList;
    }

    private void closeStream(InputStream is) {
        if (is != null){
            try {
                is.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    private void closeStream(OutputStream os){
        if (os != null){
            try {
                os.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
