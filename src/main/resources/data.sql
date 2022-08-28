INSERT INTO users(username, password, enabled)
values('user', 'pass', true);

INSERT INTO users(username, password, enabled)
values('admin', 'admin', true);

INSERT INTO authorities(username,  authority)
values('admin', 'ROLE_ADMIN');

INSERT INTO authorities(username,  authority)
values('user', 'ROLE_USER');