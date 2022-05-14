package BillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.HashMap;
import java.util.Map;

/*
In this class, contacts of the verified Customers are created.
It also checks whether the number of the contact is Safaricom verified or not.
Finally, make an instance of the CallFrame class
 */
public class ContactFrame extends JFrame implements ActionListener {

    private static final String[] availableHost = {"Gerald Bahati","Wizzoh Omondi","Muuo King"};
    private static final String[] verifiedSafaricomLines = {"011","012","079","019","072","070","071","074","0758",
            "0759","0768","0768","0769"}; // these are prefixes of verified Safaricom lines.

    private final Map<String,String> mobileNumbers = new HashMap<>();

    private final JLabel headerLabel;
    private final JLabel contact1Label;
    private final JLabel contact2Label;
    private final JLabel contact3Label;

    private final JComboBox<String> callerNames;

    private final JButton confirmButton;
    private final JButton call1Button;
    private final JButton call2Button;
    private final JButton call3Button;
    private final JButton backButton;

    public ContactFrame() {
        //__labels__

        JLabel titleLabel = new JLabel();
        titleLabel.setText("CALL TEST");
        titleLabel.setFont(new Font("MV Boli",Font.BOLD,24));

        JLabel explain1Label = new JLabel();
        explain1Label.setText("This window demonstrates how different customers, under Safaricom service," +
                " make calls and the program collect the data.");
        explain1Label.setFont(new Font("SansSerif",Font.PLAIN,14));

        JLabel explain2Label = new JLabel();
        explain2Label.setText("The following are names of registered customers that act as dummies.");
        explain2Label.setFont(new Font("SansSerif",Font.PLAIN,14));

        JLabel explain3Label = new JLabel();
        explain3Label.setText("Each customer has different contacts to mirror the real world.");
        explain3Label.setFont(new Font("SansSerif",Font.PLAIN,14));

        JLabel callerNameLabel = new JLabel();
        callerNameLabel.setText("Choose a customer: ");
        callerNameLabel.setFont(new Font("SansSerif",Font.PLAIN,16));
        callerNameLabel.setBounds(155,20,200,30);

        headerLabel = new JLabel();
        headerLabel.setVisible(false);
        headerLabel.setFont(new Font("MV Boli",Font.BOLD,20));
        headerLabel.setHorizontalAlignment(JLabel.CENTER);
        headerLabel.setBounds(0,60,850,30);

        contact1Label = new JLabel();
        contact1Label.setVisible(false);
        contact1Label.setFont(new Font(null,Font.PLAIN,16));
        contact1Label.setBounds(175,120,300,20);

        contact2Label = new JLabel();
        contact2Label.setVisible(false);
        contact2Label.setFont(new Font(null,Font.PLAIN,16));
        contact2Label.setBounds(175,170,300,20);

        contact3Label = new JLabel();
        contact3Label.setVisible(false);
        contact3Label.setFont(new Font(null,Font.PLAIN,16));
        contact3Label.setBounds(175,220,300,20);

        JLabel updateLabel = new JLabel();
        updateLabel.setText("<--- To view the Call Reports press Home button.");
        updateLabel.setFont(new Font("SansSerif",Font.PLAIN,16));
        updateLabel.setVisible(false);
        updateLabel.setBounds(210,300,500,50);

       /*If the total number of calls made is greater than one,
        then make the updateLabel visible to the user.
        */
        if (Call.getTotalNumberOfCalls()>0) {
            updateLabel.setVisible(true);
        }
        //__labels__

        //__buttons__
        call1Button = new JButton("Call");
        call1Button.setFocusable(false);
        call1Button.setVisible(false);
        call1Button.addActionListener(this);
        call1Button.setBounds(575,120,100,20);

        call2Button =new JButton("Call");
        call2Button.setFocusable(false);
        call2Button.setVisible(false);
        call2Button.addActionListener(this);
        call2Button.setBounds(575,170,100,20);

        call3Button = new JButton("Call");
        call3Button.setFocusable(false);
        call3Button.setVisible(false);
        call3Button.addActionListener(this);
        call3Button.setBounds(575,220,100,20);

        confirmButton = new JButton("Confirm");
        confirmButton.setFocusable(false);
        confirmButton.addActionListener(this);
        confirmButton.setBounds(645,20,100,30);

        backButton = new JButton("Home");
        backButton.setFont(new Font("SansSerif",Font.BOLD,20));
        backButton.setFocusable(false);
        backButton.addActionListener(this);
        backButton.setBounds(10,300,200,50);

        //__buttons__

        //__comboBox__
        callerNames = new JComboBox<>(availableHost);
        callerNames.setFont(new Font("Ink Free",Font.PLAIN,16));
        callerNames.addActionListener(this);
        callerNames.setEditable(false);
        callerNames.setBounds(375,20,200,30);

        //__comboBox__

        //__panels__
        JPanel headerPanel = new JPanel();
        headerPanel.add(titleLabel);
        headerPanel.add(explain1Label);
        headerPanel.add(explain2Label);
        headerPanel.add(explain3Label);
        headerPanel.setBounds(0,0,850,100);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.add(callerNames);
        bodyPanel.add(callerNameLabel);
        bodyPanel.add(headerLabel);
        bodyPanel.add(contact1Label);
        bodyPanel.add(contact2Label);
        bodyPanel.add(contact3Label);
        bodyPanel.add(backButton);
        bodyPanel.add(call1Button);
        bodyPanel.add(call2Button);
        bodyPanel.add(call3Button);
        bodyPanel.add(confirmButton);
        bodyPanel.add(updateLabel);
        bodyPanel.setBounds(0,100,850,400);

        //__panels__

        //__the frame__
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(new Dimension(850,500));
        this.setLocationRelativeTo(null);

        //____placement of the objects in the frame____
        this.add(headerPanel);
        this.add(bodyPanel);

        this.setVisible(true);
        //__the frame ends__
    }

