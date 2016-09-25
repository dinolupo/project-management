package io.github.dinolupo.model;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services, specifically {@link io.github.dinolupo.service.http.EntryServiceSoap}.
 *
 * @author Brian Wing Shun Chan
 * @see io.github.dinolupo.service.http.EntryServiceSoap
 * @generated
 */
public class EntrySoap implements Serializable {
    private String _uuid;
    private long _entryId;
    private long _groupId;
    private long _companyId;
    private long _userId;
    private String _userName;
    private Date _createDate;
    private Date _modifiedDate;
    private String _name;
    private String _value;
    private long _projectId;

    public EntrySoap() {
    }

    public static EntrySoap toSoapModel(Entry model) {
        EntrySoap soapModel = new EntrySoap();

        soapModel.setUuid(model.getUuid());
        soapModel.setEntryId(model.getEntryId());
        soapModel.setGroupId(model.getGroupId());
        soapModel.setCompanyId(model.getCompanyId());
        soapModel.setUserId(model.getUserId());
        soapModel.setUserName(model.getUserName());
        soapModel.setCreateDate(model.getCreateDate());
        soapModel.setModifiedDate(model.getModifiedDate());
        soapModel.setName(model.getName());
        soapModel.setValue(model.getValue());
        soapModel.setProjectId(model.getProjectId());

        return soapModel;
    }

    public static EntrySoap[] toSoapModels(Entry[] models) {
        EntrySoap[] soapModels = new EntrySoap[models.length];

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModel(models[i]);
        }

        return soapModels;
    }

    public static EntrySoap[][] toSoapModels(Entry[][] models) {
        EntrySoap[][] soapModels = null;

        if (models.length > 0) {
            soapModels = new EntrySoap[models.length][models[0].length];
        } else {
            soapModels = new EntrySoap[0][0];
        }

        for (int i = 0; i < models.length; i++) {
            soapModels[i] = toSoapModels(models[i]);
        }

        return soapModels;
    }

    public static EntrySoap[] toSoapModels(List<Entry> models) {
        List<EntrySoap> soapModels = new ArrayList<EntrySoap>(models.size());

        for (Entry model : models) {
            soapModels.add(toSoapModel(model));
        }

        return soapModels.toArray(new EntrySoap[soapModels.size()]);
    }

    public long getPrimaryKey() {
        return _entryId;
    }

    public void setPrimaryKey(long pk) {
        setEntryId(pk);
    }

    public String getUuid() {
        return _uuid;
    }

    public void setUuid(String uuid) {
        _uuid = uuid;
    }

    public long getEntryId() {
        return _entryId;
    }

    public void setEntryId(long entryId) {
        _entryId = entryId;
    }

    public long getGroupId() {
        return _groupId;
    }

    public void setGroupId(long groupId) {
        _groupId = groupId;
    }

    public long getCompanyId() {
        return _companyId;
    }

    public void setCompanyId(long companyId) {
        _companyId = companyId;
    }

    public long getUserId() {
        return _userId;
    }

    public void setUserId(long userId) {
        _userId = userId;
    }

    public String getUserName() {
        return _userName;
    }

    public void setUserName(String userName) {
        _userName = userName;
    }

    public Date getCreateDate() {
        return _createDate;
    }

    public void setCreateDate(Date createDate) {
        _createDate = createDate;
    }

    public Date getModifiedDate() {
        return _modifiedDate;
    }

    public void setModifiedDate(Date modifiedDate) {
        _modifiedDate = modifiedDate;
    }

    public String getName() {
        return _name;
    }

    public void setName(String name) {
        _name = name;
    }

    public String getValue() {
        return _value;
    }

    public void setValue(String value) {
        _value = value;
    }

    public long getProjectId() {
        return _projectId;
    }

    public void setProjectId(long projectId) {
        _projectId = projectId;
    }
}
