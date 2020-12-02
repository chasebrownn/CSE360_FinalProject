import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is our "Main" class aka MainFrame. This is where all of the magic happens. It first declares all of the objects
 * needed to build our project interface; JMenuBar is our top menu bar, JMenuItem holds all of our "interactables"
 * or all of the different objects the user can click and interact with. Such as save, load roster, about, plot, and
 * add attendance. Under that you can find the JTable which is where we write our table from Table.java
 * We then declare our 2d arrays which is where we store our student data pulled from the loadroster csv and the
 * add attendnace csv.
 */

public abstract class MainFrame extends JFrame implements ActionListener
{
	public static final String delimiter = ",";

	static JMenuBar menuBar; //object menubar
	
	static JMenu fileMenu; //menu button for main file operations
	
	static JMenu aboutMenu; //menu button for about dialog box
	
	static JMenuItem aboutUs; //menubar option for seeing the About Us info
	static JMenuItem loadRoster; //menubar option for load a roster
	static JMenuItem addAttendance; //option for add attendance
	static JMenuItem save; //option for saving
	static JMenuItem plotData; //option for plotting data
	
	static JFrame mainFrame; //main window for the application
	
	public static JTable mainTable = new JTable(); //JTable creation
	static DefaultTableModel dTableModel = new DefaultTableModel(0,0); //default table setup
	static String headers[] = {"ID", "First Name", "Last Name", "Program", "Level", "ASURITE"}; //headers for JTable
	
	public static List<Roster> rosterInfo = new ArrayList<>(); //array list for roster table data
	public static List<Attendance> attendanceInfo = new ArrayList<>();
	
	public static ArrayList<String[]> tableData = new ArrayList<String[]>();
	static JScrollPane scrollPane; //scroll pane for JTable

	/**
	 * Our load() method takes csvFile and iterates through every line that is not NULL. When the line is not NULL
	 * it pulls the student's information in the 6 categories in order from student ID all the way to asurite and
	 * adds it to our student roster
	 * @param csvFile The csvFile is our file that the user loads into the program which holds our roster info
	 */
	
	public static void load(File csvFile) //load method to load all roster info from csv file
    {
        
        try 
        {
            FileReader fr = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
 
            while((line = br.readLine()) != null)
            {
            	Roster added = new Roster();
                tempArr = line.split(delimiter);
                added.setId(tempArr[0]);
                added.setFirstName(tempArr[1]);
                added.setLastName(tempArr[2]);
                added.setMajor(tempArr[3]);
                added.setLevel(tempArr[4]);
                added.setAsurite(tempArr[5]);
                rosterInfo.add(added);
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
    }

	/**
	 * LoadAtt() is what is called when the user wants to load attendance for the existing students within the
	 * roster. This is done after load() is terminated.
	 * @param attCSV Is the csv file that the user loads into the program. This file holds 2 categories, asurite and
	 *               time attended class (in minutes)
	 */

	public static void loadAtt(File attCSV) //load method to load all attendance data from csv file
	{
		try 
        {
            FileReader fr = new FileReader(attCSV);
            BufferedReader br = new BufferedReader(fr);
            String line = "";
            String[] tempArr;
 
            while((line = br.readLine()) != null)
            {
            	Attendance added = new Attendance();
                tempArr = line.split(delimiter);
                added.setAsurite(tempArr[0]);
                added.setTime(tempArr[1]);
                attendanceInfo.add(added);
            }
            br.close();
        } catch(IOException ioe) {
            ioe.printStackTrace();
        }
	}

	/**
	 * This called to display any students that were add via attendance, but werent included in the roster.
	 * @param a 2d array holding the students' information: asurite and attendance
	 * @return a stacked string holding a sentence in the form of "asurite for x minutes"
	 */
	
	public static String printAdd(String[][] a)
	{
		String s = "";
		for(int i = 0; i < a.length; i++)
		{
			if(a[i][0] != null)
			{
				s += a[i][0] + " for " + a[i][1] + " minutes \n";
			}
		}
		return s;
	}

	/**
	 * Main method
	 * @param args Input
	 */
	
	public static void main(String[] args) 
	{
		//Main stage for the program
		mainFrame= new JFrame("CSE360 Final Project"); //creation of frame for main window with name "CSE360 Final Project"
		
		//Addition of Menu Bar with items File and About
		menuBar = new JMenuBar(); //creation of the main menu bar
		fileMenu = new JMenu("File"); //creation of file drop down
		aboutMenu = new JMenu("About"); //creation of about drop down
		
		//Menu Item Additions
		aboutUs = new JMenuItem("About Us"); //about us option in about
		loadRoster = new JMenuItem("Load a Roster"); //load option in file
		addAttendance = new JMenuItem("Add Attendance"); //add option
		save = new JMenuItem("Save"); //save option
		plotData = new JMenuItem("Plot Data"); //plot data option
		
		//action listener for when someone clicks the about us menu option
		aboutUs.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e)
			{
				JOptionPane.showMessageDialog(mainFrame, "CSE360 Team: Keenan High, Brandon Phillips, Chase Brown, Jemiah Martin, Sergio Castillo"); //dialog box pop up with names
			}
		});

