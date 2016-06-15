package game;

public class ChronometerDisplay extends Thread
{
    private NumberDisplay seconds;
    private NumberDisplay minutes;
    private String displayString;    // simulates the actual display
    
    /**
     * Constructor for ChronometerDisplay objects. This constructor 
     * creates a new clock set at 00:00.
     */
    public ChronometerDisplay()
    {
        seconds= new NumberDisplay(60);
        minutes = new NumberDisplay(60);
        updateDisplay();
    }

    /**
     * Constructor for ChronometerDisplay objects. This constructor
     * creates a new clock set at the time specified by the 
     * parameters.
     */
    public ChronometerDisplay(int minute, int second)
    {
        seconds= new NumberDisplay(60);
        minutes = new NumberDisplay(60);
        setTime( minute, second);
    }

    /**
     * This method should get called once every minute - it makes
     * the clock display go one minute forward.
     */
    public void timeTick()
    {
        seconds.decrement();
        if(seconds.getValue() == 59) {  // it just rolled over!
            minutes.decrement();
        }
        updateDisplay();
    }

    /**
     * Set the time of the display to the specified hour and
     * minute.
     */
    public void setTime(int minute, int second)
    {
        seconds.setValue(second);
        minutes.setValue(minute);
        updateDisplay();
    }

    /**
     * Return the current time of this display in the format HH:MM.
     */
    public String getTime()
    {
        return displayString;
    }
    
    /**
     * Update the internal string that represents the display.
     */
    private void updateDisplay()
    {
        displayString = minutes.getDisplayValue() + ":" + 
                        seconds.getDisplayValue();
    }
}
