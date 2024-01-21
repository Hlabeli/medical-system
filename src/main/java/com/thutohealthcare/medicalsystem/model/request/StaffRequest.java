package model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class StaffRequest implements Serializable {

    @NotBlank(message = "Staff name cannot be empty")
    @Size(min = 3, max = 80, message = "Staff name length cannot be less than 3 characters and more than 80 characters")
    private String name;

    @NotBlank(message = "Staff registration date cannot be empty")
    private String registrationDate;

}
