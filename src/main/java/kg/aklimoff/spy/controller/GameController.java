package kg.aklimoff.spy.controller;

import kg.aklimoff.spy.dto.CategoryDto;
import kg.aklimoff.spy.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("api")
@RequiredArgsConstructor
public class GameController {
    private final CategoryService categoryService;

//    @GetMapping("start")
//    public String getStartGamePage() {
//        return "game/start";
//    }
//
//    @GetMapping("/getCategories")
//    public ResponseEntity<CategoryDto> getCategories() {
//        List<CategoryDto> categoryDtos = categoryService.getAllCategoryDtos();
//    }

    @PostMapping("getCategories")
    public ResponseEntity<?> getCategories() {
        try {
            List<CategoryDto> categoryDtos = categoryService.getAllCategoryDtos();
            return new ResponseEntity<>(categoryDtos, HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity<>("Error finding categories: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

//    @PostMapping("start-game")
//    public ResponseEntity<?> processGameStart () {
//        try {
//
//        } catch () {
//
//        }
//    }
}
