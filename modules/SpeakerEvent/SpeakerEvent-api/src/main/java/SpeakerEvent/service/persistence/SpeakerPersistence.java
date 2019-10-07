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

package SpeakerEvent.service.persistence;

import SpeakerEvent.exception.NoSuchSpeakerException;

import SpeakerEvent.model.Speaker;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.service.persistence.BasePersistence;

/**
 * The persistence interface for the speaker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpeakerEvent.service.persistence.impl.SpeakerPersistenceImpl
 * @see SpeakerUtil
 * @generated
 */
@ProviderType
public interface SpeakerPersistence extends BasePersistence<Speaker> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link SpeakerUtil} to access the speaker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns the speaker where speakerId = &#63; or throws a {@link NoSuchSpeakerException} if it could not be found.
	*
	* @param speakerId the speaker ID
	* @return the matching speaker
	* @throws NoSuchSpeakerException if a matching speaker could not be found
	*/
	public Speaker findByspeakerId(long speakerId)
		throws NoSuchSpeakerException;

	/**
	* Returns the speaker where speakerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param speakerId the speaker ID
	* @return the matching speaker, or <code>null</code> if a matching speaker could not be found
	*/
	public Speaker fetchByspeakerId(long speakerId);

	/**
	* Returns the speaker where speakerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param speakerId the speaker ID
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the matching speaker, or <code>null</code> if a matching speaker could not be found
	*/
	public Speaker fetchByspeakerId(long speakerId, boolean retrieveFromCache);

	/**
	* Removes the speaker where speakerId = &#63; from the database.
	*
	* @param speakerId the speaker ID
	* @return the speaker that was removed
	*/
	public Speaker removeByspeakerId(long speakerId)
		throws NoSuchSpeakerException;

	/**
	* Returns the number of speakers where speakerId = &#63;.
	*
	* @param speakerId the speaker ID
	* @return the number of matching speakers
	*/
	public int countByspeakerId(long speakerId);

	/**
	* Caches the speaker in the entity cache if it is enabled.
	*
	* @param speaker the speaker
	*/
	public void cacheResult(Speaker speaker);

	/**
	* Caches the speakers in the entity cache if it is enabled.
	*
	* @param speakers the speakers
	*/
	public void cacheResult(java.util.List<Speaker> speakers);

	/**
	* Creates a new speaker with the primary key. Does not add the speaker to the database.
	*
	* @param speakerId the primary key for the new speaker
	* @return the new speaker
	*/
	public Speaker create(long speakerId);

	/**
	* Removes the speaker with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker that was removed
	* @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	*/
	public Speaker remove(long speakerId) throws NoSuchSpeakerException;

	public Speaker updateImpl(Speaker speaker);

	/**
	* Returns the speaker with the primary key or throws a {@link NoSuchSpeakerException} if it could not be found.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker
	* @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	*/
	public Speaker findByPrimaryKey(long speakerId)
		throws NoSuchSpeakerException;

	/**
	* Returns the speaker with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param speakerId the primary key of the speaker
	* @return the speaker, or <code>null</code> if a speaker with the primary key could not be found
	*/
	public Speaker fetchByPrimaryKey(long speakerId);

	@Override
	public java.util.Map<java.io.Serializable, Speaker> fetchByPrimaryKeys(
		java.util.Set<java.io.Serializable> primaryKeys);

	/**
	* Returns all the speakers.
	*
	* @return the speakers
	*/
	public java.util.List<Speaker> findAll();

	/**
	* Returns a range of all the speakers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speakers
	* @param end the upper bound of the range of speakers (not inclusive)
	* @return the range of speakers
	*/
	public java.util.List<Speaker> findAll(int start, int end);

	/**
	* Returns an ordered range of all the speakers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speakers
	* @param end the upper bound of the range of speakers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of speakers
	*/
	public java.util.List<Speaker> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker> orderByComparator);

	/**
	* Returns an ordered range of all the speakers.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link SpeakerModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of speakers
	* @param end the upper bound of the range of speakers (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @param retrieveFromCache whether to retrieve from the finder cache
	* @return the ordered range of speakers
	*/
	public java.util.List<Speaker> findAll(int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator<Speaker> orderByComparator,
		boolean retrieveFromCache);

	/**
	* Removes all the speakers from the database.
	*/
	public void removeAll();

	/**
	* Returns the number of speakers.
	*
	* @return the number of speakers
	*/
	public int countAll();
}