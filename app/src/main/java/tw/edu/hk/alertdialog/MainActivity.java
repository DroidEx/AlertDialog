package tw.edu.hk.alertdialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
        implements DialogInterface.OnClickListener{

    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txv = (TextView)findViewById(R.id.answer);

        new AlertDialog.Builder(this)
                .setMessage("How is the weather today?")
                .setCancelable(false)
                .setPositiveButton("Sunny",this)
                .setNegativeButton("Cloudy",this)
                .setIcon(android.R.drawable.ic_menu_edit)
                .setNeutralButton("Raining", this)
                .show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onClick(DialogInterface dialog, int which) {
        if(which == DialogInterface.BUTTON_POSITIVE){
            txv.setText("Today is a sunny day.");
        }
        else if (which == DialogInterface.BUTTON_NEGATIVE){
            txv.setText("Today is a cloudy day.");
        }
        else if (which == DialogInterface.BUTTON_NEUTRAL){
            txv.setText("Today is a raining day.");
        }
    }
}
