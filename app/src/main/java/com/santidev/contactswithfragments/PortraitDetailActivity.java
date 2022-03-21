
package com.santidev.contactswithfragments;

import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.santidev.contactswithfragments.databinding.ActivityPortraitDetailBinding;

public class PortraitDetailActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portrait_detail);



        FragmentManager manager = getFragmentManager();
        Fragment frag = manager.findFragmentById(R.id.holder_fragment_detail);

        Bundle extras = getIntent().getExtras();
        int position = 0;

        if (extras != null){
            position = extras.getInt("position");
        }
        if(frag == null){
            frag = AddressDetalFragment.newInstance(position);
        }
        manager.beginTransaction()
                .add(R.id.holder_fragment_detail, frag)
                .commit();

    }


}