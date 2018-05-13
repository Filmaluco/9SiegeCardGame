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

        cards = new ArrayList<>();
        cards.add(new CardModel(new TrebuchetAttackEventDay1(), new TrebuchetAttackEventDay2(), new TrebuchetAttackEventDay3()));
        cards.add(new CardModel(new IllnessEvent(),             new GuardsDistractedEvent(),    new TrebuchetAttackEventDay3()));
        cards.add(new CardModel(new SuppliesSoiledEvent(),      new BadWeatherEvent(),          new BoilingOilEvent()));
        cards.add(new CardModel(new DeathOfALeaderEvent(),      new GateFortifiedEvent(),       new FlamingArrowsEvent()));
        cards.add(new CardModel(new VolleyOfArrowsEvent(),      new CollapsedEvent(),           new RepairedTrebuchetEvent()));
        cards.add(new CardModel(new CoverOfDarknessEvent(),     new EnemyFatigueEvent(),        new RallyEvent()));
        cards.add(new CardModel(new DeterminedEnemyEvent(),     new IronShieldsEvent(),         new FaithEvent()));

        shuffle(cards);
        numberCards = cards.size();
        currentCard = 0;
        currentDay = 1;
    }

    public EventModel draw(){
        if (currentCard == (numberCards)){ currentCard = 0; currentDay++;}
        lastCard = currentCard;
        return cards.get(currentCard++).getEvent(currentDay);
    }

    public void reShuffle(){
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
