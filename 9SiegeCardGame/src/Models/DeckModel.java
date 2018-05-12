package Models;

import Models.Events.*;

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
        cards.add(new CardModel(new TrebuchetAttackEvent(), new TrebuchetAttackEvent(), new TrebuchetAttackEvent()));
        cards.add(new CardModel(new IllnessEvent(), new GuardsDistractedEvent(), new TrebuchetAttackEvent()));
        cards.add(new CardModel(new SuppliesSoiledEvent(), new BadWeatherEvent(), new BoilingOilEvent()));
        cards.add(new CardModel(new DeathOfALeaderEvent(), new GateFortifiedEvent(), new FlamingArrowsEvent()));
        cards.add(new CardModel(new VolleyOfArrowsEvent(), new CollapsedEvent(), new RepairedTrebuchetEvent()));
        cards.add(new CardModel(new CoverOfDarknessEvent(), new EnemyFatigueEvent(), new RallyEvent()));
        cards.add(new CardModel(new DeterminedEnemyEvent(), new IronShieldsEvent(), new FaithEvent()));
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
