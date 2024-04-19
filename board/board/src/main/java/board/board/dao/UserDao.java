package board.board.dao;

import board.dto.User;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.jdbc.core.simple.SimpleJdbcInsertOperations;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.naming.Name;
import javax.sql.DataSource;

//spring이 관리하는 bean

@Repository
public class UserDao {

    private final NamedParameterJdbcTemplate jdbcTemplate;
    private final SimpleJdbcInsertOperations insertUser;

    public UserDao(DataSource dataSource) {
        jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        insertUser = new SimpleJdbcInsert(dataSource)
                .withTableName("user")
                .usingGeneratedKeyColumns("user_id");
    }

    //Spring JDBC를 이용한 코드.

    @Transactional
    public User addUser(String email, String name, String password) {

        User user = new User();

        user.setName(name);
        user.setEmail(email);
        user.setPassword(password);
        user.setRegdate(new java.util.Date().toString());

        SqlParameterSource params = new BeanPropertySqlParameterSource(user);
        Number number = insertUser.executeAndReturnKey(params); //insert를 실행하고 , 자동으로 생성된 id를 가져온다.
        int userid=number.intValue();
        user.setUserId(userid);

        return user;
    }

    /*    public int getLastInserId(){
        return 0;
    }
    만들때 확인할수있게 같이 만든다.
    */
    @Transactional
    public void mappingUserRole(int userId) {

        String sql = "insert into user_role( user_id, role_id) values (:user, 1)";
        SqlParameterSource params = new MapSqlParameterSource("userId",userId);
        jdbcTemplate.update(sql,params);
    }
}
