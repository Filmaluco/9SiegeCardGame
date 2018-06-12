package Models;

import SiegeCard.Util.Constants;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class CardModel implements Serializable {

    private static int ID = 0;

    private int cardId;
    List<EventModel> events;

    public CardModel(EventModel day1Event, EventModel day2Event, EventModel day3Event){
            events = new ArrayList<>();
            cardId = ++ID;
            events.add(day1Event);
            events.add(day2Event);
            events.add(day3Event);
    }

    public EventModel getEvent(int currentDay){
        return events.get(currentDay-1);
    }

    public int getCardID(){return cardId;}
}
