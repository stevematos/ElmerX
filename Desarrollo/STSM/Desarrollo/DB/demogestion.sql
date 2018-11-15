drop index PERTENECE_FK;

drop index TOMA_FK;

drop index ASIENTO_PK;

drop table ASIENTO;

drop index TIENE_FK;

drop index AUTOMOVIL_PK;

drop table AUTOMOVIL;

drop index TIENE3_FK;

drop index RELATIONSHIP_3_FK;

drop index CONDUCTOR_PK;

drop table CONDUCTOR;

drop index FACULTAD_PK;

drop table FACULTAD;

drop index RELATIONSHIP_5_FK;

drop index PASAJERO_PK;

drop table PASAJERO;

drop index TIENE2_FK;

drop index USUARIO_PK;

drop table USUARIO;

drop index REALIZA_FK;

drop index VIAJE_PK;

drop table VIAJE;

/*==============================================================*/
/* Table: ASIENTO                                               */
/*==============================================================*/
create table ASIENTO (
   ID_VIAJE             SERIAL not null,
   ID_PASAJERO          SERIAL    not null,
   HORA_OCUPACION       DATE  not null,
   constraint PK_ASIENTO primary key (ID_VIAJE, ID_PASAJERO)
);

/*==============================================================*/
/* Index: ASIENTO_PK                                            */
/*==============================================================*/
create unique index ASIENTO_PK on ASIENTO (
ID_VIAJE,
ID_PASAJERO
);

/*==============================================================*/
/* Index: TOMA_FK                                               */
/*==============================================================*/
create  index TOMA_FK on ASIENTO (
ID_PASAJERO
);

/*==============================================================*/
/* Index: PERTENECE_FK                                          */
/*==============================================================*/
create  index PERTENECE_FK on ASIENTO (
ID_VIAJE
);

/*==============================================================*/
/* Table: AUTOMOVIL                                             */
/*==============================================================*/
create table AUTOMOVIL (
   ID_AUTOMOVIL         SERIAL not null,
   ID_CONDUCTOR         INT4                 not null,
   MODELO               VARCHAR(1024)        not null,
   ASIENTOS             INT4                 not null,
   SOAT                 VARCHAR(1024)        not null,
   constraint PK_AUTOMOVIL primary key (ID_AUTOMOVIL)
);

/*==============================================================*/
/* Index: AUTOMOVIL_PK                                          */
/*==============================================================*/
create unique index AUTOMOVIL_PK on AUTOMOVIL (
ID_AUTOMOVIL
);

/*==============================================================*/
/* Index: TIENE_FK                                              */
/*==============================================================*/
create  index TIENE_FK on AUTOMOVIL (
ID_CONDUCTOR
);

/*==============================================================*/
/* Table: CONDUCTOR                                             */
/*==============================================================*/
create table CONDUCTOR (
   ID_CONDUCTOR         SERIAL not null,
   ID_USUARIO           INT4                 not null,
   ID_AUTOMOVIL         INT4                 not null,
   LICENCIA             VARCHAR(1024)        not null,
   constraint PK_CONDUCTOR primary key (ID_CONDUCTOR)
);

/*==============================================================*/
/* Index: CONDUCTOR_PK                                          */
/*==============================================================*/
create unique index CONDUCTOR_PK on CONDUCTOR (
ID_CONDUCTOR
);

/*==============================================================*/
/* Index: RELATIONSHIP_3_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_3_FK on CONDUCTOR (
ID_USUARIO
);

/*==============================================================*/
/* Index: TIENE3_FK                                             */
/*==============================================================*/
create  index TIENE3_FK on CONDUCTOR (
ID_AUTOMOVIL
);

/*==============================================================*/
/* Table: FACULTAD                                              */
/*==============================================================*/
create table FACULTAD (
   ID_FACULTAD          SERIAL not null,
   NOMBRE               VARCHAR(1024)        not null,
   constraint PK_FACULTAD primary key (ID_FACULTAD)
);

/*==============================================================*/
/* Index: FACULTAD_PK                                           */
/*==============================================================*/
create unique index FACULTAD_PK on FACULTAD (
ID_FACULTAD
);

