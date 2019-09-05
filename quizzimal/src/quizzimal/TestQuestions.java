package quizzimal;

//Importing libraries
import javax.swing.JFrame;

public class TestQuestions {

	public static void main(String[] args) {
		//Declaring instance
		MainScreen main = new MainScreen();
	
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		main.setSize(800,800);
		main.setResizable(false);
		main.setVisible(true);

	}

}
