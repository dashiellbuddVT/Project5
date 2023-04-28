package prj5;

import java.awt.Color;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;
import java.util.*;

/**
 * Class to create a new GUI and display the data
 * @author henryauvil
 * @version 2023.04.26
 *
 */
public class Display 
{
    private Window myWindow;
    private Button trad;
    private Button reach;
    private Button name;
    private Button engage;
    private Button jan;
    private Button feb;
    private Button mar;
    private Button quar;
    private Button quit;
    private boolean isReach;
    private boolean isJan;
    private boolean isFeb;
    private boolean isMar;
    private boolean isQuar;
    private boolean isName;
    private Controller reader;
    
    /**
     * Initialize all fields and create GUI and buttons
     * @param cont is the controller used for the displayed data
     */
    public Display(Controller cont)
    {
        reader = cont;
        isReach = false;
        isJan = true;
        isFeb = false;
        isMar = false;
        isQuar = false;
        isName = true;
        
        myWindow = new Window();
        myWindow.setTitle("Social Media Vis");
        trad = new Button("Traditional Engagement Rate");
        trad.onClick(this, "clickedTrad");
        reach = new Button("Reach EngagementRate");
        reach.onClick(this, "clickedReach");
        name = new Button("Sort by Channel Name");
        name.onClick(this, "clickedName");
        engage = new Button("Sort by Engagement Rate");
        engage.onClick(this, "clickedEngage");
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        
        myWindow.addButton(name, WindowSide.NORTH);
        myWindow.addButton(engage, WindowSide.NORTH);
        myWindow.addButton(quit, WindowSide.NORTH);
        myWindow.addButton(trad, WindowSide.WEST);
        myWindow.addButton(reach, WindowSide.WEST);
        
        jan = new Button("January");
        jan.onClick(this, "clickedJan");
        feb = new Button("February");
        feb.onClick(this, "clickedFeb");
        mar = new Button("March");
        mar.onClick(this, "clickedMar");
        quar = new Button("First Quarter (Jan-March)");
        quar.onClick(this, "clickedQuar");
        
        myWindow.addButton(jan, WindowSide.SOUTH);
        myWindow.addButton(feb, WindowSide.SOUTH);
        myWindow.addButton(mar, WindowSide.SOUTH);
        myWindow.addButton(quar, WindowSide.SOUTH);
        //update();
        
        
        
    }
    
    /**
     * Method for clicking traditional rate button
     * @param button traditional button
     */
    public void clickedTrad(Button button) {
        if (reader.ready()) 
        {
            isReach = false;
            //reader.sortByTrad(reader.getAccountList());
            update();
        }
    }
    
    /**
     * Method for clicking reach rate button
     * @param button is the reach button
     */
    public void clickedReach(Button button) 
    {
        if (reader.ready()) 
        {
            isReach = true;
            //reader.sortByReach(reader.getAccountList());
            update();
        }
    }
    
    /**
     * Method for clicking name  button
     * @param button is the name button
     */
    public void clickedName(Button button) {
        if (reader.ready()) 
        {
            isName = true;
            reader.sortByName(reader.getAccountList());
            update();
        }
    }
    
    /**
     * Method for clicking sort by engagement button
     * @param button is the engagement button
     */
    public void clickedEngage(Button button) {
        if (reader.ready()) 
        {
            isName = false;
            if (isReach == true)
            {
                reader.sortByReach(reader.getAccountList());
            }
            else
            {
                reader.sortByTrad(reader.getAccountList());
            }
            update();
        }
    }
    
    /**
     * Method for clicking the quit button
     * @param button is the quit button
     */
    public void clickedQuit(Button button) 
    {
        System.exit(0);
    }
    
    /**
     * Method for clicking the january button
     * @param button is the january button
     */
    public void clickedJan(Button button) {
        if (reader.ready()) 
        {
            isJan = true;
            isFeb = false;
            isMar = false;
            isQuar = false;
            
            update();
        }
    }
    
    /**
     * Method for clicking the february button
     * @param button is the february button
     */
    public void clickedFeb(Button button) {
        if (reader.ready()) 
        {
            isJan = false;
            isFeb = true;
            isMar = false;
            isQuar = false;
            
            update();
        }
    }
    
    /**
     * Method for clicking the march button
     * @param button is the march button
     */
    public void clickedMar(Button button) {
        if (reader.ready()) 
        {
            isJan = false;
            isFeb = false;
            isMar = true;
            isQuar = false;
            
            update();
        }
    }
    
    /**
     * Method for clicking the quarter button
     * @param button is the quarter button
     */
    public void clickedQuar(Button button) {
        if (reader.ready()) 
        {
            isJan = false;
            isFeb = false;
            isMar = false;
            isQuar = true;
            
            update();
        }
    }
    
    /**
     * Method to remove all existing shapes and redraw new 
     * bars based on what the user wants to see
     */
    private void update() {
        myWindow.removeAllShapes();
        drawBars();
    }
    
    /**
     * Method to draw bars based on what the user requests
     */
    private void drawBars()
    {
        Month[] months = reader.getMonths();
        int barH = 0;
        
        // First index label
        TextShape index1 = new TextShape(5, 5, "No Month");
        if (isJan == true)
        {
            index1 = new TextShape(5, 5, "January");
        }
        else if (isFeb == true)
        {
            index1 = new TextShape(5, 5, "February");
        }
        else if (isMar == true)
        {
            index1 = new TextShape(5, 5, "March");
        }
        else if (isQuar == true)
        {
            index1 = new TextShape(5, 5, "First Quarter (Jan-March)");
        }
        myWindow.addShape(index1);
        
        // Second index label
        TextShape index2 = new TextShape(5, 20, "No Rate");
        if (isReach == true)
        {
            index2 = new TextShape(5, 20, "Reach Engagement Rate");
        }
        else
        {
            index2 = new TextShape(5, 20, "Traditional Engagement Rate");
        }
        myWindow.addShape(index2);
        
        // Third index label
        TextShape index3 = new TextShape(5, 35, "No Sort");
        if (isName == true)
        {
            index3 = new TextShape(5, 35, "Sorting By Channel Name");
        }
        else
        {
            index3 = new TextShape(5, 35, "Sorting By Engagement Rate");
        }
        myWindow.addShape(index3);
        
        //Getting the correct month array position
        int mon = 0;
        if (isJan == true)
        {
            mon = 1;
        }
        else if (isFeb == true)
        {
            mon = 2;
        }
        else if (isMar == true)
        {
            mon = 3;
        }
        else if (isQuar == true)
        {
            mon = 13;
        }
        
        // Building the bars
        for (int i = 0; i < 4; i++)
        {
            int offset = 80 + (150*i);
            int height = 10;
            TextShape text2 = null;
            if (isReach == false)
            {
                height = (int)reader.getAccountList()
                    .get(i).getMonth(mon).getTradRate();
                text2 = new TextShape(offset, 270, ""+ (int)reader.getAccountList()
                .get(i).getMonth(mon).getTradRate());
            }
            else
            {
                height = (int)reader.getAccountList()
                    .get(i).getMonth(mon).getReachRate();
                text2 = new TextShape(offset, 270, ""+ (int)reader.getAccountList()
                .get(i).getMonth(mon).getReachRate());
            }
            Shape bar = new Shape(offset, 250-height, 20, height);
            myWindow.addShape(bar);
            TextShape text1 = new TextShape(offset, 250, reader.getAccountList()
                .get(i).getMonth(mon).getChannelName());
            myWindow.addShape(text1);
            
            myWindow.addShape(text2);
            
        }
        
    }
    
    
    
    
}
