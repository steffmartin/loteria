package br.com.megasena.domain.randomgame;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RandomGameService {

  @Autowired
  GameRepository gameRepository;

  @Transactional
  public int[] generate(String email) {
    Random random = new Random();

    Set<Integer> numbers = new HashSet<>();
    while (numbers.size() < 6) {
      numbers.add(random.nextInt(60) + 1);
    }

    Game game = new Game();
    game.setEmail(email);
    game.setNumbers(numbers.stream().sorted().mapToInt(Integer::intValue).toArray());

    gameRepository.save(game);

    return game.getNumbers();
  }

  @Transactional(readOnly = true)
  public List<int[]> history(String email) {
    return gameRepository.findAllByEmailOrderByCreatedDate(email).map(Game::getNumbers)
        .collect(Collectors.toList());
  }

}
