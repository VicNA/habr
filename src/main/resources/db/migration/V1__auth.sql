create table users (
    id         bigserial primary key,
    username   varchar(36) not null,
    password   varchar(80) not null,
    email      varchar(50) unique,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table roles (
    id         bigserial primary key,
    name       varchar(50) not null,
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp
);

create table users_roles (
    user_id    bigint not null references users (id),
    role_id    bigint not null references roles (id),
    created_at timestamp default current_timestamp,
    updated_at timestamp default current_timestamp,
    primary key (user_id, role_id)
);

insert into users (username, password, email)
values ('bob', 'bob', 'bob_johnson@gmail.com'),
       ('jack', 'jack', 'jack_johnson@gmail.com');
       ('john', 'john', 'john_johnson@gmail.com');

insert into roles (name)
values ('USER'),
       ('MODERATOR'),
       ('ADMIN');

insert into users_roles (user_id, role_id)
values (1, 1),
       (2, 2),
       (3, 3);