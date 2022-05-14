package BillingSystem;

import java.util.ArrayList;
import java.util.Random;

/*
This is the customer class. For very customer instance,
it creates a phone number, calculate the total charges of the calls made and
saves all call instances in an array.
 */
public class ServiceCustomer {

    private final Random random = new Random();
    private static final String[] verifiedSafaricomLines = {"011","012","079","019","072","070","071","074","0758",
            "0759","0768","0768","0769"};

    public static ArrayList<ServiceCustomer> allCustomerInstance = new ArrayList<>();// store all ServiceCustomer
    // instances
    public static ArrayList<String> allRegisteredCustomerNames = new ArrayList<>();
    private static int totalCustomers = 0;

    private String customerPhoneNumber;
    private final ArrayList<Call> customerCallInstances = new ArrayList<>();//store all call instances
    // for each ServiceCustomer instance
    private double totalCallCharges = 0;
    private int customerTotalCalls = 0;

    public ServiceCustomer(String customerName, Call recentCall) {
        generatePhoneNumber();
        addCustomerCallInstance(recentCall);
        addAllRegisteredCustomerNames(customerName);
        totalCustomers++;
    }

    private void calculateTotalCost() {// calculates and returns the total charges of the calls made
        this.totalCallCharges = 0;
        for (Call callInstance : customerCallInstances) {
            this.totalCallCharges+=callInstance.calculatePricePlusTax();
        }
    }
    //__setters and getters__ encapsulation
    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public double getTotalCallCharges() {
        calculateTotalCost();
        return totalCallCharges;
    }

    public int getCustomerTotalCalls() {
        return customerTotalCalls;
    }

    public Call getCustomerCallInstance(int callIndex) {
        return customerCallInstances.get(callIndex);
    }

    public static int getTotalCustomers() {
        return totalCustomers;
    }
    //__setters and getters__ encapsulation

    private void addAllRegisteredCustomerNames(String customerName) {
        //add the customer's name to allRegisteredCustomerNames ArrayList
        allRegisteredCustomerNames.add(customerName);
    }

    public void addCustomerCallInstance(Call currentCall) {
        //add a call instance to the customerCallInstances ArrayList
        this.customerCallInstances.add(currentCall);
        customerTotalCalls++;//add one to the total Calls for each customer instance
    }

    private void generatePhoneNumber() {
        // this method generates a Safaricom phone number for a new customer.
        int randomSelect = random.nextInt(verifiedSafaricomLines.length);
        StringBuilder generatedNumber = new StringBuilder(verifiedSafaricomLines[randomSelect]);
        int lengthOfPhoneNumber = 10 - generatedNumber.length();

        for (int i = 0;i<lengthOfPhoneNumber;i++) {
            generatedNumber.append(random.nextInt(0, 10));
        }

        this.customerPhoneNumber = generatedNumber.toString();
    }
}
