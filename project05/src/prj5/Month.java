package prj5;

import java.util.Comparator;

/**
 * Month class
 * 
 * @author henryauvil
 * @version 2022.04.20
 */
public class Month {
    private int month;
    private int likes;
    private int posts;
    private int followers;
    private int comments;
    private int views;
    private String channelName;
    public static final String[] MONTHS = {"", "January", "February", "March",
        "April", "May", "June", "July", "August", "September", "October",
        "November", "December" };

    /**
     * Creates a new month with all of the data
     * 
     * @param month
     *            is the month for all of the data
     * @param likes
     *            is the number of likes during the month
     * @param posts
     *            is the number of posts during the month
     * @param followers
     *            is the number of followers during the month
     * @param comments
     *            is the number of comments during the month
     * @param views
     *            is the number of views during the month
     */
    public Month(
        int month,
        int likes,
        int posts,
        int followers,
        int comments,
        int views) {
        this.month = month;
        this.likes = likes;
        this.posts = posts;
        this.followers = followers;
        this.comments = comments;
        this.views = views;
    }


    /**
     * Method to get the month
     * 
     * @return the month
     */
    public int getMonth() {
        return month;
    }


    /**
     * sets a new channel name
     * 
     * @param n
     *            the new channel name
     */
    public void setChannelName(String n) {
        channelName = n;
    }


    /**
     * 
     * @return the name of the associated channel
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Method to get the number of likes
     * 
     * @return the likes for the month
     */
    public int getLikes() {
        return likes;
    }


    /**
     * Method to get the number of posts
     * 
     * @return the posts for the month
     */
    public int getPosts() {
        return posts;
    }


    /**
     * Method to get the number of followers
     * 
     * @return the followers for the month
     */
    public int getFollowers() {
        return followers;
    }


    /**
     * Method to get the number of comments
     * 
     * @return the comments for the month
     */
    public int getComments() {
        return comments;
    }


    /**
     * Method to get the number of views
     * 
     * @return the views for the month
     */
    public int getViews() {
        return views;
    }


    /**
     * Method to get the traditional rate
     * 
     * @return the calculated traditional rate
     */
    public double getTradRate() {
        return (((double)(comments + likes) / (double)followers) * 100.0);
    }


    /**
     * Method to get the reach rate
     * 
     * @return the calculated reach rate
     */
    public double getReachRate() {
        return (((double)(comments + likes) / (double)views) * 100.0);
    }
    
    
//    public static Comparator<Month> tradCompare()
//    {
//        return new Comparator<Month>()
//        {
//            /**
//             * 
//             */
//            @Override
//            public int compare(Month thisObj, Month oth)
//            {
//                if (thisObj.getTradRate() == oth.getTradRate())
//                {
//                    return thisObj.getChannelName()
//                        .compareTo(oth.getChannelName());
//                }
//                double doubleTrad = (oth.getTradRate() 
//                    - thisObj.getTradRate()) * 10;
//                return (int)doubleTrad;
//            }
//        };
//    }
//    
//    public static Comparator<Month> reachCompare()
//    {
//        return new Comparator<Month>()
//        {
//            /**
//             * 
//             */
//            @Override
//            public int compare(Month thisObj, Month oth)
//            {
//                if (thisObj.getReachRate() == oth.getReachRate())
//                {
//                    return thisObj.getChannelName()
//                        .compareTo(oth.getChannelName());
//                }
//                double doubleReach = (oth.getReachRate() 
//                    - thisObj.getReachRate()) * 10;
//                return (int)doubleReach;
//            }
//        };
//    }
//    
//    public static Comparator<Month> nameCompare()
//    {
//        return new Comparator<Month>()
//        {
//            /**
//             * 
//             */
//            @Override
//            public int compare(Month thisObj, Month oth)
//            {
//                return thisObj.getChannelName()
//                    .compareTo(oth.getChannelName());
//            }
//        };
//    }
    
    

    /**
     * Method to get the string form of the month
     * 
     * @return the string form of the month
     */
    public String toString() {
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


    /**
     * Checks if two objects are the same
     * 
     * @param obj
     *            The thing to be checked
     * @return
     *         if both are equal or not
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass() != this.getClass()) {
            return false;
        }
        Month temp = (Month)obj;

        return temp.getComments() == comments && temp
            .getFollowers() == followers && temp.getLikes() == likes && temp
                .getMonth() == month && temp.getPosts() == posts;
    }
    

}
