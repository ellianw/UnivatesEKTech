
import Views.FrmMain;
import com.formdev.flatlaf.FlatLightLaf;
import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

/**
 *
 * @author Ellian
 */
public class UnivatesEKTech {

    public static void main(String[] args) {
            try {
                    // Set System L&F
//                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            UIManager.setLookAndFeel( new FlatLightLaf() );
            } 
            catch (UnsupportedLookAndFeelException e) {
               // handle exception
            }
//            catch (ClassNotFoundException e) {
//               // handle exception
//            }
//            catch (InstantiationException e) {
//               // handle exception
//            }
//            catch (IllegalAccessException e) {
//               // handle exception
//            }
        JFrame frame = new FrmMain();
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize((int)Math.round(screenSize.width*0.5), (int) Math.round(screenSize.height*0.5));
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);    
    }
}
