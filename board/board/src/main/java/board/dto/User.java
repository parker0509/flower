package board.dto;

import board.board.Service.UserService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class User {
    private int userId;
    private String email;
    private String name;
    private String password;
    private String regdate; // 원래는 날짜 type으로 읽어온 후 문자열로 변환
}
