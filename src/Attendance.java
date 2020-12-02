
/**
 *  Attendance.java is our attendance constructor class. It contains the getters and setters for what is contained
 *  in our student object rows following attendance added (post roster added) which will be displayed in our roster
 *  table following a .csv import. Simply declares 2 different variables when you add attendance of an existing student.
 *  Those 2 variables include their asurite username (which it uses to see if that student was added previously view roster)
 *  as well as their time in minutes that they were in attendance.
 */

public class Attendance {
    
	//declare variables
    private String asurite;
    private String time;

    //constructor
    public Attendance(String asurite, String time){
        this.asurite = asurite;
        this.time = time;
    }

    //default constructor
    public Attendance(){
        asurite = "asurite";
        time = "100";
    }

    //setters
    public void setAsurite(String asurite) {
        this.asurite = asurite;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAsurite(){
        return asurite;
    }

    public String getTime(){
        return time;
    }

    public int addTime(int newTime){
            int timeInt = Integer.parseInt(time);
    		timeInt += newTime;
            return timeInt;
            }
}
