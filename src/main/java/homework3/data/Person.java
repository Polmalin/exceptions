package homework3.data;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Person {
    private String lastName;
    private String firstName;
    private String secondName;
    private String birthDate;
    private String phone;
    private String gender;
}
