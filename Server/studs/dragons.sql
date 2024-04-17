create table studs.dragons
(
    id           bigint  not null
        constraint dragons_pk
            unique,
    name         varchar not null,
    x            integer not null,
    y            integer not null,
    creationdate varchar not null,
    age          integer not null,
    speaking     boolean not null,
    type         varchar not null,
    character    varchar not null,
    login        varchar not null,
    color        integer not null
)
    using ???;

alter table studs.dragons
    owner to postgres;

