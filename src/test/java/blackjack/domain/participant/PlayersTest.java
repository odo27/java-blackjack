package blackjack.domain.participant;

import static blackjack.domain.card.Number.ACE;
import static blackjack.domain.card.Number.FIVE;
import static blackjack.domain.card.Number.FOUR;
import static blackjack.domain.card.Number.SIX;
import static blackjack.domain.card.Number.THREE;
import static blackjack.domain.card.Number.TWO;
import static blackjack.domain.card.Symbol.SPADE;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;

import blackjack.domain.card.Card;
import blackjack.domain.card.MockDeckGenerator;
import org.assertj.core.util.Lists;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class PlayersTest {

    private Players players;

    @BeforeEach
    void init() {
        players = Players.from(List.of("a", "b", "c"));
    }

    @Test
    void should_ThrowException_When_NameIsDuplicated() {
        assertThatThrownBy(() -> Players.from(List.of("a", "a", "b")))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("플레이어 이름은 중복될 수 없습니다.");
    }

    @Test
    void should_HaveMatchedName_When_FindPlayerByName() {
        Player player = players.getPlayers().get(0);
        assertThat(player.getName()).isEqualTo("a");
    }

    @Test
    void should_HaveAllNameOfPlayers_When_GetPlayerNames() {
        assertThat(players.getPlayersName()).containsExactly("a", "b", "c");
    }

    @Test
    void should_HaveAllCardsOfPlayer_When_GetPlayerCards() {
        Player player = players.getPlayers().get(0);

        Card card1 = new Card(SPADE, ACE);
        player.take(card1);

        Card card2 = new Card(SPADE, TWO);
        player.take(card2);

        assertThat(player.getCards()).containsExactly(card1, card2);
    }

    @Test
    void should_AllPlayersHave2Cards_When_HandInitialCards() {
        MockDeckGenerator mockDeckGenerator = new MockDeckGenerator(Lists.newArrayList(
                new Card(SPADE, ACE),
                new Card(SPADE, TWO),
                new Card(SPADE, THREE),
                new Card(SPADE, FOUR),
                new Card(SPADE, FIVE),
                new Card(SPADE, SIX)
        ));
        players.handInitialCards(mockDeckGenerator.generate());
        players.getPlayers().forEach(player -> assertThat(player.getCards()).hasSize(2));
    }
}
