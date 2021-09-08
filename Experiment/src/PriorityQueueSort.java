import java.util.Date;
import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueSort {

    public static void main(String args[]) throws InterruptedException {

        Queue<Tweet> queue = new PriorityQueue<>(
                (tweet1, tweet2) -> tweet2.getTimeStamp().compareTo(tweet1.getTimeStamp())
        );

        Tweet tweet1 = new Tweet(1, new Date());
        queue.offer(tweet1);
        Thread.sleep(100);

        Tweet tweet2 = new Tweet(2, new Date());
        queue.offer(tweet2);

        queue.forEach(tweet -> {
            System.out.println(tweet.tweetId);
        });



    }
}

class Tweet {
    int tweetId;
    Date timeStamp;
    Tweet(int tweetId, Date timeStamp){
        this.tweetId = tweetId;
        this.timeStamp = timeStamp;
    }
    public Date getTimeStamp() {
        return this.timeStamp;
    }

}
