create table user_accounts
(
    id         serial       not null
        constraint user_accounts_pkey
            primary key,
    created_at date,
    first_name varchar(16)  not null,
    last_name  varchar(16)  not null,
    password   varchar(255) not null,
    role       varchar(255),
    status     varchar(255),
    user_name  varchar(16)  not null
        constraint uk_1u4s1u6ctndl9gsgnuvcw87xh
            unique
);

alter table user_accounts
    owner to postgres;

INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'admin', 'admin', '$2a$08$s/8ogJw1XPyzYwMJdY/HIOtOQWcgxQrRURnIvs1u.yGDEhmH4FSEu', 'ADMIN', 'ACTIVE', 'admin');
INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'kolobok', 'kolobok', '$2a$08$CaEYwh6UeDYs9Adimkwk4OyFygT6L/jSdfwpdJk6ZfmABPbMU0zDq', 'USER', 'ACTIVE', 'kolobok');
INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'Bunny', 'Bunny', '$2a$08$So9DOa5FIx8oiTEWLfZTku.TrVuNJsxGZruJC14SwVV2AKEczQyg6', 'USER', 'ACTIVE', 'Bunny');
INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'Fox', 'FoxFox', '$2a$08$QMCJgH7u7zxFjGnytBS.ueDrsriYNIvqewg35ERpZv6tZWvJF2qrC', 'USER', 'ACTIVE', 'Fox');
INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'Monkey', 'Monkey', '$2a$08$6l/gpWY9PTs3SxxatEuGAuhVzjLaTIfKr/69izO8t.06E3yDbYmqi', 'USER', 'ACTIVE', 'Monkey');
INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'Granny', 'Granny', '$2a$08$ifVGsCplXwDKUhNFFx5Av.huZlppOYlQtmJ13939UXGPphBHQpxxq', 'USER', 'ACTIVE', 'Granny');
INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'RedHat', 'RedHat', '$2a$08$eri9GhjA48vMMk2s2lqM4.yvxU11E8qPtsuU9BwqJCSdB3AanFy5K', 'USER', 'ACTIVE', 'RedHat');
INSERT INTO public.user_accounts (created_at, first_name, last_name, password, role, status, user_name) VALUES ('2021-06-23', 'Wolf', 'Wolf', '$2a$08$Z5TJ8RWM57nTrrG5bhseN.FfMI2SQWoLHFUwh9Nq3.QRQHo/1QiCu', 'USER', 'ACTIVE', 'Wolf');