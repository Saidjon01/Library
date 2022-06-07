package templates;

import lombok.*;
import role.BookRole;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Book {
    private String name;
    private BookRole role;
    private String author;

   private String id = UUID.randomUUID().toString();
   private String rentedTo = " ";

    @Override
    public String toString() {
        return "\nBook{" +
                "\nname='" + name +
                "\nauthor='" + author +
                "\n role=" + role +
                "\n id='" + id +
                '}';
    }
}
