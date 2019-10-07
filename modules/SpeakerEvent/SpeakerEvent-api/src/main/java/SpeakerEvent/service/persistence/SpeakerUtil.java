/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package SpeakerEvent.service.persistence;

import SpeakerEvent.model.Speaker;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the speaker service. This utility wraps {@link SpeakerEvent.service.persistence.impl.SpeakerPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpeakerPersistence
 * @see SpeakerEvent.service.persistence.impl.SpeakerPersistenceImpl
 * @generated
 */
@ProviderType
public class SpeakerUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#clearCache(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static void clearCache(Speaker speaker) {
		getPersistence().clearCache(speaker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<Speaker> findWithDynamicQuery(DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Speaker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Speaker> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Speaker> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Speaker update(Speaker speaker) {
		return getPersistence().update(speaker);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Speaker update(Speaker speaker, ServiceContext serviceContext) {
		return getPersistence().update(speaker, serviceContext);
	}

	/**
	* Returns the speaker where speakerId = &#63; or throws a {@link NoSuchSpeakerException} if it could not be found.
	*
	* @param speakerId the speaker ID
	* @return the matching speaker
	* @throws NoSuchSpeakerException if a matching speaker could not be found
	*/
	public static Speaker findByspeakerId(long speakerId)
		throws SpeakerEvent.exception.NoSuchSpeakerException {
		return getPersistence().findByspeakerId(speakerId);
	}

	/**
	* Returns the speaker where speakerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param speakerId the speaker ID
	* @return the matching speaker, or <code>null</code> if a matching speaker could not be found
	*/
	public static Speaker fetchByspeakerId(long speakerId) {
		return getPersistence().fetchByspeakerId(speakerId);
	}

	/**
	* Returns the speaker where speakerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param speakerId the speaker ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching speaker, or <code>null</code> if a matching speaker could not be found
	*/
	public static Speaker fetchByspeakerId(long speakerId,
		boolean retrieveFromCache) {
		return getPersistence().fetchByspeakerId(speakerId, retrieveFromCache);
	}

	/**
	* Removes the speaker where speakerId = &#63; from the database.
	*
	* @param speakerId the speaker ID
	* @return the speaker that was removed
	*/
	public static Speaker removeByspeakerId(long speakerId)
		throws SpeakerEvent.exception.NoSuchSpeakerException {
		return getPersistence().removeByspeakerId(speakerId);
	}

	/**
	* Returns the number of speakers where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @return the number of matching speakers
	*/
	public static int countByspeakerId(long speakerId) {
		return getPersistence().countByspeakerId(speakerId);
	}

	/**
	* Caches the speaker in the entity cache if it is enabled.
	*
	* @param speaker the speaker
	*/
	public static void cacheResult(Speaker speaker) {
		getPersistence().cacheResult(speaker);
	}

	/**
	* Caches the speakers in the entity cache if it is enabled.
	*
	* @param speakers the speakers
	*/
	public static void cacheResult(List<Speaker> speakers) {
		getPersistence().cacheResult(speakers);
	}

	/**
	* Creates a new speaker with the primary key. Does not add the speaker to the database.
	*
	* @param speakerId the primary key for the new speaker
	* @return the new speaker
	*/
	public static Speaker create(long speakerId) {
		return getPersistence().create(speakerId);
	}

	/**
	* Removes the speaker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker that was removed
	* @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	*/
	public static Speaker remove(long speakerId)
		throws SpeakerEvent.exception.NoSuchSpeakerException {
		return getPersistence().remove(speakerId);
	}

	public static Speaker updateImpl(Speaker speaker) {
		return getPersistence().updateImpl(speaker);
	}

	/**
	* Returns the speaker with the primary key or throws a {@link NoSuchSpeakerException} if it could not be found.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker
	* @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	*/
	public static Speaker findByPrimaryKey(long speakerId)
		throws SpeakerEvent.exception.NoSuchSpeakerException {
		return getPersistence().findByPrimaryKey(speakerId);
	}

	/**
	* Returns the speaker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker, or <code>null</code> if a speaker with the primary key could not be found
	*/
	public static Speaker fetchByPrimaryKey(long speakerId) {
		return getPersistence().fetchByPrimaryKey(speakerId);
	}

	public static java.util.Map<java.io.Serializable, Speaker> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the speakers.
	*
	* @return the speakers
	*/
	public static List<Speaker> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the speakers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speakers
	* @param end the upper bound of the range of speakers (not inclusive)
	* @return the range of speakers
	*/
	public static List<Speaker> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the speakers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speakers
	* @param end the upper bound of the range of speakers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of speakers
	*/
	public static List<Speaker> findAll(int start, int end,
		OrderByComparator<Speaker> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the speakers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speakers
	* @param end the upper bound of the range of speakers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of speakers
	*/
	public static List<Speaker> findAll(int start, int end,
		OrderByComparator<Speaker> orderByComparator, boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the speakers from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of speakers.
	*
	* @return the number of speakers
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static SpeakerPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<SpeakerPersistence, SpeakerPersistence> _serviceTracker =
		ServiceTrackerFactory.open(SpeakerPersistence.class);
}