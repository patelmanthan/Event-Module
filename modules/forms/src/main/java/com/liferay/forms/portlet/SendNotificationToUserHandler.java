package com.liferay.forms.portlet;

import org.osgi.service.component.annotations.Component;

import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.model.UserNotificationEvent;
import com.liferay.portal.kernel.notifications.BaseUserNotificationHandler;
import com.liferay.portal.kernel.notifications.UserNotificationHandler;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.StringUtil;

@Component(service = UserNotificationHandler.class)
public class SendNotificationToUserHandler extends BaseUserNotificationHandler{

	public static final String PORTLET_ID = "com_liferay_forms_portlet";
	
	public SendNotificationToUserHandler() {
		setPortletId(PORTLET_ID);
	}
	
	@Override
	protected String getBody(UserNotificationEvent userNotificationEvent, ServiceContext serviceContext)
			throws Exception {
//		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
//		String notificationText = jsonObject.getString("notificationText");
//		String title = jsonObject.getString("title");
//		String senderName = jsonObject.getString("senderName");
		String body = getBodyTemplate();
		return body;
	}
	
	@Override
	protected String getBodyTemplate() throws Exception {
		StringBuilder builder = new StringBuilder(5);
		builder.append("<div class=\"title\">Title::Form entry approved</div><div");
		builder.append("class=\"body\">Sender::Admin <br> Notification:: You dorm entry has been approved by admin</div>");
		return super.getBodyTemplate();
	}
}
