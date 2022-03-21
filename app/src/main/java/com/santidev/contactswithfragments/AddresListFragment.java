package com.santidev.contactswithfragments;

import android.app.ListFragment;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AddresListFragment extends ListFragment {

    private ActivityComs mActivityComs;

    private ArrayList<Contact> contacts;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        this.contacts = AddressBook.getInstance().getContacts();
        AddressListAdapter adapter = new AddressListAdapter(this.contacts);
        setListAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        //context es de tipo Main Activity, pero hacemos un casting a la interfaz Activity coms
        this.mActivityComs = (ActivityComs) context;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        //Ya no necesito la interfaz, pues la destruyo
        mActivityComs = null;
    }

    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        mActivityComs.onListItemSelected(position);
    }

    public class AddressListAdapter extends ArrayAdapter<Contact> {

        public AddressListAdapter(ArrayList<Contact> contacts){
            super(getActivity(), R.layout.list_item, contacts);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            //Si la celda de la tabla llega nula es que nadie la ha inicializado antes...
            if(convertView == null){
                LayoutInflater inflater = (LayoutInflater) getActivity().getLayoutInflater();
                convertView = inflater.inflate(R.layout.list_item, null);
            }

            Contact currentContact = getItem(position);

            TextView txName = (TextView) convertView.findViewById(R.id.txt_name);
            txName.setText(currentContact.getName() + " " + currentContact.getSurname());

            return convertView;
        }
    }
}
