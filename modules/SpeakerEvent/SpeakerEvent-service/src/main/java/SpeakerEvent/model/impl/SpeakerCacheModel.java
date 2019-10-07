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

import SpeakerEvent.model.Speaker;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.model.CacheModel;
import com.liferay.portal.kernel.util.HashUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing Speaker in entity cache.
 *
 * @author Brian Wing Shun Chan
 * @see Speaker
 * @generated
 */
@ProviderType
public class SpeakerCacheModel implements CacheModel<Speaker>, Externalizable {
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof SpeakerCacheModel)) {
			return false;
		}

		SpeakerCacheModel speakerCacheModel = (SpeakerCacheModel)obj;

		if (speakerId == speakerCacheModel.speakerId) {
			return true;
		}

		return false;
	}

	@Override
	public int hashCode() {
		return HashUtil.hash(0, speakerId);
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(11);

		sb.append("{speakerId=");
		sb.append(speakerId);
		sb.append(", userId=");
		sb.append(userId);
		sb.append(", firstName=");
		sb.append(firstName);
		sb.append(", lastName=");
		sb.append(lastName);
		sb.append(", email=");
		sb.append(email);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Speaker toEntityModel() {
		SpeakerImpl speakerImpl = new SpeakerImpl();

		speakerImpl.setSpeakerId(speakerId);
		speakerImpl.setUserId(userId);

		if (firstName == null) {
			speakerImpl.setFirstName(StringPool.BLANK);
		}
		else {
			speakerImpl.setFirstName(firstName);
		}

		if (lastName == null) {
			speakerImpl.setLastName(StringPool.BLANK);
		}
		else {
			speakerImpl.setLastName(lastName);
		}

		if (email == null) {
			speakerImpl.setEmail(StringPool.BLANK);
		}
		else {
			speakerImpl.setEmail(email);
		}

		speakerImpl.resetOriginalValues();

		return speakerImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		speakerId = objectInput.readLong();

		userId = objectInput.readLong();
		firstName = objectInput.readUTF();
		lastName = objectInput.readUTF();
		email = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(speakerId);

		objectOutput.writeLong(userId);

		if (firstName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(firstName);
		}

		if (lastName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastName);
		}

		if (email == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(email);
		}
	}

	public long speakerId;
	public long userId;
	public String firstName;
	public String lastName;
	public String email;
}