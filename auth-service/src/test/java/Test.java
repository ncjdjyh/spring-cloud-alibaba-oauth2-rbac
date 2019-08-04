import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @Author: ncjdjyh
 * @FirstInitial: 2019/8/2
 * @Description: ~
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BCryptPasswordEncoder().encode("123456"));
    }
}
