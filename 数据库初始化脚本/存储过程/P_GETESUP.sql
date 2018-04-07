create or replace PROCEDURE P_GETESUP 
(
  ename in "equipment"."e_name"%TYPE,esuppelier out "equipment"."supplier"%TYPE
)
AS 
BEGIN
  select "equipment"."supplier" INTO esuppelier FROM "equipment" WHERE "equipment"."e_name"=ename;
END P_GETESUP;