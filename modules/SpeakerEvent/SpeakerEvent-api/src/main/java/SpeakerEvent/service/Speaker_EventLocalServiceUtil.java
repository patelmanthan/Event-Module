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

package SpeakerEvent.service;

import aQute.bnd.annotation.ProviderType;

import com.liferay.osgi.util.ServiceTrackerFactory;

import org.osgi.util.tracker.ServiceTracker;

/**
 * Provides the local service utility for Speaker_Event. This utility wraps
 * {@link SpeakerEvent.service.impl.Speaker_EventLocalServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on the local server. Methods of this service will not have security checks
 * based on the propagated JAAS credentials because this service can only be
 * accessed from within the same VM.
 *
 * @author Brian Wing Shun Chan
 * @see Speaker_EventLocalService
 * @see SpeakerEvent.service.base.Speaker_EventLocalServiceBaseImpl
 * @see SpeakerEvent.service.impl.Speaker_EventLocalServiceImpl
 * @generated
 */
@ProviderType
public class Speaker_EventLocalServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link SpeakerEvent.service.impl.Speaker_EventLocalServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */
	public static SpeakerEvent.model.Speaker_Event addSpeakerEvent(
		long eventId, long speakerId) {
		return getService().addSpeakerEvent(eventId, speakerId);
	}

	/**
	* Adds the speaker_ event to the database. Also notifies the appropriate model listeners.
	*
	* @param speaker_Event the speaker_ event
	* @return the speaker_ event that was added
	*/
	public static SpeakerEvent.model.Speaker_Event addSpeaker_Event(
		SpeakerEvent.model.Speaker_Event speaker_Event) {
		return getService().addSpeaker_Event(speaker_Event);
	}

	/**
	* Creates a new speaker_ event with the primary key. Does not add the speaker_ event to the database.
	*
	* @param id the primary key for the new speaker_ event
	* @return the new speaker_ event
	*/
	public static SpeakerEvent.model.Speaker_Event createSpeaker_Event(long id) {
		return getService().createSpeaker_Event(id);
	}

	/**
	* Deletes the speaker_ event from the database. Also notifies the appropriate model listeners.
	*
	* @param speaker_Event the speaker_ event
	* @return the speaker_ event that was removed
	*/
	public static SpeakerEvent.model.Speaker_Event deleteSpeaker_Event(
		SpeakerEvent.model.Speaker_Event speaker_Event) {
		return getService().deleteSpeaker_Event(speaker_Event);
	}

	/**
	* Deletes the speaker_ event with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event that was removed
	* @throws PortalException if a speaker_ event with the primary key could not be found
	*/
	public static SpeakerEvent.model.Speaker_Event deleteSpeaker_Event(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deleteSpeaker_Event(id);
	}

	public static SpeakerEvent.model.Speaker_Event fetchSpeaker_Event(long id) {
		return getService().fetchSpeaker_Event(id);
	}

	/**
	* Returns the speaker_ event with the primary key.
	*
	* @param id the primary key of the speaker_ event
	* @return the speaker_ event
	* @throws PortalException if a speaker_ event with the primary key could not be found
	*/
	public static SpeakerEvent.model.Speaker_Event getSpeaker_Event(long id)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getSpeaker_Event(id);
	}

	/**
	* Updates the speaker_ event in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param speaker_Event the speaker_ event
	* @return the speaker_ event that was updated
	*/
	public static SpeakerEvent.model.Speaker_Event updateSpeaker_Event(
		SpeakerEvent.model.Speaker_Event speaker_Event) {
		return getService().updateSpeaker_Event(speaker_Event);
	}

	public static com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return getService().getActionableDynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return getService().dynamicQuery();
	}

	public static com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return getService().getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	public static com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().deletePersistedModel(persistedModel);
	}

	public static com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return getService().getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of speaker_ events.
	*
	* @return the number of speaker_ events
	*/
	public static int getSpeaker_EventsCount() {
		return getService().getSpeaker_EventsCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	public static java.lang.String getOSGiServiceIdentifier() {
		return getService().getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerEvent.model.impl.Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return getService().dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerEvent.model.impl.Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	public static <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return getService()
				   .dynamicQuery(dynamicQuery, start, end, orderByComparator);
	}

	public static java.util.List<SpeakerEvent.model.Speaker_Event> findByEventId(
		long eventId) {
		return getService().findByEventId(eventId);
	}

	public static java.util.List<SpeakerEvent.model.Speaker_Event> findBySpeakerId(
		long speakerId) {
		return getService().findBySpeakerId(speakerId);
	}

	/**
	* Returns a range of all the speaker_ events.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerEvent.model.impl.Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speaker_ events
	* @param end the upper bound of the range of speaker_ events (not inclusive)
	* @return the range of speaker_ events
	*/
	public static java.util.List<SpeakerEvent.model.Speaker_Event> getSpeaker_Events(
		int start, int end) {
		return getService().getSpeaker_Events(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return getService().dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	public static long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return getService().dynamicQueryCount(dynamicQuery, projection);
	}

	public static Speaker_EventLocalService getService() {
		return _serviceTracker.getService();
	}

	private static ServiceTracker<Speaker_EventLocalService, Speaker_EventLocalService> _serviceTracker =
		ServiceTrackerFactory.open(Speaker_EventLocalService.class);
}