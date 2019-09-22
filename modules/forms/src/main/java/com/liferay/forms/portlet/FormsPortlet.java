package com.liferay.forms.portlet;

import java.util.ArrayList;
import java.util.List;

import javax.portlet.Portlet;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import org.osgi.service.component.annotations.Component;

import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.forms.constants.FormsPortletKeys;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;

/**
 * @author manthan
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
		List<String> dataList = new ArrayList<>();
		List<DDMContent> content = DDMContentLocalServiceUtil.getContents(0);
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
		renderRequest.setAttribute("list", dataList);
		renderRequest.setAttribute("userName", userName);
		
	}
}