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
 * This class is a wrapper for {@link Speaker}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Speaker
 * @generated
 */
@ProviderType
public class SpeakerWrapper implements Speaker, ModelWrapper<Speaker> {
	public SpeakerWrapper(Speaker speaker) {
		_speaker = speaker;
	}

	@Override
	public Class<?> getModelClass() {
		return Speaker.class;
	}

	@Override
	public String getModelClassName() {
		return Speaker.class.getName();
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("speakerId", getSpeakerId());
		attributes.put("userId", getUserId());
		attributes.put("firstName", getFirstName());
		attributes.put("lastName", getLastName());
		attributes.put("email", getEmail());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long speakerId = (Long)attributes.get("speakerId");

		if (speakerId != null) {
			setSpeakerId(speakerId);
		}

		Long userId = (Long)attributes.get("userId");

		if (userId != null) {
			setUserId(userId);
		}

		String firstName = (String)attributes.get("firstName");

		if (firstName != null) {
			setFirstName(firstName);
		}

		String lastName = (String)attributes.get("lastName");

		if (lastName != null) {
			setLastName(lastName);
		}

		String email = (String)attributes.get("email");

		if (email != null) {
			setEmail(email);
		}
	}

	@Override
	public SpeakerEvent.model.Speaker toEscapedModel() {
		return new SpeakerWrapper(_speaker.toEscapedModel());
	}

	@Override
	public SpeakerEvent.model.Speaker toUnescapedModel() {
		return new SpeakerWrapper(_speaker.toUnescapedModel());
	}

	@Override
	public boolean isCachedModel() {
		return _speaker.isCachedModel();
	}

	@Override
	public boolean isEscapedModel() {
		return _speaker.isEscapedModel();
	}

	@Override
	public boolean isNew() {
		return _speaker.isNew();
	}

	@Override
	public ExpandoBridge getExpandoBridge() {
		return _speaker.getExpandoBridge();
	}

	@Override
	public com.liferay.portal.kernel.model.CacheModel<SpeakerEvent.model.Speaker> toCacheModel() {
		return _speaker.toCacheModel();
	}

	@Override
	public int compareTo(SpeakerEvent.model.Speaker speaker) {
		return _speaker.compareTo(speaker);
	}

	@Override
	public int hashCode() {
		return _speaker.hashCode();
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _speaker.getPrimaryKeyObj();
	}

	@Override
	public java.lang.Object clone() {
		return new SpeakerWrapper((Speaker)_speaker.clone());
	}

	/**
	* Returns the email of this speaker.
	*
	* @return the email of this speaker
	*/
	@Override
	public java.lang.String getEmail() {
		return _speaker.getEmail();
	}

	/**
	* Returns the first name of this speaker.
	*
	* @return the first name of this speaker
	*/
	@Override
	public java.lang.String getFirstName() {
		return _speaker.getFirstName();
	}

	/**
	* Returns the last name of this speaker.
	*
	* @return the last name of this speaker
	*/
	@Override
	public java.lang.String getLastName() {
		return _speaker.getLastName();
	}

	/**
	* Returns the user uuid of this speaker.
	*
	* @return the user uuid of this speaker
	*/
	@Override
	public java.lang.String getUserUuid() {
		return _speaker.getUserUuid();
	}

	@Override
	public java.lang.String toString() {
		return _speaker.toString();
	}

	@Override
	public java.lang.String toXmlString() {
		return _speaker.toXmlString();
	}

	/**
	* Returns the primary key of this speaker.
	*
	* @return the primary key of this speaker
	*/
	@Override
	public long getPrimaryKey() {
		return _speaker.getPrimaryKey();
	}

	/**
	* Returns the speaker ID of this speaker.
	*
	* @return the speaker ID of this speaker
	*/
	@Override
	public long getSpeakerId() {
		return _speaker.getSpeakerId();
	}

	/**
	* Returns the user ID of this speaker.
	*
	* @return the user ID of this speaker
	*/
	@Override
	public long getUserId() {
		return _speaker.getUserId();
	}

	@Override
	public void persist() {
		_speaker.persist();
	}

	@Override
	public void setCachedModel(boolean cachedModel) {
		_speaker.setCachedModel(cachedModel);
	}

	/**
	* Sets the email of this speaker.
	*
	* @param email the email of this speaker
	*/
	@Override
	public void setEmail(java.lang.String email) {
		_speaker.setEmail(email);
	}

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge) {
		_speaker.setExpandoBridgeAttributes(expandoBridge);
	}

	@Override
	public void setExpandoBridgeAttributes(
		com.liferay.portal.kernel.model.BaseModel<?> baseModel) {
		_speaker.setExpandoBridgeAttributes(baseModel);
	}

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext) {
		_speaker.setExpandoBridgeAttributes(serviceContext);
	}

	/**
	* Sets the first name of this speaker.
	*
	* @param firstName the first name of this speaker
	*/
	@Override
	public void setFirstName(java.lang.String firstName) {
		_speaker.setFirstName(firstName);
	}

	/**
	* Sets the last name of this speaker.
	*
	* @param lastName the last name of this speaker
	*/
	@Override
	public void setLastName(java.lang.String lastName) {
		_speaker.setLastName(lastName);
	}

	@Override
	public void setNew(boolean n) {
		_speaker.setNew(n);
	}

	/**
	* Sets the primary key of this speaker.
	*
	* @param primaryKey the primary key of this speaker
	*/
	@Override
	public void setPrimaryKey(long primaryKey) {
		_speaker.setPrimaryKey(primaryKey);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		_speaker.setPrimaryKeyObj(primaryKeyObj);
	}

	/**
	* Sets the speaker ID of this speaker.
	*
	* @param speakerId the speaker ID of this speaker
	*/
	@Override
	public void setSpeakerId(long speakerId) {
		_speaker.setSpeakerId(speakerId);
	}

	/**
	* Sets the user ID of this speaker.
	*
	* @param userId the user ID of this speaker
	*/
	@Override
	public void setUserId(long userId) {
		_speaker.setUserId(userId);
	}

	/**
	* Sets the user uuid of this speaker.
	*
	* @param userUuid the user uuid of this speaker
	*/
	@Override
	public void setUserUuid(java.lang.String userUuid) {
		_speaker.setUserUuid(userUuid);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpeakerWrapper)) {
			return false;
		}

		SpeakerWrapper speakerWrapper = (SpeakerWrapper)obj;

		if (Objects.equals(_speaker, speakerWrapper._speaker)) {
			return true;
		}

		return false;
	}

	@Override
	public Speaker getWrappedModel() {
		return _speaker;
	}

	@Override
	public boolean isEntityCacheEnabled() {
		return _speaker.isEntityCacheEnabled();
	}

	@Override
	public boolean isFinderCacheEnabled() {
		return _speaker.isFinderCacheEnabled();
	}

	@Override
	public void resetOriginalValues() {
		_speaker.resetOriginalValues();
	}

	private final Speaker _speaker;
}