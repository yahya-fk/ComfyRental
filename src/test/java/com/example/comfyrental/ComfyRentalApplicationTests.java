package com.example.comfyrental;

import com.example.comfyrental.Entities.Local;
import com.example.comfyrental.Repositories.LocalRepository;
import com.example.comfyrental.Services.LocalService;
import com.example.comfyrental.Services.LocalServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@SpringBootTest
class ComfyRentalApplicationTests {

    @Test
    void contextLoads() {

    }

}
