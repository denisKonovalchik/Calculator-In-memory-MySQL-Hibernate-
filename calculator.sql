create table users
(
    id       int auto_increment
        primary key,
    name     varchar(30) not null,
    email    varchar(50) not null,
    password varchar(50) not null,
    constraint users_email_uindex
        unique (email)
);

create table addresses
(
    id          int auto_increment
        primary key,
    city        varchar(50) not null,
    street      varchar(50) not null,
    homeNumber  int         not null,
    apartNumber int         not null,
    user_id     int         not null,
    constraint addresses_users_id_fk
        foreign key (user_id) references users (id)
);

create table log_operations
(
    id        int auto_increment
        primary key,
    num1      double      not null,
    num2      double      not null,
    operation varchar(50) not null,
    result    double      null,
    user_id   int         not null,
    constraint log_operations_users_id_fk
        foreign key (user_id) references users (id)
);

create table telephones
(
    id      int auto_increment
        primary key,
    number  mediumtext not null,
    user_id int        not null,
    constraint telephones_users_id_fk
        foreign key (user_id) references users (id)
);


