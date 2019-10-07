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

import com.liferay.portal.kernel.transaction.Transactional;

import SpeakerEvent.model.Speaker;
import SpeakerEvent.model.Speaker_Event;
import SpeakerEvent.service.base.SpeakerLocalServiceBaseImpl;

/**
 * The implementation of the speaker local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are
 * added, rerun ServiceBuilder to copy their definitions into the
 * {@link SpeakerEvent.service.SpeakerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security
 * checks based on the propagated JAAS credentials because this service can only
 * be accessed from within the same VM.
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpeakerLocalServiceBaseImpl
 * @see SpeakerEvent.service.SpeakerLocalServiceUtil
 */
public class SpeakerLocalServiceImpl extends SpeakerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this class directly. Always use {@link
	 * SpeakerEvent.service.SpeakerLocalServiceUtil} to access the speaker local
	 * service.
	 */

	@Transactional
	public Speaker addSpeaker(long eventId,long userId, String firstName,String lastName,String email) {

		long speakerId = counterLocalService.increment();
		Speaker speaker = speakerPersistence.create(speakerId);
		speaker.setSpeakerId(speakerId);
		speaker.setFirstName(firstName);
		speaker.setLastName(lastName);
		speaker.setEmail(email);
		speakerPersistence.update(speaker);

		// Add data to speaker_event table too
		Speaker_Event speakerEvent = speaker_EventLocalService.addSpeakerEvent(eventId, speakerId);
		System.out.println("speakerEvent :" + speakerEvent);
		
		return speaker;
	}

	@Transactional
	public Speaker findBySpeakerId(long speakerId) {
		return speakerPersistence.fetchByspeakerId(speakerId);
	}
}