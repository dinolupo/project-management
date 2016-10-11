package io.github.dinolupo.projmanagement.business.workflow.boundary;

import java.util.Locale;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.faces.portal.context.LiferayPortletHelperFactory;
import com.liferay.faces.util.context.FacesContextHelperFactory;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

abstract class AbstractBacking {
	protected static Log logger = LogFactoryUtil.getLog(AbstractBacking.class);

	protected static final String UNEXPECTED_ERROR_MSG_ID = "an-unexpected-error-occurred";
	protected static final String SUCCESS_INFO_MSG_ID = "your-request-processed-successfully";

	private Locale locale;
	
	public void addGlobalSuccessInfoMessage() {
	    FacesContextHelperFactory.getFacesContextHelperInstance().addGlobalSuccessInfoMessage();
	}

	public void addGlobalUnexpectedErrorMessage() {
	    FacesContextHelperFactory.getFacesContextHelperInstance().addGlobalUnexpectedErrorMessage();
	}
	
	public Locale getLocale() {
		if (locale == null) {
			locale = FacesContextHelperFactory.getFacesContextHelperInstance().getLocale();
		}
		return locale;
	}
	
}
