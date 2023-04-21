package prj5;

import java.util.Comparator;

public class CompareTraditional implements Comparator<Month>
{

    @Override
    public int compare(Month o1, Month o2) {
        return (int)(o1.getTradRate() - o2.getTradRate());
    }
    
    
}
