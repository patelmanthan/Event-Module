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

package SpeakerEvent.service.impl;

import java.util.List;

import com.liferay.portal.kernel.transaction.Transactional;

import SpeakerEvent.model.Speaker_Event;
import SpeakerEvent.service.base.Speaker_EventLocalServiceBaseImpl;

/**
 * The implementation of the speaker_ event local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link SpeakerEvent.service.Speaker_EventLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Speaker_EventLocalServiceBaseImpl
 * @see SpeakerEvent.service.Speaker_EventLocalServiceUtil
 */
public class Speaker_EventLocalServiceImpl
	extends Speaker_EventLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link SpeakerEvent.service.Speaker_EventLocalServiceUtil} to access the speaker_ event local service.
	 */
	@Transactional
	public Speaker_Event addSpeakerEvent(long eventId,long speakerId) {

		long speakerEventId = counterLocalService.increment();
		Speaker_Event speakerEvent = speaker_EventPersistence.create(speakerEventId);
		speakerEvent.setSpeakerId(speakerId);
		speakerEvent.setEventId(eventId);
		speaker_EventPersistence.update(speakerEvent);
		return speakerEvent;
	}

	@Transactional
	public List<Speaker_Event> findByEventId(long eventId){
		return speaker_EventPersistence.findByeventId(eventId);
	}
	
	@Transactional
	public List<Speaker_Event> findBySpeakerId(long speakerId){
		return speaker_EventPersistence.findByspeakerId(speakerId);
	}
	
}