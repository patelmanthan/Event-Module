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

import SpeakerEvent.model.Speaker_Event;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.service.ServiceContext;
import com.liferay.portal.kernel.util.OrderByComparator;

import org.osgi.util.tracker.ServiceTracker;

import java.util.List;

/**
 * The persistence utility for the speaker_ event service. This utility wraps {@link SpeakerEvent.service.persistence.impl.Speaker_EventPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Speaker_EventPersistence
 * @see SpeakerEvent.service.persistence.impl.Speaker_EventPersistenceImpl
 * @generated
 */
@ProviderType
public class Speaker_EventUtil {
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
	public static void clearCache(Speaker_Event speaker_Event) {
		getPersistence().clearCache(speaker_Event);
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
	public static List<Speaker_Event> findWithDynamicQuery(
		DynamicQuery dynamicQuery) {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Speaker_Event> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end) {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Speaker_Event> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel)
	 */
	public static Speaker_Event update(Speaker_Event speaker_Event) {
		return getPersistence().update(speaker_Event);
	}

	/**
	 * @see com.liferay.portal.kernel.service.persistence.BasePersistence#update(com.liferay.portal.kernel.model.BaseModel, ServiceContext)
	 */
	public static Speaker_Event update(Speaker_Event speaker_Event,
		ServiceContext serviceContext) {
		return getPersistence().update(speaker_Event, serviceContext);
	}

	/**
	* Returns all the speaker_ events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching speaker_ events
	*/
	public static List<Speaker_Event> findByeventId(long eventId) {
		return getPersistence().findByeventId(eventId);
	}

	/**
	* Returns a range of all the speaker_ events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @return the range of matching speaker_ events
	*/
	public static List<Speaker_Event> findByeventId(long eventId, int start,
		int end) {
		return getPersistence().findByeventId(eventId, start, end);
	}

	/**
	* Returns an ordered range of all the speaker_ events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching speaker_ events
	*/
	public static List<Speaker_Event> findByeventId(long eventId, int start,
		int end, OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence()
				   .findByeventId(eventId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the speaker_ events where eventId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param eventId the event ID
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching speaker_ events
	*/
	public static List<Speaker_Event> findByeventId(long eventId, int start,
		int end, OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByeventId(eventId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public static Speaker_Event findByeventId_First(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence().findByeventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the first speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public static Speaker_Event fetchByeventId_First(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence().fetchByeventId_First(eventId, orderByComparator);
	}

	/**
	* Returns the last speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public static Speaker_Event findByeventId_Last(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence().findByeventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the last speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public static Speaker_Event fetchByeventId_Last(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence().fetchByeventId_Last(eventId, orderByComparator);
	}

	/**
	* Returns the speaker_ events before and after the current speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param id the primary key of the current speaker_ event
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next speaker_ event
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public static Speaker_Event[] findByeventId_PrevAndNext(long id,
		long eventId, OrderByComparator<Speaker_Event> orderByComparator)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence()
				   .findByeventId_PrevAndNext(id, eventId, orderByComparator);
	}

	/**
	* Removes all the speaker_ events where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	*/
	public static void removeByeventId(long eventId) {
		getPersistence().removeByeventId(eventId);
	}

	/**
	* Returns the number of speaker_ events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching speaker_ events
	*/
	public static int countByeventId(long eventId) {
		return getPersistence().countByeventId(eventId);
	}

	/**
	* Returns all the speaker_ events where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @return the matching speaker_ events
	*/
	public static List<Speaker_Event> findByspeakerId(long speakerId) {
		return getPersistence().findByspeakerId(speakerId);
	}

	/**
	* Returns a range of all the speaker_ events where speakerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param speakerId the speaker ID
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @return the range of matching speaker_ events
	*/
	public static List<Speaker_Event> findByspeakerId(long speakerId,
		int start, int end) {
		return getPersistence().findByspeakerId(speakerId, start, end);
	}

	/**
	* Returns an ordered range of all the speaker_ events where speakerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param speakerId the speaker ID
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching speaker_ events
	*/
	public static List<Speaker_Event> findByspeakerId(long speakerId,
		int start, int end, OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence()
				   .findByspeakerId(speakerId, start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the speaker_ events where speakerId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param speakerId the speaker ID
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of matching speaker_ events
	*/
	public static List<Speaker_Event> findByspeakerId(long speakerId,
		int start, int end, OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findByspeakerId(speakerId, start, end, orderByComparator,
			retrieveFromCache);
	}

	/**
	* Returns the first speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public static Speaker_Event findByspeakerId_First(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence()
				   .findByspeakerId_First(speakerId, orderByComparator);
	}

	/**
	* Returns the first speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public static Speaker_Event fetchByspeakerId_First(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence()
				   .fetchByspeakerId_First(speakerId, orderByComparator);
	}

	/**
	* Returns the last speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public static Speaker_Event findByspeakerId_Last(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence()
				   .findByspeakerId_Last(speakerId, orderByComparator);
	}

	/**
	* Returns the last speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public static Speaker_Event fetchByspeakerId_Last(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence()
				   .fetchByspeakerId_Last(speakerId, orderByComparator);
	}

	/**
	* Returns the speaker_ events before and after the current speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param id the primary key of the current speaker_ event
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next speaker_ event
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public static Speaker_Event[] findByspeakerId_PrevAndNext(long id,
		long speakerId, OrderByComparator<Speaker_Event> orderByComparator)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence()
				   .findByspeakerId_PrevAndNext(id, speakerId, orderByComparator);
	}

	/**
	* Removes all the speaker_ events where speakerId = &#63; from the database.
	*
	* @param speakerId the speaker ID
	*/
	public static void removeByspeakerId(long speakerId) {
		getPersistence().removeByspeakerId(speakerId);
	}

	/**
	* Returns the number of speaker_ events where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @return the number of matching speaker_ events
	*/
	public static int countByspeakerId(long speakerId) {
		return getPersistence().countByspeakerId(speakerId);
	}

	/**
	* Caches the speaker_ event in the entity cache if it is enabled.
	*
	* @param speaker_Event the speaker_ event
	*/
	public static void cacheResult(Speaker_Event speaker_Event) {
		getPersistence().cacheResult(speaker_Event);
	}

	/**
	* Caches the speaker_ events in the entity cache if it is enabled.
	*
	* @param speaker_Events the speaker_ events
	*/
	public static void cacheResult(List<Speaker_Event> speaker_Events) {
		getPersistence().cacheResult(speaker_Events);
	}

	/**
	* Creates a new speaker_ event with the primary key. Does not add the speaker_ event to the database.
	*
	* @param id the primary key for the new speaker_ event
	* @return the new speaker_ event
	*/
	public static Speaker_Event create(long id) {
		return getPersistence().create(id);
	}

	/**
	* Removes the speaker_ event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event that was removed
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public static Speaker_Event remove(long id)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence().remove(id);
	}

	public static Speaker_Event updateImpl(Speaker_Event speaker_Event) {
		return getPersistence().updateImpl(speaker_Event);
	}

	/**
	* Returns the speaker_ event with the primary key or throws a {@link NoSuchSpeaker_EventException} if it could not be found.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public static Speaker_Event findByPrimaryKey(long id)
		throws SpeakerEvent.exception.NoSuchSpeaker_EventException {
		return getPersistence().findByPrimaryKey(id);
	}

	/**
	* Returns the speaker_ event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event, or <code>null</code> if a speaker_ event with the primary key could not be found
	*/
	public static Speaker_Event fetchByPrimaryKey(long id) {
		return getPersistence().fetchByPrimaryKey(id);
	}

	public static java.util.Map<java.io.Serializable, Speaker_Event> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys) {
		return getPersistence().fetchByPrimaryKeys(primaryKeys);
	}

	/**
	* Returns all the speaker_ events.
	*
	* @return the speaker_ events
	*/
	public static List<Speaker_Event> findAll() {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the speaker_ events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @return the range of speaker_ events
	*/
	public static List<Speaker_Event> findAll(int start, int end) {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the speaker_ events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of speaker_ events
	*/
	public static List<Speaker_Event> findAll(int start, int end,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Returns an ordered range of all the speaker_ events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of speaker_ events
	*/
	public static List<Speaker_Event> findAll(int start, int end,
		OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache) {
		return getPersistence()
				   .findAll(start, end, orderByComparator, retrieveFromCache);
	}

	/**
	* Removes all the speaker_ events from the database.
	*/
	public static void removeAll() {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of speaker_ events.
	*
	* @return the number of speaker_ events
	*/
	public static int countAll() {
		return getPersistence().countAll();
	}

	public static java.util.Set<java.lang.String> getBadColumnNames() {
		return getPersistence().getBadColumnNames();
	}

	public static Speaker_EventPersistence getPersistence() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Speaker_EventPersistence, Speaker_EventPersistence> _serviceTracker =
		ServiceTrackerFactory.open(Speaker_EventPersistence.class);
}