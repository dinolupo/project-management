package io.github.dinolupo.service.impl;

import java.util.Date;
import java.util.List;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.ServiceContext;

import io.github.dinolupo.EntryNameException;
import io.github.dinolupo.EntryValueException;
import io.github.dinolupo.model.Entry;
import io.github.dinolupo.service.base.EntryLocalServiceBaseImpl;

/**
 * The implementation of the entry local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link io.github.dinolupo.service.EntryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see io.github.dinolupo.service.base.EntryLocalServiceBaseImpl
 * @see io.github.dinolupo.service.EntryLocalServiceUtil
 */
public class EntryLocalServiceImpl extends EntryLocalServiceBaseImpl {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link io.github.dinolupo.service.EntryLocalServiceUtil} to access the entry local service.
     */
	

	@Override
	public List<Entry> getEntrys(long projectId, long groupId) throws SystemException {

	    return entryPersistence.findByP_G(projectId, groupId);
	}
	
	@Override
	public List<Entry> getEntrys(long projectId, long groupId, int start, int end)
	     throws SystemException {
	    return entryPersistence.findByP_G(projectId, groupId, start, end);
	}

	
	@Override
	public Entry addEntry(Entry entry) throws SystemException {
	    long entryId = counterLocalService.increment(Entry.class.getName());
	    entry.setEntryId(entryId);

	    return super.addEntry(entry);
	}
	
	protected void validate (String name, String value) throws PortalException {
	    if (Validator.isNull(name)) {
	       throw new EntryNameException();
	    }
	    if (Validator.isNull(value)) {
	    	throw new EntryValueException();
	    }
	}
	
	@Override
	public Entry addEntry(long userId, long projectId,
			String name, 
			String value, 
			ServiceContext serviceContext) throws SystemException, PortalException {
		long groupId = serviceContext.getScopeGroupId();
		User user = userPersistence.findByPrimaryKey(userId);
		Date now = new Date();
		validate(name, value);
		
		long entryId = counterLocalService.increment(Entry.class.getName());
		
		Entry entry = entryPersistence.create(entryId);
		
		// default fields
		entry.setUuid(serviceContext.getUuid());
		entry.setUserId(userId);
		entry.setGroupId(groupId);
		entry.setCompanyId(user.getCompanyId());
		entry.setUserName(user.getFullName());
		entry.setCreateDate(serviceContext.getCreateDate(now));
		entry.setModifiedDate(serviceContext.getModifiedDate(now));
		
		// custom fields
		entry.setProjectId(projectId);
		entry.setName(name);
		entry.setValue(value);
		
		entry.setExpandoBridgeAttributes(serviceContext);
		
		return entry;
		
	}




}
