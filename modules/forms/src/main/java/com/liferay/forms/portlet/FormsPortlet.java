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

import com.liferay.dynamic.data.mapping.model.DDMContent;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.service.DDMContentLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordLocalServiceUtil;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordVersionLocalServiceUtil;
import com.liferay.forms.constants.FormsPortletKeys;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCPortlet;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;
import com.liferay.portal.kernel.workflow.WorkflowHandlerUtil;
import com.liferay.portal.kernel.workflow.WorkflowStatusManagerUtil;
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
		long groupId = themeDisplay.getSiteGroupId();

		List<DDMFormInstance> formNameList = DDMFormInstanceLocalServiceUtil.getFormInstances(groupId);
		List<DDMFormInstance> formNameListFinal = new ArrayList<>();
		for (DDMFormInstance ddmFormInstance : formNameList) {
			if (ddmFormInstance.getUserId() == themeDisplay.getUserId())
				formNameListFinal.add(ddmFormInstance);
		}
		_log.info(formNameListFinal);
		renderRequest.setAttribute("formNameList", formNameListFinal);
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
						DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion = DDMFormInstanceRecordVersionLocalServiceUtil.getFormInstanceRecordVersion(
								ddmFormInstanceRecord.getFormInstanceRecordId(), ddmFormInstanceRecord.getVersion());
						dataMap.put("recordVersionId", String.valueOf(ddmFormInstanceRecordVersion.getFormInstanceRecordVersionId()));
						dataMap.put("status", String.valueOf(ddmFormInstanceRecordVersion.getStatus()));
						for (KaleoInstanceToken kaleoInstanceToken : kaleoInstanceTokens) {
							if (kaleoInstanceToken.getClassPK() == DDMFormInstanceRecordVersionLocalServiceUtil
									.getFormInstanceRecordVersion(ddmFormInstanceRecord.getFormInstanceRecordId(),
											ddmFormInstanceRecord.getVersion())
									.getFormInstanceRecordVersionId()) {
							}
						}
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