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
    first_name    varchar2(30),
    lastname      varchar2(30),
    password      varchar2(50),
    position_id   number,
    constraint user_id_pk primary key ( user_id )
);
create table reimburse_request (
    reimburse_request_id   number,
    user_id                number,
    amount                 number(*,2),
    notes                  clob,
    photo_url              varchar2(100),
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
-- Add default value for logged, balance
alter table reimburse_request modify (
    amount default 0
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
create or replace trigger trg_reimburse_request_pk before
    insert on reimburse_request
    for each row
begin
    select seq_reimburse_request_pk.nextval into
        :new.reimburse_request_id
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
-- Reimburse Log
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
-- Add order:
-- position
-- reimburse_status
-- users
-- reimburse_request
-- reimburse_log