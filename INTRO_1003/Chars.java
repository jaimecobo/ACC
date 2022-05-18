import javax.swing.JOptionPane;
 
/**
 * Java program to display some characters using various forms of initialization.
 * The app demonstrates Unicode and also introduces the Swing library's unique
 * use of HTML for styling effects.
 */
public class Chars {
     
    public static void main(String[] args) {
        char zed = 'Z',                 // declare a character literal
             eAcute = '\u00E9',         // use the unicode escape
             russianYa = (char) 0x042F, // use a hexidecimal literal with cast
             hindiAw = (char) 2321;     // use a decimal literal with cast
        final String OUTPUT = "<h1><font color=\"blue\">   zed = " + zed  + ",   eAcute = " + eAcute + ",   russianYa = " + russianYa + ",   hindiAw = " + hindiAw + "  \"</font></h1>\"";
        JOptionPane.showMessageDialog(null, OUTPUT);
    }
}