package kr.co.fastcampus.eatgo.interfaces;


import kr.co.fastcampus.eatgo.application.UserService;
import kr.co.fastcampus.eatgo.domain.User;
import kr.co.fastcampus.eatgo.utils.JwtUtil;
import org.dom4j.jaxb.JAXBObjectHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.net.URISyntaxException;

@RestController
public class SessionController {

    @Autowired
    private UserService userService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/session")
    public ResponseEntity<SessionResponseDto> create(
            @RequestBody SessionRequestDto resource
    ) throws URISyntaxException {

        String email = resource.getEmail();
        String password = resource.getPassword();

        User user  = userService.authenticate(email, password);

        String accessToken = jwtUtil.createToken(user.getId(), user.getName());

//        String accessToken = jwtUtil.createToken(1004L, "John");

        String uri = "/session";
        SessionResponseDto sessionResponseDto = SessionResponseDto.builder()
                .accessToken(accessToken)
                .build();


        return ResponseEntity.created(new URI(uri))
                .body(sessionResponseDto);
    }
}
