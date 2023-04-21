package prj5;

public class Account {

    private String name;
    private String country;
    private String topic;
    Month[] monthData;
    
 
    public Account(String name, String country, String topic)
    {
        this.name = name;
        this.country = country;
        this.topic = topic;
        monthData = new Month[17];
    }
    
    public Month getMonth(int index)
    {
        return monthData[index];
    }
    
    public String getName()
    {
        return name;
    }
    
    public String getCountry()
    {
        return country;
    }
    
    public String getTopic()
    {
        return topic;
    }
    
    public void setMonth(Month m)
    {
        monthData[m.getMonth()] = m;
        m.setChannelName(name);
        for(int i = 0; i< 4; i++)
        {
            setQuarter(i);
        }
    }
    
    /**
     * 
     * @param quarter 0 - 3 depending on the quarter
     * @return
     */
    public void setQuarter(int quarter)
    {
        int likes = 0;
        int posts = 0;
        int followers = 0;
        int comments = 0;
        int views = 0;
        
        for(int i = quarter*3 ; i < (quarter+1) * 3 ; i++)
        {
            if(monthData[i] != null)
            {
                likes += monthData[i].getLikes();
                posts += monthData[i].getPosts();
                followers = monthData[i].getFollowers();
                comments += monthData[i].getComments();
                views += monthData[i].getViews();
            }
        }
        
        
        Month m = new Month(13, likes, posts, followers, comments, views);
        monthData[quarter + 13] = m;
    }
}
