drop table reimburse_log cascade constraints;
drop table reimburse_request cascade constraints;
drop table users cascade constraints;
drop table position cascade constraints;
drop table reimburse_status cascade constraints;
drop sequence seq_users_pk;
drop sequence seq_reimburse_request_pk;
drop sequence seq_position_pk;
drop sequence seq_reimburse_log_pk;
drop sequence seq_reimburse_status_pk;
/
create table users (
    user_id       number,
    username      varchar2(20),
    first_name    varchar2(30),
    last_name     varchar2(30),
    password      varchar2(50),
    position_id   number,
    constraint user_id_pk primary key ( user_id )
);
create table reimburse_request (
    reimburse_request_id   number,
    user_id                number,
    amount                 number(*,2),
    amount_approved        number(*,2),
    reimburse_status_id    number,
    notes                  varchar2(140),
    resolved_by            number,
    photo_blob             blob,
    constraint reimburse_request_id_pk primary key ( reimburse_request_id )
);
create table position (
    position_id     number,
    position_name   varchar2(20),
    constraint position_id_pk primary key ( position_id )
);
create table reimburse_status (
    reimburse_status_id   number,
    status_name           varchar2(20),
    constraint status_id_pk primary key ( reimburse_status_id )
);
create table reimburse_log (
    reimburse_log_id       number,
    reimburse_request_id   number,
    reimburse_status_id    number,
    log_date               timestamp with local time zone,
    resolved_by            number,
    constraint reimburse_log_id_pk primary key ( reimburse_log_id )
);
/
-- Add constraints for foreign keys
alter table users
    add constraint fk_position_id foreign key ( position_id )
        references position ( position_id );
alter table reimburse_request
    add constraint fk_user_id foreign key ( user_id )
        references users ( user_id );
alter table reimburse_log
    add constraint fk_reimburse_status_id foreign key ( reimburse_status_id )
        references users ( user_id );
alter table reimburse_log
    add constraint fk_reimburse_request_id foreign key ( reimburse_request_id )
        references reimburse_request ( reimburse_request_id );
/
-- Add default value for amount, resolved by
alter table reimburse_request modify (
    amount default 0
);
alter table reimburse_request modify (
    amount_approved default 0
);
alter table reimburse_request modify (
    resolved_by default 0
);
/
-- Sequences for pk
create sequence seq_users_pk start with 1 increment by 1;
create sequence seq_reimburse_request_pk start with 1 increment by 1;
create sequence seq_position_pk start with 1 increment by 1;
create sequence seq_reimburse_log_pk start with 1 increment by 1;
create sequence seq_reimburse_status_pk start with 1 increment by 1;
/
-- Triggers to auto increment pks
-- Users
create or replace trigger trg_users_pk before
    insert on users
    for each row
begin
    select seq_users_pk.nextval into
        :new.user_id
    from dual;
end;
/
-- Position
create or replace trigger trg_position_pk before
    insert on position
    for each row
begin
    select seq_position_pk.nextval into
        :new.position_id
    from dual;
end;
/
-- Reimburse Request
-- Automatically add a 'pending' status
create or replace trigger trg_reimburse_request_pk before
    insert on reimburse_request
    for each row
begin
    select seq_reimburse_request_pk.nextval,
           1 into
        :new.reimburse_request_id,:new.reimburse_status_id
    from dual;
end;
/
-- Reimburse Status
create or replace trigger trg_reimburse_status_pk before
    insert on reimburse_status
    for each row
begin
    select seq_reimburse_status_pk.nextval into
        :new.reimburse_status_id
    from dual;
end;
/
-- Reimburse Log: automatically create a default log when
-- request is INSERTed or UPDATEd.
-- Also has another auto-add for date/time
create or replace trigger trg_reimburse_log_pk before
    insert on reimburse_log
    for each row
declare
    log_date_time   timestamp with local time zone;
begin
    log_date_time := localtimestamp;
    select seq_reimburse_log_pk.nextval,
           log_date_time into
        :new.reimburse_log_id,:new.log_date
    from dual;
end;
/
-- Reimbursement Log
-- Trigger to automatically log actions to log
-- based on changes to reimbursement changes
create or replace trigger trg_update_reimburse_log after
    update or insert on reimburse_request
    for each row
begin
    insert into reimburse_log (
        reimburse_request_id,
        reimburse_status_id,
        resolved_by
    ) values (
        :new.reimburse_request_id,
        :new.reimburse_status_id,
        :new.resolved_by
    );
end;
/
-- Insert test data
-- position
insert into position ( position_name ) values ( 'Employee' );
insert into position ( position_name ) values ( 'Manager' );


-- reimburse_status
insert into reimburse_status ( status_name ) values ( 'pending' );
insert into reimburse_status ( status_name ) values ( 'rejected' );
insert into reimburse_status ( status_name ) values ( 'approved' );


-- users
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'asdf',
    'asdf',
    'asdf',
    'asdf',
    2
);
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'mikecarl',
    'mike',
    'carlson',
    'mk',
    1
);
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'andyh',
    'andy',
    'harris',
    'andoharro',
    1
);
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'birhanp',
    'birhan',
    'payli',
    'bpayli',
    1
);
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'test',
    'test',
    'user',
    'password',
    1
);
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'schmoejoe',
    'schmoe',
    'joe',
    'js',
    1
);
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'yavadoc',
    'e',
    'e',
    'scryer',
    1
);
insert into users (
    username,
    first_name,
    last_name,
    password,
    position_id
) values (
    'super',
    'questionable',
    'language',
    'sql',
    1
);

-- reimburse_request
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    4,
    40,
    'reimbursement for plane'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    1,
    200,
    '5 star meal'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    1,
    1000,
    'testing funds'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    5,
    1000,
    'testing funds'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    7,
    250,
    'OCA'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    8,
    10.08,
    'aws?'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    1,
    500.00,
    'more test funds'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    6,
    6.00,
    'ES6'
);
insert into reimburse_request (
    user_id,
    amount,
    notes
) values (
    2,
    15.00,
    'rock climbing'
);

-- reimburse_log test
-- Since everything in the log is done via a trigger,
-- this is a test to see if updates work.
update reimburse_request
    set
        resolved_by = 1,
        reimburse_status_id = 2
where reimburse_request_id = 5;