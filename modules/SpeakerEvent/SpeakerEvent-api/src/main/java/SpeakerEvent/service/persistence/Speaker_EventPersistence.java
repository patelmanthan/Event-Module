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

import SpeakerEvent.exception.NoSuchSpeaker_EventException;

import SpeakerEvent.model.Speaker_Event;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the speaker_ event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpeakerEvent.service.persistence.impl.Speaker_EventPersistenceImpl
 * @see Speaker_EventUtil
 * @generated
 */
@ProviderType
public interface Speaker_EventPersistence extends BasePersistence<Speaker_Event> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link Speaker_EventUtil} to access the speaker_ event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the speaker_ events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the matching speaker_ events
	*/
	public java.util.List<Speaker_Event> findByeventId(long eventId);

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
	public java.util.List<Speaker_Event> findByeventId(long eventId, int start,
		int end);

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
	public java.util.List<Speaker_Event> findByeventId(long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator);

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
	public java.util.List<Speaker_Event> findByeventId(long eventId, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public Speaker_Event findByeventId_First(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException;

	/**
	* Returns the first speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public Speaker_Event fetchByeventId_First(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator);

	/**
	* Returns the last speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public Speaker_Event findByeventId_Last(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException;

	/**
	* Returns the last speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public Speaker_Event fetchByeventId_Last(long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator);

	/**
	* Returns the speaker_ events before and after the current speaker_ event in the ordered set where eventId = &#63;.
	*
	* @param id the primary key of the current speaker_ event
	* @param eventId the event ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next speaker_ event
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public Speaker_Event[] findByeventId_PrevAndNext(long id, long eventId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException;

	/**
	* Removes all the speaker_ events where eventId = &#63; from the database.
	*
	* @param eventId the event ID
	*/
	public void removeByeventId(long eventId);

	/**
	* Returns the number of speaker_ events where eventId = &#63;.
	*
	* @param eventId the event ID
	* @return the number of matching speaker_ events
	*/
	public int countByeventId(long eventId);

	/**
	* Returns all the speaker_ events where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @return the matching speaker_ events
	*/
	public java.util.List<Speaker_Event> findByspeakerId(long speakerId);

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
	public java.util.List<Speaker_Event> findByspeakerId(long speakerId,
		int start, int end);

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
	public java.util.List<Speaker_Event> findByspeakerId(long speakerId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator);

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
	public java.util.List<Speaker_Event> findByspeakerId(long speakerId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Returns the first speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public Speaker_Event findByspeakerId_First(long speakerId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException;

	/**
	* Returns the first speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public Speaker_Event fetchByspeakerId_First(long speakerId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator);

	/**
	* Returns the last speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event
	* @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	*/
	public Speaker_Event findByspeakerId_Last(long speakerId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException;

	/**
	* Returns the last speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	*/
	public Speaker_Event fetchByspeakerId_Last(long speakerId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator);

	/**
	* Returns the speaker_ events before and after the current speaker_ event in the ordered set where speakerId = &#63;.
	*
	* @param id the primary key of the current speaker_ event
	* @param speakerId the speaker ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next speaker_ event
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public Speaker_Event[] findByspeakerId_PrevAndNext(long id, long speakerId,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException;

	/**
	* Removes all the speaker_ events where speakerId = &#63; from the database.
	*
	* @param speakerId the speaker ID
	*/
	public void removeByspeakerId(long speakerId);

	/**
	* Returns the number of speaker_ events where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @return the number of matching speaker_ events
	*/
	public int countByspeakerId(long speakerId);

	/**
	* Caches the speaker_ event in the entity cache if it is enabled.
	*
	* @param speaker_Event the speaker_ event
	*/
	public void cacheResult(Speaker_Event speaker_Event);

	/**
	* Caches the speaker_ events in the entity cache if it is enabled.
	*
	* @param speaker_Events the speaker_ events
	*/
	public void cacheResult(java.util.List<Speaker_Event> speaker_Events);

	/**
	* Creates a new speaker_ event with the primary key. Does not add the speaker_ event to the database.
	*
	* @param id the primary key for the new speaker_ event
	* @return the new speaker_ event
	*/
	public Speaker_Event create(long id);

	/**
	* Removes the speaker_ event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event that was removed
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public Speaker_Event remove(long id) throws NoSuchSpeaker_EventException;

	public Speaker_Event updateImpl(Speaker_Event speaker_Event);

	/**
	* Returns the speaker_ event with the primary key or throws a {@link NoSuchSpeaker_EventException} if it could not be found.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event
	* @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	*/
	public Speaker_Event findByPrimaryKey(long id)
		throws NoSuchSpeaker_EventException;

	/**
	* Returns the speaker_ event with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event, or <code>null</code> if a speaker_ event with the primary key could not be found
	*/
	public Speaker_Event fetchByPrimaryKey(long id);

	@Override
	public java.util.Map<java.io.Serializable, Speaker_Event> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the speaker_ events.
	*
	* @return the speaker_ events
	*/
	public java.util.List<Speaker_Event> findAll();

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
	public java.util.List<Speaker_Event> findAll(int start, int end);

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
	public java.util.List<Speaker_Event> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator);

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
	public java.util.List<Speaker_Event> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the speaker_ events from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of speaker_ events.
	*
	* @return the number of speaker_ events
	*/
	public int countAll();

	@Override
	public java.util.Set<java.lang.String> getBadColumnNames();
}