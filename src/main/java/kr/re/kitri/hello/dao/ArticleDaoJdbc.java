package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-14.
 */

@Repository
public class ArticleDaoJdbc implements ArticleDao {

    @Autowired
    private DataSource dataSource;


    public void insertArticle(Article article) {

        //1. connection 확보
        try {
            Connection conn = dataSource.getConnection();


            //2. 쿼리를 생성 - PreparedStatement 생성
            String query =
                    "insert into article (article_id, title, author, content)\n" +
                            "values(?,?,?,?);";


            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(article.getArticleId()));
            pstmt.setString(2, article.getTitle());
            pstmt.setString(3, article.getAuthor());
            pstmt.setString(4, article.getContent());

            pstmt.executeUpdate();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * 글전체보기
     *
     * @return 전체 글 리스트
     */


    public List<Article> selectAllArticles() {

        String query =
                "SELECT article_id,title,author,content\n" +
                        "From article;";

        try {
            Connection conn = dataSource.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();


            List<Article> list = new ArrayList<>();
            Article article;
            while (rs.next()) {
                article = new Article();
                article.setArticleId(rs.getString(1));
                article.setTitle(rs.getString(2));
                article.setAuthor(rs.getString(3));
                article.setContent(rs.getString(4));

                list.add(article);
            }
            conn.close();
            return list;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    @Override
    public void updateArticle(String articleId, Article article) {

    }

    @Override
    public void deleteArticle(String articleId) {

    }


    /**
     * 글상세보기
     *
     * @param articleId 글번호
     * @return
     */
    public Article selectArticleById(String articleId) {

        String query =
                "SELECT article_id,title,author,content\n" +
                        "FROM article\n" +
                        "Where article_id= ?";

        try {
            Connection conn = dataSource.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setInt(1, Integer.parseInt(articleId));
            ResultSet rs = pstmt.executeQuery();
            rs.next();

            Article article = new Article();
            article.setArticleId(rs.getString(1));
            article.setTitle(rs.getString(2));
            article.setAuthor(rs.getString(3));
            article.setContent(rs.getString(4));

            conn.close();
            return article;


        } catch (SQLException e) {
            e.printStackTrace();
            return new Article();
        }

    }

}


