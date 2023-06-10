create table hibernate_sequence (
    next_val bigint
);

insert into hibernate_sequence values ( 1 );
insert into hibernate_sequence values ( 1 );

CREATE TABLE user (
    id BIGINT NOT NULL AUTO_INCREMENT,
    password varchar(64) not null,
    login varchar(64) not null,
    PRIMARY KEY (id)
);
CREATE TABLE plot (
    id BIGINT not null AUTO_INCREMENT,
    sizeX int,
    sizeY int,
    PRIMARY KEY (id)
);