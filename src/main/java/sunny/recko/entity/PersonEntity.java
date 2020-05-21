package sunny.recko.entity;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import sunny.recko.config.dto.FamilyDto;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "person")
public class PersonEntity  {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "power")
    private int power;

    @Column(name = "universeid")
    private Long universeid;

    @Column(name = "familyid")
    private Long familyid;
}
