package io.github.dinolupo.model;

import com.liferay.portal.kernel.lar.StagedModelType;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.ModelWrapper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * This class is a wrapper for {@link Project}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectWrapper implements Project, ModelWrapper<Project> {
    private Project _project;

    public ProjectWrapper(Project project) {
        _project = project;
    }

    @Override
    public Class<?> getModelClass() {
        return Project.class;
    }

    @Override
    public String getModelClassName() {
        return Project.class.getName();
    }

    @Override
    public Map<String, Object> getModelAttributes() {
        Map<String, Object> attributes = new HashMap<String, Object>();

        attributes.put("uuid", getUuid());
        attributes.put("projectId", getProjectId());
        attributes.put("groupId", getGroupId());
        attributes.put("companyId", getCompanyId());
        attributes.put("userId", getUserId());
        attributes.put("userName", getUserName());
        attributes.put("createDate", getCreateDate());
        attributes.put("modifiedDate", getModifiedDate());
        attributes.put("name", getName());
        attributes.put("description", getDescription());
        attributes.put("startDate", getStartDate());
        attributes.put("endDate", getEndDate());
        attributes.put("active", getActive());

        return attributes;
    }

    @Override
    public void setModelAttributes(Map<String, Object> attributes) {
        String uuid = (String) attributes.get("uuid");

        if (uuid != null) {
            setUuid(uuid);
        }

        Long projectId = (Long) attributes.get("projectId");

        if (projectId != null) {
            setProjectId(projectId);
        }

        Long groupId = (Long) attributes.get("groupId");

        if (groupId != null) {
            setGroupId(groupId);
        }

        Long companyId = (Long) attributes.get("companyId");

        if (companyId != null) {
            setCompanyId(companyId);
        }

        Long userId = (Long) attributes.get("userId");

        if (userId != null) {
            setUserId(userId);
        }

        String userName = (String) attributes.get("userName");

        if (userName != null) {
            setUserName(userName);
        }

        Date createDate = (Date) attributes.get("createDate");

        if (createDate != null) {
            setCreateDate(createDate);
        }

        Date modifiedDate = (Date) attributes.get("modifiedDate");

        if (modifiedDate != null) {
            setModifiedDate(modifiedDate);
        }

        String name = (String) attributes.get("name");

        if (name != null) {
            setName(name);
        }

        String description = (String) attributes.get("description");

        if (description != null) {
            setDescription(description);
        }

        Date startDate = (Date) attributes.get("startDate");

        if (startDate != null) {
            setStartDate(startDate);
        }

        Date endDate = (Date) attributes.get("endDate");

        if (endDate != null) {
            setEndDate(endDate);
        }

        Boolean active = (Boolean) attributes.get("active");

        if (active != null) {
            setActive(active);
        }
    }

    /**
    * Returns the primary key of this project.
    *
    * @return the primary key of this project
    */
    @Override
    public long getPrimaryKey() {
        return _project.getPrimaryKey();
    }

    /**
    * Sets the primary key of this project.
    *
    * @param primaryKey the primary key of this project
    */
    @Override
    public void setPrimaryKey(long primaryKey) {
        _project.setPrimaryKey(primaryKey);
    }

    /**
    * Returns the uuid of this project.
    *
    * @return the uuid of this project
    */
    @Override
    public java.lang.String getUuid() {
        return _project.getUuid();
    }

    /**
    * Sets the uuid of this project.
    *
    * @param uuid the uuid of this project
    */
    @Override
    public void setUuid(java.lang.String uuid) {
        _project.setUuid(uuid);
    }

    /**
    * Returns the project ID of this project.
    *
    * @return the project ID of this project
    */
    @Override
    public long getProjectId() {
        return _project.getProjectId();
    }

    /**
    * Sets the project ID of this project.
    *
    * @param projectId the project ID of this project
    */
    @Override
    public void setProjectId(long projectId) {
        _project.setProjectId(projectId);
    }

    /**
    * Returns the group ID of this project.
    *
    * @return the group ID of this project
    */
    @Override
    public long getGroupId() {
        return _project.getGroupId();
    }

    /**
    * Sets the group ID of this project.
    *
    * @param groupId the group ID of this project
    */
    @Override
    public void setGroupId(long groupId) {
        _project.setGroupId(groupId);
    }

    /**
    * Returns the company ID of this project.
    *
    * @return the company ID of this project
    */
    @Override
    public long getCompanyId() {
        return _project.getCompanyId();
    }

    /**
    * Sets the company ID of this project.
    *
    * @param companyId the company ID of this project
    */
    @Override
    public void setCompanyId(long companyId) {
        _project.setCompanyId(companyId);
    }

    /**
    * Returns the user ID of this project.
    *
    * @return the user ID of this project
    */
    @Override
    public long getUserId() {
        return _project.getUserId();
    }

    /**
    * Sets the user ID of this project.
    *
    * @param userId the user ID of this project
    */
    @Override
    public void setUserId(long userId) {
        _project.setUserId(userId);
    }

    /**
    * Returns the user uuid of this project.
    *
    * @return the user uuid of this project
    * @throws SystemException if a system exception occurred
    */
    @Override
    public java.lang.String getUserUuid()
        throws com.liferay.portal.kernel.exception.SystemException {
        return _project.getUserUuid();
    }

    /**
    * Sets the user uuid of this project.
    *
    * @param userUuid the user uuid of this project
    */
    @Override
    public void setUserUuid(java.lang.String userUuid) {
        _project.setUserUuid(userUuid);
    }

    /**
    * Returns the user name of this project.
    *
    * @return the user name of this project
    */
    @Override
    public java.lang.String getUserName() {
        return _project.getUserName();
    }

    /**
    * Sets the user name of this project.
    *
    * @param userName the user name of this project
    */
    @Override
    public void setUserName(java.lang.String userName) {
        _project.setUserName(userName);
    }

    /**
    * Returns the create date of this project.
    *
    * @return the create date of this project
    */
    @Override
    public java.util.Date getCreateDate() {
        return _project.getCreateDate();
    }

    /**
    * Sets the create date of this project.
    *
    * @param createDate the create date of this project
    */
    @Override
    public void setCreateDate(java.util.Date createDate) {
        _project.setCreateDate(createDate);
    }

    /**
    * Returns the modified date of this project.
    *
    * @return the modified date of this project
    */
    @Override
    public java.util.Date getModifiedDate() {
        return _project.getModifiedDate();
    }

    /**
    * Sets the modified date of this project.
    *
    * @param modifiedDate the modified date of this project
    */
    @Override
    public void setModifiedDate(java.util.Date modifiedDate) {
        _project.setModifiedDate(modifiedDate);
    }

    /**
    * Returns the name of this project.
    *
    * @return the name of this project
    */
    @Override
    public java.lang.String getName() {
        return _project.getName();
    }

    /**
    * Sets the name of this project.
    *
    * @param name the name of this project
    */
    @Override
    public void setName(java.lang.String name) {
        _project.setName(name);
    }

    /**
    * Returns the description of this project.
    *
    * @return the description of this project
    */
    @Override
    public java.lang.String getDescription() {
        return _project.getDescription();
    }

    /**
    * Sets the description of this project.
    *
    * @param description the description of this project
    */
    @Override
    public void setDescription(java.lang.String description) {
        _project.setDescription(description);
    }

    /**
    * Returns the start date of this project.
    *
    * @return the start date of this project
    */
    @Override
    public java.util.Date getStartDate() {
        return _project.getStartDate();
    }

    /**
    * Sets the start date of this project.
    *
    * @param startDate the start date of this project
    */
    @Override
    public void setStartDate(java.util.Date startDate) {
        _project.setStartDate(startDate);
    }

    /**
    * Returns the end date of this project.
    *
    * @return the end date of this project
    */
    @Override
    public java.util.Date getEndDate() {
        return _project.getEndDate();
    }

    /**
    * Sets the end date of this project.
    *
    * @param endDate the end date of this project
    */
    @Override
    public void setEndDate(java.util.Date endDate) {
        _project.setEndDate(endDate);
    }

    /**
    * Returns the active of this project.
    *
    * @return the active of this project
    */
    @Override
    public boolean getActive() {
        return _project.getActive();
    }

    /**
    * Returns <code>true</code> if this project is active.
    *
    * @return <code>true</code> if this project is active; <code>false</code> otherwise
    */
    @Override
    public boolean isActive() {
        return _project.isActive();
    }

    /**
    * Sets whether this project is active.
    *
    * @param active the active of this project
    */
    @Override
    public void setActive(boolean active) {
        _project.setActive(active);
    }

    @Override
    public boolean isNew() {
        return _project.isNew();
    }

    @Override
    public void setNew(boolean n) {
        _project.setNew(n);
    }

    @Override
    public boolean isCachedModel() {
        return _project.isCachedModel();
    }

    @Override
    public void setCachedModel(boolean cachedModel) {
        _project.setCachedModel(cachedModel);
    }

    @Override
    public boolean isEscapedModel() {
        return _project.isEscapedModel();
    }

    @Override
    public java.io.Serializable getPrimaryKeyObj() {
        return _project.getPrimaryKeyObj();
    }

    @Override
    public void setPrimaryKeyObj(java.io.Serializable primaryKeyObj) {
        _project.setPrimaryKeyObj(primaryKeyObj);
    }

    @Override
    public com.liferay.portlet.expando.model.ExpandoBridge getExpandoBridge() {
        return _project.getExpandoBridge();
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.model.BaseModel<?> baseModel) {
        _project.setExpandoBridgeAttributes(baseModel);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portlet.expando.model.ExpandoBridge expandoBridge) {
        _project.setExpandoBridgeAttributes(expandoBridge);
    }

    @Override
    public void setExpandoBridgeAttributes(
        com.liferay.portal.service.ServiceContext serviceContext) {
        _project.setExpandoBridgeAttributes(serviceContext);
    }

    @Override
    public java.lang.Object clone() {
        return new ProjectWrapper((Project) _project.clone());
    }

    @Override
    public int compareTo(io.github.dinolupo.model.Project project) {
        return _project.compareTo(project);
    }

    @Override
    public int hashCode() {
        return _project.hashCode();
    }

    @Override
    public com.liferay.portal.model.CacheModel<io.github.dinolupo.model.Project> toCacheModel() {
        return _project.toCacheModel();
    }

    @Override
    public io.github.dinolupo.model.Project toEscapedModel() {
        return new ProjectWrapper(_project.toEscapedModel());
    }

    @Override
    public io.github.dinolupo.model.Project toUnescapedModel() {
        return new ProjectWrapper(_project.toUnescapedModel());
    }

    @Override
    public java.lang.String toString() {
        return _project.toString();
    }

    @Override
    public java.lang.String toXmlString() {
        return _project.toXmlString();
    }

    @Override
    public void persist()
        throws com.liferay.portal.kernel.exception.SystemException {
        _project.persist();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof ProjectWrapper)) {
            return false;
        }

        ProjectWrapper projectWrapper = (ProjectWrapper) obj;

        if (Validator.equals(_project, projectWrapper._project)) {
            return true;
        }

        return false;
    }

    @Override
    public StagedModelType getStagedModelType() {
        return _project.getStagedModelType();
    }

    /**
     * @deprecated As of 6.1.0, replaced by {@link #getWrappedModel}
     */
    public Project getWrappedProject() {
        return _project;
    }

    @Override
    public Project getWrappedModel() {
        return _project;
    }

    @Override
    public void resetOriginalValues() {
        _project.resetOriginalValues();
    }
}
