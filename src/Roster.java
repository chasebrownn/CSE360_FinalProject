/**
 *  Roster.java is our student roster constructor class. It contains the getters and setters for what is contained
 *  in our student object rows which will be displayed in our roster table following a .csv import. Simply declares
 *  6 different variables when you declare 1 roster object i.e. a new student. Those 6 variables include their student
 *  ID, first name, last name, major, level of graduate, and asurite username.
 */

public class Roster {

    private String student_id;
    private String first_name;
    private String last_name;
    private String major;
    private String level;
    private String asurite;

    public Roster(String student_id, String first_name, String last_name, String major, String level, String asurite)
    {
        this.student_id = student_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.major = major;
        this.level = level;
        this.asurite = asurite;
    }

    public Roster() 
    {
    	student_id = "1234567890";
    	first_name = "first";
    	last_name = "last";
    	major = "major";
    	level = "level";
    	asurite = "asurite";
    }
    
    public String getId()
    {
        return student_id;
    }

    public void setId(String tempArr)
    {
        this.student_id = tempArr;
    }

    public String getFirstName()
    {
        return first_name;
    }

    public void setFirstName(String first_name)
    {
        this.first_name = first_name;
    }

    public String getLastName()
    {
        return last_name;
    }

    public void setLastName(String last_name)
    {
        this.last_name = last_name;
    }

    public String getMajor()
    {
        return major;
    }

    public void setMajor(String major)
    {
        this.major = major;
    }

    public String getLevel()
    {
        return level;
    }

    public void setLevel(String level)
    {
        this.level = level;
    }

    public String getAsurite()
    {
        return asurite;
    }

    public void setAsurite(String asurite)
    {
        this.asurite = asurite;
    }

}
