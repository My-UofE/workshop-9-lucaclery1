import java.io.*;
import java.time.LocalDate;
import java.util.*;


public class MessageBoard implements Serializable {
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

}