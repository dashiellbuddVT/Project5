package prj5;

import java.util.Comparator;

/**
 * this compares the comparator
 * 
 * @author Group
 * @version 4/21/2023
 */
public class CompareName implements Comparator<Month> {
    
    public int compare(Month o1, Month o2) {
        return o1.getChannelName().compareTo(o2.getChannelName());
    }
}
