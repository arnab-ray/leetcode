package design;

/**
 * @author arnab.ray
 * @created on 05/11/22
 */
public class Driver {
    public static void main(String[] args) {
        System.out.println("********* Twitter *********");
        Twitter twitter = new Twitter();
        twitter.postTweet(1, 5);
        System.out.println(twitter.getNewsFeed(1));

        twitter.follow(1, 2);
        twitter.postTweet(2, 6);
        System.out.println(twitter.getNewsFeed(1));

        twitter.unfollow(1, 2);
        System.out.println(twitter.getNewsFeed(1));

        System.out.println("********* File System *********");
        FileSystem obj = new FileSystem();
        System.out.println(obj.ls("/"));
        obj.mkdir("/a/b/c");
        obj.addContentToFile("/a/b/c/d", "hello");
        System.out.println(obj.ls("/"));
        System.out.println(obj.readContentFromFile("/a/b/c/d"));
    }
}
