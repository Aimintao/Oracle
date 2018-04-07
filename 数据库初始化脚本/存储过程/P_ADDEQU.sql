create or replace PROCEDURE P_ADDEQU 
(
 v_eid in "equipment"."e_id"%TYPE,
 v_ename in "equipment"."e_name"%TYPE,
 v_fee in "equipment"."fee"%TYPE,
 v_supplier in "equipment"."supplier"%TYPE,
 v_pid in "equipment"."p_id"%TYPE,
 v_remarks in "equipment"."remarks"%TYPE
 
)
AS 
BEGIN
  INSERT INTO "equipment"("e_id","e_name","fee","supplier","p_id","remarks")
  VALUES(v_eid,v_ename,v_fee,v_supplier,V_pid,v_remarks);
END P_ADDEQU;