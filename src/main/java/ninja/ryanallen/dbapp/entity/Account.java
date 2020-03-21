package ninja.ryanallen.dbapp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document
@Data
@AllArgsConstructor
public class Account {
    @Id
    private String id;
    private String username;
    private String email;
    @CreatedDate
    private Date createdDate;
}
