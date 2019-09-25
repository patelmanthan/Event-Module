package com.liferay.calendar.portlet;

import com.liferay.calendar.constants.CalendarModulePortletKeys;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author manthan
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.header-portlet-css=/css/main.css",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=CalendarModule",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + CalendarModulePortletKeys.CALENDARMODULE,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class CalendarModulePortlet extends MVCPortlet {
	private final static Log _log = LogFactoryUtil.getLog(CalendarModulePortlet.class.getClass());
	
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		_log.info("render called===========================");
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		long groupId = themeDisplay.getSiteGroupId();
		_log.info(groupId);

		List<DDMFormInstance> formNameList = DDMFormInstanceLocalServiceUtil.getFormInstances(groupId);
		List<DDMFormInstance> formNameListFinal = new ArrayList<>();
		for (DDMFormInstance ddmFormInstance : formNameList) {
			if (ddmFormInstance.getUserId() == themeDisplay.getUserId())
				formNameListFinal.add(ddmFormInstance);
			_log.info(ddmFormInstance.getName(Locale.US));
		}
//		_log.info(formNameListFinal);
		renderRequest.setAttribute("formNameList", formNameListFinal);
		super.render(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		
		_log.info("serve call=============================");
		String task = ParamUtil.get(resourceRequest, "task", StringPool.BLANK);
		switch (task) {
		case "getFormValue":

			String groupIdd = ParamUtil.get(resourceRequest, "groupId", StringPool.BLANK);
			_log.info("Task" + groupIdd);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			long groupId = themeDisplay.getSiteGroupId();
			
			List<Map<String, String>> dataList = new ArrayList<>();
			Map<String, String> dataMap = new HashMap<String, String>();

			List<DDMFormInstance> formNameList = DDMFormInstanceLocalServiceUtil.getFormInstances(groupId);
			for (DDMFormInstance ddmFormInstance : formNameList) {
				if (ddmFormInstance.getUserId() == themeDisplay.getUserId())
					dataMap.put("name", ddmFormInstance.getName(Locale.US));
					dataMap.put("id", String.valueOf(ddmFormInstance.getFormInstanceId()));
			}
			dataList.add(dataMap);
			resourceRequest.setAttribute("data", dataList);
			PrintWriter printout = resourceResponse.getWriter();
			printout.print(JSONFactoryUtil.createJSONArray(dataList).toJSONString());
			super.serveResource(resourceRequest, resourceResponse);

		default:
			break;
		}
	}
}