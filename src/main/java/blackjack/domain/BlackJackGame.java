package blackjack.domain;

import java.util.List;

import blackjack.domain.bet.Money;
import blackjack.domain.card.Card;
import blackjack.domain.card.Deck;
import blackjack.domain.card.DeckGenerator;
import blackjack.domain.participant.Dealer;
import blackjack.domain.participant.Participant;
import blackjack.domain.participant.Participants;
import blackjack.domain.participant.Player;
import blackjack.domain.result.GameResult;

public class BlackJackGame {

    private final Deck deck;
    private final Participants participants;

    public BlackJackGame(DeckGenerator deckGenerator, List<String> playersName) {
        this.deck = deckGenerator.generate();
        this.participants = Participants.of(playersName);
    }

    public void addPlayerBetMoney(Player player, Money betMoney) {
        participants.getDealer().addPlayerBetMoney(player, betMoney);
    }

    public void handInitialCards() {
        participants.handInitialCards(deck);
    }

    public void handOneCard(Participant participant) {
        Card card = deck.draw();
        participant.take(card);
    }

    public Card getDealerFirstCard() {
        return getDealer().getFirstCard();
    }

    public GameResult getGameResult() {
        return participants.getGameResult();
    }

    public Dealer getDealer() {
        return participants.getDealer();
    }

    public List<String> getPlayersName() {
        return participants.getPlayersName();
    }

    public List<Player> getPlayers() {
        return participants.getPlayers();
    }
}
