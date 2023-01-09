package ro.pontes.crossword;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.TypedValue;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    // The TableLayout for grid, found in XML layout file:
    private TableLayout tlGrid;
    private final int rows = 21;
    private final int cols = 21;

    public static int textSize = 16;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the TableLayout tlGrid:
        tlGrid = findViewById(R.id.tlGrid);
        drawGrid();
    } // end onCreate() method.

    // A method to draw the grid depending of the grid array:
    private void drawGrid() {
        // A StringBuilder for letters:
        StringBuilder letters = new StringBuilder("ABCDEFGHIJKLMNOPQRSTUVXYZ");
        Random random = new Random();
        tlGrid.removeAllViews();
        for (int i = 0; i < rows; i++) {
            TableRow tr = new TableRow(this);
            for (int j = 0; j < cols; j++) {
                TextView tv = new TextView(this);
                // We take a letter to display it, randomly:


                // Generate a random integer between 1 and 10 (inclusive)
                int rand = random.nextInt(letters.length());
                String tvText = String.valueOf(letters.charAt(rand));
                tv.setText(tvText);
// Set also a content description:
                String cdText = tvText + ", on " + (i + 1) + ", " + (j + 1) + ".";
                tv.setContentDescription(cdText);
                tv.setTextSize(TypedValue.COMPLEX_UNIT_SP, MainActivity.textSize);
                tv.setPadding(5, 2, 5, 2);

                tr.addView(tv);
            } // end for horizontal movement in grid, from 1 to 7.
            tlGrid.addView(tr);
        } // end for vertical movement in grid, from 1 to 6.
    } // end draw grid.

} // end class.
