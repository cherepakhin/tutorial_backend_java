CREATE table if not exists tutorial
(
    "n"             serial not null UNIQUE,
    "title"         varchar(120) not null default '',
    "description"   varchar(120) not null default '',
    "submitted"     boolean not null default false,
    CONSTRAINT tutorial_pkey PRIMARY KEY (n)
);


