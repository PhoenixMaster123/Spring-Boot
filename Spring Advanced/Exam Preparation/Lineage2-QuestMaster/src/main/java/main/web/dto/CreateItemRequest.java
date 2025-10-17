package main.web.dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import main.model.enums.ItemType;
import org.hibernate.validator.constraints.URL;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateItemRequest {

    @NotBlank
    @Size(min = 6, max = 26)
    private String name;

    @NotNull
    private ItemType type;

    @Min(1)
    @Max(3)
    private double xpBonusMultiplier;

    @NotBlank
    @URL
    private String url;

}
