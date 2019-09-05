package quizzimal;

//Importing libraries
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JLabel;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JList;

@SuppressWarnings("serial")
public class MainScreen extends JFrame {
	//Declaring swing components
	private JPanel contents = new JPanel();
	private JPanel welcomePanel = new JPanel();
	private JPanel listPanel = new JPanel();
	JScrollPane scrollPane = new JScrollPane();
	
	private JLabel welcome = new JLabel("Welcome to Quizzimal folks!");
	
	private static ArrayList<String> challenges = new ArrayList<String>();
	private static ArrayList<String> questions = new ArrayList<String>();
	private static ArrayList<String> answers = new ArrayList<String>();
	private static int count;
	private static String getChallenge;
	private static String getQuestion;
	private static String getAnswers;
	@SuppressWarnings("rawtypes")
	private static JList list;
	
	//Class constructor
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public MainScreen() {
		super("Quizzimal");
		//setLayout(row,column,horizontal gap,vertical gap)
		contents.setLayout(new BoxLayout(contents,BoxLayout.Y_AXIS));
		//Centering all the components within the panels
		welcomePanel.setLayout(new GridLayout(1,1));
		
		//Database codes
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
				String queryChallenge = "SELECT * FROM quiztb WHERE id = "+i;
				
				ResultSet rs2 = s.executeQuery(queryChallenge);
				
				if(rs2.next()) {
					getChallenge = rs2.getString(2);
					getQuestion = rs2.getString(3);
					getAnswers = rs2.getString(4);
				}
				challenges.add(getChallenge);
				questions.add(getQuestion);
				answers.add(getAnswers);
			}

			list = new JList(challenges.toArray());
		}
		catch(SQLException se) {
			se.printStackTrace();
		} 
		catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		
		//Labels
		welcome.setBackground(Color.DARK_GRAY);
		welcome.setFont(new Font("Arial",Font.BOLD,55));
		welcome.setForeground(Color.GRAY);
		welcome.setHorizontalAlignment(SwingConstants.CENTER);
		welcome.setVerticalAlignment(SwingConstants.CENTER);
		
	    //Contents of main screen
		contents.setBackground(Color.DARK_GRAY);
		list.setVisibleRowCount(4);
		list.setBackground(Color.DARK_GRAY);
		list.setSelectionBackground(Color.GRAY);
		list.setFont(new Font("Arial",Font.BOLD,36));
		list.setForeground(Color.YELLOW);
		list.setFixedCellHeight(90);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		welcomePanel.add(welcome);
		welcomePanel.setBackground(Color.DARK_GRAY);
		
		//Adding scroll option to list
		scrollPane.add(list);
		scrollPane.setViewportView(list);
		listPanel.add(scrollPane);
		listPanel.setBackground(Color.DARK_GRAY);
		contents.add(welcomePanel);	
		contents.add(listPanel);
;		add(contents);
		
		//Icon
		ImageIcon ic = new ImageIcon("images/q.png");
		this.setIconImage(ic.getImage());
		
		//Selection listener class
		list.addListSelectionListener(
				new ListSelectionListener() {
					public void valueChanged(ListSelectionEvent event) {
						if (!event.getValueIsAdjusting()) {
							new QuestionWindow(answers.get(list.getSelectedIndex()),list.getSelectedIndex(),questions.get(list.getSelectedIndex()));
						}
					}
				}
		);

	}

}
