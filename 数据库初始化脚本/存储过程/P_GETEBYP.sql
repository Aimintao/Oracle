create or replace PROCEDURE P_GETEBYP 
(
  PNAME IN VARCHAR2 , ENAME OUT VARCHAR2 , EFEE OUT FLOAT , ESUP OUT VARCHAR2 
) AS 
BEGIN
  select "equipment"."e_name" INTO ENAME FROM "equipment" WHERE "equipment"."p_id"=F_GETPID(PNAME);
  select "equipment"."fee" INTO EFEE FROM "equipment" WHERE "equipment"."p_id"=F_GETPID(PNAME);
  select "equipment"."supplier" INTO ESUP FROM "equipment" WHERE "equipment"."p_id"=F_GETPID(PNAME);
END P_GETEBYP;