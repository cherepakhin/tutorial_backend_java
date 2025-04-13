CREATE table if not exists tutorial
(
    "n"            serial not null UNIQUE,
    "title"     varchar(120) not null default '',
    "description"      varchar(120) not null default '',
    "submitted"    BOOLEAN not null default false,
    CONSTRAINT tutorial_pkey PRIMARY KEY (n)
);

-- default value for null director
insert into tutorial(n) values (-1);
