create table users(
username varchar_ignorecase(50) not null primary key,
password varchar_ignorecase(5) not null,
enable boolean not null
);

create table authorities(
username varchar_ignorecase(50) not null,
authorities varchar_ignorecase(50) not null
constraint fk_authorities_users foreign key(username) references users(username)

);
create unique index ix_auth_username on authorities (username, authorities);