public class Attendance {
    //declare variables
    private String asurite;
    private int time;

    //constructor
    public Attendance(String asurite, int time){
        this.asurite = asurite;
        this.time = time;
    }

    //default constructor
    public Attendance(){
        asurite = "asurite";
        time = 70;
    }

    //setters
    public void setAsurite(String asurite) {
        this.asurite = asurite;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getAsurite(){
        return asurite;
    }

    public int getTime(){
        return time;
    }

    public int addTime(int newTime){
            time += newTime;
            return time;
            }
}