		//action listener for when clicking the load roster option
		loadRoster.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser(); //creation of chooser
				switch (fileChooser.showOpenDialog(mainFrame))
				{
				case JFileChooser.APPROVE_OPTION:
					
					File newCSV = fileChooser.getSelectedFile(); //set selected file to newCSV
					load(newCSV); //load method for the selected CSV, loads the data into a Linked List
					
					dTableModel.setColumnIdentifiers(headers); //setting the headers
					mainTable.setModel(dTableModel); //setting the table to default model
					int rosterSize = rosterInfo.size(); //getting size of the roster
					String [][] rosterLoaded = new String [rosterSize][6]; //creating new 2D array
					
					for (int i = 0; i < rosterSize; i++) //load all data points from the roster array list from CSV into the 2D array
					{
						rosterLoaded[i][0] = rosterInfo.get(i).getId();
						rosterLoaded[i][1] = rosterInfo.get(i).getFirstName();
						rosterLoaded[i][2] = rosterInfo.get(i).getLastName();
						rosterLoaded[i][3] = rosterInfo.get(i).getMajor();
						rosterLoaded[i][4] = rosterInfo.get(i).getLevel();
						rosterLoaded[i][5] = rosterInfo.get(i).getAsurite();
					}
					
					for (int i = 0; i < rosterLoaded.length; i++) //for every student, add them into the table and add a row
					{
						tableData.add(rosterLoaded[i]);
						dTableModel.addRow(rosterLoaded[i]);
					}
					
					scrollPane = new JScrollPane(mainTable); //add the table to the scroll pane
					scrollPane.setVerticalScrollBarPolicy(scrollPane.VERTICAL_SCROLLBAR_ALWAYS); //add the scroll bars to be there always
					scrollPane.setHorizontalScrollBarPolicy(scrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
					
					mainFrame.add(scrollPane); //add the scroll pane to the main frame
					SwingUtilities.updateComponentTreeUI(mainFrame); //update all components of the frame
					
					break;
				}
			}
		});

		/**
		 * Adding new attendacne for existing roster when addAttendance is clicked
		 */

		//action listener for adding attendance
		addAttendance.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e)
			{
				JFileChooser fileChooser = new JFileChooser(); //creation of chooser
				switch (fileChooser.showOpenDialog(mainFrame))
				{
				case JFileChooser.APPROVE_OPTION:
					
					File attCSV = fileChooser.getSelectedFile(); //set selected file to newCSV
					loadAtt(attCSV); //load method for the selected CSV, loads the new attendance data into attendanceInfo array list
					
					//ADD DATE PICKER HERE
					
					dTableModel.addColumn("Date");
					
					int attSize = attendanceInfo.size();
					int studentsAdded = 0;
					int moreStudents = 0;
					String[][] attLoaded = new String [attSize][2];
					String[][] additionalAtt = new String[attSize][2];
					for (int i = 0; i < attSize; i++) //add all data from attendance Array list to 2D attendance list
					{
						attLoaded[i][0] = attendanceInfo.get(i).getAsurite();
						attLoaded[i][1] = attendanceInfo.get(i).getTime();
					}
					
					for (int i = 0; i < mainTable.getRowCount(); i++) //set all attendance times to 0 by default
					{
						mainTable.setValueAt("0", i, mainTable.getColumnCount() - 1);
					}

					boolean match = false;
					
					for (int i = 0; i < attLoaded.length; i++) //iterate through all of the attendances //3
					{
						match = false;

						for(int j = 0; j < mainTable.getRowCount(); j++) //iterate through all of the rows in the table //3
						{
							if (mainTable.getValueAt(j, 5).equals(attLoaded[i][0])) //if the value in the ASURITE column is the same as the one in any of the rows
							{
								mainTable.setValueAt(attLoaded[i][1], i, mainTable.getColumnCount() - 1); //set the value in the date column equal to what is in the attLoaded array
								studentsAdded++;

								match = true;
							}
						}
						if (!match)
						{
							additionalAtt[moreStudents][0] = attLoaded[i][0];
							additionalAtt[moreStudents][1] = attLoaded[i][1];
							moreStudents++;
						}
					}
					
					JOptionPane.showMessageDialog(mainFrame, "Data loaded for " + studentsAdded + " users in the roster. \n" + moreStudents + " additional attendees were found:\n" + printAdd(additionalAtt));
					
					break;
				
				}
			}
		});

		/**
		 * This is our save method when Save is clicked. When save is clicked and there exists a table that is not
		 * NULL aka a table that is worth saving or a table actually holding student information, we call our save
		 * class Save.java where we create the .csv downloadable.
		 */

		//action listener for saving the table
		save.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e)
			{
				if (tableData.size() > 0)
				{
					Save saveFile = new Save();
					try {
						saveFile.JtableToCSV(mainTable);
					}
					catch (Exception exc){
						System.out.println("Error Saving"); // crash report
					}
				}
			}
		});

		/**
		 * This is our method that is called when plot data is clicked. It calls the plot data method and writes
		 * the scatterplot found in ScatterPlot.java
		 */

		//action listener for plotting the data
		plotData.addActionListener(new ActionListener() { 
			public void actionPerformed(ActionEvent e)
			{
				//JOptionPane.showMessageDialog(mainFrame, "CSE360 Team: Keenan High, Brandon Phillips, Chase Brown, Jemiah Martin, Sergio Castillo"); //dialog box pop up with names
				if (mainTable.getColumnCount() > 0)
				{
					SwingUtilities.invokeLater(() -> {
						ScatterPlot plotData = new ScatterPlot("Plot Data");
						plotData.setSize(700, 500);
						plotData.setLocationRelativeTo(null);
						plotData.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
						plotData.setVisible(true);
					});
				}
			}
		});
		
		
		//adding of all options to file
		fileMenu.add(loadRoster);
		fileMenu.add(addAttendance);
		fileMenu.add(save);
		fileMenu.add(plotData);
		
		//adding of option in about
		aboutMenu.add(aboutUs);
		
		//adding of both drop downs to menu bar
		menuBar.add(fileMenu);
		menuBar.add(aboutMenu);
		
		//addition of menu bar to frame
		mainFrame.setJMenuBar(menuBar);
		
		//creation of the main frame
		mainFrame.setSize(1000, 1000); //setting the size of the frame to 1k by 1k
		mainFrame.setVisible(true); //setting it to be visible from start of application
	}

	

	
}
