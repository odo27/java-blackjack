package blackjack.domain.participant;

import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.result.GameResult;

public class Participants {

    private final Dealer dealer = new Dealer();
    private final Players players;

    private Participants(Players players) {
        this.players = players;
    }

    public static Participants of(List<String> playersName) {
        Players players = Players.from(playersName);
        return new Participants(players);
    }

    public void handInitialCards(Deck deck) {
        dealer.handInitialCards(deck);
        players.handInitialCards(deck);
    }

    public boolean canDealerHit() {
        return dealer.canHit();
    }

    public void handOneCardToDealer(Card card) {
        dealer.take(card);
    }

    public GameResult getGameResult() {
        return GameResult.of(dealer, players);
    }

    public Dealer getDealer() {
        return dealer;
    }

    public List<String> getPlayersName() {
        return players.getPlayersName();
    }

    public List<Player> getPlayers() {
        return players.getPlayers();
    }
}
