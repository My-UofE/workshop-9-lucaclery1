import java.io.IOException;

public class TestPostApp {
    public static void main() {
        Post a1 = new Post("Alex Adam", "Help with JavaE", "Hi, could anyone help me I need to learn how to code in java", null);
        System.out.println(a1.toString());
        try {
            // code to save the post
            a1.saveAsTextFile("mypost.txt");
        } catch( IOException ex ) {
            System.out.println("File not saved.");
            ex.printStackTrace();
        }
    }
}
