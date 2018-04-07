create or REPLACE view v_d_m
AS
select "worker"."w_id","worker"."w_name","worker"."sex","worker"."age","worker"."contract_date","worker"."post","department"."d_name"
from "worker","department"
where "worker"."w_id"="department"."m_id"


create or REPLACE view v_m_p
AS
select "worker"."w_name","project"."p_name","project"."signing_time","project"."complete_time"
from "worker","project"
where "worker"."w_id"="project"."w_id"