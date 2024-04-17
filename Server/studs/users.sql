create table studs.users
(
    login    varchar not null
        constraint users_pk_2
            unique,
    password varchar not null,
    color    integer not null
        constraint users_pk
            unique
)
    using ???;

alter table studs.users
    owner to postgres;

