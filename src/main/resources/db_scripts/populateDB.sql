DELETE FROM measurements;
DELETE FROM recipes;
DELETE FROM visits;
DELETE FROM sickness_history;
DELETE FROM persons;
DELETE FROM doctors;
DELETE FROM hospitals;

ALTER SEQUENCE global_seq RESTART WITH 100000;

INSERT INTO persons(full_name, birthdate) VALUES 
    ('Савка Богдан', '2011-07-20'),
    ('Савка Марина', '1986-09-08'),
    ('Савка Андрій', '1986-06-22'),
    ('Савка Соломія', '2015-08-17');
    
INSERT INTO hospitals (full_name, address, web_site_url) VALUES
    ('Центр святої Параскеви', 'Львів, вул. Заводьська, 7', 'https://medcenter.lviv.ua/ua'),
    ('Інтерсоно', 'Львів, вул. Антоновича, 102', 'https://intersono.ua/'),
    ('Амбулаторія сімейної медицини №2', 'Львів, вул. Олени Степанівни, 35А, (032)233-12-12', 'http://3mkl.lviv.ua/news_63.html'),
    ('КУ ЛОР «Львівський регіональний фтизіопульмонологічний клінічний лікувально-діагностичний центр»', 'Львів, вул. Зелена, 477, (032) 236-89-09', 'http://lunghealth.lviv.ua');
    
INSERT INTO doctors(full_name, contacts, specialization, hospital_id) VALUES 
    ('Дзіх Наталія Богданівна', '+380989255972', 'сімейний лікар', 100006),
    ('Павлюк П.С.', 'уточнити', 'дитячий ЛОР', 100004),
    ('Кучминда Наталія Йосипівна', 'уточнити', 'провідний терапевт', 100004),
    ('Лишак Христина', 'уточнити', 'проктолог', 100004),
    ('Толох Ольга Степанівна', '(032) 236-89-31', 'пульмонолог, фтизіатр', 100007);
    
INSERT INTO sickness_history(start_date, end_date, description, person_id) VALUES
    ('2017-11-15', '2017-12-05', 'Пневмонія, Саркоїдоз', 100002),
    ('2017-12-18', '2017-12-25', 'ГРВІ', 100000);
INSERT INTO visits(visit_date, next_visit_date, conclusion, doctor_id, sickness_id) VALUES 
	('2017-11-20', '2017-11-25', 'Пневмонія', 100010, 100013),
	('2017-12-20', '2017-12-28', 'ГРВІ', 100008, 100014),
	('2017-11-23', '2017-12-08', 'Пневмонія, саркоїдоз', 100012, 100013);
INSERT INTO recipes(medicine, cost, visit_id) VALUES 
	('Медрол', 80000, 100017),
	('Нольпаза', 25000, 100017),
    ('Орасепт', 16000, 100016),
	('Назол', 5000, 100016);
INSERT INTO measurements(measure_datetime, indicator_value, measurement_type, person_id) VALUES
	('2017-11-20 12:55:37', '36.6', 'TEMPERATURE_C', 100000),
	('2017-11-20 00:00:00', '98.3', 'TEMPERATURE_F', 100001),
	('2017-11-20 00:00:00', '80/100', 'BLOOD_PRESSURE_MMHG', 100002);