package com.example.arpad.fragmentdemo;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity
        implements BlankFragment.OnFragmentInteractionListener,
            MainFragment.OnFragmentInteractionListener,
            SimpleFragment.OnFragmentInteractionListener {

    private static String TAG = "MainActivity.TAG";
    private static String value = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("FragmentDemo", TAG + " onCreate()");

        if ( savedInstanceState == null ){
            showMainFragment();
        }
    }

    public void showMainFragment() {
        Log.d("FragmentDemo", TAG + " showMainFragment()");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace( R.id.container, new MainFragment(), TAG );
        ft.addToBackStack("MainFragment");
        ft.commit();
    }

    public void showBlankFragment(){
        Log.d("FragmentDemo", TAG + " showBlankFragment()");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.container, new BlankFragment(), TAG);
        ft.addToBackStack("BlankFragment");
        ft.commit();


    }

    public void showSimpleFragment() {
        Log.d("FragmentDemo", TAG + " showSimpleFragment()");
        FragmentManager fm = getFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace( R.id.container, new SimpleFragment(), TAG );
        ft.addToBackStack("SimpleFragment");
        ft.commit();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {
        Log.d("FragmentDemo", TAG + " onFragmentInteraction()");
        Toast.makeText(getApplicationContext(), uri.toString(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void setValue(String value) {
        this.value = value;
    }

//    @Override
//    public String getValue() {
//        return this.value;
//    }
}
