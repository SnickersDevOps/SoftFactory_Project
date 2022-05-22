package com.example.snickersdevops.services.usermanagement.utils;

import org.springframework.stereotype.Service;

import java.util.Calendar;
import java.util.Date;

@Service
public class DateHelperImpl implements DateHelper {

	@Override
	public Date getCurrentDate() {
		return new Date();
	}

	@Override
	public Date getExpirationDate(Date from, int offset) {

		if (offset <= 0) {
			return from;
		}

		Calendar calendar = Calendar.getInstance();
		calendar.setTime(from);
		calendar.add(Calendar.MINUTE, offset);

		return calendar.getTime();
	}

}
