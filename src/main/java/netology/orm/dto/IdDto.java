package netology.orm.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IdDto {
    @NotBlank
    private String name;
    @NotBlank
    private String surname;
    @NotNull
    private Integer age;
}
