create or replace procedure p_delworker
 (
 v_wid in "worker"."w_id"%TYPE
 ) 
as
 begin
  DELETE FROM "worker" WHERE "worker"."w_id"=v_wid;
 end;