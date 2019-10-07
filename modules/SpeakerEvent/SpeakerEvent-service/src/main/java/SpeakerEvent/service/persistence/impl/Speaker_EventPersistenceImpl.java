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

import SpeakerEvent.exception.NoSuchSpeaker_EventException;

import SpeakerEvent.model.Speaker_Event;

import SpeakerEvent.model.impl.Speaker_EventImpl;
import SpeakerEvent.model.impl.Speaker_EventModelImpl;

import SpeakerEvent.service.persistence.Speaker_EventPersistence;

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
import com.liferay.portal.kernel.util.ReflectionUtil;
import com.liferay.portal.kernel.util.SetUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.spring.extender.service.ServiceReference;

import java.io.Serializable;

import java.lang.reflect.Field;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * The persistence implementation for the speaker_ event service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see Speaker_EventPersistence
 * @see SpeakerEvent.service.persistence.Speaker_EventUtil
 * @generated
 */
@ProviderType
public class Speaker_EventPersistenceImpl extends BasePersistenceImpl<Speaker_Event>
	implements Speaker_EventPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link Speaker_EventUtil} to access the speaker_ event persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = Speaker_EventImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED,
			Speaker_EventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED,
			Speaker_EventImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID = new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED,
			Speaker_EventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByeventId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID =
		new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED,
			Speaker_EventImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByeventId", new String[] { Long.class.getName() },
			Speaker_EventModelImpl.EVENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_EVENTID = new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByeventId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the speaker_ events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByeventId(long eventId) {
		return findByeventId(eventId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the speaker_ events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @return the range of matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByeventId(long eventId, int start, int end) {
		return findByeventId(eventId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the speaker_ events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByeventId(long eventId, int start, int end,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return findByeventId(eventId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the speaker_ events where eventId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param eventId the event ID
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByeventId(long eventId, int start, int end,
		OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_EVENTID;
			finderArgs = new Object[] { eventId, start, end, orderByComparator };
		}

		List<Speaker_Event> list = null;

		if (retrieveFromCache) {
			list = (List<Speaker_Event>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Speaker_Event speaker_Event : list) {
					if ((eventId != speaker_Event.getEventId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SPEAKER_EVENT_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Speaker_EventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

				if (!pagination) {
					list = (List<Speaker_Event>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Speaker_Event>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first speaker_ event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching speaker_ event
	 * @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event findByeventId_First(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException {
		Speaker_Event speaker_Event = fetchByeventId_First(eventId,
				orderByComparator);

		if (speaker_Event != null) {
			return speaker_Event;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpeaker_EventException(msg.toString());
	}

	/**
	 * Returns the first speaker_ event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event fetchByeventId_First(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		List<Speaker_Event> list = findByeventId(eventId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last speaker_ event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching speaker_ event
	 * @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event findByeventId_Last(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException {
		Speaker_Event speaker_Event = fetchByeventId_Last(eventId,
				orderByComparator);

		if (speaker_Event != null) {
			return speaker_Event;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("eventId=");
		msg.append(eventId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpeaker_EventException(msg.toString());
	}

	/**
	 * Returns the last speaker_ event in the ordered set where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event fetchByeventId_Last(long eventId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		int count = countByeventId(eventId);

		if (count == 0) {
			return null;
		}

		List<Speaker_Event> list = findByeventId(eventId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the speaker_ events before and after the current speaker_ event in the ordered set where eventId = &#63;.
	 *
	 * @param id the primary key of the current speaker_ event
	 * @param eventId the event ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next speaker_ event
	 * @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event[] findByeventId_PrevAndNext(long id, long eventId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException {
		Speaker_Event speaker_Event = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Speaker_Event[] array = new Speaker_EventImpl[3];

			array[0] = getByeventId_PrevAndNext(session, speaker_Event,
					eventId, orderByComparator, true);

			array[1] = speaker_Event;

			array[2] = getByeventId_PrevAndNext(session, speaker_Event,
					eventId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Speaker_Event getByeventId_PrevAndNext(Session session,
		Speaker_Event speaker_Event, long eventId,
		OrderByComparator<Speaker_Event> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPEAKER_EVENT_WHERE);

		query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Speaker_EventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(eventId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(speaker_Event);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Speaker_Event> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the speaker_ events where eventId = &#63; from the database.
	 *
	 * @param eventId the event ID
	 */
	@Override
	public void removeByeventId(long eventId) {
		for (Speaker_Event speaker_Event : findByeventId(eventId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(speaker_Event);
		}
	}

	/**
	 * Returns the number of speaker_ events where eventId = &#63;.
	 *
	 * @param eventId the event ID
	 * @return the number of matching speaker_ events
	 */
	@Override
	public int countByeventId(long eventId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_EVENTID;

		Object[] finderArgs = new Object[] { eventId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPEAKER_EVENT_WHERE);

			query.append(_FINDER_COLUMN_EVENTID_EVENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(eventId);

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

	private static final String _FINDER_COLUMN_EVENTID_EVENTID_2 = "speaker_Event.eventId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_SPEAKERID =
		new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED,
			Speaker_EventImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByspeakerId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPEAKERID =
		new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED,
			Speaker_EventImpl.class, FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByspeakerId", new String[] { Long.class.getName() },
			Speaker_EventModelImpl.SPEAKERID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_SPEAKERID = new FinderPath(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByspeakerId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the speaker_ events where speakerId = &#63;.
	 *
	 * @param speakerId the speaker ID
	 * @return the matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByspeakerId(long speakerId) {
		return findByspeakerId(speakerId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the speaker_ events where speakerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param speakerId the speaker ID
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @return the range of matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByspeakerId(long speakerId, int start,
		int end) {
		return findByspeakerId(speakerId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the speaker_ events where speakerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param speakerId the speaker ID
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByspeakerId(long speakerId, int start,
		int end, OrderByComparator<Speaker_Event> orderByComparator) {
		return findByspeakerId(speakerId, start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the speaker_ events where speakerId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param speakerId the speaker ID
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of matching speaker_ events
	 */
	@Override
	public List<Speaker_Event> findByspeakerId(long speakerId, int start,
		int end, OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache) {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPEAKERID;
			finderArgs = new Object[] { speakerId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_SPEAKERID;
			finderArgs = new Object[] { speakerId, start, end, orderByComparator };
		}

		List<Speaker_Event> list = null;

		if (retrieveFromCache) {
			list = (List<Speaker_Event>)finderCache.getResult(finderPath,
					finderArgs, this);

			if ((list != null) && !list.isEmpty()) {
				for (Speaker_Event speaker_Event : list) {
					if ((speakerId != speaker_Event.getSpeakerId())) {
						list = null;

						break;
					}
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 2));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_SPEAKER_EVENT_WHERE);

			query.append(_FINDER_COLUMN_SPEAKERID_SPEAKERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(Speaker_EventModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(speakerId);

				if (!pagination) {
					list = (List<Speaker_Event>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Speaker_Event>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first speaker_ event in the ordered set where speakerId = &#63;.
	 *
	 * @param speakerId the speaker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching speaker_ event
	 * @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event findByspeakerId_First(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException {
		Speaker_Event speaker_Event = fetchByspeakerId_First(speakerId,
				orderByComparator);

		if (speaker_Event != null) {
			return speaker_Event;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("speakerId=");
		msg.append(speakerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpeaker_EventException(msg.toString());
	}

	/**
	 * Returns the first speaker_ event in the ordered set where speakerId = &#63;.
	 *
	 * @param speakerId the speaker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event fetchByspeakerId_First(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		List<Speaker_Event> list = findByspeakerId(speakerId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last speaker_ event in the ordered set where speakerId = &#63;.
	 *
	 * @param speakerId the speaker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching speaker_ event
	 * @throws NoSuchSpeaker_EventException if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event findByspeakerId_Last(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException {
		Speaker_Event speaker_Event = fetchByspeakerId_Last(speakerId,
				orderByComparator);

		if (speaker_Event != null) {
			return speaker_Event;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("speakerId=");
		msg.append(speakerId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchSpeaker_EventException(msg.toString());
	}

	/**
	 * Returns the last speaker_ event in the ordered set where speakerId = &#63;.
	 *
	 * @param speakerId the speaker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching speaker_ event, or <code>null</code> if a matching speaker_ event could not be found
	 */
	@Override
	public Speaker_Event fetchByspeakerId_Last(long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator) {
		int count = countByspeakerId(speakerId);

		if (count == 0) {
			return null;
		}

		List<Speaker_Event> list = findByspeakerId(speakerId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the speaker_ events before and after the current speaker_ event in the ordered set where speakerId = &#63;.
	 *
	 * @param id the primary key of the current speaker_ event
	 * @param speakerId the speaker ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next speaker_ event
	 * @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event[] findByspeakerId_PrevAndNext(long id, long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator)
		throws NoSuchSpeaker_EventException {
		Speaker_Event speaker_Event = findByPrimaryKey(id);

		Session session = null;

		try {
			session = openSession();

			Speaker_Event[] array = new Speaker_EventImpl[3];

			array[0] = getByspeakerId_PrevAndNext(session, speaker_Event,
					speakerId, orderByComparator, true);

			array[1] = speaker_Event;

			array[2] = getByspeakerId_PrevAndNext(session, speaker_Event,
					speakerId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected Speaker_Event getByspeakerId_PrevAndNext(Session session,
		Speaker_Event speaker_Event, long speakerId,
		OrderByComparator<Speaker_Event> orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(4 +
					(orderByComparator.getOrderByConditionFields().length * 3) +
					(orderByComparator.getOrderByFields().length * 3));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_SPEAKER_EVENT_WHERE);

		query.append(_FINDER_COLUMN_SPEAKERID_SPEAKERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(Speaker_EventModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(speakerId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(speaker_Event);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Speaker_Event> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the speaker_ events where speakerId = &#63; from the database.
	 *
	 * @param speakerId the speaker ID
	 */
	@Override
	public void removeByspeakerId(long speakerId) {
		for (Speaker_Event speaker_Event : findByspeakerId(speakerId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(speaker_Event);
		}
	}

	/**
	 * Returns the number of speaker_ events where speakerId = &#63;.
	 *
	 * @param speakerId the speaker ID
	 * @return the number of matching speaker_ events
	 */
	@Override
	public int countByspeakerId(long speakerId) {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_SPEAKERID;

		Object[] finderArgs = new Object[] { speakerId };

		Long count = (Long)finderCache.getResult(finderPath, finderArgs, this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_SPEAKER_EVENT_WHERE);

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

	private static final String _FINDER_COLUMN_SPEAKERID_SPEAKERID_2 = "speaker_Event.speakerId = ?";

	public Speaker_EventPersistenceImpl() {
		setModelClass(Speaker_Event.class);

		try {
			Field field = ReflectionUtil.getDeclaredField(BasePersistenceImpl.class,
					"_dbColumnNames");

			Map<String, String> dbColumnNames = new HashMap<String, String>();

			dbColumnNames.put("id", "id_");

			field.set(this, dbColumnNames);
		}
		catch (Exception e) {
			if (_log.isDebugEnabled()) {
				_log.debug(e, e);
			}
		}
	}

	/**
	 * Caches the speaker_ event in the entity cache if it is enabled.
	 *
	 * @param speaker_Event the speaker_ event
	 */
	@Override
	public void cacheResult(Speaker_Event speaker_Event) {
		entityCache.putResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventImpl.class, speaker_Event.getPrimaryKey(),
			speaker_Event);

		speaker_Event.resetOriginalValues();
	}

	/**
	 * Caches the speaker_ events in the entity cache if it is enabled.
	 *
	 * @param speaker_Events the speaker_ events
	 */
	@Override
	public void cacheResult(List<Speaker_Event> speaker_Events) {
		for (Speaker_Event speaker_Event : speaker_Events) {
			if (entityCache.getResult(
						Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
						Speaker_EventImpl.class, speaker_Event.getPrimaryKey()) == null) {
				cacheResult(speaker_Event);
			}
			else {
				speaker_Event.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all speaker_ events.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		entityCache.clearCache(Speaker_EventImpl.class);

		finderCache.clearCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the speaker_ event.
	 *
	 * <p>
	 * The {@link EntityCache} and {@link FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Speaker_Event speaker_Event) {
		entityCache.removeResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventImpl.class, speaker_Event.getPrimaryKey());

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Speaker_Event> speaker_Events) {
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Speaker_Event speaker_Event : speaker_Events) {
			entityCache.removeResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
				Speaker_EventImpl.class, speaker_Event.getPrimaryKey());
		}
	}

	/**
	 * Creates a new speaker_ event with the primary key. Does not add the speaker_ event to the database.
	 *
	 * @param id the primary key for the new speaker_ event
	 * @return the new speaker_ event
	 */
	@Override
	public Speaker_Event create(long id) {
		Speaker_Event speaker_Event = new Speaker_EventImpl();

		speaker_Event.setNew(true);
		speaker_Event.setPrimaryKey(id);

		return speaker_Event;
	}

	/**
	 * Removes the speaker_ event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param id the primary key of the speaker_ event
	 * @return the speaker_ event that was removed
	 * @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event remove(long id) throws NoSuchSpeaker_EventException {
		return remove((Serializable)id);
	}

	/**
	 * Removes the speaker_ event with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the speaker_ event
	 * @return the speaker_ event that was removed
	 * @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event remove(Serializable primaryKey)
		throws NoSuchSpeaker_EventException {
		Session session = null;

		try {
			session = openSession();

			Speaker_Event speaker_Event = (Speaker_Event)session.get(Speaker_EventImpl.class,
					primaryKey);

			if (speaker_Event == null) {
				if (_log.isDebugEnabled()) {
					_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchSpeaker_EventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(speaker_Event);
		}
		catch (NoSuchSpeaker_EventException nsee) {
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
	protected Speaker_Event removeImpl(Speaker_Event speaker_Event) {
		speaker_Event = toUnwrappedModel(speaker_Event);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(speaker_Event)) {
				speaker_Event = (Speaker_Event)session.get(Speaker_EventImpl.class,
						speaker_Event.getPrimaryKeyObj());
			}

			if (speaker_Event != null) {
				session.delete(speaker_Event);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (speaker_Event != null) {
			clearCache(speaker_Event);
		}

		return speaker_Event;
	}

	@Override
	public Speaker_Event updateImpl(Speaker_Event speaker_Event) {
		speaker_Event = toUnwrappedModel(speaker_Event);

		boolean isNew = speaker_Event.isNew();

		Speaker_EventModelImpl speaker_EventModelImpl = (Speaker_EventModelImpl)speaker_Event;

		Session session = null;

		try {
			session = openSession();

			if (speaker_Event.isNew()) {
				session.save(speaker_Event);

				speaker_Event.setNew(false);
			}
			else {
				speaker_Event = (Speaker_Event)session.merge(speaker_Event);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (!Speaker_EventModelImpl.COLUMN_BITMASK_ENABLED) {
			finderCache.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}
		else
		 if (isNew) {
			Object[] args = new Object[] { speaker_EventModelImpl.getEventId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
				args);

			args = new Object[] { speaker_EventModelImpl.getSpeakerId() };

			finderCache.removeResult(FINDER_PATH_COUNT_BY_SPEAKERID, args);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPEAKERID,
				args);

			finderCache.removeResult(FINDER_PATH_COUNT_ALL, FINDER_ARGS_EMPTY);
			finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL,
				FINDER_ARGS_EMPTY);
		}

		else {
			if ((speaker_EventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						speaker_EventModelImpl.getOriginalEventId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);

				args = new Object[] { speaker_EventModelImpl.getEventId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_EVENTID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_EVENTID,
					args);
			}

			if ((speaker_EventModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPEAKERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						speaker_EventModelImpl.getOriginalSpeakerId()
					};

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SPEAKERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPEAKERID,
					args);

				args = new Object[] { speaker_EventModelImpl.getSpeakerId() };

				finderCache.removeResult(FINDER_PATH_COUNT_BY_SPEAKERID, args);
				finderCache.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_SPEAKERID,
					args);
			}
		}

		entityCache.putResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
			Speaker_EventImpl.class, speaker_Event.getPrimaryKey(),
			speaker_Event, false);

		speaker_Event.resetOriginalValues();

		return speaker_Event;
	}

	protected Speaker_Event toUnwrappedModel(Speaker_Event speaker_Event) {
		if (speaker_Event instanceof Speaker_EventImpl) {
			return speaker_Event;
		}

		Speaker_EventImpl speaker_EventImpl = new Speaker_EventImpl();

		speaker_EventImpl.setNew(speaker_Event.isNew());
		speaker_EventImpl.setPrimaryKey(speaker_Event.getPrimaryKey());

		speaker_EventImpl.setId(speaker_Event.getId());
		speaker_EventImpl.setSpeakerId(speaker_Event.getSpeakerId());
		speaker_EventImpl.setEventId(speaker_Event.getEventId());

		return speaker_EventImpl;
	}

	/**
	 * Returns the speaker_ event with the primary key or throws a {@link com.liferay.portal.kernel.exception.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the speaker_ event
	 * @return the speaker_ event
	 * @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event findByPrimaryKey(Serializable primaryKey)
		throws NoSuchSpeaker_EventException {
		Speaker_Event speaker_Event = fetchByPrimaryKey(primaryKey);

		if (speaker_Event == null) {
			if (_log.isDebugEnabled()) {
				_log.debug(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchSpeaker_EventException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return speaker_Event;
	}

	/**
	 * Returns the speaker_ event with the primary key or throws a {@link NoSuchSpeaker_EventException} if it could not be found.
	 *
	 * @param id the primary key of the speaker_ event
	 * @return the speaker_ event
	 * @throws NoSuchSpeaker_EventException if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event findByPrimaryKey(long id)
		throws NoSuchSpeaker_EventException {
		return findByPrimaryKey((Serializable)id);
	}

	/**
	 * Returns the speaker_ event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the speaker_ event
	 * @return the speaker_ event, or <code>null</code> if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event fetchByPrimaryKey(Serializable primaryKey) {
		Serializable serializable = entityCache.getResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
				Speaker_EventImpl.class, primaryKey);

		if (serializable == nullModel) {
			return null;
		}

		Speaker_Event speaker_Event = (Speaker_Event)serializable;

		if (speaker_Event == null) {
			Session session = null;

			try {
				session = openSession();

				speaker_Event = (Speaker_Event)session.get(Speaker_EventImpl.class,
						primaryKey);

				if (speaker_Event != null) {
					cacheResult(speaker_Event);
				}
				else {
					entityCache.putResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
						Speaker_EventImpl.class, primaryKey, nullModel);
				}
			}
			catch (Exception e) {
				entityCache.removeResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
					Speaker_EventImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return speaker_Event;
	}

	/**
	 * Returns the speaker_ event with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param id the primary key of the speaker_ event
	 * @return the speaker_ event, or <code>null</code> if a speaker_ event with the primary key could not be found
	 */
	@Override
	public Speaker_Event fetchByPrimaryKey(long id) {
		return fetchByPrimaryKey((Serializable)id);
	}

	@Override
	public Map<Serializable, Speaker_Event> fetchByPrimaryKeys(
		Set<Serializable> primaryKeys) {
		if (primaryKeys.isEmpty()) {
			return Collections.emptyMap();
		}

		Map<Serializable, Speaker_Event> map = new HashMap<Serializable, Speaker_Event>();

		if (primaryKeys.size() == 1) {
			Iterator<Serializable> iterator = primaryKeys.iterator();

			Serializable primaryKey = iterator.next();

			Speaker_Event speaker_Event = fetchByPrimaryKey(primaryKey);

			if (speaker_Event != null) {
				map.put(primaryKey, speaker_Event);
			}

			return map;
		}

		Set<Serializable> uncachedPrimaryKeys = null;

		for (Serializable primaryKey : primaryKeys) {
			Serializable serializable = entityCache.getResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
					Speaker_EventImpl.class, primaryKey);

			if (serializable != nullModel) {
				if (serializable == null) {
					if (uncachedPrimaryKeys == null) {
						uncachedPrimaryKeys = new HashSet<Serializable>();
					}

					uncachedPrimaryKeys.add(primaryKey);
				}
				else {
					map.put(primaryKey, (Speaker_Event)serializable);
				}
			}
		}

		if (uncachedPrimaryKeys == null) {
			return map;
		}

		StringBundler query = new StringBundler((uncachedPrimaryKeys.size() * 2) +
				1);

		query.append(_SQL_SELECT_SPEAKER_EVENT_WHERE_PKS_IN);

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

			for (Speaker_Event speaker_Event : (List<Speaker_Event>)q.list()) {
				map.put(speaker_Event.getPrimaryKeyObj(), speaker_Event);

				cacheResult(speaker_Event);

				uncachedPrimaryKeys.remove(speaker_Event.getPrimaryKeyObj());
			}

			for (Serializable primaryKey : uncachedPrimaryKeys) {
				entityCache.putResult(Speaker_EventModelImpl.ENTITY_CACHE_ENABLED,
					Speaker_EventImpl.class, primaryKey, nullModel);
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
	 * Returns all the speaker_ events.
	 *
	 * @return the speaker_ events
	 */
	@Override
	public List<Speaker_Event> findAll() {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the speaker_ events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @return the range of speaker_ events
	 */
	@Override
	public List<Speaker_Event> findAll(int start, int end) {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the speaker_ events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of speaker_ events
	 */
	@Override
	public List<Speaker_Event> findAll(int start, int end,
		OrderByComparator<Speaker_Event> orderByComparator) {
		return findAll(start, end, orderByComparator, true);
	}

	/**
	 * Returns an ordered range of all the speaker_ events.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link Speaker_EventModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of speaker_ events
	 * @param end the upper bound of the range of speaker_ events (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @param retrieveFromCache whether to retrieve from the finder cache
	 * @return the ordered range of speaker_ events
	 */
	@Override
	public List<Speaker_Event> findAll(int start, int end,
		OrderByComparator<Speaker_Event> orderByComparator,
		boolean retrieveFromCache) {
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

		List<Speaker_Event> list = null;

		if (retrieveFromCache) {
			list = (List<Speaker_Event>)finderCache.getResult(finderPath,
					finderArgs, this);
		}

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 2));

				query.append(_SQL_SELECT_SPEAKER_EVENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_SPEAKER_EVENT;

				if (pagination) {
					sql = sql.concat(Speaker_EventModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Speaker_Event>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = Collections.unmodifiableList(list);
				}
				else {
					list = (List<Speaker_Event>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the speaker_ events from the database.
	 *
	 */
	@Override
	public void removeAll() {
		for (Speaker_Event speaker_Event : findAll()) {
			remove(speaker_Event);
		}
	}

	/**
	 * Returns the number of speaker_ events.
	 *
	 * @return the number of speaker_ events
	 */
	@Override
	public int countAll() {
		Long count = (Long)finderCache.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_SPEAKER_EVENT);

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
	public Set<String> getBadColumnNames() {
		return _badColumnNames;
	}

	@Override
	protected Map<String, Integer> getTableColumnsMap() {
		return Speaker_EventModelImpl.TABLE_COLUMNS_MAP;
	}

	/**
	 * Initializes the speaker_ event persistence.
	 */
	public void afterPropertiesSet() {
	}

	public void destroy() {
		entityCache.removeCache(Speaker_EventImpl.class.getName());
		finderCache.removeCache(FINDER_CLASS_NAME_ENTITY);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		finderCache.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@ServiceReference(type = EntityCache.class)
	protected EntityCache entityCache;
	@ServiceReference(type = FinderCache.class)
	protected FinderCache finderCache;
	private static final String _SQL_SELECT_SPEAKER_EVENT = "SELECT speaker_Event FROM Speaker_Event speaker_Event";
	private static final String _SQL_SELECT_SPEAKER_EVENT_WHERE_PKS_IN = "SELECT speaker_Event FROM Speaker_Event speaker_Event WHERE id_ IN (";
	private static final String _SQL_SELECT_SPEAKER_EVENT_WHERE = "SELECT speaker_Event FROM Speaker_Event speaker_Event WHERE ";
	private static final String _SQL_COUNT_SPEAKER_EVENT = "SELECT COUNT(speaker_Event) FROM Speaker_Event speaker_Event";
	private static final String _SQL_COUNT_SPEAKER_EVENT_WHERE = "SELECT COUNT(speaker_Event) FROM Speaker_Event speaker_Event WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "speaker_Event.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Speaker_Event exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Speaker_Event exists with the key {";
	private static final Log _log = LogFactoryUtil.getLog(Speaker_EventPersistenceImpl.class);
	private static final Set<String> _badColumnNames = SetUtil.fromArray(new String[] {
				"id"
			});
}