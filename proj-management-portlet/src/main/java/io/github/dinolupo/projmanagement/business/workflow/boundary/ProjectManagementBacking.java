package io.github.dinolupo.projmanagement.business.workflow.boundary;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.liferay.faces.portal.context.LiferayPortletHelper;
import com.liferay.faces.portal.context.LiferayPortletHelperFactory;
import com.liferay.portal.kernel.exception.SystemException;

import io.github.dinolupo.model.Entry;
import io.github.dinolupo.model.Project;
import io.github.dinolupo.service.EntryLocalServiceUtil;
import io.github.dinolupo.service.ProjectLocalServiceUtil;
import io.github.dinolupo.service.persistence.ProjectUtil;

@ManagedBean
@ViewScoped
public class ProjectManagementBacking extends AbstractBacking {

	public static final String DEFAULT_PROJECT_NAME = "Main";

	private Project originalProject;

	private Project selectedProject;
	private List<Project> projects;

	private Entry selectedEntry;
	private List<Entry> entries;

	private boolean editingProject;
	public boolean isEditingProject() {
		return editingProject;
	}

	public boolean isEditingEntry() {
		return editingEntry;
	}

	private boolean editingEntry;
	
	public void add() {
	    setOriginalProject(getSelectedProject());
	    Project project = ProjectUtil.create(0L);
	    project.setGroupId(LiferayPortletHelperFactory.getLiferayPortletHelperInstance().getScopeGroupId());
	    setSelectedProject(project);
	    editProject();
	}
	
	
	public void editSelectedProject() {
		logger.warn("selected project: " + selectedProject);
		setOriginalProject(selectedProject);
		editProject();
	}
	
	public void cancel() {
	    select(getOriginalProject());
	}

	public void editEntry() {
	    editingEntry = true;
	    editingProject = false;
	}

	public void editProject() {
	    editingEntry = false;
	    editingProject = true;
	}
	
	public void createMainProject() {

	    try {

	        LiferayPortletHelper liferayPortletHelper = LiferayPortletHelperFactory.getLiferayPortletHelperInstance();
	        long scopeGroupId = liferayPortletHelper.getScopeGroupId();

	        Project defaultProject = (Project)
	            ProjectLocalServiceUtil.getFirstProjectByName(scopeGroupId, DEFAULT_PROJECT_NAME);

	        // Create the default project if it does not exist in the database
	        if (defaultProject == null) {
	            logger.info("postConstruct: creating a default project named " + DEFAULT_PROJECT_NAME + " ...");

	            Project project = ProjectUtil.create(0L);
	            project.setName(DEFAULT_PROJECT_NAME);
	            project.setGroupId(scopeGroupId);
	            project.setCompanyId(liferayPortletHelper.getCompanyId());
	            project.setUserId(liferayPortletHelper.getUserId());	            
	            ProjectLocalServiceUtil.addProject(project);
	            
	        }
	    }
	    catch (Exception e) {
	        e.printStackTrace();
	    }
	}

	@PostConstruct
	public void postConstruct() {
	    createMainProject();
	}
	
	
	public void save() {
	    Project project = getSelectedProject();
	    LiferayPortletHelper liferayPortletHelper = LiferayPortletHelperFactory.getLiferayPortletHelperInstance();
	    project.setCompanyId(liferayPortletHelper.getCompanyId());
	    project.setUserId(liferayPortletHelper.getUserId());
	    project.setActive(true);
	    Date now = new Date();
	    project.setCreateDate(now);
	    project.setModifiedDate(now);
	    project.setUserName(liferayPortletHelper.getUser().getFullName());
	    
	    
	    try {

	        if (project.getProjectId() == 0) {
	            project = ProjectLocalServiceUtil.addProject(project);
	        }
	        else {
	            project = ProjectLocalServiceUtil.updateProject(project);
	        }

	        addGlobalSuccessInfoMessage();
	    }
	    catch (Exception e) {
	        addGlobalUnexpectedErrorMessage();
	        logger.error(e);
	    }

	    // Go back to master view
	    select(project);
	}

	public void select(Project project) {

	    if (project == null) {
	        setSelectedProject(null);
	    }
	    else {
	        setSelectedProject(project);
	    }

	    // Force Projects and Entries to reload
	    setProjects(null);
	    setEntries(null);

	    editingEntry = false;
	    editingProject = false;
	    
	}
	
	
	public void setEditingEntry(boolean editingEntry) {
	    this.editingEntry = editingEntry;
	}

	public void setEditingProject(boolean editingProject) {
	    this.editingProject = editingProject;
	}
	
	public void removeAllProjects() {
		List<Project> projects = getProjects();
		long scopeGroupId = LiferayPortletHelperFactory.getLiferayPortletHelperInstance().getScopeGroupId();
		
		for (Project project: projects) {
			try {
				List<Entry> entries = EntryLocalServiceUtil.getEntrys(project.getProjectId(), scopeGroupId);
				for(Entry entry : entries) {
					EntryLocalServiceUtil.deleteEntry(entry);
				}
				ProjectLocalServiceUtil.deleteProject(project);
			} catch (SystemException e) {
				logger.error(e);
			}
		}
		createMainProject();
		select(getSelectedProject());
	}
	
