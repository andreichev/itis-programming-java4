package ru.itis.u_mishi.shop.dto.auth;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class SendSmsRequest {
    @NotBlank(message = "где телефон гнида?????")
    @Size(min = 5)
    private String phone;
}
