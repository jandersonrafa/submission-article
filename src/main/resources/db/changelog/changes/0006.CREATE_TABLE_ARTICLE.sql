create table article (
  article_id bigint auto_increment not null,
  event_id bigint not null,
  user_id bigint not null,
  title varchar(255) not null,
  resume clob not null,
  submission_date date not null,
  file_name varchar(255) not null,
  primary key (article_id),
  foreign key (user_id) references user(id),
  foreign key (event_id) references event(event_id)
)
