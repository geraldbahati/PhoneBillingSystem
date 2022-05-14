package BillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame implements ActionListener {
    //__global variables__
    private final JButton payReportButton;
    private final JButton callTestButton;

    public MainWindow() {
        //__Label__
            //__it displays the Safaricom logo__
        JLabel myDetails = new JLabel("J17/5106/2021  -  MUENDO GERALD BAHATI");
        myDetails.setFont(new Font("SansSerif",Font.BOLD,20));
        myDetails.setHorizontalAlignment(JLabel.CENTER);
        myDetails.setBounds(0,20,700,50);

        JLabel organisationName = new JLabel("SAFARICOM");
        organisationName.setFont(new Font("SansSerif",Font.BOLD,36));
        organisationName.setHorizontalAlignment(JLabel.CENTER);
        organisationName.setBounds(0,100,700,50);

        JLabel welcomeLabel = new JLabel("Welcome to Phone Billing System:");
        welcomeLabel.setFont(new Font("Serif",Font.BOLD,15));
        welcomeLabel.setBounds(40,0,680,20);

        JLabel instruction1Label = new JLabel(". To view call reports click Analysis button." +
                " It will be disabled momentarily if no calls are made.");
        instruction1Label.setFont(new Font("Serif",Font.PLAIN,14));
        instruction1Label.setBounds(60,30,660,20);

        JLabel instruction2Label = new JLabel(" . To make a call sample click the Call Test button.");
        instruction2Label.setFont(new Font("Serif",Font.PLAIN,14));
        instruction2Label.setBounds(60,110,660,20);
        //__Label__

        //__Buttons__
        payReportButton = new JButton("Analysis");
        payReportButton.setFont(new Font("SansSerif",Font.BOLD,16));
        payReportButton.setFocusable(false);
        payReportButton.setEnabled(false);
        payReportButton.addActionListener(this);
        payReportButton.setBounds(250,50,200,50);

        callTestButton = new JButton("Test Call");
        callTestButton.setFont(new Font("SansSerif",Font.BOLD,16));
        callTestButton.setFocusable(false);
        callTestButton.addActionListener(this);
        callTestButton.setBounds(250,130,200,50);
        //__Buttons__

            /*it checks the number of calls made,
                if there is more than one call it enables the payReportButton.
             */
        if (Call.getTotalNumberOfCalls()>0) {
            payReportButton.setEnabled(true);
        }

        //__panels__
        JPanel headerPanel = new JPanel();
        headerPanel.setLayout(null);
        headerPanel.add(myDetails);
        headerPanel.add(organisationName);
        headerPanel.setBounds(0,0,700,200);

        JPanel bodyPanel = new JPanel();
        bodyPanel.setLayout(null);
        bodyPanel.add(welcomeLabel);
        bodyPanel.add(instruction1Label);
        bodyPanel.add(payReportButton);
        bodyPanel.add(instruction2Label);
        bodyPanel.add(callTestButton);
        bodyPanel.setBounds(0,200,700,300);
        //__panels__

        //__the frame__
        this.setTitle("HOME");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(new Dimension(700,450));
        this.setLocationRelativeTo(null);
        this.setResizable(false);

        //____placement of the panels in the frame____
        this.add(headerPanel);
        this.add(bodyPanel);


        this.setVisible(true);
        //__the frame ends__
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource()==callTestButton) {
            this.dispose();//close the current frame
            new ContactFrame();//make an instance of the ContactFrame class
        }

        if (e.getSource()==payReportButton) {
            this.dispose();//close the current frame
            new ReportFrame();//make an instance of the ReportFrame class
        }

    }
}
