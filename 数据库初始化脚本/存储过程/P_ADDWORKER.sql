create or replace PROCEDURE P_ADDWORKER 
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
  INSERT INTO "worker"("w_id","w_name","sex","age","contract_date","post","d_id")
  VALUES(v_wid,v_wname,v_sex,v_age,F_TODATE(v_date),v_post,v_did);
END P_ADDWORKER;