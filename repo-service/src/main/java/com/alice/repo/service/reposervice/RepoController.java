package com.alice.repo.service.reposervice;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liuchun
 * @date 2020/02/29  13:26
 */
@Slf4j
@RestController
public class RepoController {

    @PutMapping("repo/{id}")
    public void serverMsg(@PathVariable("id") String id) {
        log.info("库存扣减：id={}", id);
    }
}
