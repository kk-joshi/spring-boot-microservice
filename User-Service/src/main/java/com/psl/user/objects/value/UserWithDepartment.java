package com.psl.user.objects.value;

import com.psl.user.objects.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWithDepartment {
    private User user;
    private Department department;
}
