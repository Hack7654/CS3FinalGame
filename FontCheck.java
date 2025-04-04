import java.awt.GraphicsEnvironment;

public class FontCheck {
    public static void main(String[] args) {
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        String[] fonts = ge.getAvailableFontFamilyNames();
        
        for (String font : fonts) {
            if (font.equalsIgnoreCase("Pixelfy Sans")) {
                System.out.println("Pixelfy Sans is installed!");
                return;
            }
        }
        System.out.println("Pixelfy Sans is NOT installed.");
    }
}
