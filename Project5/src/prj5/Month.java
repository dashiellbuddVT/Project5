package prj5;

/**
 * Month class
 * @author henryauvil
 * @version 2022.04.20
 */
public class Month 
{
    private int month;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;
    public static final String[] MONTHS = {"January", "February", 
        "March", "April", "May", "June", "July", "August", 
        "September", "October", "November", "December"};
    
    /**
     * Creates a new month with all of the data
     * @param month is the month for all of the data
     * @param likes is the number of likes during the month
     * @param posts is the number of posts during the month
     * @param followers is the number of followers during the month
     * @param comments is the number of comments during the month
     * @param views is the number of views during the month
     */
    public Month(int month, int likes, int posts, 
        int followers, int comments, int views)
    {
        this.month = month;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }
    
    /**
     * Method to get the month
     * @return the month
     */
    public int getMonth()
    {
        return month;
    }
    
    /**
     * Method to get the number of likes
     * @return the likes for the month
     */
    public int getLikes()
    {
        return likes;
    }
    
    /**
     * Method to get the number of posts
     * @return the posts for the month
     */
    public int getPosts()
    {
        return posts;
    }
    
    /**
     * Method to get the number of followers
     * @return the followers for the month
     */
    public int getFollowers()
    {
        return followers;
    }
    
    /**
     * Method to get the number of comments
     * @return the comments for the month
     */
    public int getComments()
    {
        return comments;
    }
    
    /**
     * Method to get the number of views
     * @return the views for the month
     */
    public int getViews()
    {
        return views;
    }
    
    /**
     * Method to get the traditional rate
     * @return the calculated traditional rate
     */
    public double getTradRate()
    {
        return (((comments + likes) / followers) * 100);
    }
    
    /**
     * Method to get the reach rate
     * @return the calculated reach rate
     */
    public double getReachRate()
    {
        return (((comments + likes) / views) * 100);
    }
    
    /**
     * Method to get the string form of the month
     * @return the string form of the month
     */
    public String toString()
    {
        String str = "";
        str += ("(Month: ");
        str += (month);
        str += (", Likes: ");
        str += (likes);
        str += (", Posts: ");
        str += (posts);
        str += (", Followers: ");
        str += (followers);
        str += (", Comments: ");
        str += (comments);
        str += (", Views: ");
        str += (views);
        str += (")");
        return str;
    }
    
    
    
    
}
