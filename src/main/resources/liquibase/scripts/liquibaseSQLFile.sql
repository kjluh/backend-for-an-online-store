-- liquibase formatted sql

--changeSet Anatoly:1
CREATE TABLE user_entity
(
    id                    int generated by default as identity primary key,
    avatar_user_entity_id int,
    role                  text,
    username              text unique,
    password              text,
    first_name            text,
    last_name             text,
    phone                 text
);

--changeSet Konstantin:2
CREATE TABLE ads_entity
(
    id          int generated by default as identity primary key,
    author_id   int,
    title       text,
    description text,
    price       int,
    created_at  timestamp
);

--changeSet Konstantin:3
CREATE TABLE ads_image
(
    id           int generated by default as identity primary key,
    ads_id       int,
    data         bytea,
    file_size    bigint,
    file_path    text,
    content_type text
);

--changeSet Konstantin:4
INSERT INTO user_entity(role, username, password, first_name, last_name, phone)
VALUES ('ADMIN', 'user@gmail.com', '$2a$12$r5kvsAvblFXSPSyv5EfQt.W6TAppM3vg83Sz0NPOINYLnixK0JUf2', 'John', 'Smith', '+79998887766');
-- пароль : password

--changeSet Konstantin:5
CREATE TABLE avatar_user_entity
(
    id         int generated by default as identity primary key,
    data       oid,
    file_size  bigint,
    file_path  text,
    media_type text
);

--changeSet Stepan:6
CREATE TABLE comment_entity
(
    id           int generated by default as identity primary key,
    author_id    int,
    create_time  timestamp,
    comment_text text,
    ads_id       int
);

--changeSet Anatoly:7
-- ALTER TABLE avatar_user_entity DROP COLUMN file_path;
ALTER TABLE avatar_user_entity DROP COLUMN file_size;

--changeSet Konstantin:8
ALTER TABLE ads_image DROP COLUMN data;