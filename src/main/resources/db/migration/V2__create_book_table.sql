create table books (
                       id SERIAL ,
                       title varchar(128),
                       author varchar(256),
                       constraint pk_book primary key (id)
);