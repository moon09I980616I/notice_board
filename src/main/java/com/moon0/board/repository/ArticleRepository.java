package com.moon0.board.repository;

import com.moon0.board.domain.Article;
import com.moon0.board.domain.QArticle;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.StringExpression;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ArticleRepository extends
        JpaRepository<Article, Long>
    , QuerydslPredicateExecutor<Article> // Article 모든 필드에 검색 기능 추가
    , QuerydslBinderCustomizer<QArticle> // 검색 커스튬
{
    @Override
    default void customize(QuerydslBindings bindings, QArticle root){
        bindings.excludeUnlistedProperties(true); //선택적으로 검색 가능
        bindings.including(root.title, root.content, root.hashtag, root.createdAt, root.createdBy); // 원하는 field 추가
        bindings.bind(root.title).first(StringExpression::containsIgnoreCase); // 검색 할 때 대소문자 구별 X like %{$v}%'
        bindings.bind(root.content).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.hashtag).first(StringExpression::containsIgnoreCase);
        bindings.bind(root.createdAt).first(DateTimeExpression::eq);
        bindings.bind(root.createdBy).first(StringExpression::containsIgnoreCase);
    }
}