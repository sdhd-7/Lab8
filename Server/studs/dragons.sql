create table studs.dragons
(
    id           bigint  not null
        constraint table_name_pk
            unique,
    character    varchar not null,
    type         varchar not null,
    x            bigint  not null,
    y            bigint  not null,
    creationdate varchar not null,
    login        varchar not null,
    age          integer not null,
    speaking     boolean not null,
    name         varchar not null,
    color        integer not null
)
    using ???;

alter table studs.dragons
    owner to postgres;

