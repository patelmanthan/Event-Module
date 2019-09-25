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
		JSONObject jsonObject = JSONFactoryUtil.createJSONObject(userNotificationEvent.getPayload());
		String title = jsonObject.getString("title");
		String notificationText = jsonObject.getString("notificationMessage");
		String body = StringUtil.replace(getBodyTemplate(), new String[] {
				"[$TITLE$]", "[$BODY$]" },
				new String[] { title, notificationText });
		return body;
	}
	
	@Override
	protected String getBodyTemplate() throws Exception {
		StringBuilder builder = new StringBuilder(5);
		builder.append("<div class=\"title\">[$TITLE$]</div><div ");
		builder.append("class=\"body\">[$BODY$]</div>");
		return super.getBodyTemplate();
	}
}
