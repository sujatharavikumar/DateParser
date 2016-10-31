package Ravikumar.Sujatha.DateAndTimeParser;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sujatharavikumar on 10/28/16.
 */
public class DateParser {

    SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm");
    public static final int payRatePerHour = 60;
    public float pay;
    public void differenceInTime(String t1, String t2){
        try {
            Date d1 = dateFormat.parse(t1);
            Date d2 = dateFormat.parse(t2);
            long diff = d2.getTime() - d1.getTime();
            long diffMinutes = diff / (60 * 1000);
            long diffHours = diff / (60 * 60 * 1000);
            long exactDiffInMinutes = diffMinutes - (diffHours*60);
            System.out.println(diffHours+":"+exactDiffInMinutes);
            System.out.println(exactDiffInMinutes);

            float minPayRate = ((float)exactDiffInMinutes/60)*payRatePerHour;
            pay = (diffHours*payRatePerHour) + minPayRate;
            System.out.println(pay);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        String time1 = "9:00";
        String time2 = "19:30";
        DateParser dateParser = new DateParser();
        dateParser.differenceInTime(time1, time2);
    }


}
