package com.action;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.BaseMVCActionCommand;
import com.liferay.portal.kernel.portlet.bridges.mvc.MVCActionCommand;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;

@Component(
		 immediate = true,
		 property = {
		 "javax.portlet.name=com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet", //for form portlet
		 "mvc.command.name=addFormInstanceRecord",
		 "service.ranking:Integer=100"
		 },
		 service = MVCActionCommand.class
		 )
public class CustomFormActionCommand extends BaseMVCActionCommand{

	@Override
	 protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	 
	 System.out.println("executiong login authentication");
	 String requestURLs = ParamUtil.get(actionRequest, "mvcRenderCommandName", StringPool.BLANK);
	 System.out.println("requestURLs:"+requestURLs);
	 mvcActionCommand.processAction(actionRequest, actionResponse);
	 
	 }
	 
	 /*
	 * You still execute original logic
	 */
	 @Reference(target = "(&(mvc.command.name=addFormInstanceRecord)(javax.portlet.name=com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet))")
	 protected MVCActionCommand mvcActionCommand;


}
