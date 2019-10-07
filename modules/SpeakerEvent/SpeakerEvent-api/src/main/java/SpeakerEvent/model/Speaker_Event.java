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

import com.liferay.portal.kernel.annotation.ImplementationClassName;
import com.liferay.portal.kernel.model.PersistedModel;
import com.liferay.portal.kernel.util.Accessor;

/**
 * The extended model interface for the Speaker_Event service. Represents a row in the &quot;FOO_Speaker_Event&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see Speaker_EventModel
 * @see SpeakerEvent.model.impl.Speaker_EventImpl
 * @see SpeakerEvent.model.impl.Speaker_EventModelImpl
 * @generated
 */
@ImplementationClassName("SpeakerEvent.model.impl.Speaker_EventImpl")
@ProviderType
public interface Speaker_Event extends Speaker_EventModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link SpeakerEvent.model.impl.Speaker_EventImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Speaker_Event, Long> ID_ACCESSOR = new Accessor<Speaker_Event, Long>() {
			@Override
			public Long get(Speaker_Event speaker_Event) {
				return speaker_Event.getId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Speaker_Event> getTypeClass() {
				return Speaker_Event.class;
			}
		};
}