package ninja.ryanallen.dbapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Data
@AllArgsConstructor
public class Game {
    @Id
    private String id;
    private String name;
    private String platform;
    private int maxPlayers;
}
