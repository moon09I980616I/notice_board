package com.moon0.board.service;

import com.moon0.board.domain.type.SearchType;
import com.moon0.board.dto.ArticleDto;
import com.moon0.board.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import static org.assertj.core.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks private ArticleService sut;

    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글검색 -> 게시글 리스트 반환")
    @Test
    void givenSearchParameters_whenSearchingArticles_thenReturnsArticleList(){
        //Given

        //When
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword"); //제목, 본문, ID, 닉네임, 해시태그

        //Then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글조회 -> 게시글 반환")
    @Test
    void givenArticleId_whenSearchingArticle_thenReturnsArticle(){
        //Given

        //When
        ArticleDto articles = sut.searchArticle(1l);

        //Then
        assertThat(articles).isNotNull();
    }



}