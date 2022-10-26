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

create table articles (
    id          bigserial primary key,
    title       varchar(500) not null,
    content     text not null,
    user_id     bigint not null references users (id),
    status_id   smallint not null,
);

create table categories (
    id          bigserial primary key,
    category    varchar(150) not null,
);

create table articles_categories (
    article_id  bigint,
    category_id bigint,
    primary key(article_id, category_id ),
    CONSTRAINT fk_category_id FOREIGN KEY(category_id) REFERENCES categories(category_id),
    CONSTRAINT fk_article_id FOREIGN KEY(article_id) REFERENCES articles(article_id)
);

create table statuses (
    id bigint not null primary key ,
    status_name varchar(150) not null
);

create table comments(
     comment_id serial not null primary key,
     text varchar(1000) not null,
     user_id int not null,
     article_id int not null,
     dt_created timestamp not null default now(),
     CONSTRAINT comments_fk_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
     CONSTRAINT comments_fk_article_id FOREIGN KEY(article_id) REFERENCES articles(article_id)
);


create table likes(
    like_id bigserial not null primary key,
    user_id int not null,
    article_id int not null,
    dt_created timestamp not null default now(),
    CONSTRAINT likes_fk_user_id FOREIGN KEY(user_id) REFERENCES users(user_id),
    CONSTRAINT likes_fk_article_id FOREIGN KEY(article_id) REFERENCES articles(article_id)
);