import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CountingStars {

	public static boolean isCameraDischarged(long days) {
		if(days%4==3){
			return true;
		}
		return false;
	}
	
	//Sunday is 0, Monday is 1 and so on.
	public static int convertDayToValue(String day) {
		switch(day){
		case "Monday":
			return 0;
		case "Tuesday":
			return 1;
		case "Wednesday":
			return 2;
		case "Thursday":
			return 3;
		case "Friday":
			return 4;
		case "Saturday":
			return 5;
		case "Sunday":
			return 6;
		}
		return 0;
	}

	public static boolean isSaturdayOrSunday(long days, String initialDay) {
        int dayOffset = (int) (days%7);
        
        int finalDay = (convertDayToValue(initialDay) + dayOffset) % 7;
        
        if(finalDay == 5 || finalDay ==6)
        {
        	return true;
        }
       
		return false;
	}

	public static long convertDateToDays(String date) throws ParseException {
		long a = 0;
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		String startDate = "01/01/0001";
		Date date1 = myFormat.parse(startDate);
		Date date2 = myFormat.parse(date);
		
		long diff = date2.getTime() - date1.getTime();
		
		return TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS);
	}
	
	public static int getDaysInCurrentYear(String date) throws ParseException {
		SimpleDateFormat myFormat = new SimpleDateFormat("dd/MM/yyyy");
		Date endDateInDateFormat = myFormat.parse(date);
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(endDateInDateFormat);
		int year = calendar.get(Calendar.YEAR);
		String startDate = "01/01/"+year;
		System.out.println(startDate);
		Date startDateInDateFormat = myFormat.parse(startDate);
        long diff = endDateInDateFormat.getTime() - startDateInDateFormat.getTime();
		
		return (int) TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS) + 1;
	}

	private static Pattern dateFrmtPtrn = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])/(0?[1-9]|1[012])/(\\d\\d\\d\\d)");

	public static boolean validateDateFormat(String userName) {

		Matcher mtch = dateFrmtPtrn.matcher(userName);
		if (mtch.matches()) {
			return true;
		}
		return false;
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> validDays = Arrays.asList( "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday");
		
		String day = args[0];
		String date = args[1];
		if(!validDays.contains(day)) {
			System.out.println("Invalid Day");
			return;
		}
		if(!validateDateFormat(date)) {
			System.out.println("Invalid Date");
			return;
		}
		
		try {
			long daysSinceStart = convertDateToDays(date);
			System.out.println(daysSinceStart);
			if(isCameraDischarged(daysSinceStart)){
				System.out.println("0");
				return;
			}
			if(isSaturdayOrSunday(daysSinceStart, day)){
				System.out.println("50");
				return;
			}
			
			System.out.println(getDaysInCurrentYear(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
