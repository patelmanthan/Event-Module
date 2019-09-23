package com.liferay.forms.portlet;

import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.forms.constants.FormsPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.WebKeys;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
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
	public void render(RenderRequest renderRequest, RenderResponse renderResponse){
		_log.info("render called.");
		ThemeDisplay themeDisplay= (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		List<String> dataList = new ArrayList<>();
		_log.info(themeDisplay.getSiteGroupId());
		List<DDMContent> content = DDMContentLocalServiceUtil.getContents(themeDisplay.getSiteGroupId());
		String userName = null;
		for (DDMContent ddmContent : content) {
			userName = ddmContent.getUserName();
			JSONArray jsonArray = null;
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
		_log.info("Form data size : "+dataList.size());
		_log.info("Form created User : "+userName);
		renderRequest.setAttribute("list", dataList);
		renderRequest.setAttribute("userName", userName);
		
	}
}