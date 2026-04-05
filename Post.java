import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Post implements Serializable {

    // Attributes
    private static int idCounter = 0;
    private int postID;
    private String author;
    private String subject;
    private String message;
    private int date;

    public Post(String author, String subject, String message) {
        this(author, subject, message, null);
    }

    public Post(String author, String subject, String message, LocalDate date) {
        this.postID = ++idCounter;
        this.author = author;
        this.subject = subject;
        this.message = message;
        if (date == null) {
            this.date = (int)LocalDate.now().toEpochDay();
        } else {
            this.date = (int)date.toEpochDay();
        }
    }

    public String toString() {
        String result = String.format("Post[postID=%d, author=\"%s\", subject=\"%s\", message=\"%s\", date=%d]", 
                                postID, author, subject, message.replace("\n", "\\n"), date);
        return result;
    }
    public int getPostID() {
        return this.postID;
    }
    public String getAuthor() {
        return this.author;
    }
    public String getSubject() {
        return this.subject;
    }
    public String getmessage() {
        return this.message;
    }
    public int getDate() {
        return this.date;
    }
    public String toFormattedString() {
        LocalDate postDate = LocalDate.ofEpochDay(this.date);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
        String result = "\n------------------  Post " + postID + "  -------------------" + 
        "\nAuthor: " + author + 
        "\nDate: " + postDate.format(formatter) + 
        "\nSubject: " + subject + "\n" + 
        "----  Message:  -------------------------------\n" +  
        message + 
        "\n-----------------------------------------------\n";
        return result;
    }
    public void saveText() throws IOException {
        String filename = "mypost";
        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(filename));
            out.write(this.toFormattedString());
            out.close();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
    
}