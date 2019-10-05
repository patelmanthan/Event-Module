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
		// formportlet		 //com_liferay_dynamic_data_mapping_form_web_portlet_DDMFormPortlet
		 "javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet", //for login portlet
		 "mvc.command.name=/login/login",
		 "service.ranking:Integer=100"
		 },
		 service = MVCActionCommand.class
		 )
public class CustomFormActionCommand extends BaseMVCActionCommand{

	@Override
	 protected void doProcessAction(ActionRequest actionRequest, ActionResponse actionResponse) throws Exception {
	 
	 System.out.println("executiong login authentication");
	 String name = ParamUtil.get(actionRequest, "mvcRenderCommandName", StringPool.BLANK);
	 System.out.println("name============"+name);
	 
	 mvcActionCommand.processAction(actionRequest, actionResponse);
	 
	 }
	 
	 /*
	 * You still execute original logic
	 */
	 @Reference(target = "(&(mvc.command.name=/login/login)(javax.portlet.name=com_liferay_login_web_portlet_LoginPortlet))")
	 protected MVCActionCommand mvcActionCommand;


}
