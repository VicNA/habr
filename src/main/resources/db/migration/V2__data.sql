create table statuses (
    id      bigserial primary key ,
    name    varchar(150) not null
);

create table articles (
    id          bigserial    primary key,
    title       varchar(500) not null,
    content     text         not null,
    user_id     bigint       not null references users (id),
    status_id   smallint     not null references statuses (id)
);

create table categories (
    id          bigserial primary key,
    category    varchar(150) not null,
    created_at  timestamp default current_timestamp,
    updated_at  timestamp default current_timestamp
);

create table articles_categories (
    article_id  bigint  not null references articles (id),
    category_id int     not null references categories (id),
    primary key(article_id, category_id )
);

create table comments (
     id         bigserial       primary key,
     comment    varchar(1000)   not null,
     user_id    bigint          not null references users (id),
     article_id bigint          not null references articles (id)
     created_at timestamp default current_timestamp,
     updated_at timestamp default current_timestamp
);

--create table likes(
--    like_id bigserial not null primary key,
--    user_id int not null,
--    article_id int not null,
--    created_at timestamp default current_timestamp,
--    updated_at timestamp default current_timestamp
--);




insert into statuses(name)
values ('created'),
       ('moderating'),
       ('published'),
       ('hidden');

insert into articles (title, content, user_id, status_id)
values ('Заголовок статьи1', 'Тут должен быть контент статьи1', 1, 1),
       ('Заголовок статьи2', 'Тут должен быть контент статьи2', 1, 1),
       ('Заголовок статьи3', 'Тут должен быть контент статьи3', 2, 1);

insert into categories(name)
values ('Marketing'),
       ('Design'),
       ('Mobile dev'),
       ('Web dev');

insert into articles_categories (category_id, article_id)
values (1, 1),
       (2, 2),
       (3, 2),
       (4, 3);

--comment, likes