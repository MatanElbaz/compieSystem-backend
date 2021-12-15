package com.example.compieSystem.services;

import com.example.compieSystem.model.ChatObj;
import com.example.compieSystem.model.ImageCard;
import com.example.compieSystem.repositories.ChatObjRepository;
import com.example.compieSystem.repositories.ImageCardRepository;
import com.example.compieSystem.services.ex.ImageCardDoestExistsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageCardServiceImpl implements ImageCardService {
    private ImageCardRepository imageCardRepository;
    private ChatObjRepository chatObjRepository;

    @Autowired
    public ImageCardServiceImpl(ImageCardRepository imageCardRepository,ChatObjRepository chatObjRepository) {
        this.imageCardRepository = imageCardRepository;
        this.chatObjRepository = chatObjRepository;
    }

    @Override
    public List<ImageCard> getAllImages() {
        return imageCardRepository.findAll();
    }

    @Override
    public List<ChatObj> getAllChatObjs(long imageCardId) throws ImageCardDoestExistsException {
        Optional<ImageCard> imageCard = imageCardRepository.findById(imageCardId);
        if (!imageCard.isPresent()) {
            throw new ImageCardDoestExistsException(String.format("Image Card with id %d does not exists.", imageCardId));
        }
        return imageCard.get().getChatObjs();
    }

    @Override
    public ChatObj addChatObj(long imageCardId, ChatObj chatObj) throws ImageCardDoestExistsException {
        Optional<ImageCard> imageCard = imageCardRepository.findById(imageCardId);
        if (!imageCard.isPresent()) {
            throw new ImageCardDoestExistsException(String.format("Image Card with id %d does not exists.", imageCardId));
        }
        ImageCard myImageCard = imageCard.get();
        chatObj.setImageCard(myImageCard);

        List<ChatObj> dataChatObjs = myImageCard.getChatObjs();
        dataChatObjs.add(chatObj);

        myImageCard.setChatObjs(dataChatObjs);
        return chatObjRepository.save(chatObj);
    }

    @Override
    public ImageCard getImageById(long id) throws ImageCardDoestExistsException {
        Optional<ImageCard> imageCard = imageCardRepository.findById(id);
        if (!imageCard.isPresent()) {
            throw new ImageCardDoestExistsException(String.format("Image Card with id %d does not exists.", id));
        }
        return imageCard.get();
    }


}
