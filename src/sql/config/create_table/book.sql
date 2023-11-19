CREATE TABLE IF NOT EXISTS"Books" (
    id varchar(50) primary key,
    name varchar(200) not null,
    pageNumber int,
    releaseDate timestamp,
    idAuthor int references "Author"(id),
    topic Topic,
    status varchar(75)
);
