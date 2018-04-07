create or replace PROCEDURE P_FDMANAGER 
(
  dname in "V_D_M"."d_name"%TYPE,
  wid out "V_D_M"."w_id"%TYPE,
  wname out "V_D_M"."w_name"%TYPE,
  sex out "V_D_M"."sex"%TYPE,
  age out "V_D_M"."age"%TYPE,
  contracttime out "V_D_M"."contract_date"%TYPE,
  post out "V_D_M"."post"%TYPE
  --dname out "V_D_M"."post"%TYPE
)
AS 
BEGIN
  select "V_D_M"."w_id" into wid FROM "V_D_M" where "V_D_M"."d_name"=dname;
  select "V_D_M"."w_name" into wname FROM "V_D_M" where "V_D_M"."d_name"=dname;
  select "V_D_M"."sex" into sex FROM "V_D_M" where "V_D_M"."d_name"=dname;
  select "V_D_M"."age" into age FROM "V_D_M" where "V_D_M"."d_name"=dname;
  select "V_D_M"."contract_date" into contracttime FROM "V_D_M" where "V_D_M"."d_name"=dname;
  select "V_D_M"."post" into post FROM "V_D_M" where "V_D_M"."d_name"=dname;
END P_FDMANAGER;