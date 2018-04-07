/*==============================================================*/
/* Table: "worker"                                              */
/*==============================================================*/
create table "worker" 
(
   "w_id"               VARCHAR2(8)           not null,
   "w_name"             VARCHAR2(8),
   "sex"                CHAR(2),
   "age"                CHAR(2),
   "contract_date"      DATE,
   "post"               VARCHAR2(8),
   "d_id"               VARCHAR2(4),
   constraint PK_WORKER primary key ("w_id")
);

/*==============================================================*/
/* Table: "department"                                          */
/*==============================================================*/
create table "department" 
(
   "d_id"               VARCHAR2(4)           not null,
   "d_name"             VARCHAR2(16),
   "m_name"             VARCHAR2(8),   --可删除
   constraint PK_DEPARTMENT primary key ("d_id")
);

/*==============================================================*/
/* Table: "project"                                             */
/*==============================================================*/
create table "project" 
(
   "p_id"               VARCHAR2(4)           not null,
   "p_name"             VARCHAR2(16),
   "fund"               FLOAT(126),
   "type"               VARCHAR2(4),
   "signing_time"       DATE,
   "complete_time"      DATE,
   "check_time"         DATE,
   "m_id"               VARCHAR2(4),
   "remarks"            VARCHAR2(256),
   
   constraint PK_PROJECT primary key ("p_id")
);

/*==============================================================*/
/* Table: "equipment"                                           */
/*==============================================================*/
create table "equipment" 
(
   "e_id"               VARCHAR2(4)           not null,
   "e_name"             VARCHAR2(16),
   "fee"                FLOAT(126),
   "supplier"           VARCHAR2(16),
   "remarks"            VARCHAR2(256),
   "p_id"               VARCHAR2(4),
   constraint PK_EQUIPMENT primary key ("e_id")
);