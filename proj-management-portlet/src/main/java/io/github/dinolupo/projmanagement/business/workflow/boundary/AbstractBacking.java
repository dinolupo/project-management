package io.github.dinolupo.projmanagement.business.workflow.boundary;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

abstract class AbstractBacking {
	protected static Log logger = LogFactoryUtil.getLog(AbstractBacking.class);

	protected static final String UNEXPECTED_ERROR_MSG_ID = "an-unexpected-error-occurred";
	protected static final String SUCCESS_INFO_MSG_ID = "your-request-processed-successfully";
	
	public void addGlobalSuccessInfoMessage() {
	    LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	    liferayFacesContext.addGlobalSuccessInfoMessage();
	}

	public void addGlobalUnexpectedErrorMessage() {
	    LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	    liferayFacesContext.addGlobalUnexpectedErrorMessage();
	}
	
}
