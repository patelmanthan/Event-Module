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

package SpeakerEvent.model.impl;

import SpeakerEvent.model.Speaker_Event;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Speaker_Event in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Speaker_Event
 * @generated
 */
@ProviderType
public class Speaker_EventCacheModel implements CacheModel<Speaker_Event>,
	Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof Speaker_EventCacheModel)) {
			return false;
		}

		Speaker_EventCacheModel speaker_EventCacheModel = (Speaker_EventCacheModel)obj;

		if (id == speaker_EventCacheModel.id) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, id);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(7);

		sb.append("{id=");
		sb.append(id);
		sb.append(", speakerId=");
		sb.append(speakerId);
		sb.append(", eventId=");
		sb.append(eventId);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Speaker_Event toEntityModel() {
		Speaker_EventImpl speaker_EventImpl = new Speaker_EventImpl();

		speaker_EventImpl.setId(id);
		speaker_EventImpl.setSpeakerId(speakerId);
		speaker_EventImpl.setEventId(eventId);

		speaker_EventImpl.resetOriginalValues();

		return speaker_EventImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		id = objectInput.readLong();

		speakerId = objectInput.readLong();

		eventId = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(id);

		objectOutput.writeLong(speakerId);

		objectOutput.writeLong(eventId);
	}

	public long id;
	public long speakerId;
	public long eventId;
}