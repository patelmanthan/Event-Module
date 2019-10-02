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

import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import org.osgi.service.component.annotations.Component;

import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceWrapper;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceWrapper;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerRegistryUtil;

@Component(service = ServiceWrapper.class)

public class FormsServiceHook extends CalendarBookingLocalServiceWrapper {

	public FormsServiceHook() {
		super(null);
	}

	@Override
	public CalendarBooking addCalendarBooking(long userId, long calendarId, long[] childCalendarIds,
			long parentCalendarBookingId, long recurringCalendarBookingId, Map<Locale, String> titleMap,
			Map<Locale, String> descriptionMap, String location, long startTime, long endTime, boolean allDay,
			String recurrence, long firstReminder, String firstReminderType, long secondReminder,
			String secondReminderType, ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		System.out.println("workflow assigned to : " + serviceContext.getExpandoBridgeAttributes().get("workflow"));
		serviceContext.setWorkflowAction(WorkflowConstants.STATUS_PENDING);
		serviceContext.setCommand("add");
		return super.addCalendarBooking(userId, calendarId, childCalendarIds, parentCalendarBookingId,
				recurringCalendarBookingId, titleMap, descriptionMap, location, startTime, endTime, allDay, recurrence,
				firstReminder, firstReminderType, secondReminder, secondReminderType, serviceContext);
	}

	@Override
	public CalendarBooking updateStatus(long userId, CalendarBooking calendarBooking, int status,
			ServiceContext serviceContext) throws PortalException {
		// TODO Auto-generated method stub
		System.out.println("Cmd: " + serviceContext.getCommand());
		System.out.println("Update status called." + calendarBooking);
		System.out.println("Status" + WorkflowConstants.getStatusLabel(status));
		if ("add".equals(serviceContext.getCommand())
				&& Validator.isNotNull(serviceContext.getExpandoBridgeAttributes().get("workflow"))) {
			if ("admin".equals(serviceContext.getExpandoBridgeAttributes().get("workflow"))) {
				// Update the status to be defaut to pending as we need to start
				// the custom workflow for the calendar event.
				status = WorkflowConstants.STATUS_PENDING;
			} else {

			}
		}
		calendarBooking = super.updateStatus(userId, calendarBooking, status, serviceContext);
		if ("add".equals(serviceContext.getCommand())
				&& Validator.isNotNull(serviceContext.getExpandoBridgeAttributes().get("workflow"))) {
			if ("admin".equals(serviceContext.getExpandoBridgeAttributes().get("workflow"))) {
				// TODO start the workflow for admin user keeping the status as
				// // pending state.
				System.out.println("Workflow handlers : "
						+ WorkflowHandlerRegistryUtil.getWorkflowHandler(CalendarBooking.class.getName()));
				
				
//				WorkflowHandlerRegistryUtil.getWorkflowHandler(CalendarBooking.class.getName()).startWorkflowInstance(
//						calendarBooking.getCompanyId(), calendarBooking.getGroupId(), userId,
//						calendarBooking.getCalendarBookingId(), CalendarBooking.class, new HashMap<>());
				// WorkflowHandlerRegistryUtil.startWorkflowInstance(calendarBooking.getCompanyId(),
				// calendarBooking.getGroupId(), userId,
				// CalendarBooking.class.getName(),
				// calendarBooking.getCalendarBookingId(),
				// CalendarBooking.class.getName(), serviceContext);

				// WorkflowInstanceLink instanceLink =
				// WorkflowInstanceLinkLocalServiceUtil.getWorkflowInstanceLink(
				// calendarBooking.getCompanyId(), calendarBooking.getGroupId(),
				// CalendarBooking.class.getName(),
				// calendarBooking.getCalendarBookingId());
				// WorkflowInstance instance = WorkflowInstanceManagerUtil
				// .getWorkflowInstance(calendarBooking.getCompanyId(),
				// instanceLink.getWorkflowInstanceId());
				//
				// List<Integer> assignLogTypes = new ArrayList<>();
				// assignLogTypes.add(WorkflowLog.TASK_ASSIGN);
				//
				// List<WorkflowLog> wfAssignLogs =
				// WorkflowLogManagerUtil.getWorkflowLogsByWorkflowInstance(
				// calendarBooking.getCompanyId(),
				// instance.getWorkflowInstanceId(), assignLogTypes,
				// QueryUtil.ALL_POS, QueryUtil.ALL_POS,
				// WorkflowComparatorFactoryUtil.getLogCreateDateComparator(true));
				//
				// long wfTaskId = wfAssignLogs.get(wfAssignLogs.size() -
				// 1).getWorkflowTaskId();
				//
				// WorkflowTask task =
				// WorkflowTaskManagerUtil.getWorkflowTask(calendarBooking.getCompanyId(),
				// wfTaskId);
				//
				// WorkflowTaskManagerUtil.assignWorkflowTaskToRole(calendarBooking.getCompanyId(),
				// userId,
				// task.getWorkflowTaskId(),
				// RoleLocalServiceUtil.getRole(calendarBooking.getCompanyId(),
				// "Administrator").getRoleId(),
				// "Assign to admin of the system", null, null);
			} else {

			}
		}
		return calendarBooking;
	}

}