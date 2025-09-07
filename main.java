//Akshay Iyer and Harsha Mullangi
//Period 2B
//This class runs the final game by creating a JFrame of the proper size and implementing a Display object.



import javax.swing.JFrame;

public class main {
	
	public static void main(String[] args) {		
		JFrame frame= new JFrame("Dog Man");
		Display game= new Display();	
		frame.add(game);
		frame.setSize(720,960);
      //frame.setSize(610,485);
      frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}
