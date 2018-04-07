create or replace PROCEDURE P_GETEFEE 
(
  ename in "equipment"."e_name"%TYPE,efee out "equipment"."fee"%TYPE
)
AS 
BEGIN
  select "equipment"."fee" INTO efee FROM "equipment" WHERE "equipment"."e_name"=ename;
END P_GETEFEE;