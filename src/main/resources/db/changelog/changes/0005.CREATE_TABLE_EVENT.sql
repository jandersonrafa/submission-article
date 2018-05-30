create table event (
  event_id bigint auto_increment not null,
  user_id bigint not null,
  event_name varchar(255) not null,
  event_date date not null,
  registration_start_date date not null,
  registration_end_date date not null,
  primary key (event_id),
  foreign key (user_id) references user(id)
)
