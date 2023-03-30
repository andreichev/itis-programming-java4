package ru.itis.u_mishi.shop.dto.auth;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class CheckCodeResponse {
    String token;
}
