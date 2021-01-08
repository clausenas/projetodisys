package br.com.projeto.repository.cargo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projeto.model.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Long> {

	Optional<Cargo> findByCargoNome(String cargoNome);
}
