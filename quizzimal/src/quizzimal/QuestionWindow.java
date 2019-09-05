package quizzimal;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.FontUIResource;

@SuppressWarnings("serial")
public class QuestionWindow extends JFrame {
	
	//Declaring components
	private JPanel contentPanel = new JPanel();
	private JPanel questionPanel = new JPanel();
	private JPanel answerPanel = new JPanel();
	private JPanel slide2Panel = new JPanel();
	private JLabel questionLabel = new JLabel();
	private JLabel type = new JLabel("Type your answer below.");
	private JButton play = new JButton("Play");
	private JTextField answer1 = new JTextField();
	private UIManager UI = new UIManager();
	
	@SuppressWarnings("static-access")
	public QuestionWindow(String answerValue, int index, String question) {
		super("Quizzimal");
		
		questionPanel.setLayout(new GridLayout(1,1,20,0));
		answerPanel.setLayout(new GridLayout(3,1,20,80));
		slide2Panel.setLayout(new GridLayout(2, 1));
		
		type.setBackground(Color.GRAY);
		type.setFont(new Font("Arial",Font.ITALIC,26));
		type.setForeground(Color.YELLOW);
		type.setHorizontalAlignment(SwingConstants.CENTER);
		type.setVerticalAlignment(SwingConstants.CENTER);
		
		
		//Button background color
		play.setBackground(Color.GRAY);
		
		//Button font
		play.setFont(new Font("Arial",Font.BOLD,26));
		
		//Button color
		play.setForeground(Color.YELLOW);
		
		//Questions
		//Adding question from array list to label
		questionLabel.setText(question);
		questionLabel.setHorizontalAlignment(SwingConstants.CENTER);
		questionLabel.setVerticalAlignment(SwingConstants.CENTER);
		questionLabel.setForeground(Color.YELLOW);
		questionLabel.setFont(new Font("Arial",Font.ITALIC,30));
		
		questionPanel.add(questionLabel);
		questionPanel.setBackground(Color.DARK_GRAY);
		questionPanel.add(questionLabel);
	
		//Answers
		answer1.setFont(new Font("Arial",Font.PLAIN,30));
		answerPanel.setBackground(Color.DARK_GRAY);
		answerPanel.add(type);
		answerPanel.add(answer1);
		answerPanel.add(play);
		
		slide2Panel.add(questionPanel);
		slide2Panel.add(answerPanel);
		slide2Panel.setBackground(Color.DARK_GRAY);
		slide2Panel.setPreferredSize(new Dimension(450,650));
		contentPanel.setBackground(Color.DARK_GRAY);
		contentPanel.add(slide2Panel);
		add(contentPanel);
		
		//Register event handlers
		play.addActionListener(
			 new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent event) {
					if(event.getSource()==play && answer1.getText().equalsIgnoreCase(answerValue)) {
						new DisplayWindow(index);
					}
					else if(event.getSource() == play && (!answer1.getText().equalsIgnoreCase(answerValue))) {
						JOptionPane.showMessageDialog(null, "Wrong answer! Try Again.", "Wrong", JOptionPane.ERROR_MESSAGE);
					}
				}
			 }
		);
		
		
		//JOptionpane font
		Font f = new Font("Arial",Font.BOLD,26);
		UI.put("OptionPane.background", Color.DARK_GRAY);
		UI.put("Panel.background", Color.DARK_GRAY);
		UI.put("OptionPane.messageForeground", Color.decode("#e08283"));
		UI.put("OptionPane.messageFont", f);
		UI.put("OptionPane.minimumSize",new Dimension(400,200));
		UI.put("OptionPane.buttonFont", new FontUIResource(new Font("ARIAL",Font.PLAIN,20)));
		UI.put("Button.background", Color.GRAY);
		UI.put("Button.foreground", Color.YELLOW);
		
		//Icon
		ImageIcon ic = new ImageIcon("images/q.png");
		this.setIconImage(ic.getImage());
		
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setSize(800,800);
		this.setResizable(false);
		this.setVisible(true);
	}

}
