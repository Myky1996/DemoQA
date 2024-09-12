package demo.element;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class UserInfo {
    public String firstName;
    public String lastName;
    public String email;
    public String gender;
    public String mobile;
    public String dob;
    public String subject;
    public String hobby;
    public String picture;
    public String address;
    public String state;
    public String city;
}
