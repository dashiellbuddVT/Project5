package prj5;

import java.util.Comparator;

/**
 * This class handles the account data format
 * 
 * @author Group
 * @version 21 April 2023
 *
 */
public class Account {

    private String name;
    private String country;
    private String topic;
    private Month[] monthData;

    /**
     * this is the constructor
     * 
     * @param name
     *            name of social media user
     * @param country
     *            country where the account is based in, including taiwan
     * @param topic
     *            main topic of the social media account
     */
    public Account(String name, String country, String topic) {
        this.name = name;
        this.country = country;
        this.topic = topic;
        monthData = new Month[17];
    }


    /**
     * returns the data of a specific month
     * 
     * @param index
     *            1-12 jan-dec month data
     *            13-17 q1,q2,q3,q4 data
     * @return
     *         returns the data for that month/quarter
     */
    public Month getMonth(int index) {
        return monthData[index];
    }
    
    /**
     * Method to get monthData array
     * @return the month data array
     */
    public Month[] getMonths()
    {
        return monthData;
    }


    /**
     * returns the name of the social media account
     * 
     * @return
     *         social media account name ie., DanTDM, Odds1Out, Pewdiepie, etc.
     */
    public String getName() {
        return name;
    }


    /**
     * returns the country the account is based in
     * 
     * @return
     *         the country, ie. Taiwan, Japan, United States, Canada etc.
     */
    public String getCountry() {
        return country;
    }


    /**
     * returns the main topic of the social media account
     * 
     * @return
     *         social media topic, ie news, sports, art, etc.
     */
    public String getTopic() {
        return topic;
    }


    /**
     * sets the data of that month
     * 
     * @param m
     *            the month's data
     */
    public void setMonth(Month m) {
        monthData[m.getMonth()] = m;
        m.setChannelName(name);
        for (int i = 0; i < 4; i++) {
            setQuarter(i);
        }
    }


    /**
     * Sets the data of the quarter, 13,14,15,16 q1,q2,q3,q4 correspondingly
     * 
     * @param quarter
     *            Reference
     *            to this
     *            13 = q1
     *            14 = q2
     *            15 = q3
     *            16 = q4
     */
    public void setQuarter(int quarter) {
        int likes = 0;
        int posts = 0;
        int followers = 0;
        int comments = 0;
        int views = 0;
        
        
        for (int i = quarter * 3 + 1 ; i < (quarter + 1) * 3 + 1; i++) {
            if (monthData[i] != null) {
                likes += monthData[i].getLikes();
                posts += monthData[i].getPosts();
                followers = monthData[i].getFollowers();
                comments += monthData[i].getComments();
                views += monthData[i].getViews();
            }
        }

        Month m = new Month(quarter + 13, likes, posts,
                followers, comments, views);
        m.setChannelName(name);
        monthData[quarter + 13] = m;
    }
    

    /**
     * Method to return a new comparator for traditional rate
     * @return a comparator for accounts based on traditional rate
     */
    public static Comparator<Account> tradCompare()
    {
        return new Comparator<Account>()
        {
            /**
             * 
             */
            public int compare(Account thisObj, Account oth, int u)
            {
                if (thisObj.getMonth(u).getTradRate() 
                    == oth.getMonth(u).getTradRate())
                {
                    return thisObj.getMonth(u).getChannelName()
                        .compareTo(oth.getMonth(u).getChannelName());
                }
                double doubleTrad = (oth.getMonth(u).getTradRate() 
                    - thisObj.getMonth(u).getTradRate()) * 10;
                return (int)doubleTrad;
            }

            @Override
            public int compare(Account o1, Account o2) 
            {
                return 0;
            }
        };
    }
    
    /**
     * Method to return a new comparator for reach rate
     * @return a comparator for accounts based on reach rate
     */
    public static Comparator<Account> reachCompare()
    {
        return new Comparator<Account>()
        {
            /**
             * 
             */
            public int compare(Account thisObj, Account oth, int u)
            {
                if (thisObj.getMonth(u).getReachRate() 
                    == oth.getMonth(u).getReachRate())
                {
                    return thisObj.getName()
                        .compareTo(oth.getName());
                }
                double doubleReach = (oth.getMonth(u).getReachRate() 
                    - thisObj.getMonth(u).getReachRate()) * 10;
                return (int)doubleReach;
            }

            @Override
            public int compare(Account o1, Account o2) 
            {
                return 0;
            }
        };
    }
    
    /**
     * Method to return a new comparator for name
     * @return a comparator for accounts based on name
     */
    public static Comparator<Account> nameCompare()
    {
        return new Comparator<Account>()
        {
            /**
             * 
             */
            @Override
            public int compare(Account thisObj, Account oth)
            {
                return thisObj.getName().toLowerCase()
                    .compareTo(oth.getName().toLowerCase());
            }
        };
    }
    
    


    /**
     * Equals method,
     * 
     * @param obj
     *            thing to be checked
     * @return
     *         if both are equals;
     */
    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj.getClass().equals(this.getClass())) {
            Account temp = (Account)obj;
            boolean flag = true;
            if (!temp.getCountry().equals(country)) {
                return false;
            }
            if (!temp.getName().equals(name)) {
                return false;
            }
            if (!temp.getTopic().equals(country)) {
                return false;
            }

            for (int i = 1; i < 14; i++) {
                if (!monthData[i].equals(temp.getMonth(i))) {
                    flag = false;
                }
            }
        }
        return false;
    }
}
