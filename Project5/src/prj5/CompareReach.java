package prj5;

import java.util.Comparator;

public class CompareReach implements Comparator<Month>
{

    @Override
    public int compare(Month o1,  Month o2) {
       return (int)(o2.getReachRate() - o1.getReachRate());
    }

}
