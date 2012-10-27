drop table "ADMIN"."DOCTORS" cascade constraints PURGE;
drop table "ADMIN"."DOCTORS_SPECIALTIES" cascade constraints PURGE;
drop table "ADMIN"."PATIENTS" cascade constraints PURGE;
drop table "ADMIN"."PERSONS" cascade constraints PURGE;
drop table "ADMIN"."SPECIALTIES" cascade constraints PURGE;
drop table "ADMIN"."TITLES" cascade constraints PURGE;
drop table "ADMIN"."VISITS" cascade constraints PURGE;

drop sequence "ADMIN"."PERSONS_SEQ";
drop sequence "ADMIN"."SPECIALTIES_SEQ";
drop sequence "ADMIN"."TITLES_SEQ";
drop sequence "ADMIN"."VISITS_SEQ";

create table PERSONS (
  "ID" NUMBER(10,0) not null,
  FIRST_NAME NVARCHAR2(50) not null,
  LAST_NAME NVARCHAR2(50) not null,
  constraint PERSONS_PK primary key ("ID") ); 

create sequence PERSONS_SEQ;

create table PATIENTS (
  "ID" NUMBER(10,0) not null,
  AGE NUMBER(10,0) not null,
  EGN NVARCHAR2(25) not null,
  constraint PATIENTS_PK primary key ("ID") );

create table DOCTORS (
  "ID" NUMBER(10,0) not null,
  TITLE_ID NUMBER(10,0) not null,
  constraint DOCTORS_PK primary key ("ID") );

create table TITLES (
  "ID" NUMBER(10,0) not null,
  NAME NVARCHAR2(20) not null,
  constraint TITLES_PK primary key ("ID") ); 

create sequence TITLES_SEQ;

create table VISITS (
  "ID" NUMBER(10,0) not null,
  "DATE" DATE not null,
  PRICE NUMBER(10,2) not null,
  DIAGNOSE NVARCHAR2(50) not null,
  PATIENT_ID NUMBER(10,0) not null,
  DOCTOR_ID NUMBER(10,0) not null,
  constraint VISITS_PK primary key ("ID") );

create sequence VISITS_SEQ;

create table SPECIALTIES(
  "ID" NUMBER(10,2) not null,
  NAME NVARCHAR2(20) not null,
  constraint SPECIALTIES_PK primary key ("ID") );

create sequence SPECIALTIES_SEQ;

create table DOCTORS_SPECIALTIES(
  DOCTOR_ID NUMBER(10,0) not null,
  SPECIALTY_ID NUMBER(10,0) not null,
  constraint DOCTORS_SPECIALTIES_PK primary key (DOCTOR_ID, SPECIALTY_ID) );

alter table PATIENTS
  add constraint PATIENTS_PERSONS_FK foreign key ("ID")
  references PERSONS ("ID");

alter table DOCTORS
  add constraint DOCTORS_PERSONS_FK foreign key ("ID")
  references PERSONS ("ID"); 

alter table DOCTORS
  add constraint DOCTORS_TITLES_FK foreign key (TITLE_ID)
  references TITLES ("ID"); 

alter table VISITS
  add constraint VISTIS_PATIENTS_FK foreign key (PATIENT_ID)
  references PATIENTS ("ID"); 

alter table VISITS
  add constraint VISTIS_DOCTORS_FK foreign key (DOCTOR_ID)
  references DOCTORS ("ID");

alter table DOCTORS_SPECIALTIES
  add constraint DOCTORS_SPECIAL_DOCTORS_FK foreign key (DOCTOR_ID)
  references DOCTORS ("ID");

alter table DOCTORS_SPECIALTIES
  add constraint DOCTORS_SPECIAL_SPECIALTIES_FK foreign key (SPECIALTY_ID)
  references SPECIALTIES ("ID");

insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (1, 'Mladena', 'Geleva');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (2, 'Svetoslav', 'Goranov');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (3, 'Ivan', 'Petrov');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (4, 'Elena', 'Dimitrova');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (5, 'Ivo', 'Donkov');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (6, 'Ema', 'Koleva');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (7, 'Gregory', 'House');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (8, 'Teodora', 'Simeonova');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (9, 'Dimityr', 'Stoqnov');
insert into PERSONS ("ID", FIRST_NAME, LAST_NAME)
values (10, 'Vanq', 'Genadieva');

insert into PATIENTS ("ID", AGE, EGN)
values (1,27,8505081111);
insert into PATIENTS ("ID", AGE, EGN)
values (2,27,8502082222);
insert into PATIENTS ("ID", AGE, EGN)
values (3,30,8205083333);
insert into PATIENTS ("ID", AGE, EGN)
values (4,62,5003244444);
insert into PATIENTS ("ID", AGE, EGN)
values (5,31,8812045555);

insert into TITLES("ID", "NAME")
values (1,'PROFFESSOR');
insert into TITLES("ID", "NAME")
values (2,'DOCTOR');
insert into TITLES("ID", "NAME")
values (3,'DOCENT');

insert into DOCTORS ("ID", TITLE_ID)
values (6,1);
insert into DOCTORS ("ID", TITLE_ID)
values (7,2);
insert into DOCTORS ("ID", TITLE_ID)
values (8,3);
insert into DOCTORS ("ID", TITLE_ID)
values (9,1);
insert into DOCTORS ("ID", TITLE_ID)
values (10,2);

insert into SPECIALTIES("ID", "NAME")
values (1,'IMMUNOLOGY');
insert into SPECIALTIES("ID", "NAME")
values (2,'CARDIOLOGY');
insert into SPECIALTIES("ID", "NAME")
values (3,'DERMATOLOGY');
insert into SPECIALTIES("ID", "NAME")
values (4,'ENDOCRINOLOGY');
insert into SPECIALTIES("ID", "NAME")
values (5,'HEMATOLOGY');
insert into SPECIALTIES("ID", "NAME")
values (6,'OSTEOPATHY');
insert into SPECIALTIES("ID", "NAME")
values (7,'PEDIATRICS');
insert into SPECIALTIES("ID", "NAME")
values (8,'EARS-NOSE-THROAT');

insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (6,1);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (8,2);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,1);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,2);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,3);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,4);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,5);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,6);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,7);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (7,8);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (9,5);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (9,7);
insert into DOCTORS_SPECIALTIES(DOCTOR_ID, SPECIALTY_ID)
values (10,8);

insert into VISITS("ID", "DATE", PRICE, DIAGNOSE, PATIENT_ID, DOCTOR_ID)
values (1, '01-AUG-2012', 20.55, 'incurable stupidity', 1, 6);
insert into VISITS("ID", "DATE", PRICE, DIAGNOSE, PATIENT_ID, DOCTOR_ID)
values (2, '23-SEP-2012', 12.60, 'lazyness', 2, 7);
insert into VISITS("ID", "DATE", PRICE, DIAGNOSE, PATIENT_ID, DOCTOR_ID)
values (3, '10-OCT-2012', 4.16, 'needs some happy pills', 1, 8);

commit;