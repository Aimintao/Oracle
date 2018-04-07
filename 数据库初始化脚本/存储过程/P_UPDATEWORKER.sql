create or replace PROCEDURE P_UPDATEWORKER 
(
 v_wid in "worker"."w_id"%TYPE,
 v_wname in "worker"."w_name"%TYPE,
 v_sex in "worker"."sex"%TYPE,
 v_age in "worker"."age"%TYPE,
 v_date in VARCHAR2,
 v_post in "worker"."post"%TYPE,
 v_did in "worker"."d_id"%TYPE
)
AS 
BEGIN
  UPDATE "worker" SET "worker"."w_name" = v_wname, "worker"."sex" = v_sex,"worker"."age"=v_age,"worker"."contract_date"=F_TODATE(v_date),
  "worker"."post"=v_post,"worker"."d_id"=v_did
   WHERE "worker"."w_id" = v_wid;
END P_UPDATEWORKER;