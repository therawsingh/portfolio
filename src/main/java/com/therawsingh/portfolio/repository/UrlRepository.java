package com.therawsingh.portfolio.repository;

import com.therawsingh.portfolio.entity.url.Url;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<Url, Long> {

    public Url findByShortUrl(String shortUrl);

    public Url findByLongUrl(String longUrl);

}
