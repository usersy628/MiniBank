package ex220318;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Date;
import java.util.Locale;

public class DataFormat {


	public String getDate() {// 현재날짜 시간
		DateFormat dfTime1 = new SimpleDateFormat("yyyy-MM-dd");
		return dfTime1.format(new Date().getTime());
	}

	public String getDateWeek() {// 현재날짜 시간
		DateFormat dfTime1 = new SimpleDateFormat("yyyy-MM-dd E요일");
		return dfTime1.format(new Date().getTime());
	}
	
	public String getDateTime() {
		DateFormat dfTime1 = new SimpleDateFormat("yyyy-MM-dd HH시mm분ss초");
		return dfTime1.format(new Date().getTime());
	}

	public String getDateItWeek(String date) {// 요일 구하기
		String[] day = date.split("-");
		LocalDate localdate = LocalDate.of(Integer.parseInt(day[0]), Integer.parseInt(day[1]),
				Integer.parseInt(day[2]));
		DayOfWeek dayOfWeek = localdate.getDayOfWeek();
		return dayOfWeek.getDisplayName(TextStyle.FULL, Locale.KOREAN);
	}

	public String getMoney(long money) {
		DecimalFormat df = new DecimalFormat("###,###");// 콤마
		return df.format(money);
	}

	public String getMoneyWon(long money) {
		DecimalFormat df = new DecimalFormat("###,###원");// 콤마
		return df.format(money);
	}

	public String getMoneyWonIcon(long money) {
		DecimalFormat df = new DecimalFormat("￦###,###원");// 콤마
		return df.format(money);
	}
}
