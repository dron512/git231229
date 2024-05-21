// HomeAdRepository.java

package com.mh.green2nd.homeAd;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HomeAdRepository extends JpaRepository<HomeAd, Long> {
    List<HomeAd> findByCategory(HomeAdCategory category);
}
