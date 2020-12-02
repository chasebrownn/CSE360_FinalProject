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

    public String addTime(int newTime){
            time += newTime;
            return time;
            }
}
