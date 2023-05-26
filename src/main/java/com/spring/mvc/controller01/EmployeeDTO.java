package com.spring.mvc.controller01;

import lombok.*;

//@Data //필요 없는 것 까지 다 만들기 때문에 쓰지 않는 것을 권고
@Getter @Setter @ToString @NoArgsConstructor
public class EmployeeDTO {
    private Long id;
    private String Name;
    private String role;
}
