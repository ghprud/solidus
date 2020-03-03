drop table message_digest if exists;

create table message_digest (
	id INT AUTO_INCREMENT PRIMARY KEY,
	message varchar(300) not null,
	digest varchar(300) not null
);

commit;