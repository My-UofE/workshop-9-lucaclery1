import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class MessageBoard implements MessageBoardInterface {
    private List<Post> posts;
    private String boardName;

    public MessageBoard(String boardName) {
        this.boardName = boardName;
        this.posts = new ArrayList<>();
    }

    public String getBoardName() {
        return boardName;
    }
    public int[] getPostIDs() {
        int[] postIDs = new int[posts.size()];
        int i = 0;
        for (Post post : posts) {
            postIDs[i++] = post.getPostID();
        }
        return postIDs;
    }

    public int getPostIndex(int postID) throws IDInvalidException {
        for (int i = 0; i < posts.size(); i++) {
            if (posts.get(i).getPostID() == postID) {
                return i;
            }
        }
        throw new IDInvalidException("Invalid post ID.");
    }

    public int addPost(String author, String subject, String message){
        // this should create a new post and add it to the posts ArrayList
        Post a = new Post(author, subject, message);
        posts.add(a);
        return 1;
    }
    public String getFormattedPost(int postID) throws IDInvalidException{
        // this should make use of getPostIndex to access the post
        // and print it using the .toFormattedString() method
        int ind = 0;
        ind = getPostIndex(postID);
        String result;
        result = (this.posts.get(ind).toFormattedString());
        System.out.println(result);
        return result;
    }
    public int[] searchPostsBySubject(String subject) {
        List<Integer> subjectPosts = new ArrayList<>();
        for (Post post : posts) {
            if (post.getSubject().toLowerCase().contains(subject) == true) {
                subjectPosts.add(post.getPostID());
            }
        }
        int[] result = new int[subjectPosts.size()];
        for (int i = 0; i < subjectPosts.size(); i++){
            result[i] = subjectPosts.get(i);
        }
        return result;
    }
    public void deletePost(int PostID) {
        posts.remove(getPostIndex(PostID));
    }
    public int addPost(String author, String subject, String message, int epochDate) {
        Post b = new Post(author, subject, message, LocalDate.ofEpochDay(epochDate));
        posts.add(b);
        return 1;
    }
    public int[] searchPostsByDate(int startDate, int endDate) {
        List<Integer> DatePosts = new ArrayList<>();
        for (Post post : posts) {
            int date = post.getDate();
            if ((date >= startDate) && (date <= endDate)) {
                DatePosts.add(post.getPostID());
            }
        }
        int[] result = new int[DatePosts.size()];
        for (int i = 0; i < DatePosts.size(); i++){
            result[i] = DatePosts.get(i);
        }
        return result;
    }
    public void saveMessageBoard(String filename) throws IOException{
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename));
        // store boardName attribute
        out.writeObject(boardName);
        // convert posts to array Post[] to simplifies the deserialisation
        Post[] postArray = posts.toArray(new Post[posts.size()]);
        //  store Post array
        out.writeObject(postArray);
    } 
    public void loadMessageBoard(String filename) throws IOException, ClassNotFoundException{
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        String loadedName = (String)in.readObject();
        boardName = loadedName;
        Post[] loadedPosts = (Post[])in.readObject();
        posts = new ArrayList<Post>();
        for (Post post : loadedPosts) {
            posts.add(post);
        }
    }
    public void savePostAsTextFile(int PostID, String filename) throws IOException {
        Post post = posts.get(this.getPostIndex(PostID));
        post.saveAsTextFile(filename);
    }
}