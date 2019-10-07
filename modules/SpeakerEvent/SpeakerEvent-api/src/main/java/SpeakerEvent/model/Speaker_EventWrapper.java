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

package SpeakerEvent.model;

import aQute.bnd.annotation.ProviderType;

import com.liferay.expando.kernel.model.ExpandoBridge;

import com.liferay.portal.kernel.model.ModelWrapper;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * <p>
 * This class is a wrapper for {@link Speaker_Event}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Speaker_Event
 * @generated
 */
@ProviderType
public class Speaker_EventWrapper implements Speaker_Event,
	ModelWrapper<Speaker_Event> {
	public Speaker_EventWrapper(Speaker_Event speaker_Event) {
		_speaker_Event = speaker_Event;
	}

	@Override
	public Class<?> getModelClass() {
		return Speaker_Event.class;
	}

	@Override
	public String getModelClassName() {
		return Speaker_Event.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("id", getId());
		attributes.put("speakerId", getSpeakerId());
		attributes.put("eventId", getEventId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long id = (Long)attributes.get("id");

		if (id != null) {
			setId(id);
		}

		Long speakerId = (Long)attributes.get("speakerId");

		if (speakerId != null) {
			setSpeakerId(speakerId);
		}

		Long eventId = (Long)attributes.get("eventId");

		if (eventId != null) {
			setEventId(eventId);
		}
	}

	@Override
	public SpeakerEvent.model.Speaker_Event toEscapedModel() {
		return new Speaker_EventWrapper(_speaker_Event.toEscapedModel());
	}

	@Override
	public SpeakerEvent.model.Speaker_Event toUnescapedModel() {
		return new Speaker_EventWrapper(_speaker_Event.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _speaker_Event.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _speaker_Event.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _speaker_Event.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _speaker_Event.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SpeakerEvent.model.Speaker_Event> toCacheModel() {
		return _speaker_Event.toCacheModel();
	}

	@Override
	public int compareTo(SpeakerEvent.model.Speaker_Event speaker_Event) {
		return _speaker_Event.compareTo(speaker_Event);
	}

	@Override
	public int hashCode() {
		return _speaker_Event.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _speaker_Event.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new Speaker_EventWrapper((Speaker_Event)_speaker_Event.clone());
	}

	@Override
	public java.lang.String toString() {
		return _speaker_Event.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _speaker_Event.toXmlString();
	}

	/**
	* Returns the event ID of this speaker_ event.
	*
	* @return the event ID of this speaker_ event
	*/
	@Override
	public long getEventId() {
		return _speaker_Event.getEventId();
	}

	/**
	* Returns the ID of this speaker_ event.
	*
	* @return the ID of this speaker_ event
	*/
	@Override
	public long getId() {
		return _speaker_Event.getId();
	}

	/**
	* Returns the primary key of this speaker_ event.
	*
	* @return the primary key of this speaker_ event
	*/
	@Override
	public long getPrimaryKey() {
		return _speaker_Event.getPrimaryKey();
	}

	/**
	* Returns the speaker ID of this speaker_ event.
	*
	* @return the speaker ID of this speaker_ event
	*/
	@Override
	public long getSpeakerId() {
		return _speaker_Event.getSpeakerId();
	}

	@Override
	public void persist() {
		_speaker_Event.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_speaker_Event.setCachedModel(cachedModel);
	}

	/**
	* Sets the event ID of this speaker_ event.
	*
	* @param eventId the event ID of this speaker_ event
	*/
	@Override
	public void setEventId(long eventId) {
		_speaker_Event.setEventId(eventId);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_speaker_Event.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_speaker_Event.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_speaker_Event.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the ID of this speaker_ event.
	*
	* @param id the ID of this speaker_ event
	*/
	@Override
	public void setId(long id) {
		_speaker_Event.setId(id);
	}

	@Override
	public void setNew(boolean n) {
		_speaker_Event.setNew(n);
	}

	/**
	* Sets the primary key of this speaker_ event.
	*
	* @param primaryKey the primary key of this speaker_ event
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_speaker_Event.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_speaker_Event.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the speaker ID of this speaker_ event.
	*
	* @param speakerId the speaker ID of this speaker_ event
	*/
	@Override
	public void setSpeakerId(long speakerId) {
		_speaker_Event.setSpeakerId(speakerId);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Speaker_EventWrapper)) {
			return false;
		}

		Speaker_EventWrapper speaker_EventWrapper = (Speaker_EventWrapper)obj;

		if (Objects.equals(_speaker_Event, speaker_EventWrapper._speaker_Event)) {
			return true;
		}

		return false;
	}

	@Override
	public Speaker_Event getWrappedModel() {
		return _speaker_Event;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _speaker_Event.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _speaker_Event.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_speaker_Event.resetOriginalValues();
	}

	private final Speaker_Event _speaker_Event;
}