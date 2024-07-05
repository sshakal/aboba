create schema if not exists user_management;
create table user_management.t_users(
    id serial primary key,
    c_username varchar not null unique,
    c_password varchar
    );
create table user_management.t_roles(
    id serial primary key,
    c_role varchar not null unique
    );
create table user_management.t_users_roles(
    id serial primary key,
    id_user int not null references user_management.t_users(id),
    id_role int not null references user_management.t_roles(id)
    ) ;