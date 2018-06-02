/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1791330
 * Created: 2018-05-28
 */

drop table SUCCURSALE;
drop table projet;
drop table piece;
drop table vendeur;
drop table vente;

--table number 1
create table SUCCURSALE(
numsuccursale integer primary key,
designation varchar(20) not null check (designation in('general','normal','partielle','specialise')),
ville varchar(20) not null,
surface double  default 0 check(surface>0),
capitale varchar(20)
 );

--table2
create table projet(
    numProjet int primary key,
    titre varchar (20) not null,
    numSuccursale int,
    budjet double default 0 check(budjet>0),
    constraint proj_numSucc_fk foreign key (numSuccursale) references succursale(numSuccursale)
);

--table3
create table piece(
numPiece int primary key,
designation varchar(20) unique check (designation in('general','normal','partielle','specialise')),
poids double unique,
couleur varchar (10) unique not null,
description varchar(30) not null,
numSuccursale int,
prixUnitaire double default 0 check(prixUnitaire>0),
quantiteStock int default 0 check(quantiteStock>0),
seuilStock int,
constraint piece_numSucc_fk foreign key (numSuccursale) references succursale(numSuccursale)
);

--table number 4
create table vendeur (
numvendeur integer primary key,
nom varchar(20) not null,
prenom varchar(20) not null,
type varchar(20) check (type in ('permanent','saisonnier')),
ville varchar(20) not null,
numsuccursale integer ,
salairefixe double ,
commision double, 
constraint vendeur_succ_fk foreign key (numsuccursale) references SUCCURSALE(numsuccursale)
);

--table5
create table vente(
numVendeur int,
numPiece int,
numProjet int,
quantite int default 0 check(quantite>0),
dateVente date not null,
constraint vente_numVendeur_fk foreign key (numVendeur) references vendeur(numVendeur),
constraint vente_numPiece_fk foreign key (numPiece) references piece(numPiece),
constraint vente_numProjet_fk foreign key (numProjet) references projet(numProjet),
primary key (numVendeur,numPiece,numProjet)
);