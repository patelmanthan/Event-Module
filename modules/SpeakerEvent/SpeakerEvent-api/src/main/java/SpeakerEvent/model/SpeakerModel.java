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

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.kernel.model.BaseModel;
import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.service.ServiceContext;

import java.io.Serializable;

/**
 * The base model interface for the Speaker service. Represents a row in the &quot;FOO_Speaker&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link SpeakerEvent.model.impl.SpeakerModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link SpeakerEvent.model.impl.SpeakerImpl}.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Speaker
 * @see SpeakerEvent.model.impl.SpeakerImpl
 * @see SpeakerEvent.model.impl.SpeakerModelImpl
 * @generated
 */
@ProviderType
public interface SpeakerModel extends BaseModel<Speaker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a speaker model instance should use the {@link Speaker} interface instead.
	 */

	/**
	 * Returns the primary key of this speaker.
	 *
	 * @return the primary key of this speaker
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this speaker.
	 *
	 * @param primaryKey the primary key of this speaker
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the speaker ID of this speaker.
	 *
	 * @return the speaker ID of this speaker
	 */
	public long getSpeakerId();

	/**
	 * Sets the speaker ID of this speaker.
	 *
	 * @param speakerId the speaker ID of this speaker
	 */
	public void setSpeakerId(long speakerId);

	/**
	 * Returns the user ID of this speaker.
	 *
	 * @return the user ID of this speaker
	 */
	public long getUserId();

	/**
	 * Sets the user ID of this speaker.
	 *
	 * @param userId the user ID of this speaker
	 */
	public void setUserId(long userId);

	/**
	 * Returns the user uuid of this speaker.
	 *
	 * @return the user uuid of this speaker
	 */
	public String getUserUuid();

	/**
	 * Sets the user uuid of this speaker.
	 *
	 * @param userUuid the user uuid of this speaker
	 */
	public void setUserUuid(String userUuid);

	/**
	 * Returns the first name of this speaker.
	 *
	 * @return the first name of this speaker
	 */
	@AutoEscape
	public String getFirstName();

	/**
	 * Sets the first name of this speaker.
	 *
	 * @param firstName the first name of this speaker
	 */
	public void setFirstName(String firstName);

	/**
	 * Returns the last name of this speaker.
	 *
	 * @return the last name of this speaker
	 */
	@AutoEscape
	public String getLastName();

	/**
	 * Sets the last name of this speaker.
	 *
	 * @param lastName the last name of this speaker
	 */
	public void setLastName(String lastName);

	/**
	 * Returns the email of this speaker.
	 *
	 * @return the email of this speaker
	 */
	@AutoEscape
	public String getEmail();

	/**
	 * Sets the email of this speaker.
	 *
	 * @param email the email of this speaker
	 */
	public void setEmail(String email);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(SpeakerEvent.model.Speaker speaker);

	@Override
	public int hashCode();

	@Override
	public CacheModel<SpeakerEvent.model.Speaker> toCacheModel();

	@Override
	public SpeakerEvent.model.Speaker toEscapedModel();

	@Override
	public SpeakerEvent.model.Speaker toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}