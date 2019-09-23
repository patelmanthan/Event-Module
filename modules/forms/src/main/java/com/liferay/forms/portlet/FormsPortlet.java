package com.liferay.forms.portlet;

import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.forms.constants.FormsPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.service.UserLocalServiceUtil;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.Portlet;
import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

/**
 * @author Parth
 */
@Component(
	immediate = true,
	property = {
		"com.liferay.portlet.display-category=category.sample",
		"com.liferay.portlet.instanceable=true",
		"javax.portlet.display-name=forms Portlet",
		"javax.portlet.init-param.template-path=/",
		"javax.portlet.init-param.view-template=/view.jsp",
		"javax.portlet.name=" + FormsPortletKeys.Forms,
		"javax.portlet.resource-bundle=content.Language",
		"javax.portlet.security-role-ref=power-user,user"
	},
	service = Portlet.class
)
public class FormsPortlet extends MVCPortlet {
	private final static Log _log = LogFactoryUtil.getLog(FormsPortlet.class.getClass());
	
	@Override
	public void render(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException{
		_log.info("render called.");
		ThemeDisplay themeDisplay= (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> dataList = new ArrayList<>();
		List<String> userNameList = new ArrayList<>();
		List<String> userIdList = new ArrayList<>();
		long groupId = themeDisplay.getSiteGroupId();
		
		List<DDMFormInstance> formNameList = DDMFormInstanceLocalServiceUtil.getFormInstances(groupId);
		for (DDMFormInstance ddmFormInstance : formNameList) {
			String formName = ddmFormInstance.getName(Locale.US);
			_log.info("formName============="+formName);
		}
		
		List<DDMContent> content = DDMContentLocalServiceUtil.getContents(groupId);
		if(Validator.isNotNull(content) && !content.isEmpty()) {
			_log.info("list size==========="+content.size());
			String userName = null;
			long userId = 0;
			for (DDMContent ddmContent : content) {
				userName = ddmContent.getUserName();
				JSONArray jsonArray = null;
				userNameList.add(userName);
				userId = ddmContent.getUserId();
				userIdList.add(String.valueOf(userId));
				try {
					jsonArray = JSONFactoryUtil.createJSONObject(ddmContent.getData()).getJSONArray("fieldValues");
					for (int i = 0; i < jsonArray.length(); i++) {
						JSONObject dataJson = jsonArray.getJSONObject(i);
						JSONObject value = JSONFactoryUtil.createJSONObject(dataJson.getString("value"));
						String fieldValue = value.getString("en_US");
						dataList.add(fieldValue);
					}
				} catch (JSONException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			_log.info("dataList====="+dataList);
			_log.info("userList====="+userNameList);
			_log.info("userIdList====="+userIdList);
			renderRequest.setAttribute("list", dataList);
			renderRequest.setAttribute("userName", userNameList);
			renderRequest.setAttribute("userIdList", userIdList);
			super.render(renderRequest, renderResponse);
		}
	}
}