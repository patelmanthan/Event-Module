create table FOO_Speaker (
	speakerId LONG not null primary key,
	userId LONG,
	firstName VARCHAR(75) null,
	lastName VARCHAR(75) null,
	email VARCHAR(75) null
);

create table FOO_Speaker_Event (
	id_ LONG not null primary key,
	speakerId LONG,
	eventId LONG
);