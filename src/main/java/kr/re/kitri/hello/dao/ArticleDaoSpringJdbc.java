package kr.re.kitri.hello.dao;

import kr.re.kitri.hello.model.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by danawacomputer on 2017-06-16.
 */

@Repository
public class ArticleDaoSpringJdbc implements ArticleDao {


    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public void insertArticle(Article article) {

        String query =
                "insert into article (article_id, title, author, content)\n" +
                        "values(?,?,?,?);";

        jdbcTemplate.update(
                query,
                Integer.parseInt(article.getArticleId()),
                article.getTitle(),
                article.getAuthor(),
                article.getContent());

    }

    @Override
    public Article selectArticleById(String articleId) {

        String query =
                " SELECT article_id,title,author,content\n" +
                        "FROM article\n" +
                        "Where article_id= ?;";

//        return jdbcTemplate.queryForObject(query,
//
//                )
//

        jdbcTemplate.queryForObject(query, new RowMapper<Article>() {
            @Override
            public Article mapRow(ResultSet rs, int i) throws SQLException {
                Article article = new Article();
                article.setArticleId(rs.getString(1));
                article.setTitle(rs.getString(2));
                article.setAuthor(rs.getString(3));
                article.setContent(rs.getString(4));
                return article;
            }
        }, Integer.parseInt(articleId));

        return null;
    }

    @Override
    public List<Article> selectAllArticles() {
        String query =
                "SELECT article_id,title,author,content" +
                        " From article;";

        return jdbcTemplate.query(query, (ResultSet rs, int i) -> {
            Article article = new Article();
            article.setArticleId(rs.getString(1));
            article.setTitle(rs.getString(2));
            article.setAuthor(rs.getString(3));
            article.setContent(rs.getString(4));
            return article;
        });

    }


    public void deleteArticle(String articleId) {

        String query = "DELETE FROM article Where article_id=?;";

        jdbcTemplate.update(query,
                Integer.parseInt(articleId));
    }

    public void updateArticle(String articleId, Article article) {

        String query = "UPDATE article SET" +
                "article_id=?, title=?, author=?, content=?\n +" +
                "WHERE article_id=?";

        jdbcTemplate.update(query,
                Integer.parseInt(article.getArticleId()),
                article.getTitle(),
                article.getAuthor(),
                article.getContent(),
                Integer.parseInt(articleId));


    }

}
