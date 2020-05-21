package sunny.recko.config.dto;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FamilyDto {

    private Long id;
    private String name;
    private Long universeid;
    private Long familyid;

}
