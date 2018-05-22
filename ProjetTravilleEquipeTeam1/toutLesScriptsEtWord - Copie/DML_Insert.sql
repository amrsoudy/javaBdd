--le script de i'insertion de donnes
insert into ordonnance values(1,'ne pas manger trop sale','Chirurgie',default);
insert into ordonnance values(2,'ne pas manger trop sucre','Chirurgie',to_date('2018-05-09','yyyy-mm-dd'));
insert into ordonnance values(3,'dormir sffisament','Chirurgie',to_date('2018-12-03','yyyy-mm-dd'));
insert into ordonnance values(4,'30 min de marche par jour','Medicaments',to_date('2018-11-10','yyyy-mm-dd'));
insert into ordonnance values(5,'pas de viande','Medicaments','2017-11-10');


insert into SALLE  values(100,'Operations');
insert into  salle  values(101,'Consultations');
insert into  salle  values(102,'Frants Fanon');
insert into  salle  values(103,'Pasteur');
insert into  salle  values(104,'Avesens');

insert into TYPECHIRURGIE values(10,'cardio','c''est pour le ceour ' );
insert into TYPECHIRURGIE values(11,'esthetique','c''est pour retrecir le nez ' );
insert into TYPECHIRURGIE values(12,'dentaire','c''est pour enlever une dent ' );
insert into TYPECHIRURGIE values(13,'bariatrique','c''est pour le gastro vertical' );


insert into SPECIALITE values(1000,'cariologie','maladie de cas cariologie');
insert into SPECIALITE values(1001,'endocrinologie','maladie de cas endocrinologie ');
insert into SPECIALITE values(1002,'dermatologie','maladie de cas dermatologie ');
insert into SPECIALITE values(1003,'andrologie','maladie de cas andrologie ');


insert into CATEGORIES values(200,'Analgesique','pour douleur');
insert into CATEGORIES values(201,'anti-inflammatoires','pour inflammation');
insert into CATEGORIES values(202,'antibiotique','pour mal a tete');
insert into CATEGORIES values(203,'antibacterie','pour bacterie ');


insert into SPECIALISATIONSALLE values(10,100,'2017-11-10');
insert into SPECIALISATIONSALLE values(11,101,'2017-12-10');
insert into SPECIALISATIONSALLE values(12,102,'2017-01-11');
insert into SPECIALISATIONSALLE values(13,103,'2018-11-10');

-- medicament
insert into medicament values (001, 'asperin', 150, 200);
insert into medicament values (002, 'coldstop', 176.43, 201);
insert into medicament values (003, 'tylenol', 140.82, 202);
insert into medicament values (004, 'amoxycilin', 217.89, 203);
--docteur
insert into docteur values (0011, 'Oleksendr', 'Brown', 1000, 'Montreal', '2000 ave decarie', 'Etudiant', 12);
insert into docteur values (0012, 'Hami', 'Kave', 1001, 'Montreal', '2000 ave decarie', 'Docteur', 23);
insert into docteur values (0013, 'Amr', 'Soudy', 1002, 'Toronto', '2000 ave decarie', 'Interne', 45);
insert into docteur values (0014, 'Hakim', 'Mamar', 1003, 'Montreal', '2000 ave decarie', 'Docteur', 34);
--dossierpatient
insert into dossierpatient values (701, 'Young', 'Paul', 'M', 1265436,'2006-05-14', default, 0011); 
insert into dossierpatient values (702, 'Marx', 'Richard', 'M', 1267637, '2012-05-14', default, 0012);
insert into dossierpatient values (703, 'Cary', 'Mary', 'F', 1534237, '2017-05-14', default, 0013);
insert into dossierpatient values (704, 'Denny', 'De Vito', 'M', 1263278, '2006-05-14', default, 0012);
--consultation
insert into consultation values (0011, 701, default, 'Infection', 1);
insert into consultation values (0012, 702, default, 'Inflammation', 2);
insert into consultation values (0013, 703, default, 'Alcoolisme chronique', 3);
insert into consultation values (0012, 704, default, 'Gastro-entérite', 4);
insert into consultation values (0011, 704, '2006-05-14', 'Gastro', 5);
--chirurgie
insert into chirurgie values (101, 10, 100, '2018-04-30', 830, 1100);
insert into chirurgie values (102, 11, 101, '2018-05-02', 1030, 1400);
insert into chirurgie values (103, 12, 100, '2018-06-15', 1000, 1500);
insert into chirurgie values (104, 13, 102, '2018-07-10', 830, 1100);
--ORDONNANCECHIRUGIE
insert into ORDONNANCECHIRUGIE values (1, 101, 3500);
insert into ORDONNANCECHIRUGIE values (2, 102, 3600);
insert into ORDONNANCECHIRUGIE values (2, 103, 4500);
insert into ORDONNANCECHIRUGIE values (3, 104, 4888);
--ORDONNANCEMEDICAMENTS
insert into ORDONNANCEMEDICAMENTS values (1, 001, default);
insert into ORDONNANCEMEDICAMENTS values (2,002, 2);
insert into ORDONNANCEMEDICAMENTS values (2,003, 34);
insert into ORDONNANCEMEDICAMENTS values (3,004, 56);