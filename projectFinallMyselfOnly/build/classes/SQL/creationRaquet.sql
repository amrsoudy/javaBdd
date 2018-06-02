/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1795162
 * Created: 2018-05-31
 */

create table STATION (
nomStation varchar2(20) primary key  , 
capacite INTEGER not null , 
lieu varchar2(20) not null ,
region varchar2(20)  ,
tarif number(5,2)by default 0 ,
constraints st_tarif_check check (tarif >=0 ) ,
constraints sT_REGION_CHECK check region in ('oceon','antille','Euroupe','am','extern'),
constraints reg_lieu_uique   unique (lieu,region)


);

create table ACTIVATE(
libelle varchar2(20) ,
prix number(6.2) by default 0 ,
nomStation varchar2(20) FOREIGN key STATION(nomStation) on delete cascade on update cascade ,
constraints prix_check check (prix >=0 ) ,
constraints acticite_station_pk primary key(libelle,nomStation)
--2 PK  PUT 2 PK 
);

create table client(
id INTEGER primary key ,
nom varchar2(20) not null ,
prenom varchar2(20) not null,
ville varchar2(20) not null ,
region varchar2(20) ,
solde  number(8,2) not null by default 0,
constraints client_solde_check check(solde >= 0)
 
);
create table SEJOUR (
dateDebut DATE primary key ,
nbPlaces INTEGER not null ,
idClient  INTEGER FOREIGN key client(id) on update cascade on delete set null,
station varchar2(20) Foreign key STATION(nomStation)on delete cascade on update cascade,
constraints sejour_client_station_pk(idClient,station,dateDebut)
-- 3 PUT 3 PK 
);

