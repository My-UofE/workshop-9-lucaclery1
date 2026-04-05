import java.io.IOException;

public class TestMBLoadApp {
    public static void main(String args[]) {
        MessageBoard mb = new MessageBoard("Coding Support");
        try {
            mb.loadMessageBoard("codingsupport.ser");
        } catch( IOException ex ) {
            System.out.println("Board not loaded.");
            ex.printStackTrace();
        } catch( ClassNotFoundException e ) {
            System.out.println("Could not find class.");
            e.printStackTrace();
        }
        int[] ids = mb.getPostIDs();
        for (int i=0; i<ids.length; i++) {
            mb.getFormattedPost(ids[i]);
        }
        try {
            int[] subsposts = mb.searchPostsBySubject("windows");
            for (int i=0; i<subsposts.length; i++) {
                mb.savePostAsTextFile(subsposts[i], "windowspost.txt");
            }
            
        } catch( IOException ex ) {
                System.out.println("File not saved.");
                ex.printStackTrace();
        }
    }
}