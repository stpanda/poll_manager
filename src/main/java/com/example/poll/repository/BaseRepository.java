package com.example.poll.repository;

import com.querydsl.core.types.EntityPath;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.binding.QuerydslBinderCustomizer;
import org.springframework.data.querydsl.binding.QuerydslBindings;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;

@NoRepositoryBean
public interface BaseRepository<E extends EntityPath<T>, T, I extends Serializable> extends JpaRepository<T, I>,
        QuerydslPredicateExecutor<T>, QuerydslBinderCustomizer<E> {

    @Override
    default void customize(QuerydslBindings bindings, E root) {
    }
}
