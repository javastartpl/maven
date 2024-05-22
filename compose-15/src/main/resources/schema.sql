create table if not exists message(
    id bigint auto_increment primary key,
    time datetime,
    author varchar(50),
    message varchar(500)
);
