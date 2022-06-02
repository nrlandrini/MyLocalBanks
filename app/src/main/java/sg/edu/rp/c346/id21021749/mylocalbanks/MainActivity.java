package sg.edu.rp.c346.id21021749.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvTranslateDBS;
    TextView tvTranslateOCBC;
    TextView tvTranslateUOB;

    String wordClicked = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvTranslateDBS = findViewById(R.id.tvDBS);
        tvTranslateOCBC = findViewById(R.id.tvOCBC);
        tvTranslateUOB = findViewById(R.id.tvUOB);
        registerForContextMenu((tvTranslateDBS));
        registerForContextMenu((tvTranslateOCBC));
        registerForContextMenu((tvTranslateUOB));

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Visit Website");
        menu.add(0,1,1,"Call Hotline");

        if(v == tvTranslateDBS) {
            wordClicked = "DBS";
        } else if (v == tvTranslateOCBC) {
            wordClicked = "OCBC";
        } else if (v == tvTranslateUOB) {
            wordClicked = "UOB";
        }
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            tvTranslateDBS.setText("DBS");
            tvTranslateOCBC.setText("OCBC");
            tvTranslateUOB.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            tvTranslateDBS.setText("星展银行");
            tvTranslateOCBC.setText("华侨银行");
            tvTranslateUOB.setText("大华银行");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (wordClicked.equalsIgnoreCase("dbs")) {
            if (item.getItemId() == 1) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18001111111"));
                startActivity(intentCall);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 0) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }
        if (wordClicked.equalsIgnoreCase("ocbc")) {
            if (item.getItemId() == 1) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18003633333"));
                startActivity(intentCall);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 0) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }
        if (wordClicked.equalsIgnoreCase("uob")) {
            if (item.getItemId() == 1) { //check whether the selected menu item ID is 0
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + "18002222121"));
                startActivity(intentCall);
                return true; //menu item successfully handled

            } else if (item.getItemId() == 0) { //check if the selected menu item ID is 1
                //code for action
                Intent intentCall = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intentCall);

                return true;  //menu item successfully handled
            }
        }
        return super.onContextItemSelected(item);




    }

}