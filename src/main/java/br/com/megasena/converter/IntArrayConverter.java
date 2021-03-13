package br.com.megasena.converter;

import java.util.Arrays;
import java.util.stream.Collectors;
import javax.persistence.AttributeConverter;

public class IntArrayConverter implements AttributeConverter<int[], String> {

  @Override
  public String convertToDatabaseColumn(int[] ints) {
    return Arrays.stream(ints).mapToObj(Integer::toString).collect(Collectors.joining(","));
  }

  @Override
  public int[] convertToEntityAttribute(String s) {
    return Arrays.stream(s.split(",")).mapToInt(Integer::parseInt).toArray();
  }
}
