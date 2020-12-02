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

    /**
     * This constructor Roster() is for initializing the student variables before loading it with the correct
     *  information.
     * @param student_id contains a 10 digit student ID specific to every student
     * @param first_name student's first name
     * @param last_name student's last name
     * @param major display's student's field of study
     * @param level whether graduate, undergraduate, etc.
     * @param asurite asu-specific username / email
     */

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
    
    public String getId() // get id
    {
        return student_id;
    }

    public void setId(String tempArr) // set id
    {
        this.student_id = tempArr;
    }

    public String getFirstName() // get first name
    {
        return first_name;
    }

    public void setFirstName(String first_name) // set first name
    {
        this.first_name = first_name;
    }

    public String getLastName() // get last name
    {
        return last_name;
    }

    public void setLastName(String last_name) // set last name
    {
        this.last_name = last_name;
    }

    public String getMajor() // get major
    {
        return major;
    }

    public void setMajor(String major) // set major
    {
        this.major = major;
    }

    public String getLevel() // get level
    {
        return level;
    }

    public void setLevel(String level) // set level
    {
        this.level = level;
    }

    public String getAsurite() // get asurite
    {
        return asurite;
    }

    public void setAsurite(String asurite) // set asurite
    {
        this.asurite = asurite;
    }

}
