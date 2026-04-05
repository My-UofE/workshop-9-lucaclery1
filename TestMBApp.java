public class TestMBApp {
    public static void main() {
        MessageBoard mb = new MessageBoard("Coding Support");
        mb.addPost("Alex Adam", "Help with Java", 
        "Hi, could anyone help me I need to learn how to code in java!"
        );
        mb.addPost("Belinda Bennett", "Help with Java", 
            "Hi Alex. Yes I can send some tutorials I found useful."
        );
        mb.addPost("Cindy Carter", "Coding on a Chromebook",
            "Hi, could anyone help me I need to learn how to code in java"
        );
        mb.addPost("Dennis Dobson", "Windows problems", 
            "My windows laptop is stuck on a reboot loop. Does anyone know what to do!"
        );
        int[] ids = mb.getPostIDs();
        for (int i=0; i<ids.length; i++) {
//            mb.getFormattedPost(ids[i]);
        }
        mb.addPost("Ellie", "Java IDE", 
        "Can someone recommend a Java IDE?", 20148
        );
        mb.addPost("Fred Fansha", "Java IDE", 
        "I just use VS Code", 20149
        );
        int[] subs = mb.searchPostsBySubject("java");
        for (int i=0; i<subs.length; i++) {
//            mb.getFormattedPost(subs[i]);
//            mb.deletePost(subs[i]);
        }
        int[] x = mb.getPostIDs();
        for (int i=0; i<x.length; i++) {
//            mb.getFormattedPost(x[i]);
        }
        int[] dat = mb.searchPostsByDate(20147, 20149);
        for (int i=0; i<dat.length; i++) {
            mb.getFormattedPost(dat[i]);
        }
        
    }
}
