CREATE TABLE IF NOT EXISTS usr
(
    id       INT AUTO_INCREMENT PRIMARY KEY,
    fio_encr  VARCHAR(250) UNIQUE NOT NULL
);

insert into usr (id, fio_encr) values (1,'Test Test');
insert into usr (id, fio_encr) values (2,'Adam Dulambo');