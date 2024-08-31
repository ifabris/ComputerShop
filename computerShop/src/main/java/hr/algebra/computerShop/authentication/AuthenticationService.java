package hr.algebra.computerShop.authentication;

import hr.algebra.computerShop.feature.user.UserRepo;
import hr.algebra.computerShop.authentication.jwt.JwtService;
import hr.algebra.computerShop.feature.user.User;
import hr.algebra.computerShop.feature.user.Role;
import hr.algebra.computerShop.feature.user.request.LoginRequest;
import hr.algebra.computerShop.feature.user.request.RegisterRequest;
import hr.algebra.computerShop.feature.user.response.LoginResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepo userRepo;
  private final JwtService jwtService;
  private final BCryptPasswordEncoder bCryptPasswordEncoder;

  public LoginResponse login(LoginRequest request) {
    User user = userRepo.findByUsername(request.getUsername())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User not found"));

    if (!bCryptPasswordEncoder.matches(request.getPassword(), user.getPassword())) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid password");
    }

    boolean isAdmin = user.getRoles().contains(Role.ROLE_ADMIN);
    int userId = user.getId(); // Assuming User entity has a method to get user ID

    return new LoginResponse(jwtService.createJwt(user), isAdmin, userId);
  }

  public void register(RegisterRequest request) {
    try {
      User newUser = new User();
      newUser.setUsername(request.getUsername());
      newUser.setEmail(request.getEmail());
      newUser.setPassword(new BCryptPasswordEncoder().encode(request.getPassword()));
      newUser.getRoles().add(Role.ROLE_USER);

      if (Boolean.TRUE.equals(request.getIsAdmin())) {
        newUser.getRoles().add(Role.ROLE_ADMIN);
      }

      userRepo.save(newUser);
    } catch (Exception e) {
      throw new ResponseStatusException(HttpStatus.BAD_REQUEST, e.getMessage());
    }
  }


  public void logout(String token){
    jwtService.invalidateToken(token);
  }
}
