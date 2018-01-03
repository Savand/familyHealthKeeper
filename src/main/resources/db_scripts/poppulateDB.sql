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
    ('Амбулаторія сімейної медицини №2', 'Львів, вул. Олени Степанівни, 35А, (032)233-12-12', 'http://3mkl.lviv.ua/news_63.html');
    
INSERT INTO doctors(full_name, contacts, specialization, hospital_id) VALUES 
    ('Дзіх Наталія Богданівна', '+380989255972', 'сімейний лікар', 100006),
    ('Павлюк П.С.', 'уточнити', 'дитячий ЛОР', 100004);
    
INSERT INTO sickness_history(start_date, end_date, description, person_id) VALUES
    ('11-15-2017', '12-05-2017', 'Пневмонія, Саркоїдоз', 100002),
    ('12-18-2017', '12-25-2017', 'ГРВІ', 100000);
    