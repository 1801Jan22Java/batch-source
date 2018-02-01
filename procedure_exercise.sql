--Stored procedures!
--Create a stored procedure that inserts 1 row into the following tables:
--BEAR
--BEAR_BEEHIVE
--BEAR_TYPE
--BEEHIVE
--CAVE

create or replace procedure bear_mutator as begin
insert into bear(bear_id,bear_name)
values(50,'Fredrik');
insert into beehive(beehive_id, BEEHIVE_WEIGHT)
values(100, 20);
insert into bear_type(BEAR_TYPE_ID, BEAR_TYPE_NAME)
values(5,'Mechanical');
insert into bear_beehive(bear_id, beehive_id)
values(50,100);
--
--insert into bear_type(BEAR_TYPE_ID, BEAR_TYPE_NAME)
--values(5,'Mechanical');
--
--insert into cave(cave_id, cave_name, max_bears)
--values(12, 'Mi Casa', 50);

end;
/
begin
bear_mutator;
end;