--script de requetes


--affiche le nombrede consulatation par docteurs
select d.matricule, d.nomm, d.prenomm, count(c.codedocteur)
from docteur d, consultation c
where d.MATRICULE = c.CODEDOCTEUR
group by d.matricule, d.nomm, d.prenomm;

--afficher le nombre de consultation par anne
select to_char(datec,'YYYY'), count(codedocteur)
from consultation
group by to_char(datec,'YYYY');

--------------------------------
--afficher le nombre de chirurgies par docteur
select matricule ,count(idchir) "number de chirurgie"
from CHIRURGIE join ORDONNANCECHIRUGIE using(idchir) 
join CONSULTATION using (numord)
join docteur on (codedocteur=matricule)
group by matricule;


--afficher le nombre de medicaments par decteur
select MATRICULE ,count(idmed) from MEDICAMENT 
join ORDONNANCEMEDICAMENTS using (idmed)
join CONSULTATION using (NUMORD)
join docteur on (CODEDOCTEUR=MATRICULE) group by MATRICULE;

--afficher le nombre de medicament par docteur et par anne 
select MATRICULE ,to_char(datec,'yyyy') Anne,count(idmed) NoMedicament from MEDICAMENT 
join ORDONNANCEMEDICAMENTS using (idmed)
join CONSULTATION using (NUMORD)
join docteur on (CODEDOCTEUR=MATRICULE) 
group by MATRICULE ,to_char(datec,'yyyy');