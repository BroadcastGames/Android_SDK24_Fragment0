package code.google.com.emptyapp102;

import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import code.google.com.emptyapp102.dummy.DummyContent;

public class MainActivity extends AppCompatActivity implements ItemFragment.OnListFragmentInteractionListener, BlankFragment.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                changeMainFragment(2);
            }
        });

        changeMainFragment(1);
    }

    @Override
    public void onFragmentInteraction(Uri uri){
        Log.i("MainActivity", "onFragmentInteraction " + uri.toString());
    }


    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {
        Log.i("MainActivity", "onListFragmentInteraction " + item.toString());
    }

    public void changeMainFragment(int fragmentSelector)
    {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (fragmentSelector) {
            case 1:
                fragmentTransaction.replace(R.id.mainActivityContainer,     new MainActivityFragment());
                break;
            case 2:
                fragmentTransaction.replace(R.id.mainActivityContainer,     BlankFragment.newInstance("hi", "there"));
                break;
            case 3:
                fragmentTransaction.replace(R.id.mainActivityContainer,     ItemFragment.newInstance(1 /* Column */));
                break;
        }
        fragmentTransaction.commit();
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

}
