package quizzimal;

//Importing libraries
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.GridLayout;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.awt.FlowLayout;
import java.awt.Font;



@SuppressWarnings("serial")
public class DisplayWindow extends JFrame{

	//Declaring components
	private JPanel panel = new JPanel();
	private JPanel picPanel = new JPanel();
	private static JLabel picture = new JLabel();
	private static JLabel desLabel = new JLabel();
	private static ArrayList<String> images = new ArrayList<String>();
	private static ArrayList<String> descriptions = new ArrayList<String>();
	private static int count;
	private static String getImages;
	private static String getDescriptions;
	
	public DisplayWindow(int index) {
		super("Quizzimal");
		//Setting layout
		panel.setLayout(new FlowLayout());
		picPanel.setLayout(new GridLayout(1,1));
	
		picPanel.add(picture);
		panel.add(picPanel);
		panel.add(desLabel);
		desLabel.setFont(new Font("Arial",Font.BOLD,30));
		desLabel.setForeground(Color.RED);
		panel.setBackground(Color.WHITE);
		
		db(index);
		add(panel);
		
		//Icon
		ImageIcon ic = new ImageIcon("images/q.png");
		this.setIconImage(ic.getImage());
		
		//Window for displaying picture
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(700,800);
		this.setResizable(false);
		this.setVisible(true);
				
		
	}
	//Database operations
    public static void db(int index) {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/quizzimaldb", "root", "");
			//SQL query
			String queryCount = "SELECT COUNT(*) FROM quiztb;";
			
			Statement s = conn.createStatement();
			
			ResultSet rs = s.executeQuery(queryCount);
			
			if(rs.next()) {
				//Can also write column name in string format in getString() function
				count = rs.getInt(1);
			}
			
			//Populating ArrayList
			for(int i=1;i<=count;i++) {
				String queryRow = "SELECT * FROM quiztb WHERE id = "+i;
				
				ResultSet rs2 = s.executeQuery(queryRow);
				
				if(rs2.next()) {
					getImages = rs2.getString(5);
					getDescriptions = rs2.getString(6);
				}
				images.add(getImages);
				descriptions.add(getDescriptions);
			}
			//Adding image and description from array list to label
			ImageIcon icon = new ImageIcon("images/"+images.get(index));
			picture.setIcon(icon);
			desLabel.setText(descriptions.get(index));
			
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		} 
    }
}
