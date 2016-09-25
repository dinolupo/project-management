package io.github.dinolupo.service.persistence;

import com.liferay.portal.kernel.dao.orm.BaseActionableDynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;

import io.github.dinolupo.model.Project;
import io.github.dinolupo.service.ProjectLocalServiceUtil;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public abstract class ProjectActionableDynamicQuery
    extends BaseActionableDynamicQuery {
    public ProjectActionableDynamicQuery() throws SystemException {
        setBaseLocalService(ProjectLocalServiceUtil.getService());
        setClass(Project.class);

        setClassLoader(io.github.dinolupo.service.ClpSerializer.class.getClassLoader());

        setPrimaryKeyPropertyName("projectId");
    }
}
