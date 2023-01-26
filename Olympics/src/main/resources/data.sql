INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (1,'miroslav@maildrop.cc','miroslav','$2y$12$NH2KM2BJaBl.ik90Z1YqAOjoPgSd0ns/bF.7WedMxZ54OhWQNNnh6','Miroslav','Simic','ADMIN');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (2,'tamara@maildrop.cc','tamara','$2y$12$DRhCpltZygkA7EZ2WeWIbewWBjLE0KYiUO.tHDUaJNMpsHxXEw9Ky','Tamara','Milosavljevic','KORISNIK');
INSERT INTO korisnik (id, e_mail, korisnicko_ime, lozinka, ime, prezime, uloga)
              VALUES (3,'petar@maildrop.cc','petar','$2y$12$i6/mU4w0HhG8RQRXHjNCa.tG2OwGSVXb0GYUnf8MZUdeadE4voHbC','Petar','Jovic','KORISNIK');
              
INSERT INTO country (id, name, mark) VALUES (1, 'Srbija', 'SRB');
INSERT INTO country (id, name, mark) VALUES (2, 'Rusija', 'RUS');
INSERT INTO country (id, name, mark) VALUES (3, 'Kina', 'CHN');
INSERT INTO country (id, name, mark) VALUES (4, 'Italija', 'ITA');

INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (1, 'Milica Mandic', 1, '1991-12-06', 1);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (2, 'Damir Mikec', 1, '1984-03-31', 1);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (3, 'Dusko Pjetlovic', 1, '1985-04-25', 1);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (4, 'Dusan Domovic', 1, '1985-10-23', 1);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (5, 'Mariya Lasitskene', 1, '1993-01-14', 2);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (6, 'Albert Batyrgaziev', 1, '1998-06-23', 2);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (7, 'Vitalina Batsarashkina', 3, '1996-10-01', 2);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (8, 'Evgeny Rylov', 3, '1996-09-23', 2);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (9, 'Yufei Zhang', 4, '1998-04-19', 3);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (10, 'Meng Chen', 2, '1994-01-15', 3);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (11, 'Qian Yang', 2, '1996-06-17', 3);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (12, 'Siyi Xie', 2, '1996-03-28', 3);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (13, 'Tingmao Shi', 2, '1991-08-31', 3);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (14, 'Luigi Samele', 2, '1987-07-25', 4);
INSERT INTO competitor (id, name_and_surname, num_of_medals, date_of_birth, country_id) VALUES (15, 'Alessandro Miressi', 2, '1998-10-02', 4);


INSERT INTO entry (id, date_of_entry, discipline, competitor_id) VALUES (1, '2022-10-10', 'Plivanje', 1);
INSERT INTO entry (id, date_of_entry, discipline, competitor_id) VALUES (2, '2022-11-11', 'Skok u vis', 13);
INSERT INTO entry (id, date_of_entry, discipline, competitor_id) VALUES (3, '2022-09-03', 'Biciklizam', 9);
INSERT INTO entry (id, date_of_entry, discipline, competitor_id) VALUES (4, '2022-08-07', 'Trcanje', 4);