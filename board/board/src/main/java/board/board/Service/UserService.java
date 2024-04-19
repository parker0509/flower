package board.board.Service;

import board.board.dao.UserDao;
import board.dto.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//@RequiredArgsConstructor // Inject 생략
public class UserService {

    private final UserDao userDao;

    public UserService (UserDao userDao){
        this.userDao=userDao;
    }

    //보통 서비스에서는 @Transactional 을 붙여서 하나의 트랙재션으로 처리하게 한다.
    //Spring Boot는 트랜잭션을 처리해주는 트랙젠션이 되어야한다.
    @Transactional
    public User addUser(String name, String email, String password){
        User user = userDao.addUser(name, email, password);
        //userDao.getLastInserId(); //
        userDao.mappingUserRole(user.getUserId()); //권한 부여
        return user;
    }
}
