package com.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletSession;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.dynamic.data.mapping.form.values.factory.DDMFormValuesFactory;
import com.liferay.dynamic.data.mapping.model.DDMForm;
import com.liferay.dynamic.data.mapping.model.DDMFormInstance;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecord;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceRecordVersion;
import com.liferay.dynamic.data.mapping.model.DDMFormInstanceSettings;
import com.liferay.dynamic.data.mapping.model.DDMFormSuccessPageSettings;
import com.liferay.dynamic.data.mapping.model.DDMStructure;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceRecordVersionLocalService;
import com.liferay.dynamic.data.mapping.service.DDMFormInstanceService;
import com.liferay.dynamic.data.mapping.storage.DDMFormValues;
import com.liferay.portal.kernel.captcha.CaptchaTextException;
import com.liferay.portal.kernel.captcha.CaptchaUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.service.ServiceContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.theme.ThemeDisplay;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Portal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.kernel.workflow.WorkflowConstants;

@Component(immediate = true, property = {
		"javax.portlet.name=com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet",
		"mvc.command.name=addFormInstanceRecord", "service.ranking:Integer=110" }, service = MVCActionCommand.class)
public class CustomFormActionCommand extends BaseMVCActionCommand{

	@Override
	protected void doProcessAction(
			ActionRequest actionRequest, ActionResponse actionResponse)
		throws Exception {
		
		PortletSession portletSession = actionRequest.getPortletSession();

		long groupId = ParamUtil.getLong(actionRequest, "groupId");

		if (groupId == 0) {
			groupId = GetterUtil.getLong(
				portletSession.getAttribute("GROUP_ID"));
		}

		long formInstanceId = ParamUtil.getLong(
			actionRequest, "formInstanceId");

		if (formInstanceId == 0) {
			formInstanceId = GetterUtil.getLong(
				portletSession.getAttribute("DYNAMIC_DATA_MAPPING_FORM_INSTANCE_ID"));
		}

		DDMFormInstance ddmFormInstance =
			_ddmFormInstanceService.getFormInstance(formInstanceId);

		validateCaptcha(actionRequest, ddmFormInstance);

		DDMForm ddmForm = getDDMForm(ddmFormInstance);

		DDMFormValues ddmFormValues = _ddmFormValuesFactory.create(
			actionRequest, ddmForm);

		ThemeDisplay themeDisplay = (ThemeDisplay)actionRequest.getAttribute(
			WebKeys.THEME_DISPLAY);


		ServiceContext serviceContext = ServiceContextFactory.getInstance(
			DDMFormInstanceRecord.class.getName(), actionRequest);

		DDMFormInstanceRecordVersion ddmFormInstanceRecordVersion =
			_ddmFormInstanceRecordVersionLocalService.
				fetchLatestFormInstanceRecordVersion(
					themeDisplay.getUserId(), formInstanceId,
					ddmFormInstance.getVersion(),
					WorkflowConstants.STATUS_DRAFT);

		DDMFormInstanceRecord ddmFormInstanceRecord;

		if (ddmFormInstanceRecordVersion == null) {
			ddmFormInstanceRecord =
				_ddmFormInstanceRecordService.addFormInstanceRecord(
					groupId, formInstanceId, ddmFormValues, serviceContext);

		}else {
			ddmFormInstanceRecord =
				_ddmFormInstanceRecordService.updateFormInstanceRecord(
					ddmFormInstanceRecordVersion.getFormInstanceRecordId(),
					false, ddmFormValues, serviceContext);
		}

		//Custom code start
		String eventId = ParamUtil.get(actionRequest, "eventId", StringPool.BLANK);
		System.out.println("eventId" + eventId);
		System.out.println("FormInstanceRecordId"+ddmFormInstanceRecord.getFormInstanceRecordId());
		System.out.println("UserId " + ddmFormInstanceRecord.getUserId());
		//TODO write custom code to save the data into the custom table.
		//Custom code end
		if (SessionErrors.isEmpty(actionRequest)) {
			DDMFormInstanceSettings formInstanceSettings =
				ddmFormInstance.getSettingsModel();

			String redirectURL = formInstanceSettings.redirectURL();

			if (Validator.isNotNull(redirectURL)) {
				portletSession.setAttribute("DYNAMIC_DATA_MAPPING_FORM_INSTANCE_ID",
					formInstanceId);
				portletSession.setAttribute("GROUP_ID", groupId);

				sendRedirect(actionRequest, actionResponse, redirectURL);
			}
			else {
				DDMFormSuccessPageSettings ddmFormSuccessPageSettings =
					ddmForm.getDDMFormSuccessPageSettings();

				if (ddmFormSuccessPageSettings.isEnabled()) {
					String portletId = _portal.getPortletId(actionRequest);

					SessionMessages.add(
						actionRequest,
						portletId.concat(
							SessionMessages.
								KEY_SUFFIX_HIDE_DEFAULT_SUCCESS_MESSAGE));
				}
			}
		}
	}

	protected DDMForm getDDMForm(DDMFormInstance ddmFormInstance)
		throws PortalException {

		DDMStructure ddmStructure = ddmFormInstance.getStructure();

		return ddmStructure.getDDMForm();
	}

	protected boolean isEmailNotificationEnabled(
			DDMFormInstance ddmFormInstance)
		throws PortalException {

		DDMFormInstanceSettings formInstanceSettings =
			ddmFormInstance.getSettingsModel();

		return formInstanceSettings.sendEmailNotification();
	}


	@Reference(unbind = "-")
	protected void setDDMFormInstanceRecordService(
		DDMFormInstanceRecordService ddmFormInstanceRecordService) {

		_ddmFormInstanceRecordService = ddmFormInstanceRecordService;
	}

	@Reference(unbind = "-")
	protected void setDDMFormInstanceService(
		DDMFormInstanceService ddmFormInstanceService) {

		_ddmFormInstanceService = ddmFormInstanceService;
	}

	@Reference(unbind = "-")
	protected void setDDMFormValuesFactory(
		DDMFormValuesFactory ddmFormValuesFactory) {

		_ddmFormValuesFactory = ddmFormValuesFactory;
	}

	protected void validateCaptcha(
			ActionRequest actionRequest, DDMFormInstance ddmFormInstance)
		throws Exception {

		DDMFormInstanceSettings formInstanceSettings =
			ddmFormInstance.getSettingsModel();

		if (formInstanceSettings.requireCaptcha()) {
			try {
				CaptchaUtil.check(actionRequest);
			}
			catch (CaptchaTextException cte) {
				SessionErrors.add(
					actionRequest, CaptchaTextException.class.getName());

				throw cte;
			}
		}
	}


	private DDMFormInstanceRecordService _ddmFormInstanceRecordService;

	@Reference
	private DDMFormInstanceRecordVersionLocalService
		_ddmFormInstanceRecordVersionLocalService;

	private DDMFormInstanceService _ddmFormInstanceService;
	private DDMFormValuesFactory _ddmFormValuesFactory;

	@Reference
	private Portal _portal;
	
}
