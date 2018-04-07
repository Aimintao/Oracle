create or replace PROCEDURE P_ISFINISHED 
(
  mname in "V_M_P"."w_name"%TYPE,
  completetime out "V_M_P"."complete_time"%TYPE,
  signingtime out "V_M_P"."signing_time"%TYPE,
  pname out "V_M_P"."p_name"%TYPE
)
AS 
BEGIN
  SELECT "V_M_P"."complete_time" into completetime FROM "V_M_P" where "V_M_P"."w_name"=mname;
  SELECT "V_M_P"."signing_time" into signingtime FROM "V_M_P" where "V_M_P"."w_name"=mname;
  SELECT "V_M_P"."p_name" into pname FROM "V_M_P" where "V_M_P"."w_name"=mname;
END P_ISFINISHED;