package io.github.dinolupo.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import io.github.dinolupo.model.Entry;

/**
 * The persistence interface for the entry service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see EntryPersistenceImpl
 * @see EntryUtil
 * @generated
 */
public interface EntryPersistence extends BasePersistence<Entry> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link EntryUtil} to access the entry persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Returns all the entries where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByUuid(
        java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entries where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @return the range of matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByUuid(
        java.lang.String uuid, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entries where uuid = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByUuid(
        java.lang.String uuid, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first entry in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entry
    * @throws io.github.dinolupo.NoSuchEntryException if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the first entry in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByUuid_First(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last entry in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entry
    * @throws io.github.dinolupo.NoSuchEntryException if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the last entry in the ordered set where uuid = &#63;.
    *
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByUuid_Last(
        java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entries before and after the current entry in the ordered set where uuid = &#63;.
    *
    * @param entryId the primary key of the current entry
    * @param uuid the uuid
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next entry
    * @throws io.github.dinolupo.NoSuchEntryException if a entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry[] findByUuid_PrevAndNext(
        long entryId, java.lang.String uuid,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Removes all the entries where uuid = &#63; from the database.
    *
    * @param uuid the uuid
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entries where uuid = &#63;.
    *
    * @param uuid the uuid
    * @return the number of matching entries
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid(java.lang.String uuid)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entry where uuid = &#63; and groupId = &#63; or throws a {@link io.github.dinolupo.NoSuchEntryException} if it could not be found.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching entry
    * @throws io.github.dinolupo.NoSuchEntryException if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByUUID_G(java.lang.String uuid,
        long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entry where uuid = &#63; and groupId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @param retrieveFromCache whether to use the finder cache
    * @return the matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByUUID_G(java.lang.String uuid,
        long groupId, boolean retrieveFromCache)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes the entry where uuid = &#63; and groupId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the entry that was removed
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry removeByUUID_G(
        java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the number of entries where uuid = &#63; and groupId = &#63;.
    *
    * @param uuid the uuid
    * @param groupId the group ID
    * @return the number of matching entries
    * @throws SystemException if a system exception occurred
    */
    public int countByUUID_G(java.lang.String uuid, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the entries where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByUuid_C(
        java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entries where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @return the range of matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entries where uuid = &#63; and companyId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByUuid_C(
        java.lang.String uuid, long companyId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first entry in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entry
    * @throws io.github.dinolupo.NoSuchEntryException if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the first entry in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByUuid_C_First(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last entry in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entry
    * @throws io.github.dinolupo.NoSuchEntryException if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the last entry in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByUuid_C_Last(
        java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entries before and after the current entry in the ordered set where uuid = &#63; and companyId = &#63;.
    *
    * @param entryId the primary key of the current entry
    * @param uuid the uuid
    * @param companyId the company ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next entry
    * @throws io.github.dinolupo.NoSuchEntryException if a entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry[] findByUuid_C_PrevAndNext(
        long entryId, java.lang.String uuid, long companyId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Removes all the entries where uuid = &#63; and companyId = &#63; from the database.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entries where uuid = &#63; and companyId = &#63;.
    *
    * @param uuid the uuid
    * @param companyId the company ID
    * @return the number of matching entries
    * @throws SystemException if a system exception occurred
    */
    public int countByUuid_C(java.lang.String uuid, long companyId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the entries where projectId = &#63; and groupId = &#63;.
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @return the matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByP_G(
        long projectId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entries where projectId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @return the range of matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByP_G(
        long projectId, long groupId, int start, int end)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entries where projectId = &#63; and groupId = &#63;.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of matching entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findByP_G(
        long projectId, long groupId, int start, int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the first entry in the ordered set where projectId = &#63; and groupId = &#63;.
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entry
    * @throws io.github.dinolupo.NoSuchEntryException if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByP_G_First(long projectId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the first entry in the ordered set where projectId = &#63; and groupId = &#63;.
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the first matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByP_G_First(long projectId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the last entry in the ordered set where projectId = &#63; and groupId = &#63;.
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entry
    * @throws io.github.dinolupo.NoSuchEntryException if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByP_G_Last(long projectId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the last entry in the ordered set where projectId = &#63; and groupId = &#63;.
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the last matching entry, or <code>null</code> if a matching entry could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByP_G_Last(long projectId,
        long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entries before and after the current entry in the ordered set where projectId = &#63; and groupId = &#63;.
    *
    * @param entryId the primary key of the current entry
    * @param projectId the project ID
    * @param groupId the group ID
    * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
    * @return the previous, current, and next entry
    * @throws io.github.dinolupo.NoSuchEntryException if a entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry[] findByP_G_PrevAndNext(
        long entryId, long projectId, long groupId,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Removes all the entries where projectId = &#63; and groupId = &#63; from the database.
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @throws SystemException if a system exception occurred
    */
    public void removeByP_G(long projectId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entries where projectId = &#63; and groupId = &#63;.
    *
    * @param projectId the project ID
    * @param groupId the group ID
    * @return the number of matching entries
    * @throws SystemException if a system exception occurred
    */
    public int countByP_G(long projectId, long groupId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Caches the entry in the entity cache if it is enabled.
    *
    * @param entry the entry
    */
    public void cacheResult(io.github.dinolupo.model.Entry entry);

    /**
    * Caches the entries in the entity cache if it is enabled.
    *
    * @param entries the entries
    */
    public void cacheResult(
        java.util.List<io.github.dinolupo.model.Entry> entries);

    /**
    * Creates a new entry with the primary key. Does not add the entry to the database.
    *
    * @param entryId the primary key for the new entry
    * @return the new entry
    */
    public io.github.dinolupo.model.Entry create(long entryId);

    /**
    * Removes the entry with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param entryId the primary key of the entry
    * @return the entry that was removed
    * @throws io.github.dinolupo.NoSuchEntryException if a entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry remove(long entryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    public io.github.dinolupo.model.Entry updateImpl(
        io.github.dinolupo.model.Entry entry)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the entry with the primary key or throws a {@link io.github.dinolupo.NoSuchEntryException} if it could not be found.
    *
    * @param entryId the primary key of the entry
    * @return the entry
    * @throws io.github.dinolupo.NoSuchEntryException if a entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry findByPrimaryKey(long entryId)
        throws com.liferay.portal.kernel.exception.SystemException,
            io.github.dinolupo.NoSuchEntryException;

    /**
    * Returns the entry with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param entryId the primary key of the entry
    * @return the entry, or <code>null</code> if a entry with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public io.github.dinolupo.model.Entry fetchByPrimaryKey(long entryId)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the entries.
    *
    * @return the entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @return the range of entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the entries.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link io.github.dinolupo.model.impl.EntryModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of entries
    * @param end the upper bound of the range of entries (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of entries
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<io.github.dinolupo.model.Entry> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the entries from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of entries.
    *
    * @return the number of entries
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}
