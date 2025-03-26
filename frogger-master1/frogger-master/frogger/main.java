package frogger;

import javax.swing.JFrame;

public class main {
	
	public static void main(String[] args) {		
		JFrame frame= new JFrame("HELP Lebron");
		Display game= new Display();	
		frame.add(game);
		frame.setSize(720,960);
      		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
