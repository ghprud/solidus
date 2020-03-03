drop table message_digest if exists;

create table message_digest (
	id integer auto_increment not null,
	message varchar(300) not null,
	digest varchar(300) not null,
	primary key(id)
);

commit;