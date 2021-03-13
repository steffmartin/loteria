package br.com.megasena.domain.randomgame;

import static org.springframework.http.MediaType.ALL_VALUE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/lottery", consumes = ALL_VALUE, produces = APPLICATION_JSON_VALUE)
@Validated
public class RandomGameController {

  @Autowired
  RandomGameService randomGameService;

  @GetMapping(value = "/generate")
  public int[] generate(@RequestParam @NotBlank @Email String email) {
    return randomGameService.generate(email);
  }

  @GetMapping(value = "/history")
  public List<int[]> history(@RequestParam @NotBlank @Email String email) {
    return randomGameService.history(email);
  }

}
