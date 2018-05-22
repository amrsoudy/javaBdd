--le script de creation de tables
drop table salle cascade constraints purge;
drop table typechirurgie cascade constraints purge;
drop table specialite cascade constraints purge;
drop table categories cascade constraints purge;
drop table specialisationsalle cascade constraints purge;
drop table medicament cascade constraints purge;
drop table ordonnancemedicaments cascade constraints purge;
drop table ordonnance cascade constraints purge;
drop table docteur cascade constraints purge;
drop table dossierpatient cascade constraints purge;
drop table consultation cascade constraints purge;
drop table chirurgie cascade constraints purge;
drop table ordonnancechirugie cascade constraints purge;



create table ordonnance(
    numord integer,
    recommandations varchar2(50),
    typeo varchar2(20),
    datec date default to_char(sysdate,'yyyy-MM-dd') ,
    constraint ord_numord_pk primary key (numord) ,
    constraint ord_typo_ck check(typeo in ('Chirurgie','Medicaments'))
);
create table salle(
	idSalle integer,
	nom varchar2(20),
	constraint salle_id_pk primary key(idSalle)
);

create table typechirurgie(
    idtype integer,
    nom varchar2(20),
    description varchar2(50),
    constraint typchir_id_pk primary key (idtype)
);
create table specialite(
	code integer,
	titre varchar2(20) not null,
	description varchar2(50),
	constraint spec_code_pk primary key(code)
);

create table categories(
	idCategorie integer,
	nom varchar2(20),
	description varchar2(20),
	constraint categ_idCategorie_pk primary key(idCategorie)
);

create table specialisationsalle(
    idtype integer,
    idsalle integer,
    datec date,
    constraint spec_idtype_fk foreign key (idtype) references typechirurgie(idtype), 
    constraint spec_idsalle_fk foreign key (idsalle) references salle(idsalle),
    constraint specsalle_pk primary key (idtype, idsalle) 
);
create table medicament(
	idmed integer,
	nomMed varchar2(20) not null,
	prix number (6,2) default 0,
	categorie integer,
        constraint med_idmed_pk primary key (idmed),
	constraint prix_check check(prix>=0),
        constraint med_nom_cat_u unique(nomMed,categorie),
	constraint medic_categorie_fk foreign key(categorie) references categories(idCategorie)
);


create table docteur(
    matricule integer,
    nomM varchar2(20) not null,
    prenomM varchar2(20) not null,
    specialite integer ,
    ville varchar2(10),
    adresse varchar2(30),
    niveau varchar2(20),
    nbrpatients integer default 0,
    constraint doc_matricule_pk primary key (matricule),
    constraint doc_specialite_fk foreign key (specialite)references specialite(code),
    constraint doc_niveau_ck  check(niveau in('Etudiant','Interne','Docteur'))
 
);
create table dossierpatient(
    numdos integer ,
    nomP varchar2(20) not null,
    prenomP varchar2(20) not null,
    genre varchar2(1),
    numas varchar2(20) ,
    datenaiss date,
    datec date default sysdate,
    matricule integer,
    constraint dp_numdos_pk primary key (numdos),
    constraint dp_matricule_fk foreign key (matricule)references docteur(matricule),
    constraint dp_genre_chk check(genre in('M','F')),
    constraint dp_numas_unique unique(numas)    
);

create table consultation(
    codedocteur integer,
    numdos integer,
    datec date default sysdate,
    diagnostic varchar2(50) not null,
    numord integer,
    constraint cons_co_num_date_pk primary key(codedocteur,numdos,datec),
    constraint cons_codedocteur_fk foreign key (codedocteur)references docteur(matricule),
    constraint cons_numdos_fk foreign key (numdos) references dossierpatient(numdos) ,
    constraint cons_numord_fk foreign key (numord) references ordonnance(numord) 
);

create table chirurgie (
idchir integer,
idtype integer,
idsalle  integer,
datechirurgie date default sysdate,
heuredebut integer ,
heurefin integer,
constraint chirurgie_idchir_pk primary key(idchir),
constraint chirurgie_idtype_fk foreign key (idtype)references typechirurgie(idtype),
constraint chirurgie_idsalle_fk foreign key (idsalle)references salle(idsalle)

);

create table ordonnancechirugie(
    numord integer,
    idchir integer,
    rang integer,
    constraint oc_numord_idchir_pk primary key(numord,idchir),
    constraint oc_numord_fk foreign key (numord)references ordonnance(numord),
    constraint oc_num_rang_u unique(numord,rang),
    constraint oc_idchir_fk foreign key (idchir)references chirurgie(idchir)
    
);


create table ordonnancemedicaments(
    numord integer,
    idmed integer,
    nbboites integer default 0,
    constraint ordM_ordmed_pk primary key (numord,idmed),
    constraint ordM_numord_fk foreign key (numord) references ordonnance(NUMORD), 
    constraint ordM_idmed_fk foreign key (idmed) references medicament(idmed),
     constraint ordM_nbboites_check check(nbboites>=0)
);