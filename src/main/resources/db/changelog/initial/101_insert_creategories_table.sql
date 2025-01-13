--liquibase formatted sql
--changeset Aktan:101
--passwords: 123

insert into CATEGORIES (id, name)
values ('cg001','Города'),
       ('cg002', 'Страны'),
       ('cg003', 'Развлечения'),
       ('cg004', 'Профессии'),
       ('cg005', '18+'),
       ('cg006', 'Части Тела'),
       ('cg007', 'Природа'),
       ('cg008', 'Места');

insert into WORDS (id, name, CATEGORY_ID)
values ('wd000001', 'Нью-Йорк', (select id from CATEGORIES where name like 'Города')),
       ('wd000002', 'Тюмень', (select id from CATEGORIES where name like 'Города')),
       ('wd000003', 'Киев', (select id from CATEGORIES where name like 'Города')),
       ('wd000004', 'Берлин', (select id from CATEGORIES where name like 'Города')),
       ('wd000005', 'Москва', (select id from CATEGORIES where name like 'Города')),
       ('wd000006', 'Минск', (select id from CATEGORIES where name like 'Города')),
       ('wd000007', 'Бишкек', (select id from CATEGORIES where name like 'Города')),
       ('wd000008', 'Алматы', (select id from CATEGORIES where name like 'Города')),
       ('wd000009', 'Лондон', (select id from CATEGORIES where name like 'Города')),
       ('wd000010', 'Пхе-Ян', (select id from CATEGORIES where name like 'Города')),
       ('wd000011', 'Токио', (select id from CATEGORIES where name like 'Города'));

INSERT INTO WORDS (id, name, CATEGORY_ID)
VALUES
    ('wd000012', 'Китай', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000013', 'Испания', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000014', 'Канада', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000015', 'США', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000016', 'Япония', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000017', 'Франция', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000018', 'Англия', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000019', 'Украина', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000020', 'Испания', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000021', 'Турция', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны')),
    ('wd000022', 'Белорусия', (SELECT id FROM CATEGORIES WHERE name LIKE 'Страны'));

INSERT INTO WORDS (id, name, CATEGORY_ID)
VALUES
    ('wd000023', 'Зоопарк', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000024', 'Тренажерный Зал', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000025', 'Пейнтбол', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000026', 'Ресторан', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000027', 'Кальянная', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000028', 'Компьютерный Клуб', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000029', 'Караоке', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000030', 'Кoток', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000031', 'Боулинг', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000032', 'Бар', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения')),
    ('wd000033', 'Кинотеатр', (SELECT id FROM CATEGORIES WHERE name LIKE 'Развлечения'));

INSERT INTO WORDS (id, name, CATEGORY_ID)
VALUES
    ('wd000034', 'Космонавт', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000035', 'Безработный', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000036', 'Дворник', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000037', 'Продавец', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000038', 'Сантехник', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000039', 'Преподаватель', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000040', 'Ученый', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000041', 'Блоггер', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000042', 'Повар', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии')),
    ('wd000043', 'Водитель', (SELECT id FROM CATEGORIES WHERE name LIKE 'Профессии'));

INSERT INTO WORDS (id, name, CATEGORY_ID)
VALUES
    ('wd000044', 'Презерватив', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000045', 'Оральный Секс', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000046', 'Ласки', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000047', 'Стриптиз', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000048', 'Эрекция', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000049', 'Gang-bang', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000050', 'Онанизм', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000051', 'Гомосексуализм', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000052', 'Пенис', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000053', 'Вибратор', (SELECT id FROM CATEGORIES WHERE name LIKE '18+')),
    ('wd000054', 'Нудисты', (SELECT id FROM CATEGORIES WHERE name LIKE '18+'));

INSERT INTO WORDS (id, name, CATEGORY_ID)
VALUES
    ('wd000055', 'Туловище', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000056', 'Плечи', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000057', 'Спина', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000058', 'Глаза', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000059', 'Грудь', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000060', 'Голова', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000061', 'Талия', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000062', 'Шея', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000063', 'Скелет', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000064', 'Живот', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000065', 'Ноги', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела')),
    ('wd000066', 'Руки', (SELECT id FROM CATEGORIES WHERE name LIKE 'Части Тела'));

INSERT INTO WORDS (id, name, CATEGORY_ID)
VALUES
    ('wd000067', 'Пляж', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000068', 'Остров', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000069', 'Болото', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000070', 'Озеро', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000071', 'Лес', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000072', 'Парк', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000073', 'Река', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000074', 'Поле', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа')),
    ('wd000075', 'Ледник', (SELECT id FROM CATEGORIES WHERE name LIKE 'Природа'));

INSERT INTO WORDS (id, name, CATEGORY_ID)
VALUES
    ('wd000076', 'Университет', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000077', 'Магазин', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000078', 'Банк', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000079', 'Завод', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000080', 'Больница', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000081', 'Вокзал', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000082', 'Стоматология', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000083', 'Парикмахерская', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000084', 'Салон Красоты', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000085', 'Школа', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000086', 'Автомойка', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места')),
    ('wd000087', 'Аэропорт', (SELECT id FROM CATEGORIES WHERE name LIKE 'Места'));


INSERT INTO AUTHORITIES (ID, ROLE)
VALUES
    ('rl002','ADMIN'),
    ('rl001', 'DEFAULT'),
    ('rl003','GUEST');

INSERT INTO USERS (id, nickname, email, name, surname, password, authority_id, enabled)
values ('admin', 'admin', null, null, null, '$2a$12$VY85Li9r92YdICRF3njFfeJJN3zsdzDLJKfaD5E7XZGMzxD6Kcumy', (select id from authorities where role like 'ADMIN'), true);

