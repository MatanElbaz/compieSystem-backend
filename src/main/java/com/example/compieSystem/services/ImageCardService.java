package com.example.compieSystem.services;

import com.example.compieSystem.model.ChatObj;
import com.example.compieSystem.model.ImageCard;
import com.example.compieSystem.services.ex.ImageCardDoestExistsException;

import java.util.List;

public interface ImageCardService {

    /**
     * find all ImageCards from h2 data.
     *
     * @return all the ImageCards.
     */
    public List<ImageCard> getAllImages();

    /**
     * find all Chat Object by imageCardId from h2 data.
     *
     * @param imageCardId The imageCardId of the ImageCard.
     * @return all the Chat Objects.
     */
    public List<ChatObj> getAllChatObjs(long imageCardId) throws ImageCardDoestExistsException;

    /**
     * Create a new Chat Object to data base.
     *
     * @param imageCardId The imageCardId of the ImageCard.
     * @param chatObj     The chatObj of the ImageCard.
     * @return The Chat Object to update.
     */
    public ChatObj addChatObj(long imageCardId, ChatObj chatObj) throws ImageCardDoestExistsException;

    /**
     * Find ImageCard by id.
     *
     * @param id the id of the ImageCard.
     * @return The ImageCard to find.
     */
    public ImageCard getImageById(long id) throws ImageCardDoestExistsException;
}
