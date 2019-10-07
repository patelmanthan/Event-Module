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

import com.liferay.portal.kernel.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link SpeakerLocalService}.
 *
 * @author Brian Wing Shun Chan
 * @see SpeakerLocalService
 * @generated
 */
@ProviderType
public class SpeakerLocalServiceWrapper implements SpeakerLocalService,
	ServiceWrapper<SpeakerLocalService> {
	public SpeakerLocalServiceWrapper(SpeakerLocalService speakerLocalService) {
		_speakerLocalService = speakerLocalService;
	}

	/**
	* Adds the speaker to the database. Also notifies the appropriate model listeners.
	*
	* @param speaker the speaker
	* @return the speaker that was added
	*/
	@Override
	public SpeakerEvent.model.Speaker addSpeaker(
		SpeakerEvent.model.Speaker speaker) {
		return _speakerLocalService.addSpeaker(speaker);
	}

	@Override
	public SpeakerEvent.model.Speaker addSpeaker(long eventId, long userId,
		java.lang.String firstName, java.lang.String lastName,
		java.lang.String email) {
		return _speakerLocalService.addSpeaker(eventId, userId, firstName,
			lastName, email);
	}

	/**
	* Creates a new speaker with the primary key. Does not add the speaker to the database.
	*
	* @param speakerId the primary key for the new speaker
	* @return the new speaker
	*/
	@Override
	public SpeakerEvent.model.Speaker createSpeaker(long speakerId) {
		return _speakerLocalService.createSpeaker(speakerId);
	}

	/**
	* Deletes the speaker from the database. Also notifies the appropriate model listeners.
	*
	* @param speaker the speaker
	* @return the speaker that was removed
	*/
	@Override
	public SpeakerEvent.model.Speaker deleteSpeaker(
		SpeakerEvent.model.Speaker speaker) {
		return _speakerLocalService.deleteSpeaker(speaker);
	}

	/**
	* Deletes the speaker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker that was removed
	* @throws PortalException if a speaker with the primary key could not be found
	*/
	@Override
	public SpeakerEvent.model.Speaker deleteSpeaker(long speakerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _speakerLocalService.deleteSpeaker(speakerId);
	}

	@Override
	public SpeakerEvent.model.Speaker fetchSpeaker(long speakerId) {
		return _speakerLocalService.fetchSpeaker(speakerId);
	}

	@Override
	public SpeakerEvent.model.Speaker findBySpeakerId(long speakerId) {
		return _speakerLocalService.findBySpeakerId(speakerId);
	}

	/**
	* Returns the speaker with the primary key.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker
	* @throws PortalException if a speaker with the primary key could not be found
	*/
	@Override
	public SpeakerEvent.model.Speaker getSpeaker(long speakerId)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _speakerLocalService.getSpeaker(speakerId);
	}

	/**
	* Updates the speaker in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param speaker the speaker
	* @return the speaker that was updated
	*/
	@Override
	public SpeakerEvent.model.Speaker updateSpeaker(
		SpeakerEvent.model.Speaker speaker) {
		return _speakerLocalService.updateSpeaker(speaker);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.ActionableDynamicQuery getActionableDynamicQuery() {
		return _speakerLocalService.getActionableDynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _speakerLocalService.dynamicQuery();
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.IndexableActionableDynamicQuery getIndexableActionableDynamicQuery() {
		return _speakerLocalService.getIndexableActionableDynamicQuery();
	}

	/**
	* @throws PortalException
	*/
	@Override
	public com.liferay.portal.kernel.model.PersistedModel deletePersistedModel(
		com.liferay.portal.kernel.model.PersistedModel persistedModel)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _speakerLocalService.deletePersistedModel(persistedModel);
	}

	@Override
	public com.liferay.portal.kernel.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException {
		return _speakerLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns the number of speakers.
	*
	* @return the number of speakers
	*/
	@Override
	public int getSpeakersCount() {
		return _speakerLocalService.getSpeakersCount();
	}

	/**
	* Returns the OSGi service identifier.
	*
	* @return the OSGi service identifier
	*/
	@Override
	public java.lang.String getOSGiServiceIdentifier() {
		return _speakerLocalService.getOSGiServiceIdentifier();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _speakerLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerEvent.model.impl.SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) {
		return _speakerLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerEvent.model.impl.SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	*/
	@Override
	public <T> java.util.List<T> dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator<T> orderByComparator) {
		return _speakerLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	* Returns a range of all the speakers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerEvent.model.impl.SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speakers
	* @param end the upper bound of the range of speakers (not inclusive)
	* @return the range of speakers
	*/
	@Override
	public java.util.List<SpeakerEvent.model.Speaker> getSpeakers(int start,
		int end) {
		return _speakerLocalService.getSpeakers(start, end);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery) {
		return _speakerLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows matching the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows matching the dynamic query
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection) {
		return _speakerLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public SpeakerLocalService getWrappedService() {
		return _speakerLocalService;
	}

	@Override
	public void setWrappedService(SpeakerLocalService speakerLocalService) {
		_speakerLocalService = speakerLocalService;
	}

	private SpeakerLocalService _speakerLocalService;
}