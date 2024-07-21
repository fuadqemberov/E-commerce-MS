package az.company.msorder.client;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum JsonFieldName {
    MESSAGE("message");

   private final String message;
}
