/**
 * Copyright 2000-present Liferay, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package content;

import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;

@Component(service = ServiceWrapper.class)

public class FormsServiceHook extends CalendarBookingLocalServiceWrapper {

	public FormsServiceHook() {
		super(null);
	}
	
	@Override
	public CalendarBooking updateCalendarBooking(long userId, long calendarBookingId, long calendarId,
			long[] childCalendarIds, Map<Locale, String> titleMap, Map<Locale, String> descriptionMap, String location,
			long startTime, long endTime, boolean allDay, String recurrence, long firstReminder,
			String firstReminderType, long secondReminder, String secondReminderType, ServiceContext serviceContext)
			throws PortalException {
		// TODO Auto-generated method stub
		System.out.println("Update Method Called..");
		return super.updateCalendarBooking(userId, calendarBookingId, calendarId, childCalendarIds, titleMap, descriptionMap,
				location, startTime, endTime, allDay, recurrence, firstReminder, firstReminderType, secondReminder,
				secondReminderType, serviceContext);
	}
	
	@Override
	public CalendarBooking moveCalendarBookingToTrash(long userId, long calendarBookingId) throws PortalException {
		// TODO Auto-generated method stub
		System.out.println("Delete Method called..");
		return super.moveCalendarBookingToTrash(userId, calendarBookingId);
	}
}