    private void collectContacts(String callerName) {
        /*
        this method creates contacts of the available Hosts
         */
        JLabel[] allContacts = {contact1Label,contact2Label,contact3Label};

        if(callerName.equals(availableHost[0])) { //checks if callerName entered is equal to Gerald Bahati
            String[][] contactsPlusNumber = {{"Lilian","0737719656"},{"Mum","0726636606"},{"Alvin Bestie","0798062238"}};
            for (int i=0;i<3;i++) {
                allContacts[i].setText(contactsPlusNumber[i][0]+"  "+contactsPlusNumber[i][1]);
                mobileNumbers.put(contactsPlusNumber[i][0], contactsPlusNumber[i][1]);
            }
        } else if (callerName.equals(availableHost[1])){ //checks if callerName entered is equal to Wizzoh Omondi
            String[][] contactsPlusNumber = {{"Abigail","0789574968"},{"Kevin","0198232585"},{"Gerald","0790329620"}};
            for (int i=0;i<3;i++) {
                allContacts[i].setText(contactsPlusNumber[i][0]+"  "+contactsPlusNumber[i][1]);
                mobileNumbers.put(contactsPlusNumber[i][0], contactsPlusNumber[i][1]);
            }
        } else if (callerName.equals(availableHost[2])){ //checks if callerName entered is equal to Muuo King
            String[][] contactsPlusNumber = {{"Brain","0143757852"},{"Gerald","0790329620"},{"Class Rep","0704125004"}};
            for (int i=0;i<3;i++) {
                allContacts[i].setText(contactsPlusNumber[i][0]+"  "+contactsPlusNumber[i][1]);
                mobileNumbers.put(contactsPlusNumber[i][0], contactsPlusNumber[i][1]);
            }
        }

    }

    private String getPhoneNumber(String callingName) { //This method returns the phone number of the person called
        return mobileNumbers.get(callingName);
    }

    private String getNetworkService(String phoneNumber) {
        /*
        This method checks whether the called number is Safaricom's or not.
        It compares the prefix of the called number with the static variable verifiedSafaricomLines.
        If the numbers match it increments the counter.
         */
        char[] eachDigits = phoneNumber.toCharArray();
        int counter;
        for (String verification : verifiedSafaricomLines) {// for each element in verifiedSafaricomLines
            counter = 0;
            for(int a=0;a < verification.length();a++) {
                if (eachDigits[a]==verification.toCharArray()[a]) {
                    counter+=1;
                }
            }
            if (counter==verification.length()) {
                return "Safaricom";
            }
        }
        return "other service";
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==confirmButton) {
            String callerName = (String) callerNames.getSelectedItem();

            // assign contacts
            assert callerName != null;
            collectContacts(callerName);

            headerLabel.setVisible(true);
            headerLabel.setText(callerName+" contacts'");

            contact1Label.setVisible(true);
            contact2Label.setVisible(true);
            contact3Label.setVisible(true);

            call1Button.setVisible(true);
            call2Button.setVisible(true);
            call3Button.setVisible(true);
        }

        if (e.getSource()==call1Button) {
            this.dispose();
            String callerName = contact1Label.getText().split(" {2}")[0];// returns the name of the one being called
            new CallFrame((String) callerNames.getSelectedItem(),callerName,
                   getNetworkService(getPhoneNumber(callerName)),
                    getPhoneNumber(callerName));//instance of CallFrame class

        }else if (e.getSource()==call2Button) {
            this.dispose();
            String callerName = contact2Label.getText().split(" {2}")[0];// returns the name of the one being called
            new CallFrame((String) callerNames.getSelectedItem(),callerName,
                    getNetworkService(getPhoneNumber(callerName)),
                    getPhoneNumber(callerName));//instance of CallFrame class

        }else if (e.getSource()==call3Button) {
            this.dispose();
            String callerName = contact3Label.getText().split(" {2}")[0];// returns the name of the one being called
            new CallFrame((String) callerNames.getSelectedItem(),callerName,
                    getNetworkService(getPhoneNumber(callerName)),
                    getPhoneNumber(callerName));//instance of CallFrame class
        }

        if (e.getSource()==backButton) {
            this.dispose();
            new MainWindow();
        }
    }
}
