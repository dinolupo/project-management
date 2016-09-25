package io.github.dinolupo.model.impl;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import io.github.dinolupo.model.Project;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Project in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Project
 * @generated
 */
public class ProjectCacheModel implements CacheModel<Project>, Externalizable {
    public String uuid;
    public long projectId;
    public long groupId;
    public long companyId;
    public long userId;
    public String userName;
    public long createDate;
    public long modifiedDate;
    public String name;
    public String description;
    public long startDate;
    public long endDate;
    public boolean active;

    @Override
    public String toString() {
        StringBundler sb = new StringBundler(27);

        sb.append("{uuid=");
        sb.append(uuid);
        sb.append(", projectId=");
        sb.append(projectId);
        sb.append(", groupId=");
        sb.append(groupId);
        sb.append(", companyId=");
        sb.append(companyId);
        sb.append(", userId=");
        sb.append(userId);
        sb.append(", userName=");
        sb.append(userName);
        sb.append(", createDate=");
        sb.append(createDate);
        sb.append(", modifiedDate=");
        sb.append(modifiedDate);
        sb.append(", name=");
        sb.append(name);
        sb.append(", description=");
        sb.append(description);
        sb.append(", startDate=");
        sb.append(startDate);
        sb.append(", endDate=");
        sb.append(endDate);
        sb.append(", active=");
        sb.append(active);
        sb.append("}");

        return sb.toString();
    }

    @Override
    public Project toEntityModel() {
        ProjectImpl projectImpl = new ProjectImpl();

        if (uuid == null) {
            projectImpl.setUuid(StringPool.BLANK);
        } else {
            projectImpl.setUuid(uuid);
        }

        projectImpl.setProjectId(projectId);
        projectImpl.setGroupId(groupId);
        projectImpl.setCompanyId(companyId);
        projectImpl.setUserId(userId);

        if (userName == null) {
            projectImpl.setUserName(StringPool.BLANK);
        } else {
            projectImpl.setUserName(userName);
        }

        if (createDate == Long.MIN_VALUE) {
            projectImpl.setCreateDate(null);
        } else {
            projectImpl.setCreateDate(new Date(createDate));
        }

        if (modifiedDate == Long.MIN_VALUE) {
            projectImpl.setModifiedDate(null);
        } else {
            projectImpl.setModifiedDate(new Date(modifiedDate));
        }

        if (name == null) {
            projectImpl.setName(StringPool.BLANK);
        } else {
            projectImpl.setName(name);
        }

        if (description == null) {
            projectImpl.setDescription(StringPool.BLANK);
        } else {
            projectImpl.setDescription(description);
        }

        if (startDate == Long.MIN_VALUE) {
            projectImpl.setStartDate(null);
        } else {
            projectImpl.setStartDate(new Date(startDate));
        }

        if (endDate == Long.MIN_VALUE) {
            projectImpl.setEndDate(null);
        } else {
            projectImpl.setEndDate(new Date(endDate));
        }

        projectImpl.setActive(active);

        projectImpl.resetOriginalValues();

        return projectImpl;
    }

    @Override
    public void readExternal(ObjectInput objectInput) throws IOException {
        uuid = objectInput.readUTF();
        projectId = objectInput.readLong();
        groupId = objectInput.readLong();
        companyId = objectInput.readLong();
        userId = objectInput.readLong();
        userName = objectInput.readUTF();
        createDate = objectInput.readLong();
        modifiedDate = objectInput.readLong();
        name = objectInput.readUTF();
        description = objectInput.readUTF();
        startDate = objectInput.readLong();
        endDate = objectInput.readLong();
        active = objectInput.readBoolean();
    }

    @Override
    public void writeExternal(ObjectOutput objectOutput)
        throws IOException {
        if (uuid == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(uuid);
        }

        objectOutput.writeLong(projectId);
        objectOutput.writeLong(groupId);
        objectOutput.writeLong(companyId);
        objectOutput.writeLong(userId);

        if (userName == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(userName);
        }

        objectOutput.writeLong(createDate);
        objectOutput.writeLong(modifiedDate);

        if (name == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(name);
        }

        if (description == null) {
            objectOutput.writeUTF(StringPool.BLANK);
        } else {
            objectOutput.writeUTF(description);
        }

        objectOutput.writeLong(startDate);
        objectOutput.writeLong(endDate);
        objectOutput.writeBoolean(active);
    }
}
