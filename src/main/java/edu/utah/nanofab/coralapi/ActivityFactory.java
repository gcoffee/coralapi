package edu.utah.nanofab.coralapi;

import java.util.Calendar;
import java.util.Date;

import org.opencoral.idl.Activity;
import org.opencoral.idl.Timestamp;

import edu.utah.nanofab.coralapi.helper.TimestampConverter;

public class ActivityFactory {

	public Activity createDefaultActivity(String item) {
		return createRunActivity("test", item, "test", "test", "test", new Date(), new Date());
	}
	
	public static Activity createRunActivity(String user, String tool, String project, String account, String lab, Date bdate, Date edate) {
		Calendar currentDate = Calendar.getInstance();
		int y = currentDate.get( Calendar.YEAR );
		int m = currentDate.get( Calendar.MONTH );
		int d = currentDate.get( Calendar.DAY_OF_MONTH );
		int h = currentDate.get( Calendar.HOUR );
		int i = currentDate.get( Calendar.MINUTE );
		int s = currentDate.get( Calendar.SECOND );
		 
		Activity activity = new Activity();
		activity.account = account  ;
		activity.agent = user        ;
		activity.amount = 0.0   ;
		try {
			Class<?> activityClass = activity.getClass();
			activityClass.getField("area").set(activity, "");
		} catch (Exception e) {
			
		}
		activity.bdate = TimestampConverter.dateToTimestamp(bdate);
		activity.creationDate = TimestampConverter.dateToTimestamp(new Date());
		activity.creator = user      ;
		activity.edate =TimestampConverter.dateToTimestamp(edate);
		activity.id = "not assigned"    ;
		activity.isNull = false ;
		activity.item = tool  ;
		activity.lab = lab        ;
		activity.member = user       ;
		activity.primeAmount = 0.0      ;
		activity.process = "default"    ;
		activity.project = project  ;
		activity.reference = "not assigned"     ;
		activity.stale = false  ;
		activity.type = "Generic Activity"      ;
		return activity;
	}	

}
