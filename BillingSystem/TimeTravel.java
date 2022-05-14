package BillingSystem;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/*
This class returns the system time once a call is made and also
checks whether the time is in between 6.00am and 6.00pm or 6.00pm to 6.00am
 */
public class TimeTravel {

    private static final SimpleDateFormat timeFormat = new SimpleDateFormat("hh:mm a");

    public TimeTravel() {
    }

    public static String getTimeInstance(String callTime) {
        /*
        checks whether the time is in between 6.00am and 6.00pm or 6.00pm to 6.00am.
        It returns day if it is between 6.00am and 6.00pm otherwise returns night.
         */
        int start = callTime.compareTo("06:00 pm");
        int stop = callTime.compareTo("06:00 am");

        if (start>0 && stop<0){
            return "night";
        }
        return "day";
    }

    public static String getRealTime() {// return the system time
        return timeFormat.format(Calendar.getInstance().getTime());
    }

}
