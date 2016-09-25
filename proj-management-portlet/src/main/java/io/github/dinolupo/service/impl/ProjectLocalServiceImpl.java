package io.github.dinolupo.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException; 
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import io.github.dinolupo.ProjectDatesCoherenceException;
import io.github.dinolupo.ProjectNameException;
import io.github.dinolupo.ProjectStartDateException;
import io.github.dinolupo.model.Project;
import io.github.dinolupo.service.base.ProjectLocalServiceBaseImpl;

/**
 * The implementation of the project local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link io.github.dinolupo.service.ProjectLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.github.dinolupo.service.base.ProjectLocalServiceBaseImpl
 * @see io.github.dinolupo.service.ProjectLocalServiceUtil
 */
public class ProjectLocalServiceImpl extends ProjectLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link
	 * io.github.dinolupo.service.ProjectLocalServiceUtil} to access the project
	 * local service.
	 */

	@Override
	public List<Project> getProjects(long groupId) throws SystemException {
		return projectPersistence.findByGroupId(groupId);
	}

	@Override
	public List<Project> getProjects(long groupId, int start, int end) throws SystemException {
		return projectPersistence.findByGroupId(groupId, start, end);
	}

	
	protected void validate (String name, Date startDate, Date endDate) throws PortalException {
	    if (Validator.isNull(name)) {
	       throw new ProjectNameException();
	    }
	    if (Validator.isNull(startDate)) {
	    	throw new ProjectStartDateException();
	    }
	    if (startDate.getTime() - endDate.getTime() > 0) {
	    	throw new ProjectDatesCoherenceException();
	    }
	    
	}
	
	@Override
	public Project addProject(Project project) throws SystemException {
	    long projectId = counterLocalService.increment(Project.class.getName());
	    project.setProjectId(projectId);
	    return super.addProject(project);
	}
	
	@Override
	public Project addProject(long userId, 
			String name, 
			String description, 
			Date startDate, 
			Date endDate,
			ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();
		validate(name, startDate, endDate);
		
		long projectId = counterLocalService.increment(Project.class.getName());
		
		Project project = projectPersistence.create(projectId);
		
		// default fields
		project.setUuid(serviceContext.getUuid());
		project.setUserId(userId);
		project.setGroupId(groupId);
		project.setCompanyId(user.getCompanyId());
		project.setUserName(user.getFullName());
		project.setCreateDate(serviceContext.getCreateDate(now));
		project.setModifiedDate(serviceContext.getModifiedDate(now));
		
		// custom fields
		project.setName(name);
		project.setDescription(description);
		project.setStartDate(startDate);
		project.setEndDate(endDate);
		project.setActive(true);
		
		project.setExpandoBridgeAttributes(serviceContext);
		
		return project;
		
	}
	
	public Project getFirstProjectByName(long groupId, String name) throws SystemException {
		Project project = null;

	    List<Project> projects = projectPersistence.findByName(name, groupId);
	    if (projects != null && projects.size() > 0) {
	        project = projects.get(0);
	    }

	    return project;
	}
	
	
}
