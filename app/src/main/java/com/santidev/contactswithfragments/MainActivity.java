package com.santidev.contactswithfragments;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ActivityComs{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dual_fragment);

        FragmentManager manager = getFragmentManager();
        Fragment fragment = manager.findFragmentById(R.id.list_fragment_holder);

        if(fragment == null){
            fragment = new AddresListFragment();
            manager.beginTransaction()
                    .add(R.id.list_fragment_holder,fragment)
                    .commit();
        }

    }

    @Override
    public void onListItemSelected(int position) {
        //Este metodo se llama cuando han seleccionado un contacto...

        if(findViewById(R.id.holder_fragment_detail) == null){
            //Estoy en vertical
            Intent i = new Intent(this, PortraitDetailActivity.class);
            i.putExtra("position", position);
            startActivity(i);

        }else{
            //Estoy en horizontal
            FragmentManager manager = getFragmentManager();
            FragmentTransaction transaction = manager.beginTransaction();

            Fragment oldFragment = manager.findFragmentById(R.id.holder_fragment_detail);
           //TODO: crea una clase AddressDetailFragment
            Fragment newFragment = AddressDetalFragment.newInstance(position); //habria que indicar la position

            if (oldFragment != null){
                transaction.remove(oldFragment);
            }
            transaction.add(R.id.holder_fragment_detail, newFragment);
            transaction.commit();

        }

    }
}