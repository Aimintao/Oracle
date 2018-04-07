create or replace FUNCTION F_GETPID 
(
  PNAME IN "project"."p_name"%TYPE
) RETURN VARCHAR2 AS 
p_id VARCHAR2(4);
BEGIN
  select "project"."p_id" INTO p_id FROM "project" WHERE "project"."p_name"=PNAME;
  RETURN p_id;
END F_GETPID;