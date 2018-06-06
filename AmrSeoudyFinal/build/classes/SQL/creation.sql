/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  1795162
 * Created: 2018-06-06
 */
drop table Livre ;
drop table  Editeur ;

create table Editeur(
id_editeur integer ,
nom_editeur varchar2(20) not null ,
type_editeur varchar2(20) not null check (type_editeur in ('Mondial','Local')),
pays_editeur varchar2(20)not null,
constraint pk_id_editure primary key (id_editeur)
);

create table Livre(
id_livre integer primary key,
categorie_livre varchar2(20) not null check (categorie_livre in('Roman','Conte','Fable')),
titre_Livre varchar2(30) not null,
annee_parution integer not null check (annee_parution > 1950) ,
nbrPages integer default 0 check (nbrPages >= 0),
nbrAuteurs integer default 0 check (nbrAuteurs > = 0 ),
editeur integer ,
constraint editeur_FK  foreign key (editeur) references Editeur(id_editeur),
constraint titre_anne_unique  unique (titre_Livre,annee_parution)
);