/*==============================================================*/
/* Table: PASAJERO                                              */
/*==============================================================*/
create table PASAJERO (
   ID_PASAJERO          SERIAL not null,
   ID_USUARIO           INT4                 not null,
   constraint PK_PASAJERO primary key (ID_PASAJERO)
);

/*==============================================================*/
/* Index: PASAJERO_PK                                           */
/*==============================================================*/
create unique index PASAJERO_PK on PASAJERO (
ID_PASAJERO
);

/*==============================================================*/
/* Index: RELATIONSHIP_5_FK                                     */
/*==============================================================*/
create  index RELATIONSHIP_5_FK on PASAJERO (
ID_USUARIO
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO (
   ID_USUARIO           SERIAL not null,
   ID_FACULTAD          INT4                 null,
   NOMBRE               VARCHAR(1024)        not null,
   APELLIDOS            VARCHAR(1024)        not null,
   CELULAR              VARCHAR(9)           not null,
   COD_ALUMNO           VARCHAR(8)           not null,
   USUARIO              VARCHAR(1024)        not null,
   CONTRASENA           VARCHAR(1024)        not null,
   constraint PK_USUARIO primary key (ID_USUARIO)
);

/*==============================================================*/
/* Index: USUARIO_PK                                            */
/*==============================================================*/
create unique index USUARIO_PK on USUARIO (
ID_USUARIO
);

/*==============================================================*/
/* Index: TIENE2_FK                                             */
/*==============================================================*/
create  index TIENE2_FK on USUARIO (
ID_FACULTAD
);

/*==============================================================*/
/* Table: VIAJE                                                 */
/*==============================================================*/
create table VIAJE (
   ID_VIAJE             SERIAL not null,
   ID_AUTOMOVIL         INT4                 null,
   INICIO               VARCHAR(1024)        not null,
   FIN                  VARCHAR(1024)        not null,
   CUPOS                INT4                 not null,
   CUPOS_DISPONIBLES    INT4                 not null,
   EN_CURSO             BOOL                 not null,
   constraint PK_VIAJE primary key (ID_VIAJE)
);

/*==============================================================*/
/* Index: VIAJE_PK                                              */
/*==============================================================*/
create unique index VIAJE_PK on VIAJE (
ID_VIAJE
);

/*==============================================================*/
/* Index: REALIZA_FK                                            */
/*==============================================================*/
create  index REALIZA_FK on VIAJE (
ID_AUTOMOVIL
);

alter table ASIENTO
   add constraint FK_ASIENTO_PERTENECE_VIAJE foreign key (ID_VIAJE)
      references VIAJE (ID_VIAJE)
      on delete restrict on update restrict;

alter table ASIENTO
   add constraint FK_ASIENTO_TOMA_PASAJERO foreign key (ID_PASAJERO)
      references PASAJERO (ID_PASAJERO)
      on delete restrict on update restrict;

alter table AUTOMOVIL
   add constraint FK_AUTOMOVI_TIENE_CONDUCTO foreign key (ID_CONDUCTOR)
      references CONDUCTOR (ID_CONDUCTOR)
      on delete restrict on update restrict;

alter table CONDUCTOR
   add constraint FK_CONDUCTO_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table CONDUCTOR
   add constraint FK_CONDUCTO_TIENE3_AUTOMOVI foreign key (ID_AUTOMOVIL)
      references AUTOMOVIL (ID_AUTOMOVIL)
      on delete restrict on update restrict;

alter table PASAJERO
   add constraint FK_PASAJERO_RELATIONS_USUARIO foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO)
      on delete restrict on update restrict;

alter table USUARIO
   add constraint FK_USUARIO_TIENE2_FACULTAD foreign key (ID_FACULTAD)
      references FACULTAD (ID_FACULTAD)
      on delete restrict on update restrict;

alter table VIAJE
   add constraint FK_VIAJE_REALIZA_AUTOMOVI foreign key (ID_AUTOMOVIL)
      references AUTOMOVIL (ID_AUTOMOVIL)
      on delete restrict on update restrict;
