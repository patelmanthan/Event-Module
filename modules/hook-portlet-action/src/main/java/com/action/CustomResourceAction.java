package com.action;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import com.liferay.portal.kernel.portlet.bridges.mvc.MVCResourceCommand;

@Component(property = { "javax.portlet.name=com_liferay_calendar_web_portlet_CalendarPortlet",
		 "service.ranking:Integer=110" }, service = MVCResourceCommand.class)
public class CustomResourceAction implements MVCResourceCommand {

	@Override
	public boolean serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws PortletException {
		return mvcResourceCommand.serveResource(resourceRequest, resourceResponse);
	}

	@Reference(target = "(component.name=com.liferay.calendar.web.internal.portlet.CalendarPortlet)")
	protected MVCResourceCommand mvcResourceCommand;
}