package br.com.megasena.domain.randomgame;

import java.util.stream.Stream;
import org.springframework.data.repository.CrudRepository;

public interface GameRepository extends CrudRepository<Game, Long> {

  Stream<Game> findAllByEmailOrderByCreatedDate(String email);

}
