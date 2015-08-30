package netrunner.netrunnerplaymat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RunnerPlaymatActivity extends AppCompatActivity {

    ImageView idImage;
    ImageView heapImage;

    LinearLayout gripLayout;
    LinearLayout programsLayout;
    LinearLayout hardwareLayout;
    LinearLayout resourcesLayout;

    List<Card> heap = new ArrayList<>();
    List<Card> stack = new LinkedList<>();
    List<Card> grip = new ArrayList<>(10);
    List<Card> programs = new ArrayList<>(10);
    List<Card> hardware = new ArrayList<>(10);
    List<Card> resources = new ArrayList<>(10);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_runner_playmat);
        // get cards out of the deck and stuff; for now we'll just make fill it with blank cards
        // get the gui elements
        gripLayout = (LinearLayout) findViewById(R.id.runner_grip_layout);
        idImage = (ImageView) findViewById(R.id.runner_id_image);
        heapImage = (ImageView) findViewById(R.id.runner_heap_image);
        programsLayout = (LinearLayout) findViewById(R.id.runner_programs_layout);
        hardwareLayout = (LinearLayout) findViewById(R.id.runner_hardware_layout);
        resourcesLayout = (LinearLayout) findViewById(R.id.runner_resources_layout);

        fillStack();
        fillGrip();

        // render stuff
        // just set them to filler to see what the layout looks like...
        idImage.setImageResource(R.drawable.runner_back);
        heapImage.setImageResource(R.drawable.runner_back);

        fillLayout(gripLayout, grip);
        fillLayout(programsLayout, programs);
        fillLayout(hardwareLayout, hardware);
        fillLayout(resourcesLayout, resources);


    }

    private void fillLayout(LinearLayout layout, List<Card> cardList) {
        for (Card c : cardList) {
            ImageView imgView = new ImageView(this);
            imgView.setImageResource(c.getResource());
            layout.addView(imgView);
        }
    }

    private void fillGrip() {
        for (int i = 0; i < 5; i++) {
            Card c = stack.remove(0);
            grip.add(c);
        }
    }

    private void fillStack() {
        // later more complicated stuff involving the deck selected...
        for (int i = 0; i < 15; i++) {
            Card c = new Card("Test " + i);
            stack.add(c);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_runner_playmat, menu);
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
