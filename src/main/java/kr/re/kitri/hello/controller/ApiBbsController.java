package kr.re.kitri.hello.controller;

import kr.re.kitri.hello.model.Article;
import kr.re.kitri.hello.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by danawacomputer on 2017-06-19.
 */


/**
 * /api/bbs              (Get) .. 전체보기
 * /api/bbs/{articleID}  (Get) .. 상세보기
 * /api/bbs              (Post).. 글쓰기
 * /api/bbs/{articleId}  (PUT) .. 글 수정
 * /api/bbs/{articleId}  (DELETE) .. 글 삭제
 */

@RestController
@RequestMapping("/api")
public class ApiBbsController {

    @Autowired
    private BbsService service;

    @GetMapping("")
    public List<Article> viewAll() {
        List<Article> list = service.getArticles();
        return list;
    }

    @GetMapping("/{articleId}")
    public Article viewDetail(@PathVariable String articleId) {
        Article article = service.viewArticle(articleId);
        return article;
    }

    @PostMapping("")
    public void regist(@RequestBody Article article) {
        System.out.println(article);
        service.registArticle(article);
    }

    @PutMapping("/{articleId}")
    public void modify(
            @PathVariable String articleId,
            @RequestBody Article article) {
        service.modifyArticle(articleId, article);
    }


    @DeleteMapping("/{articleId}")
    public void remove(@PathVariable String articleId) {
        service.removeArticle(articleId);


    }


}
