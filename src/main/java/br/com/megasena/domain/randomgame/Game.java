package br.com.megasena.domain.randomgame;

import br.com.megasena.converter.IntArrayConverter;
import java.time.Instant;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Index;
import javax.persistence.PrePersist;
import javax.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(indexes = {@Index(columnList = "email")})
public class Game {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(nullable = false)
  private String email;

  @Column(nullable = false)
  @Convert(converter = IntArrayConverter.class)
  private int[] numbers;

  @Column(nullable = false, updatable = false)
  private Instant createdDate;

  @PrePersist
  private void prePersist() {
    createdDate = Instant.now();
  }

}
