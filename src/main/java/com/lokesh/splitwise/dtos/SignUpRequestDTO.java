package com.lokesh.splitwise.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDTO {
    private String Name;
    private String Email;
    private String Password;
}
