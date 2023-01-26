package Project.Olympics.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import Project.Olympics.model.Korisnik;

@Repository
public interface KorisnikRepository extends JpaRepository<Korisnik, Long>{

	Optional<Korisnik> findFirstByKorisnickoIme(String korisnickoIme);
}
