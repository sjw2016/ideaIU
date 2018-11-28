import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JwtToken {
    /**
     * 公用密钥 保存在服务端
     */
    public static String SECRET = "sjw";

    /**
     * 生成token
     * @return
     * @throws Exception
     */
    public static String Token() throws Exception {
        //签发时间
        Date d = new Date();
        //过期时间1分钟过期
        Calendar time = Calendar.getInstance();
        time.add(Calendar.MINUTE,1);
        Date expiresDate = time.getTime();
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("alg","HS256");
        map.put("typ","JWT");
        String token = JWT.create().withHeader(map)//header
                .withClaim("name","aa")//payload
                .withClaim("age","11")
                .withExpiresAt(expiresDate)//设置过期时间
                .withIssuedAt(d)//设置签发时间
                .sign(Algorithm.HMAC256("SECRT"));//加密
        return token;
    }

    /**
     * 解密     * @param token
     * @return
     * @throws Exception
     */
    public static Map<String, Claim> verifToken(String token) throws Exception {
        JWTVerifier jv = JWT.require(Algorithm.HMAC256("SECRT")).build();
        DecodedJWT jwt = null;
        try {
            jwt = jv.verify(token);
        }catch (Exception e){
            throw new RuntimeException("登录已过期");
        }
        return jwt.getClaims();
    }
}
