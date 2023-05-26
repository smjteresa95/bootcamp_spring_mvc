package com.spring.mvc.controller;

import com.spring.mvc.controller01.NotebookDTO;
import org.junit.jupiter.api.Test;

public class NotebookDTOTest {

    @Test
    public void notebookDTOTest(){
        NotebookDTO noteBook = new NotebookDTO();
//        noteBook = NotebookDTO.builder()
//                .modelName("macbook pro")
//                .price(2000)
//                .ram(3)
//                .ssd(10)
//                .build();
        System.out.println(noteBook);
    }
}
