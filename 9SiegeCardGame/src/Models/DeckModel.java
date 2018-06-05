package Models;

import Models.Events.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import static java.util.Collections.shuffle;

public class DeckModel implements Serializable{

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
        lastCard = 0;
        currentCard = 0;
        currentDay = 1;
    }

    public EventModel draw(){
        lastCard = currentCard;
        return cards.get(currentCard++).getEvent(currentDay);
        //TODO throw expection maybe?
    }

    public void reShuffle(){
        shuffle(cards);
        currentCard = 0;
        currentDay = currentDay+1 > 3 ? currentDay : currentDay+1;
    }

    public String getLastCardName(){
        return cards.get(lastCard).getEvent(currentDay).getName();
    }

    public String getLastCardDescription(){
        return cards.get(lastCard).getEvent(currentDay).getDescription();
    }

    @Override
    public String toString() {
        String s = "";
        s+="Card: " + getLastCardName() + "\n";
        s+="Effect: \n" + getLastCardDescription() + "\n";
        return s;
    }
}
