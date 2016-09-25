package io.github.dinolupo.projmanagement.business.workflow.boundary;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;

import com.liferay.faces.portal.context.LiferayFacesContext;

import io.github.dinolupo.model.Entry;
import io.github.dinolupo.service.EntryLocalServiceUtil;
import io.github.dinolupo.service.persistence.EntryUtil;

@ManagedBean
@RequestScoped
public class EntryBacking extends AbstractBacking {

	@ManagedProperty(name = "projectManagementBacking", value = "#{projectManagementBacking}")
	protected ProjectManagementBacking projectManagementBacking;
	
	public void setProjectManagementBacking(ProjectManagementBacking projMan) {
		this.projectManagementBacking = projMan;
	}
	
	public void add() {
	    Entry entry = EntryUtil.create(0L);
	    LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	    entry.setGroupId(liferayFacesContext.getScopeGroupId());
	    entry.setProjectId(projectManagementBacking.getSelectedProject().getProjectId());
	    projectManagementBacking.setSelectedEntry(entry);
	    projectManagementBacking.editEntry();
	}

	public void cancel() {
	    projectManagementBacking.select(projectManagementBacking.getSelectedProject());
	}

	public void save() {

	    Entry entry = projectManagementBacking.getSelectedEntry();
	    LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	    entry.setCompanyId(liferayFacesContext.getCompanyId());
	    entry.setUserId(liferayFacesContext.getUserId());

	    try {

	        if (entry.getEntryId() == 0) {
	            EntryLocalServiceUtil.addEntry(entry);
	        }
	        else {
	            EntryLocalServiceUtil.updateEntry(entry);
	        }

	        addGlobalSuccessInfoMessage();
	    }
	    catch (Exception e) {
	        addGlobalUnexpectedErrorMessage();
	        logger.error(e);
	    }

	    projectManagementBacking.select(projectManagementBacking.getSelectedProject());
	}
	
}
