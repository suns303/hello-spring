package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Amigo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by danawacomputer on 2017-06-15.
 */
@Repository
public class AmigoDao {

    @Autowired
    private DataSource dataSource;

    public void insertAmigo(Amigo amigo){
        //2. 쿼리를 생성
        String query =
                "insert into amigo (name,phone,email)\n" +
                        "values(?,?,?)";

        //1. connection 확보

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1,amigo.getName());
            pstmt.setString(2,amigo.getPhone());
            pstmt.setString(3,amigo.getEmail());
            pstmt.executeUpdate();

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

}
