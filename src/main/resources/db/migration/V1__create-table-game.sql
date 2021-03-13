create table game (
    id bigserial not null,
    created_date timestamp not null,
    email varchar(255) not null,
    numbers varchar(255) not null,
    primary key (id)
);
create index IDXds2rbk8ylkpjfro447n7samhb on game (email);