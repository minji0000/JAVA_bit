package practice;

public class Sample {
    public static void main(String[] args) {
        int month = 8;
        String monthString = "";
        switch (month) {
            case 1:  monthString = "January";
            case 2:  monthString = "February";
            case 3:  monthString = "March";
            case 4:  monthString = "April";
            case 5:  monthString = "May";
            case 6:  monthString = "June";
            case 7:  monthString = "July";
            case 8:  monthString = "August";
            case 9:  monthString = "September";
            case 10: monthString = "October";
            case 11: monthString = "November";
            case 12: monthString = "December";
           // default: monthString = "Invalid month";
        }
        System.out.println(monthString);
    }
}
