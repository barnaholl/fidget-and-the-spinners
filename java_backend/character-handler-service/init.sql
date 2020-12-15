create table if not exists equipment
(
    id bigint not null
        constraint equipment_pkey
            primary key
);

create table if not exists inventory
(
    id bigint not null
        constraint inventory_pkey
            primary key
);

create table if not exists item
(
    id           bigint not null
        constraint item_pkey
            primary key,
    equipment_id bigint
        constraint fkdu3d79j0akjt04hmxgdnoaynb
            references equipment,
    inventory_id bigint
        constraint fk69jrwlwin8x1qcbmg3k8ut7w1
            references inventory
);

create table if not exists statistics
(
    id              bigint  not null
        constraint statistics_pkey
            primary key,
    algorithm       integer not null,
    clean_code      integer not null,
    design          integer not null,
    energy_level    integer not null,
    motivation      integer not null,
    problem_solving integer not null,
    testing         integer not null
);

create table if not exists character
(
    id                      bigint  not null
        constraint character_pkey
            primary key,
    character_currency      bigint,
    character_experience    bigint,
    character_level         integer not null,
    character_name          varchar(255),
    character_equipment_id  bigint
        constraint fkmnieykt05b1gj2mnjdgk8w21c
            references equipment,
    character_inventory_id  bigint
        constraint fkpv2n04xgv12b4y6vi1rf91eq7
            references inventory,
    character_statistics_id bigint
        constraint fkta6cf8escsj2ymtlb6uun5dfi
            references statistics
);

