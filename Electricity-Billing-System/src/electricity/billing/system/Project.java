package electricity.billing.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project extends JFrame implements ActionListener {

    String atype, meter;

    Project(String atype, String meter) {
        this.atype = atype;
        this.meter = meter;

        // Ensure frame visibility and layout setup
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout()); // Set layout for the frame

        // Background image setup
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/electricity.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1550, 850, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        add(image, BorderLayout.CENTER); // Add the background image to the center

        // Button panel to replace the JMenuBar
        JPanel buttonPanel = new JPanel(new GridLayout(1, 0, 10, 10)); // Grid layout for the buttons with spacing

        // Add appropriate buttons based on atype
        if (atype.equals("Admin")) {
            buttonPanel.add(createButton("New Customer", "icon/icon1.png"));
            buttonPanel.add(createButton("Customer Details", "icon/icon2.png"));
            buttonPanel.add(createButton("Deposit Details", "icon/icon3.png"));
            buttonPanel.add(createButton("Calculate Bill", "icon/icon5.png"));
        } else {
            buttonPanel.add(createButton("Update Information", "icon/icon4.png"));
            buttonPanel.add(createButton("View Information", "icon/icon6.png"));
            buttonPanel.add(createButton("Pay Bill", "icon/icon4.png"));
            buttonPanel.add(createButton("Bill Details", "icon/icon6.png"));
            buttonPanel.add(createButton("Generate Bill", "icon/icon7.png"));
            buttonPanel.add(createButton("Exit", "icon/icon11.png"));
        }

        add(buttonPanel, BorderLayout.NORTH); // Place the button panel at the top (north) of the frame

        // Ensure frame visibility
        pack(); // Pack the components
        setVisible(true); // Make the frame visible
    }

    private JButton createButton(String text, String iconPath) {
        ImageIcon icon = new ImageIcon(ClassLoader.getSystemResource(iconPath));
        Image scaledIcon = icon.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        JButton button = new JButton(text, new ImageIcon(scaledIcon));
        button.addActionListener(this); // Attach the action listener
        return button;
    }

    public void actionPerformed(ActionEvent ae) {
        String msg = ae.getActionCommand();
        switch (msg) {
            case "New Customer":
                new NewCustomer();
                break;
            case "Customer Details":
                new CustomerDetails();
                break;
            case "Deposit Details":
                new DepositDetails();
                break;
            case "Calculate Bill":
                new CalculateBill();
                break;
            case "View Information":
                new ViewInformation(meter);
                break;
            case "Update Information":
                new UpdateInformation(meter);
                break;
            case "Bill Details":
                new BillDetails(meter);
                break;
            case "Pay Bill":
                new PayBill(meter);
                break;
            case "Generate Bill":
                new GenerateBill(meter);
                break;
            case "Exit":
                setVisible(false);
                new Login();
                break;
        }
    }

    public static void main(String[] args) {
        new Project("", "");
    }
}
