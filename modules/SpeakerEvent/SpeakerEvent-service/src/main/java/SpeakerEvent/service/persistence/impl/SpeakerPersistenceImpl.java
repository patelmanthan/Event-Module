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

package SpeakerEvent.service.persistence.impl;

import SpeakerEvent.exception.NoSuchSpeakerException;

import SpeakerEvent.model.Speaker;

import SpeakerEvent.model.impl.SpeakerImpl;
import SpeakerEvent.model.impl.SpeakerModelImpl;

import SpeakerEvent.service.persistence.SpeakerPersistence;

import aQute.bnd.annotation.ProviderType;

import com.liferay.portal.kernel.dao.orm.EntityCache;
import com.liferay.portal.kernel.dao.orm.FinderCache;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.service.persistence.impl.BasePersistenceImpl;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the speaker service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see SpeakerPersistence
 * @see SpeakerEvent.service.persistence.SpeakerUtil
 * @generated
 */
@ProviderType
public class SpeakerPersistenceImpl extends BasePersistenceImpl<Speaker>
	implements SpeakerPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link SpeakerUtil} to access the speaker persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = SpeakerImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerModelImpl.FINDER_CACHE_ENABLED, SpeakerImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerModelImpl.FINDER_CACHE_ENABLED, SpeakerImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_SPEAKERID = new FinderPath(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerModelImpl.FINDER_CACHE_ENABLED, SpeakerImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByspeakerId",
			new String[] { Long.class.getName() },
			SpeakerModelImpl.SPEAKERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPEAKERID = new FinderPath(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByspeakerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the speaker where speakerId = &#63; or throws a {@link NoSuchSpeakerException} if it could not be found.
	 *
	 * @param speakerId the speaker ID
	 * @return the matching speaker
	 * @throws NoSuchSpeakerException if a matching speaker could not be found
	 */
	@Override
	public Speaker findByspeakerId(long speakerId)
		throws NoSuchSpeakerException {
		Speaker speaker = fetchByspeakerId(speakerId);

		if (speaker == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("speakerId=");
			msg.append(speakerId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isDebugEnabled()) {
				_log.debug(msg.toString());
			}

			throw new NoSuchSpeakerException(msg.toString());
		}

		return speaker;
	}

	/**
	 * Returns the speaker where speakerId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param speakerId the speaker ID
	 * @return the matching speaker, or <code>null</code> if a matching speaker could not be found
	 */
	@Override
	public Speaker fetchByspeakerId(long speakerId) {
		return fetchByspeakerId(speakerId, true);
	}

	/**
	 * Returns the speaker where speakerId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param speakerId the speaker ID
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the matching speaker, or <code>null</code> if a matching speaker could not be found
	 */
	@Override
	public Speaker fetchByspeakerId(long speakerId, boolean retrieveFromCache) {
		Object[] finderArgs = new Object[] { speakerId };

		Object result = null;

		if (retrieveFromCache) {
			result = finderCache.getResult(FINDER_PATH_FETCH_BY_SPEAKERID,
					finderArgs, this);
		}

		if (result instanceof Speaker) {
			Speaker speaker = (Speaker)result;

			if ((speakerId != speaker.getSpeakerId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_SPEAKER_WHERE);

			query.append(_FINDER_COLUMN_SPEAKERID_SPEAKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(speakerId);

				List<Speaker> list = q.list();

				if (list.isEmpty()) {
					finderCache.putResult(FINDER_PATH_FETCH_BY_SPEAKERID,
						finderArgs, list);
				}
				else {
					if (list.size() > 1) {
						Collections.sort(list, Collections.reverseOrder());

						if (_log.isWarnEnabled()) {
							_log.warn(
								"SpeakerPersistenceImpl.fetchByspeakerId(long, boolean) with parameters (" +
								StringUtil.merge(finderArgs) +
								") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
						}
					}

					Speaker speaker = list.get(0);

					result = speaker;

					cacheResult(speaker);

					if ((speaker.getSpeakerId() != speakerId)) {
						finderCache.putResult(FINDER_PATH_FETCH_BY_SPEAKERID,
							finderArgs, speaker);
					}
				}
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_FETCH_BY_SPEAKERID,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (Speaker)result;
		}
	}

	/**
	 * Removes the speaker where speakerId = &#63; from the database.
	 *
	 * @param speakerId the speaker ID
	 * @return the speaker that was removed
	 */
	@Override
	public Speaker removeByspeakerId(long speakerId)
		throws NoSuchSpeakerException {
		Speaker speaker = findByspeakerId(speakerId);

		return remove(speaker);
	}

	/**
	 * Returns the number of speakers where speakerId = &#63;.
	 *
	 * @param speakerId the speaker ID
	 * @return the number of matching speakers
	 */
	@Override
	public int countByspeakerId(long speakerId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPEAKERID;

		Object[] finderArgs = new Object[] { speakerId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPEAKER_WHERE);

			query.append(_FINDER_COLUMN_SPEAKERID_SPEAKERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(speakerId);

				count = (Long)q.uniqueResult();

				finderCache.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_SPEAKERID_SPEAKERID_2 = "speaker.speakerId = ?";

	public SpeakerPersistenceImpl() {
		setModelClass(Speaker.class);
	}

	/**
	 * Caches the speaker in the entity cache if it is enabled.
	 *
	 * @param speaker the speaker
	 */
	@Override
	public void cacheResult(Speaker speaker) {
		entityCache.putResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerImpl.class, speaker.getPrimaryKey(), speaker);

		finderCache.putResult(FINDER_PATH_FETCH_BY_SPEAKERID,
			new Object[] { speaker.getSpeakerId() }, speaker);

		speaker.resetOriginalValues();
	}

	/**
	 * Caches the speakers in the entity cache if it is enabled.
	 *
	 * @param speakers the speakers
	 */
	@Override
	public void cacheResult(List<Speaker> speakers) {
		for (Speaker speaker : speakers) {
			if (entityCache.getResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
						SpeakerImpl.class, speaker.getPrimaryKey()) == null) {
				cacheResult(speaker);
			}
			else {
				speaker.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all speakers.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(SpeakerImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the speaker.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Speaker speaker) {
		entityCache.removeResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerImpl.class, speaker.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache((SpeakerModelImpl)speaker, true);
	}

	@Override
	public void clearCache(List<Speaker> speakers) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Speaker speaker : speakers) {
			entityCache.removeResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
				SpeakerImpl.class, speaker.getPrimaryKey());

			clearUniqueFindersCache((SpeakerModelImpl)speaker, true);
		}
	}

	protected void cacheUniqueFindersCache(SpeakerModelImpl speakerModelImpl) {
		Object[] args = new Object[] { speakerModelImpl.getSpeakerId() };

		finderCache.putResult(FINDER_PATH_COUNT_BY_SPEAKERID, args,
			Long.valueOf(1), false);
		finderCache.putResult(FINDER_PATH_FETCH_BY_SPEAKERID, args,
			speakerModelImpl, false);
	}

	protected void clearUniqueFindersCache(SpeakerModelImpl speakerModelImpl,
		boolean clearCurrent) {
		if (clearCurrent) {
			Object[] args = new Object[] { speakerModelImpl.getSpeakerId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SPEAKERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SPEAKERID, args);
		}

		if ((speakerModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_SPEAKERID.getColumnBitmask()) != 0) {
			Object[] args = new Object[] { speakerModelImpl.getOriginalSpeakerId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SPEAKERID, args);
			finderCache.removeResult(FINDER_PATH_FETCH_BY_SPEAKERID, args);
		}
	}

	/**
	 * Creates a new speaker with the primary key. Does not add the speaker to the database.
	 *
	 * @param speakerId the primary key for the new speaker
	 * @return the new speaker
	 */
	@Override
	public Speaker create(long speakerId) {
		Speaker speaker = new SpeakerImpl();

		speaker.setNew(true);
		speaker.setPrimaryKey(speakerId);

		return speaker;
	}

	/**
	 * Removes the speaker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param speakerId the primary key of the speaker
	 * @return the speaker that was removed
	 * @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	 */
	@Override
	public Speaker remove(long speakerId) throws NoSuchSpeakerException {
		return remove((Serializable)speakerId);
	}

	/**
	 * Removes the speaker with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the speaker
	 * @return the speaker that was removed
	 * @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	 */
	@Override
	public Speaker remove(Serializable primaryKey)
		throws NoSuchSpeakerException {
		Session session = null;

		try {
			session = openSession();

			Speaker speaker = (Speaker)session.get(SpeakerImpl.class, primaryKey);

			if (speaker == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpeakerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(speaker);
		}
		catch (NoSuchSpeakerException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected Speaker removeImpl(Speaker speaker) {
		speaker = toUnwrappedModel(speaker);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(speaker)) {
				speaker = (Speaker)session.get(SpeakerImpl.class,
						speaker.getPrimaryKeyObj());
			}

			if (speaker != null) {
				session.delete(speaker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (speaker != null) {
			clearCache(speaker);
		}

		return speaker;
	}

	@Override
	public Speaker updateImpl(Speaker speaker) {
		speaker = toUnwrappedModel(speaker);

		boolean isNew = speaker.isNew();

		SpeakerModelImpl speakerModelImpl = (SpeakerModelImpl)speaker;

		Session session = null;

		try {
			session = openSession();

			if (speaker.isNew()) {
				session.save(speaker);

				speaker.setNew(false);
			}
			else {
				speaker = (Speaker)session.merge(speaker);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!SpeakerModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		entityCache.putResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
			SpeakerImpl.class, speaker.getPrimaryKey(), speaker, false);

		clearUniqueFindersCache(speakerModelImpl, false);
		cacheUniqueFindersCache(speakerModelImpl);

		speaker.resetOriginalValues();

		return speaker;
	}

	protected Speaker toUnwrappedModel(Speaker speaker) {
		if (speaker instanceof SpeakerImpl) {
			return speaker;
		}

		SpeakerImpl speakerImpl = new SpeakerImpl();

		speakerImpl.setNew(speaker.isNew());
		speakerImpl.setPrimaryKey(speaker.getPrimaryKey());

		speakerImpl.setSpeakerId(speaker.getSpeakerId());
		speakerImpl.setUserId(speaker.getUserId());
		speakerImpl.setFirstName(speaker.getFirstName());
		speakerImpl.setLastName(speaker.getLastName());
		speakerImpl.setEmail(speaker.getEmail());

		return speakerImpl;
	}

	/**
	 * Returns the speaker with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the speaker
	 * @return the speaker
	 * @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	 */
	@Override
	public Speaker findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpeakerException {
		Speaker speaker = fetchByPrimaryKey(primaryKey);

		if (speaker == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpeakerException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return speaker;
	}

	/**
	 * Returns the speaker with the primary key or throws a {@link NoSuchSpeakerException} if it could not be found.
	 *
	 * @param speakerId the primary key of the speaker
	 * @return the speaker
	 * @throws NoSuchSpeakerException if a speaker with the primary key could not be found
	 */
	@Override
	public Speaker findByPrimaryKey(long speakerId)
		throws NoSuchSpeakerException {
		return findByPrimaryKey((Serializable)speakerId);
	}

	/**
	 * Returns the speaker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the speaker
	 * @return the speaker, or <code>null</code> if a speaker with the primary key could not be found
	 */
	@Override
	public Speaker fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
				SpeakerImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Speaker speaker = (Speaker)serializable;

		if (speaker == null) {
			Session session = null;

			try {
				session = openSession();

				speaker = (Speaker)session.get(SpeakerImpl.class, primaryKey);

				if (speaker != null) {
					cacheResult(speaker);
				}
				else {
					entityCache.putResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
						SpeakerImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
					SpeakerImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return speaker;
	}

	/**
	 * Returns the speaker with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param speakerId the primary key of the speaker
	 * @return the speaker, or <code>null</code> if a speaker with the primary key could not be found
	 */
	@Override
	public Speaker fetchByPrimaryKey(long speakerId) {
		return fetchByPrimaryKey((Serializable)speakerId);
	}

	@Override
	public Map<Serializable, Speaker> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Speaker> map = new HashMap<Serializable, Speaker>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Speaker speaker = fetchByPrimaryKey(primaryKey);

			if (speaker != null) {
				map.put(primaryKey, speaker);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
					SpeakerImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Speaker)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SPEAKER_WHERE_PKS_IN);

		for (Serializable primaryKey : uncachedPrimaryKeys) {
			query.append((long)primaryKey);

			query.append(StringPool.COMMA);
		}

		query.setIndex(query.index() - 1);

		query.append(StringPool.CLOSE_PARENTHESIS);

		String sql = query.toString();

		Session session = null;

		try {
			session = openSession();

			Query q = session.createQuery(sql);

			for (Speaker speaker : (List<Speaker>)q.list()) {
				map.put(speaker.getPrimaryKeyObj(), speaker);

				cacheResult(speaker);

				uncachedPrimaryKeys.remove(speaker.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(SpeakerModelImpl.ENTITY_CACHE_ENABLED,
					SpeakerImpl.class, primaryKey, nullModel);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		return map;
	}

	/**
	 * Returns all the speakers.
	 *
	 * @return the speakers
	 */
	@Override
	public List<Speaker> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<Speaker> findAll(int start, int end) {
		return findAll(start, end, null);
	}

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
	@Override
	public List<Speaker> findAll(int start, int end,
		OrderByComparator<Speaker> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

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
	@Override
	public List<Speaker> findAll(int start, int end,
		OrderByComparator<Speaker> orderByComparator, boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<Speaker> list = null;

		if (retrieveFromCache) {
			list = (List<Speaker>)finderCache.getResult(finderPath, finderArgs,
					this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SPEAKER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPEAKER;

				if (pagination) {
					sql = sql.concat(SpeakerModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Speaker>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Speaker>)QueryUtil.list(q, getDialect(),
							start, end);
				}

				cacheResult(list);

				finderCache.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				finderCache.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the speakers from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Speaker speaker : findAll()) {
			remove(speaker);
		}
	}

	/**
	 * Returns the number of speakers.
	 *
	 * @return the number of speakers
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SPEAKER);

				count = (Long)q.uniqueResult();

				finderCache.putResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY,
					count);
			}
			catch (Exception e) {
				finderCache.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return SpeakerModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the speaker persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(SpeakerImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SPEAKER = "SELECT speaker FROM Speaker speaker";
	private static final String _SQL_SELECT_SPEAKER_WHERE_PKS_IN = "SELECT speaker FROM Speaker speaker WHERE speakerId IN (";
	private static final String _SQL_SELECT_SPEAKER_WHERE = "SELECT speaker FROM Speaker speaker WHERE ";
	private static final String _SQL_COUNT_SPEAKER = "SELECT COUNT(speaker) FROM Speaker speaker";
	private static final String _SQL_COUNT_SPEAKER_WHERE = "SELECT COUNT(speaker) FROM Speaker speaker WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "speaker.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Speaker exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Speaker exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(SpeakerPersistenceImpl.class);
}