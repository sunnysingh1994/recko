package sunny.recko.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "universe")
public class UniverseEntity {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String name;
}
