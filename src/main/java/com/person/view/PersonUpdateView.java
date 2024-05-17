package com.person.view;

import com.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PersonUpdateView {

    private User user;
    private String firstName;
    private String surname;
    private String email;
}
