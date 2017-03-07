package testing;

/*
 * User Interface
 * Test 1
 */
import javax.swing.*;

public class userInterface
{

    public static void main(String[] args)
    {


        JFrame myGui = new JFrame();
        myGui.setLayout(null);

        /* ==================
         * Menu Bar
         * ================== */
        JMenuBar menuBar = new JMenuBar();

        // file menu
        JMenu menuFile = new JMenu("File");
        JMenuItem menuItemExit = new JMenuItem("Exit");
        menuFile.add(menuItemExit);
        menuBar.add(menuFile);

        // help menu
        JMenu menuHelp = new JMenu("Help");
        JMenuItem menuItemAbout = new JMenuItem("About");
        menuHelp.add(menuItemAbout);
        menuBar.add(menuHelp);
        myGui.setJMenuBar(menuBar);

        /* =====================
         * Frame Settings
         * ===================== */

        // set default close action
        myGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // set window size
        myGui.setSize(800, 800);

        // set the start position
        myGui.setLocationRelativeTo(null);

        // disable resize
        myGui.setResizable(false);

        // Set a Title
        myGui.setTitle("PCO Gui");

        myGui.setVisible(true);

        /* =====================
         * Start Time (input)
         * ===================== */

        JLabel startTime = new JLabel("Start Time: ");

        myGui.add(startTime);

        startTime.setLocation(0, 10);
        startTime.setSize(100, 20);

        JTextField inputStartTime = new JTextField();
        myGui.add(inputStartTime);

        inputStartTime.setLocation(100, 10);
        inputStartTime.setSize(100, 20);

        /* =====================
         * Location
         * ===================== */
        JLabel location = new JLabel("Location:");

        myGui.add(location);

        location.setLocation(0, 60);
        location.setSize(100, 20);


        /* =====================
         * Optimal Time (output)
         * ===================== */
        JLabel optimalTime = new JLabel("Optimal Time:");

        myGui.add(optimalTime);

        optimalTime.setLocation(0, 150);
        optimalTime.setSize(100, 20);

    } // end main method



} // end class userInterface
