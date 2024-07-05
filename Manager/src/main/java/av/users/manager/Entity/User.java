package av.users.manager.Entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;


@Data
@Builder
@AllArgsConstructor
public class User {
    Integer id;
    String name;
    String email;
    Integer age;

}
