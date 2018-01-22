DROP TABLE IF EXISTS drugs;
DROP TABLE IF EXISTS measurements;
DROP TABLE IF EXISTS visits;
DROP TABLE IF EXISTS sickness_history;
DROP TABLE IF EXISTS persons;
DROP TABLE IF EXISTS doctors;
DROP TABLE IF EXISTS hospitals;

DROP SEQUENCE IF EXISTS global_seq;


CREATE SEQUENCE global_seq START 100000;
    
CREATE TABLE persons
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    full_name       text NOT NULL,
    birthdate       date NOT NULL
);

CREATE TABLE sickness_history
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    start_date      date NOT NULL,
    end_date        date,
    description     text NOT NULL,
    person_id       INTEGER,
    FOREIGN KEY (person_id) REFERENCES persons (id)
);

CREATE TABLE hospitals
(
    id                     INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    full_name              text NOT NULL,
    address                text NOT NULL,
    web_site_url           text NOT NULL,
    rate                   INTEGER,
    private_institution    boolean
);

CREATE TABLE doctors
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    full_name       text NOT NULL,
    contacts        text NOT NULL,
    specialization  text NOT NULL,
    hospital_id     INTEGER,
    FOREIGN KEY (hospital_id) REFERENCES hospitals (id)
);

CREATE TABLE visits
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    visit_date      date NOT NULL,
    next_visit_date date,
    conclusion      text NOT NULL,
    file_url        text,
    doctor_id       INTEGER NOT NULL,
    sickness_id     INTEGER NOT NULL, 
    rate            INTEGER,
    FOREIGN KEY (doctor_id) REFERENCES doctors (id),
    FOREIGN KEY (sickness_id) REFERENCES sickness_history (id)
);

CREATE TABLE measurements
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    measure_datetime TIMESTAMP NOT NULL,
    indicator_value  text NOT NULL,
    measurement_type text NOT NULL,
    person_id        INTEGER NOT NULL, 
    FOREIGN KEY (person_id) REFERENCES persons (id)
);

CREATE TABLE drugs
(
    id              INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    medicine        text NOT NULL,
    cost            INTEGER NOT NULL,
    visit_id        INTEGER NOT NULL,
    FOREIGN KEY (visit_id) REFERENCES visits (id)
);