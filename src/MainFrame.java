import java.io.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.JFileChooser;

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
	
	
	public static void load(File csvFile)
	{
		Roster mainRoster = new Roster();
		try 
		{
			FileReader fr = new FileReader(csvFile);
			BufferedReader br = new BufferedReader(fr);
			String line = "";
			String[] tempArr;
			while((line = br.readLine()) != null)
			{
				tempArr = line.split(delimiter);
				mainRoster.setId(Integer.parseInt(tempArr[0]));
				mainRoster.setFirstName(tempArr[1]);
			
			}
			br.close();
		} catch(IOException ioe) {
			ioe.printStackTrace();
		}
	}
	
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
				JFileChooser fileChooser = new JFileChooser();
				switch (fileChooser.showOpenDialog(mainFrame))
				{
				case JFileChooser.APPROVE_OPTION:
					//LOAD ROSTER METHOD Here
					File newCSV = fileChooser.getSelectedFile();
					load(newCSV);
					
					/*try {
						File file = new File(fileChosen);
						FileReader fr = new FileReader(file);
						BufferedReader br = new BufferedReader(fr);
						String line = "";
						while((line = br.readLine()) != null) {
							mainRoster = line.split(delimiter);
							for(String tempStr : tempArr) {
								System.out.print(tempStr + " ");
							}
							System.out.println();
						}
						br.close();
					} catch(IOException ioe) {
						ioe.printStackTrace();
					}*/
					
					JOptionPane.showMessageDialog(mainFrame, "This is where we need to use the load method"); // get rid of this for the lead method
					break;
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
