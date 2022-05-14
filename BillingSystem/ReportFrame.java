package BillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ReportFrame extends JFrame implements ActionListener {

    private final JLabel customerCallsLabel;
    private final JLabel summationCost;
    private final JLabel callingNumberLabel;
    private final JLabel callTimeLabel;
    private final JLabel callDurationLabel;
    private final JLabel callCostLabel;
    private final JLabel callTaxLabel;
    private final JLabel totalCallCostLabel;

    private final JButton selectButton;
    private final JButton backButton;

    private final JComboBox<String> availCustomersComboBox;

    //Below are arrays of JLabels
    private final ArrayList<JLabel> callingNumberLabels = new ArrayList<>();
    private final ArrayList<JLabel> callTimeLabels = new ArrayList<>();
    private final ArrayList<JLabel> callDurationLabels = new ArrayList<>();
    private final ArrayList<JLabel> callCostLabels = new ArrayList<>();
    private final ArrayList<JLabel> callTaxLabels = new ArrayList<>();
    private final ArrayList<JLabel> callTotalCostLabels = new ArrayList<>();

    public ReportFrame() {
        //___Labels___
        JLabel titleLabel = new JLabel("REPORT");
        titleLabel.setFont(new Font(null,Font.BOLD,20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        titleLabel.setBounds(300,10,100,30);

        JLabel chooseCustomerLabel = new JLabel("Choose customer:");
        chooseCustomerLabel.setFont(new Font(null,Font.PLAIN,14));
        chooseCustomerLabel.setBounds(30,130,150,30);

        callingNumberLabel = new JLabel("Calling number");
        callingNumberLabel.setVisible(false);
        callingNumberLabel.setFont(new Font(null,Font.BOLD,14));
        callingNumberLabel.setBounds(10,200,150,30);

        callTimeLabel = new JLabel("Call Time");
        callTimeLabel.setVisible(false);
        callTimeLabel.setFont(new Font(null,Font.BOLD,14));
        callTimeLabel.setBounds(160,200,100,30);

        callDurationLabel = new JLabel("call Duration");
        callDurationLabel.setVisible(false);
        callDurationLabel.setFont(new Font(null,Font.BOLD,14));
        callDurationLabel.setBounds(260,200,100,30);

        callCostLabel = new JLabel("Cost");
        callCostLabel.setVisible(false);
        callCostLabel.setFont(new Font(null,Font.BOLD,14));
        callCostLabel.setBounds(360,200,100,30);

        callTaxLabel = new JLabel("Tax");
        callTaxLabel.setVisible(false);
        callTaxLabel.setFont(new Font(null,Font.BOLD,14));
        callTaxLabel.setBounds(460,200,100,30);

        totalCallCostLabel = new JLabel("Total Cost");
        totalCallCostLabel.setVisible(false);
        totalCallCostLabel.setFont(new Font(null,Font.BOLD,14));
        totalCallCostLabel.setBounds(560,200,100,30);

        JLabel totalCustomersLabel = new JLabel();
        totalCustomersLabel.setText(String.format("Total Customers = %d", ServiceCustomer.getTotalCustomers()));
        totalCustomersLabel.setFont(new Font(null,Font.PLAIN,16));
        totalCustomersLabel.setBounds(20,50,300,30);

        JLabel allCallsLabel = new JLabel();
        allCallsLabel.setText(String.format("Total Call = %d",Call.getTotalNumberOfCalls()));
        allCallsLabel.setFont(new Font(null,Font.PLAIN,16));
        allCallsLabel.setBounds(20,90,300,30);

        customerCallsLabel = new JLabel();
        customerCallsLabel.setFont(new Font(null,Font.ITALIC,16));
        customerCallsLabel.setVisible(false);
        customerCallsLabel.setBounds(200,165,300,30);

        summationCost = new JLabel();
        summationCost.setVisible(false);
        summationCost.setFont(new Font(null,Font.BOLD,16));
        summationCost.setBounds(500,400,200,30);

        //___Labels___

        //___ComboBox___
        availCustomersComboBox = new JComboBox<>(ServiceCustomer.allRegisteredCustomerNames.toArray(new String[0]));
        availCustomersComboBox.addActionListener(this);
        availCustomersComboBox.setBounds(200,130,230,30);

        //___ComboBox___

        //__buttons__
        selectButton = new JButton("Select");
        selectButton.addActionListener(this);
        selectButton.setFocusable(false);
        selectButton.setBounds(450,130,100,30);

        backButton = new JButton("Home");
        backButton.setFont(new Font("SansSerif",Font.BOLD,20));
        backButton.addActionListener(this);
        backButton.setFocusable(false);
        backButton.setBounds(20,410,100,50);

        //__buttons__

        //__myReportFrame__
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Reports");
        this.setLayout(null);
        this.setSize(new Dimension(700,500));
        this.setLocationRelativeTo(null);

        //___add Components to the frame____

        this.add(titleLabel);
        this.add(totalCustomersLabel);
        this.add(allCallsLabel);
        this.add(totalCallCostLabel);
        this.add(chooseCustomerLabel);
        this.add(availCustomersComboBox);
        this.add(selectButton);
        this.add(callingNumberLabel);
        this.add(callTimeLabel);
        this.add(callDurationLabel);
        this.add(callCostLabel);
        this.add(callTaxLabel);
        this.add(totalCallCostLabel);
        this.add(customerCallsLabel);

        addReportToTheFrame();

        this.add(summationCost);
        this.add(backButton);

        this.setVisible(true);
        //__myReportFrame__
    }

    private void addReportToTheFrame() {
        /*
        this method create instances of JLabels relative to the total number of calls made and
        sets there positions on the frame
         */
        int allYCoordinate = 240;
        for (int i = 0;i<Call.getTotalNumberOfCalls();i++) {
            //create instances of JLabels and add them to the arrays
            callingNumberLabels.add(new JLabel());
            callTimeLabels.add(new JLabel());
            callDurationLabels.add(new JLabel());
            callCostLabels.add(new JLabel());
            callTaxLabels.add(new JLabel());
            callTotalCostLabels.add(new JLabel());

            //set the font and coordinates of the created JLabel instances
            callingNumberLabels.get(i).setFont(new Font(null,Font.PLAIN,14));
            callingNumberLabels.get(i).setBounds(10,allYCoordinate,150,30);

            callTimeLabels.get(i).setFont(new Font(null,Font.PLAIN,14));
            callTimeLabels.get(i).setBounds(160,allYCoordinate,100,30);

            callDurationLabels.get(i).setFont(new Font(null,Font.PLAIN,14));
            callDurationLabels.get(i).setBounds(260,allYCoordinate,100,30);

            callCostLabels.get(i).setFont(new Font(null,Font.PLAIN,14));
            callCostLabels.get(i).setBounds(360,allYCoordinate,100,30);

            callTaxLabels.get(i).setFont(new Font(null,Font.PLAIN,14));
            callTaxLabels.get(i).setBounds(460,allYCoordinate,100,30);

            callTotalCostLabels.get(i).setFont(new Font(null,Font.PLAIN,14));
            callTotalCostLabels.get(i).setBounds(560,allYCoordinate,100,30);

            // adds the JLabel instances to the frame
            this.add(callingNumberLabels.get(i));
            this.add(callTimeLabels.get(i));
            this.add(callDurationLabels.get(i));
            this.add(callCostLabels.get(i));
            this.add(callTaxLabels.get(i));
            this.add(callTotalCostLabels.get(i));

            allYCoordinate+=40;//increment the y-coordinate by 40
        }
    }

    private void updateTheReport(int customerIndex) {
        /*
        this method adds data to the JLabels generated by the addReportToTheFrame method
         */
        ServiceCustomer customerInstance = ServiceCustomer.allCustomerInstance.get(customerIndex);
        for (int i = 0;i<customerInstance.getCustomerTotalCalls();i++) {
            Call customerCallInstance = customerInstance.getCustomerCallInstance(i);

            callingNumberLabels.get(i).setText(String.format("%s", customerCallInstance.getCallingNumber()));
            callTimeLabels.get(i).setText(String.format("%s",customerCallInstance.getCurrentTime()));
            callDurationLabels.get(i).setText(String.format("%.0f seconds",customerCallInstance.getTimeDuration()));
            callCostLabels.get(i).setText(String.format("sh %.2f",customerCallInstance.calculatePricePlusTax()
                    - customerCallInstance.getCallTax()));
            callTaxLabels.get(i).setText(String.format("sh %.2f", customerCallInstance.getCallTax()));
            callTotalCostLabels.get(i).setText(String.format("sh %.2f",customerCallInstance.calculatePricePlusTax()));

        }
    }

    private void resetLabel() {
        //this method sets the text of JLabels generated by the addReportToTheFrame method to an empty string
        for (int i = 0;i<Call.getTotalNumberOfCalls();i++) {

            callingNumberLabels.get(i).setText("");
            callTimeLabels.get(i).setText("");
            callDurationLabels.get(i).setText("");
            callCostLabels.get(i).setText("");
            callTaxLabels.get(i).setText("");
            callTotalCostLabels.get(i).setText("");
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String chooseName = (String) availCustomersComboBox.getSelectedItem();//gets the caller's name
        int customerIndex = ServiceCustomer.allRegisteredCustomerNames.indexOf(chooseName);//gets the caller's index
        ServiceCustomer customerInstance = ServiceCustomer.allCustomerInstance.get(customerIndex);//gets the caller's
        // instance from the array of ServiceCustomer instances that corresponds to the caller's index.

        int numberOfCalls = customerInstance.getCustomerTotalCalls();//gets number of calls made by each customer
        double totalCallCost = customerInstance.getTotalCallCharges();//get total call charges

        if (e.getSource()==selectButton) {
            resetLabel();
            customerCallsLabel.setText(String.format("%s has %d calls",customerInstance.getCustomerPhoneNumber(),
                    numberOfCalls));
            customerCallsLabel.setVisible(true);

            summationCost.setText(String.format("Total Cost: sh %.02f",totalCallCost));
            summationCost.setVisible(true);

            callingNumberLabel.setVisible(true);
            callTimeLabel.setVisible(true);
            callDurationLabel.setVisible(true);
            callCostLabel.setVisible(true);
            callTaxLabel.setVisible(true);
            totalCallCostLabel.setVisible(true);

            updateTheReport(customerIndex);
        }

        if (e.getSource()==backButton) {
            this.dispose();
            new MainWindow();
        }
    }
}