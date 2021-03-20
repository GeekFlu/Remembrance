create table moments.epic_event(
    id_epic_event serial
        constraint epic_event_pk
            primary key,
    name varchar(250) not null,
    description text not null,
    event_date timestamp
);

