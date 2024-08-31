package hr.algebra.computerShop.feature.user.response;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public class LoginResponse {

  private final String jwtToken;
  private final boolean isAdmin;
  private final int userId;

  @Override
  public String toString() {
    return "LoginResponse{" +
            "jwtToken='" + jwtToken + '\'' +
            ", isAdmin=" + isAdmin +
            ", userId=" + userId +
            '}';
  }
}
