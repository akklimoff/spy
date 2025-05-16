package kg.aklimoff.spy.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class CategoryDto {
    private String id;
    private String name;
}
