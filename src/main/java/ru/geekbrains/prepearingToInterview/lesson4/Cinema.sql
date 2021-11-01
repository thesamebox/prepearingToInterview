create table films
(
    id       bigserial primary key,
    title    varchar(255),
    duration int
);

insert into films (title, duration)
values ('Каждый', 120),
       ('Охотник', 60),
       ('Желает', 180);

create table seances
(
    id    bigserial primary key,
    time  varchar(255),
    price numeric(8, 2) not null
);

insert into seances (time, price)
values ('9:00', 300),
       ('11:00', 300),
       ('13:00', 400),
       ('15:00', 400),
       ('17:00', 500),
       ('19:00', 500),
       ('21:00', 800),
       ('23:00', 800);

create table seance_film
(
    film_id   bigint not null references films (id),
    seance_id bigint not null references seances (id),
    primary key (film_id, seance_id)
);

insert into seance_film (film_id, seance_id)
values (1, 1),
       (1, 2),
       (1, 3),
       (1, 4),
       (2, 4),
       (2, 5),
       (2, 6),
       (2, 7),
       (3, 6),
       (3, 7),
       (3, 8);

create table users
(
    id    bigserial primary key,
    login varchar(255),
    phone varchar(25),
);

insert into users (login, phone)
values ('Сам', '+79009000000'),
       ('Где', '+79009000001'),
       ('Сидит', '+79009000002'),

create table order
(
    id       bigserial primary key,
    film     bigint not null references seance_film (film_id),
    seance   bigint not null references seance_film (seance_id),
    quantity int
);

insert into order (film, seance, quantity)
values (2, 4, 2),
       (3, 8, 5);

create table user_order
(
    user_id  bigint not null references users (id),
    order_id bigint not null references order (id),
    primary key (user_id, order_id)
);

insert into user_order (user_id, order_id)
values (1, 1),
       (2, 2);