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
public class Speaker_EventSoap implements Serializable {
	public static Speaker_EventSoap toSoapModel(Speaker_Event model) {
		Speaker_EventSoap soapModel = new Speaker_EventSoap();

		soapModel.setId(model.getId());
		soapModel.setSpeakerId(model.getSpeakerId());
		soapModel.setEventId(model.getEventId());

		return soapModel;
	}

	public static Speaker_EventSoap[] toSoapModels(Speaker_Event[] models) {
		Speaker_EventSoap[] soapModels = new Speaker_EventSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static Speaker_EventSoap[][] toSoapModels(Speaker_Event[][] models) {
		Speaker_EventSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new Speaker_EventSoap[models.length][models[0].length];
		}
		else {
			soapModels = new Speaker_EventSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static Speaker_EventSoap[] toSoapModels(List<Speaker_Event> models) {
		List<Speaker_EventSoap> soapModels = new ArrayList<Speaker_EventSoap>(models.size());

		for (Speaker_Event model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new Speaker_EventSoap[soapModels.size()]);
	}

	public Speaker_EventSoap() {
	}

	public long getPrimaryKey() {
		return _id;
	}

	public void setPrimaryKey(long pk) {
		setId(pk);
	}

	public long getId() {
		return _id;
	}

	public void setId(long id) {
		_id = id;
	}

	public long getSpeakerId() {
		return _speakerId;
	}

	public void setSpeakerId(long speakerId) {
		_speakerId = speakerId;
	}

	public long getEventId() {
		return _eventId;
	}

	public void setEventId(long eventId) {
		_eventId = eventId;
	}

	private long _id;
	private long _speakerId;
	private long _eventId;
}