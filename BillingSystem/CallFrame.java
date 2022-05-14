package BillingSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CallFrame extends JFrame implements ActionListener {

    private int elapsedTime = 0;

    private String callerName;
    private String callingName;
    private String networkService;
    private String callingPhoneNumber;
    private final String callTime;

    private final JLabel timerLabel;

    private final JButton endCallButton;

    //_____time counter_____
    /*
    The instance below counts the duration of a call.
    It stops when the End Call button is pressed.
     */
    private final Timer timer = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            elapsedTime+=1000;
            int minutes = (elapsedTime / 60000) % 60;
            int seconds = (elapsedTime / 1000) % 60;
            String minuteCounter = String.format("%02d", minutes);
            String secondCounter = String.format("%02d", seconds);
            timerLabel.setText(minuteCounter +":"+ secondCounter);
        }
    });
    //_____time counter____

    public CallFrame(String callerName,String callingName, String networkService,String callingPhoneNumber) {
        setCallerName(callerName);
        setCallingName(callingName);
        setNetworkService(networkService);
        setCallingPhoneNumber(callingPhoneNumber);
        callTime = TimeTravel.getRealTime();

        //__label__
        JLabel callingNameLabel = new JLabel();
        callingNameLabel.setText(this.callingName.toUpperCase());
        callingNameLabel.setFont(new Font(null,Font.BOLD,24));
        callingNameLabel.setHorizontalAlignment(JLabel.CENTER);
        callingNameLabel.setBounds(25,10,300,30);

        JLabel serviceLabel = new JLabel();
        serviceLabel.setText(this.networkService);
        serviceLabel.setFont(new Font(null,Font.ITALIC,14));
        serviceLabel.setHorizontalAlignment(JLabel.CENTER);
        serviceLabel.setBounds(75,50,200,20);

        timerLabel = new JLabel();//-----------
        timerLabel.setOpaque(true);
        timerLabel.setFont(new Font(null,Font.PLAIN,14));
        timerLabel.setHorizontalAlignment(JLabel.CENTER);
        timerLabel.setBounds(135,100,80,20);

        //__label__

        //__buttons__
        endCallButton = new JButton("End Call");
        endCallButton.setFocusable(false);
        endCallButton.addActionListener(this);
        endCallButton.setBounds(125,140,100,30);
        //__buttons__

        //__the frame__
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(new Dimension(350,200));
        this.setResizable(true);
        this.setLocationRelativeTo(null);

        //____placement of the objects in the frame____
        this.add(callingNameLabel);
        this.add(serviceLabel);
        this.add(endCallButton);
        this.add(timerLabel);

        //___starts the timer__
        startTimer();

        this.setVisible(true);
        //__the frame ends__
    }

    //__setters and getters__encapsulation
    public void setCallingPhoneNumber(String callingPhoneNumber) {
        this.callingPhoneNumber = callingPhoneNumber;
    }

    public String getCallingPhoneNumber() {
        return callingPhoneNumber;
    }

    public String getCallerName() {
        return callerName;
    }

    public void setCallerName(String callerName) {
        this.callerName = callerName;
    }

    public void setNetworkService(String networkService) {
        this.networkService = networkService;
    }

    public void setCallingName(String callingName) {
        this.callingName = callingName;
    }

    public String getNetworkService() {
        return networkService;
    }

    public String getCallingName() {
        return callingName;
    }
    //__setters and getters__encapsulation

    private void startTimer() {// starts the timer
        timer.start();
    }

    private int stopTimer() {// stops the timer and returns the total number of seconds taken
        timer.stop();
        return (elapsedTime/1000);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==endCallButton) {
            this.dispose();
            Call customerCall = new Call(TimeTravel.getTimeInstance(callTime), getCallingName(), getCallingPhoneNumber(),
                    getNetworkService(), stopTimer(), callTime);
            /*
            this if statement checks whether the caller instance already exists by checking a list of all
            customer's instances,i.e, the ServiceCustomer class.
            */
            if (!ServiceCustomer.allRegisteredCustomerNames.contains(getCallerName())) {
                //if not it creates an instance of the ServiceCustomer

                ServiceCustomer newCustomer = new ServiceCustomer(getCallerName(),customerCall);
                ServiceCustomer.allCustomerInstance.add(newCustomer);
            } else {/*
            if it does exist, it updates the added data by adding
            the call instance to the related ServiceCustomer instance.
            */
                int customerIndex = ServiceCustomer.allRegisteredCustomerNames.indexOf(getCallerName());
                ServiceCustomer customerInstance = ServiceCustomer.allCustomerInstance.get(customerIndex);
                customerInstance.addCustomerCallInstance(customerCall);
            }
            new ContactFrame();
        }
    }
}