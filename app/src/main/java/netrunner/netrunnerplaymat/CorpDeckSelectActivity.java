package netrunner.netrunnerplaymat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.LinkedList;
import java.util.List;

public class CorpDeckSelectActivity extends AppCompatActivity {

    LinearLayout decksLayout;
    List<Decklist> decks = new LinkedList<>();


    public static final String WHICH_DECK = "netrunner.netrunnerplaymat.WHICH_DECK_CORP";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_corp_deck_select);
        decksLayout = (LinearLayout) findViewById(R.id.corp_deck_lists);
        // setupy stuff for testing
        Card a = new Card("A");
        Card b = new Card("B");
        Card c = new Card("C");
        List<Card> cardList = new LinkedList<>();
        cardList.add(a);
        cardList.add(b);
        cardList.add(c);
        Decklist dlist1 = new Decklist("deck1", cardList);
        Decklist dlist2 = new Decklist("deck2", cardList);
        decks.add(dlist1);
        decks.add(dlist2);
        for (Decklist d : decks) {
            TextView dview = new TextView(this);
            dview.setText(d.name);
            decksLayout.addView(dview);
            dview.setClickable(true);
            dview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    playDeck(v);
                }
            });
        }


    }

    private void playDeck(View v) {
        Intent intent = new Intent(this, CorpPlaymatActivity.class);
        intent.putExtra(WHICH_DECK, ((TextView) v).getText());
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_corp_deck_select, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
