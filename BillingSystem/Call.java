package BillingSystem;

public class Call {
    private static final double DAY_CHARGE = 4.0;
    private static final double NIGHT_CHARGE = 3.0;
    private static final double DEFAULT_CHARGE = 5.0;
    private static final double VAT = 0.16;

    private static int totalNumberOfCalls = 0;

    private String timeInstance;
    private String callingName;
    private String callingNumber;
    private String networkService;
    private double timeDuration;
    private String currentTime;
    private double callTax;

    public Call ( String timeInstance, String callingName,String callingNumber,
                  String networkService, double timeDuration, String currentTime) {
        setTimeInstance(timeInstance);
        setCallingName(callingName);
        setCallingNumber(callingNumber);
        setNetworkService(networkService.toLowerCase());
        setTimeDuration(timeDuration);
        setCurrentTime(currentTime);

        totalNumberOfCalls++;//adds one to the totalNumberOfCalls for every call instance
    }

    @Override
    public String toString() {
        return "Call{" +
                ", timeRange='" + timeInstance + '\'' +
                ", callingName='" + callingName + '\'' +
                ", callingNumber='" + callingNumber + '\'' +
                ", networkService='" + networkService + '\'' +
                ", timeDuration=" + timeDuration +
                '}';
    }

    //__getters and setters__ encapsulation
    public String getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(String currentTime) {
        this.currentTime = currentTime;
    }

    public static int getTotalNumberOfCalls() {// return the total number of calls made
        return totalNumberOfCalls;
    }

    public String getCallingNumber() {
        return callingNumber;
    }

    private String getNetworkService() {
        return networkService;
    }

    private String getTimeInstance() {
        return timeInstance;
    }

    public double getTimeDuration() {
        return timeDuration;
    }

    private void setCallingName(String callingName) {
        this.callingName = callingName;
    }

    private void setCallingNumber(String callingNumber) {
        this.callingNumber = callingNumber;
    }

    private void setNetworkService(String networkService) {
        this.networkService = networkService.toLowerCase();
    }

    private void setTimeInstance(String timeInstance) {
        this.timeInstance = timeInstance;
    }

    private void setTimeDuration(double timeDuration) {
        this.timeDuration = timeDuration;
    }

    public double getCallTax() {
        return callTax;
    }

    //__getters and setters__ encapsulation

    private double calculateTax(double charge) {// calculate the call tax
        callTax = (charge * (getTimeDuration()/60)) * VAT;
        return callTax;
    }

    public double calculatePricePlusTax() {// calculate the call charge and
        // adds tax if call duration is greater than 2 minutes
        double seconds = getTimeDuration();
        if (getNetworkService().equals("safaricom")) {
            if (getTimeInstance().equals("day")) {
                if (seconds > 120) {
                    double tax = calculateTax(DAY_CHARGE);
                    return DAY_CHARGE * (seconds / 60) + tax;
                }

                return DAY_CHARGE * (seconds / 60);
            } else {
                if (seconds > 120) {
                    double tax = calculateTax(NIGHT_CHARGE);
                    return NIGHT_CHARGE * (seconds / 60) + tax;
                }

                return NIGHT_CHARGE * (seconds / 60);
            }
        } else {
            if (seconds>120) {
                double tax = calculateTax(DEFAULT_CHARGE);
                return DEFAULT_CHARGE * (seconds/60)+tax;
            }
            return DEFAULT_CHARGE * (seconds/60);
        }
    }
}
