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

import java.io.Serializable;

import java.util.ArrayList;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Brian Wing Shun Chan
 * @generated
 */
@ProviderType
public class SpeakerSoap implements Serializable {
	public static SpeakerSoap toSoapModel(Speaker model) {
		SpeakerSoap soapModel = new SpeakerSoap();

		soapModel.setSpeakerId(model.getSpeakerId());
		soapModel.setUserId(model.getUserId());
		soapModel.setFirstName(model.getFirstName());
		soapModel.setLastName(model.getLastName());
		soapModel.setEmail(model.getEmail());

		return soapModel;
	}

	public static SpeakerSoap[] toSoapModels(Speaker[] models) {
		SpeakerSoap[] soapModels = new SpeakerSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static SpeakerSoap[][] toSoapModels(Speaker[][] models) {
		SpeakerSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new SpeakerSoap[models.length][models[0].length];
		}
		else {
			soapModels = new SpeakerSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static SpeakerSoap[] toSoapModels(List<Speaker> models) {
		List<SpeakerSoap> soapModels = new ArrayList<SpeakerSoap>(models.size());

		for (Speaker model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new SpeakerSoap[soapModels.size()]);
	}

	public SpeakerSoap() {
	}

	public long getPrimaryKey() {
		return _speakerId;
	}

	public void setPrimaryKey(long pk) {
		setSpeakerId(pk);
	}

	public long getSpeakerId() {
		return _speakerId;
	}

	public void setSpeakerId(long speakerId) {
		_speakerId = speakerId;
	}

	public long getUserId() {
		return _userId;
	}

	public void setUserId(long userId) {
		_userId = userId;
	}

	public String getFirstName() {
		return _firstName;
	}

	public void setFirstName(String firstName) {
		_firstName = firstName;
	}

	public String getLastName() {
		return _lastName;
	}

	public void setLastName(String lastName) {
		_lastName = lastName;
	}

	public String getEmail() {
		return _email;
	}

	public void setEmail(String email) {
		_email = email;
	}

	private long _speakerId;
	private long _userId;
	private String _firstName;
	private String _lastName;
	private String _email;
}