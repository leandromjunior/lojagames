package repository;

import org.springframework.data.jpa.repository.JpaRepository;

import datasource.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long>{

}
