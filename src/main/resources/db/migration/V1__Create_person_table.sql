DROP TABLE IF EXISTS people;
DROP SEQUENCE IF EXISTS peop_seq_people_id;

CREATE SEQUENCE peop_seq_people_id START WITH 1;

CREATE TABLE people(
    peop_pk_people_id BIGINT PRIMARY KEY,
    peop_ch_people_name VARCHAR NOT NULL,
    peop_nu_age NUMBER NOT NULL);