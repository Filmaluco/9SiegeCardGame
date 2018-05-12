package Models;

import Models.Events.GuardsDistractedEvent;
import Models.Events.IllnessEvent;
import Models.Events.SuppliesSoiledEvent;

import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class DeckModel {

    private int numberCards,
                currentCard,
                lastCard,
                currentDay;

    private List<CardModel> cards;

    public DeckModel(){

        //Exemple of a card
        cards = new ArrayList<>();
        cards.add(new CardModel(new IllnessEvent(), new GuardsDistractedEvent(), new SuppliesSoiledEvent()));

        numberCards = cards.size();
        currentCard = 0;
        currentDay = 1;
    }

    public EventModel Draw(){
        if (currentCard == (numberCards)){ currentCard = 0; currentDay++;}
        lastCard = currentCard;
        return cards.get(currentCard++).getEvent(currentDay);
    }

    public void Shuffle(){
        shuffle(cards);
        currentCard = 0;
    }

    public String getLastCardName(){
        return cards.get(lastCard).getEvent(currentDay).getName();
    }

    public String getLastCardDescription(){
        return cards.get(lastCard).getEvent(currentDay).getDescription();
    }

}
