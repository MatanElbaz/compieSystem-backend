package com.example.compieSystem.controllers;

import com.example.compieSystem.model.ChatObj;
import com.example.compieSystem.model.ImageCard;
import com.example.compieSystem.services.ImageCardService;
import com.example.compieSystem.services.ex.ImageCardDoestExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200"}, allowCredentials = "true")
@RestController
@RequestMapping("/images")
public class ImageCardController {
    private ImageCardService imageCardService;

    @Autowired
    public ImageCardController(ImageCardService imageCardService) {
        this.imageCardService = imageCardService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ImageCard>> findAllImageCards() {
        List<ImageCard> allImageCards = imageCardService.getAllImages();
        if (allImageCards.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(allImageCards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ImageCard> findImageCardById(@PathVariable long id)
            throws ImageCardDoestExistsException {
        ImageCard imageCardById = imageCardService.getImageById(id);
        if (imageCardById == null) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(imageCardById);
    }

    @GetMapping("/chat-obj/{imageCardId}")
    public ResponseEntity<List<ChatObj>> getAllChatObjs(@PathVariable long imageCardId) throws ImageCardDoestExistsException {
        ImageCard imageCardById = imageCardService.getImageById(imageCardId);
        if (imageCardById == null) {
            return ResponseEntity.noContent().build();
        }
        List<ChatObj> allChatObjs = imageCardService.getAllChatObjs(imageCardId);
        return ResponseEntity.ok(allChatObjs);
    }

    @PutMapping("/chat-obj/{imageCardId}")
    public ResponseEntity<ChatObj> addChatObj(@RequestBody ChatObj chatObj, @PathVariable long imageCardId) throws ImageCardDoestExistsException {
        System.out.println(chatObj);
        System.out.println(imageCardId);
        ImageCard imageCardById = imageCardService.getImageById(imageCardId);
        if (imageCardById == null) {
            return ResponseEntity.noContent().build();
        }
        chatObj.setImageCard(imageCardById);
        imageCardService.addChatObj(imageCardId, chatObj);
        return ResponseEntity.ok(chatObj);
    }
}
