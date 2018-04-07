/*==============================================================*/
/* Table: "worker"                                              */
/*==============================================================*/
INSERT INTO "worker" VALUES ('1008', '马化腾', '男', '29', TO_DATE('20171229201245', 'YYYYMMDDHH24MISS'), '经理', '11');
INSERT INTO "worker" VALUES ('1011', '雷军', '男', '21', TO_DATE('20171220085418', 'YYYYMMDDHH24MISS'), '职员', '11');
INSERT INTO "worker" VALUES ('1006', '司马懿', '男', '56', TO_DATE('20171229202106', 'YYYYMMDDHH24MISS'), '职员', '13');
INSERT INTO "worker" VALUES ('1005', '王超', '男', '38', TO_DATE('20171018161809', 'YYYYMMDDHH24MISS'), '经理', '14');
INSERT INTO "worker" VALUES ('1001', '张三', '男', '26', TO_DATE('20171026143550', 'YYYYMMDDHH24MISS'), '职员', '11');
INSERT INTO "worker" VALUES ('1002', '李四', '男', '25', TO_DATE('20171026143733', 'YYYYMMDDHH24MISS'), '职员', '12');
INSERT INTO "worker" VALUES ('1003', '李玲', '女', '27', TO_DATE('20171026144030', 'YYYYMMDDHH24MISS'), '经理', '13');
INSERT INTO "worker" VALUES ('1004', '王五', '男', '25', TO_DATE('20171026144412', 'YYYYMMDDHH24MISS'), '经理', '14');

/*==============================================================*/
/* Table: "department"                                          */
/*==============================================================*/
INSERT INTO "department" VALUES ('11', '采购部', '1008');
INSERT INTO "department" VALUES ('12', '销售部', '1002');
INSERT INTO "department" VALUES ('13', '策划部', '1003');
INSERT INTO "department" VALUES ('14', '人事部', '1004');

/*==============================================================*/
/* Table: "project"                                             */
/*==============================================================*/
INSERT INTO "project" VALUES ('004', '跨海大桥', 300000000, '桥梁', TO_DATE('20160226150155', 'YYYYMMDDHH24MISS'), TO_DATE('20170326150206', 'YYYYMMDDHH24MISS'), TO_DATE('20171001150213', 'YYYYMMDDHH24MISS'), '1004', NULL);
INSERT INTO "project" VALUES ('001', '京沪高速', 300000, '建筑', TO_DATE('20170901145036', 'YYYYMMDDHH24MISS'), TO_DATE('20171026145042', 'YYYYMMDDHH24MISS'), TO_DATE('20171027145048', 'YYYYMMDDHH24MISS'), '1005', NULL);
INSERT INTO "project" VALUES ('002', '青藏铁路', 1500000, '建筑', TO_DATE('20170701145439', 'YYYYMMDDHH24MISS'), TO_DATE('20170901145459', 'YYYYMMDDHH24MISS'), TO_DATE('20171026145505', 'YYYYMMDDHH24MISS'), '1008', NULL);
INSERT INTO "project" VALUES ('003', '鸟巢', 30000000, '工程', TO_DATE('20170801145900', 'YYYYMMDDHH24MISS'), TO_DATE('20170901145906', 'YYYYMMDDHH24MISS'), TO_DATE('20171004145911', 'YYYYMMDDHH24MISS'), '1003', NULL);

/*==============================================================*/
/* Table: "equipment"                                           */
/*==============================================================*/
INSERT INTO "equipment" VALUES ('101', '挖掘机', 100000, '徐工', '001', NULL);
INSERT INTO "equipment" VALUES ('102', '玻璃', 10000, '通用', '003', NULL);
INSERT INTO "equipment" VALUES ('103', '铝合金', 20000, '上汽', '002', NULL);
INSERT INTO "equipment" VALUES ('104', '液晶', 50000, '京东方', '004', NULL);
INSERT INTO "equipment" VALUES ('105', '台式机', 100000, '清华同方', '003', '办公专用');
INSERT INTO "equipment" VALUES ('109', '键鼠套装', 1000, '达尔优', '003', NULL);