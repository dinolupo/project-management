package io.github.dinolupo.projmanagement.business.workflow.boundary;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.liferay.faces.portal.context.LiferayFacesContext;
import com.liferay.portal.kernel.exception.SystemException;

import io.github.dinolupo.model.Project;
import io.github.dinolupo.service.EntryLocalServiceUtil;
import io.github.dinolupo.service.ProjectLocalServiceUtil;
import io.github.dinolupo.service.persistence.EntryUtil;
import io.github.dinolupo.service.persistence.ProjectUtil;
import io.github.dinolupo.model.Entry;

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
		logger.warn("----------> add");
	    setOriginalProject(getSelectedProject());

	    Project project = ProjectUtil.create(0L);
	    LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	    project.setGroupId(liferayFacesContext.getScopeGroupId());
	    setSelectedProject(project);
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

	        LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	        long scopeGroupId = liferayFacesContext.getScopeGroupId();

	        Project defaultProject = (Project)
	            ProjectLocalServiceUtil.getFirstProjectByName(scopeGroupId, DEFAULT_PROJECT_NAME);

	        // Create the default project if it does not exist in the database
	        if (defaultProject == null) {
	            logger.info("postConstruct: creating a default project named " + DEFAULT_PROJECT_NAME + " ...");

	            Project project = ProjectUtil.create(0L);
	            project.setName(DEFAULT_PROJECT_NAME);
	            project.setGroupId(scopeGroupId);
	            project.setCompanyId(liferayFacesContext.getCompanyId());
	            project.setUserId(liferayFacesContext.getUserId());	            
	            ProjectLocalServiceUtil.addProject(project);
	            
	            // dino
//	            Entry entry = EntryUtil.create(0L);
//	            entry.setName("Entry Name Default");
//	            entry.setValue("Entry Value Default");
//	            entry.setProjectId(0L);	            
//	            EntryLocalServiceUtil.addEntry(entry);
//	            this.setSelectedEntry(entry);
//	            this.editEntry();
	            
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
	    LiferayFacesContext liferayFacesContext = LiferayFacesContext.getInstance();
	    project.setCompanyId(liferayFacesContext.getCompanyId());
	    project.setUserId(liferayFacesContext.getUserId());

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
	
	
	public List<Entry> getEntries() {

	    if (entries == null) {
	        long scopeGroupId = LiferayFacesContext.getInstance().getScopeGroupId();
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
	        long scopeGroupId = LiferayFacesContext.getInstance().getScopeGroupId();

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
	        long scopeGroupId = LiferayFacesContext.getInstance().getScopeGroupId();

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
	
	
}