	public void removeAllEntries() throws SystemException {
		List<Entry> entries = getEntries();
		for(Entry entry : entries) {
			EntryLocalServiceUtil.deleteEntry(entry);
		}
		select(getSelectedProject());
	}
	
	public List<Entry> getEntries() {

	    if (entries == null) {
	    	
	        long scopeGroupId = LiferayPortletHelperFactory.getLiferayPortletHelperInstance().getScopeGroupId();
	        Project selectedProject = getSelectedProject();

	        try {
	            entries = new ArrayList<Entry>();

	            if (selectedProject == null) {
	                logger.info("getEntries: selectedProject == null ... ");
	            }
	            else {
	                List<Entry> list = EntryLocalServiceUtil.getEntrys(
	                    selectedProject.getProjectId(), scopeGroupId);

	                for (Entry entry : list) {
	                    entries.add(entry);
	                }
	            }

	        }
	        catch (SystemException e) {
	            logger.error(e);
	        }
	    }

	    return entries;
	}

	public void setEntries(List<Entry> entries) {
	    this.entries = entries;
	}
	
	public List<Project> getProjects() {

	    if (projects == null) {
	        long scopeGroupId = LiferayPortletHelperFactory.getLiferayPortletHelperInstance().getScopeGroupId();

	        try {
	            projects = new ArrayList<Project>();

	            List<Project> list = ProjectLocalServiceUtil.getProjects(
	                scopeGroupId);

	            for (Project project : list) {
	                projects.add(project);
	            }
	        }
	        catch (SystemException e) {
	            logger.error(e);
	        }
	    }

	    logger.info("getProjects: projects.size() = " + projects.size());

	    return projects;
	}

	public void setProjects(List<Project> projects) {
	    this.projects = projects;
	}
	
	
	// --------------------------------------------------------------------------
	
	public Project getOriginalProject() {
	    return originalProject;
	}

	public void setOriginalProject(Project originalProject) {
	    this.originalProject = originalProject;
	}

	public Project getSelectedProject() {

	    if (selectedProject == null) {

	    	long scopeGroupId = LiferayPortletHelperFactory.getLiferayPortletHelperInstance().getScopeGroupId();

	        try {
	            Project firstProjectByName =
	                (Project) ProjectLocalServiceUtil.getFirstProjectByName(
	                    scopeGroupId, DEFAULT_PROJECT_NAME);

	            if (firstProjectByName == null) {
	                logger.info("getSelectedProject: No Project named " + DEFAULT_PROJECT_NAME);
	            }
	            else {
	                selectedProject = firstProjectByName;
	            }
	        }
	        catch (SystemException e) {
	            logger.error(e);
	        }
	    }

	    return selectedProject;
	}

	public void setSelectedProject(Project selectedProject) {
	    this.selectedProject = selectedProject;
	}
	
	public Entry getSelectedEntry() {
	    return selectedEntry;
	}

	public void setSelectedEntry(Entry selectedEntry) {
	    this.selectedEntry = selectedEntry;
	}

	// -----------------------------------------------------------------------------------------
	//				PERMISSION 	SETTINGS
	// -----------------------------------------------------------------------------------------
	
	public static final String MODEL 			= "io.github.dinolupo.model";
	public static final String MODEL_ENTRY 		= "io.github.dinolupo.model.Entry";
	public static final String MODEL_PROJECT 	= "io.github.dinolupo.model.Project";

	private Boolean hasAddPermission;
	private Boolean hasViewPermission;
	
	public Boolean getHasAddPermission() {

	    if (hasAddPermission == null) {
	        LiferayPortletHelper liferayPortletHelper = LiferayPortletHelperFactory.getLiferayPortletHelperInstance();
	        long scopeGroupId = liferayPortletHelper.getScopeGroupId();
	        hasAddPermission = liferayPortletHelper.getThemeDisplay().getPermissionChecker().hasPermission(
	            scopeGroupId, MODEL, scopeGroupId, "ADD_PROJECT"
	            );
	    }

	    return hasAddPermission;
	}

	public void setHasAddPermission(Boolean hasAddPermission) {
	    this.hasAddPermission = hasAddPermission;
	}

	public Boolean getHasViewPermission() {

	    if (hasViewPermission == null) {
	        LiferayPortletHelper liferayPortletHelper = LiferayPortletHelperFactory.getLiferayPortletHelperInstance();
	        long scopeGroupId = liferayPortletHelper.getScopeGroupId();
	        hasViewPermission = liferayPortletHelper.getThemeDisplay().getPermissionChecker().hasPermission(
	            scopeGroupId, MODEL_PROJECT, scopeGroupId, "VIEW"
	            );
	    }

	    return hasViewPermission;
	}

	public void setHasViewPermission(Boolean hasViewPermission) {
	    this.hasViewPermission = hasViewPermission;
	}
	
	
	
}
