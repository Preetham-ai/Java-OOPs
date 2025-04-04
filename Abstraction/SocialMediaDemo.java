abstract class SocialMediaPost {
    protected String author;
    protected String content;
    
    public SocialMediaPost(String author, String content) {
        this.author = author;
        this.content = content;
    }
    
    abstract void display();
    
    void showAuthor() {
        System.out.println("Posted by: " + author);
    }
}

class TwitterPost extends SocialMediaPost {
    public TwitterPost(String author, String content) {
        super(author, content);
    }
    
    void display() {
        System.out.println("Tweet: " + content);
        System.out.println("Like,Share,Subscribe");
    }
}

public class SocialMediaDemo {
    public static void main(String[] args) {
        SocialMediaPost tweet = new TwitterPost("java_dev", "Learning Java interfaces today!");
        
        tweet.showAuthor();
        tweet.display();
    }
}
