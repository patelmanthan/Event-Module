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
 * The extended model interface for the Speaker service. Represents a row in the &quot;FOO_Speaker&quot; database table, with each column mapped to a property of this class.
 *
 * @author Brian Wing Shun Chan
 * @see SpeakerModel
 * @see SpeakerEvent.model.impl.SpeakerImpl
 * @see SpeakerEvent.model.impl.SpeakerModelImpl
 * @generated
 */
@ImplementationClassName("SpeakerEvent.model.impl.SpeakerImpl")
@ProviderType
public interface Speaker extends SpeakerModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link SpeakerEvent.model.impl.SpeakerImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
	public static final Accessor<Speaker, Long> SPEAKER_ID_ACCESSOR = new Accessor<Speaker, Long>() {
			@Override
			public Long get(Speaker speaker) {
				return speaker.getSpeakerId();
			}

			@Override
			public Class<Long> getAttributeClass() {
				return Long.class;
			}

			@Override
			public Class<Speaker> getTypeClass() {
				return Speaker.class;
			}
		};
}