package com.liferay.forms.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.calendar.model.Calendar;
import com.liferay.calendar.model.CalendarBooking;
import com.liferay.calendar.service.CalendarBookingLocalServiceUtil;
import com.liferay.calendar.service.CalendarLocalServiceUtil;
import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordVersionLocalServiceUtil;
import com.liferay.forms.constants.FormsPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.model.UserNotificationDeliveryConstants;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.RoleLocalServiceUtil;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.UserGroupRoleLocalServiceUtil;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.service.UserNotificationEventLocalService;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.workflow.kaleo.model.KaleoInstanceToken;
import com.liferay.portal.workflow.kaleo.service.KaleoInstanceTokenLocalServiceUtil;

/**
 * @author Parth
 */
@Component(immediate = true, property = { "com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true", "javax.portlet.display-name=forms Portlet",
		"javax.portlet.init-param.template-path=/", "javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FormsPortletKeys.Forms, "javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user" }, service = Portlet.class)
public class FormsPortlet extends MVCPortlet {
	private final static Log _log = LogFactoryUtil.getLog(FormsPortlet.class.getClass());

	private UserNotificationEventLocalService _userNotificationEventLocalService;

	@Reference(unbind = "-")
	protected void setGroupLocalService(UserNotificationEventLocalService userNotificationEventLocalService) {
		_userNotificationEventLocalService = userNotificationEventLocalService;
	}
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#render(javax.
	 * portlet.RenderRequest, javax.portlet.RenderResponse)
	 */
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.info("render called.");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
//		UserGroupRoleLocalServiceUtil.getUserGroupRoles(-1, -1).stream().filter(predicate -> {
//			try {
//				return predicate.getRoleId() == RoleLocalServiceUtil.getRole(themeDisplay.getCompanyId(), "Organization Content Reviewer").getRoleId();
//			} catch (PortalException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//		});
		//Get calendar events that are created by current user
		Calendar calendar = CalendarLocalServiceUtil.fetchGroupCalendar(themeDisplay.getCompanyId(),themeDisplay.getSiteGroupId(), "Liferay");
		System.out.println("claendarID" + calendar.getCalendarId());
		System.out.println("Calendar Name " + calendar.getNameCurrentValue());
		List<CalendarBooking> calendarBookings = new ArrayList<>();
		Map<Long, String> formAttribute = new HashMap<>();
		CalendarBookingLocalServiceUtil.getCalendarBookings(calendar.getCalendarId(), new int [] {WorkflowConstants.STATUS_APPROVED}).stream().filter(predicate -> predicate.getUserId() == themeDisplay.getUserId()).forEach(action ->{
			action.setTitle(action.getTitleCurrentValue());
			calendarBookings.add(action);
			formAttribute.put(Long.valueOf(action.getCalendarBookingId()), (String) action.getExpandoBridge().getAttribute("formId"));
//			System.out.println("http://localhost:8080/web/forms/shared/-/form/"+CalendarBookingLocalServiceUtil.getCalendarBooking(calendarBookingId).getExpandoBridge().getAttribute("formId"));
		});
		
		renderRequest.setAttribute("calendarBookings", calendarBookings);
		renderRequest.setAttribute("formAttribute", formAttribute);
		super.render(renderRequest, renderResponse);
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet#serveResource(
	 * javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		if (Validator.isNotNull(resourceRequest.getParameter("Id"))) {
			List<Map<String, String>> dataList = new ArrayList<>();
			Map<String, String> dataMap;
			List<DDMFormInstanceRecord> fromInstances = DDMFormInstanceRecordLocalServiceUtil
					.getFormInstanceRecords(Long.parseLong(resourceRequest.getParameter("Id")));
			for (DDMFormInstanceRecord ddmFormInstanceRecord : fromInstances) {
				try {
					dataMap = new HashMap<String, String>();
					DDMContent ddmContent = DDMContentLocalServiceUtil.getContent(ddmFormInstanceRecord.getStorageId());
					String data = ddmContent.getData();
					JSONArray jsonArray = JSONFactoryUtil.createJSONObject(data).getJSONArray("fieldValues");
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject dataJson = jsonArray.getJSONObject(i);
						JSONObject value = JSONFactoryUtil.createJSONObject(dataJson.getString("value"));
						String fieldValue = value.getString("en_US");
						dataMap.put("email", fieldValue);
						dataMap.put("contentId", String.valueOf(ddmContent.getContentId()));
						dataMap.put("userId", String.valueOf(ddmFormInstanceRecord.getUserId()));
						List<KaleoInstanceToken> kaleoInstanceTokens = KaleoInstanceTokenLocalServiceUtil
								.getKaleoInstanceTokens(-1, -1);
						DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion = DDMFormInstanceRecordVersionLocalServiceUtil
								.getFormInstanceRecordVersion(ddmFormInstanceRecord.getFormInstanceRecordId(),
										ddmFormInstanceRecord.getVersion());
						dataMap.put("recordVersionId",
								String.valueOf(ddmFormInstanceRecordVersion.getFormInstanceRecordVersionId()));
						dataMap.put("status", String.valueOf(ddmFormInstanceRecordVersion.getStatus()));
						dataList.add(dataMap);
					}
				} catch (PortalException e) {
					e.printStackTrace();
				}
			}
			resourceRequest.setAttribute("data", dataList);
			PrintWriter printout = resourceResponse.getWriter();
			printout.print(JSONFactoryUtil.createJSONArray(dataList).toJSONString());
			super.serveResource(resourceRequest, resourceResponse);
		} else if (Validator.isNotNull(resourceRequest.getParameter("recordID"))) {
			try {
				DDMFormInstanceRecord ddmFormInstanceRecord = DDMFormInstanceRecordLocalServiceUtil.updateStatus(
						Long.parseLong(resourceRequest.getParameter("userId")),
						Long.parseLong(resourceRequest.getParameter("recordVersionId")),
						WorkflowConstants.STATUS_APPROVED, null);
				// TODO send user notification for successfull implementation.
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				jsonObject.put("userId", resourceRequest.getParameter("userId"));
				jsonObject.put("title", "Form Submission Approved.");
				jsonObject.put("senderName", "Admin");
				jsonObject.put("notificationMessage",
						"Your entries for the event has been approved successfully by admin.");
				_log.info("Notification to be send");
				_userNotificationEventLocalService.addUserNotificationEvent(Long.parseLong(resourceRequest.getParameter("userId")),
						SendNotificationToUserHandler.PORTLET_ID, (new Date()).getTime(),
						UserNotificationDeliveryConstants.TYPE_WEBSITE,
						Long.parseLong(resourceRequest.getParameter("userId")), jsonObject.toString(), false, new ServiceContext());
				_log.info("Notification done");
				PrintWriter printout = resourceResponse.getWriter();
				printout.print("{\"status\":\"success\"}");
			} catch (NumberFormatException | PortalException e) {
				e.printStackTrace();
				PrintWriter printout = resourceResponse.getWriter();
				printout.print("{\"status\":\"failure\"}");
			}
			super.serveResource(resourceRequest, resourceResponse);
		}
	}
}