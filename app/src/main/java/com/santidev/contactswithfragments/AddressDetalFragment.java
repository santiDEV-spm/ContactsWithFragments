package com.santidev.contactswithfragments;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class AddressDetalFragment extends Fragment {

    private ArrayList<Contact> mContacts;
    private Contact currentContact;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContacts = AddressBook.getInstance().getContacts();
        int position = (int) getArguments().getInt("position");
        currentContact = mContacts.get(position);
    }

    public static AddressDetalFragment newInstance(int position){
        Bundle bundle = new Bundle();
        bundle.putInt("position", position);
        AddressDetalFragment frag = new AddressDetalFragment();
        frag.setArguments(bundle);
        return frag;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.detail_fragment, container, false);
        TextView txName = (TextView) view.findViewById(R.id.txt_name);
        TextView txAddress = (TextView) view.findViewById(R.id.txt_addres);
        TextView txZip = (TextView) view.findViewById(R.id.txt_zip);

        txName.setText(currentContact.getName() + " " + currentContact.getSurname());
        txAddress.setText(currentContact.getAddress1()+ " " + currentContact.getAddress2());
        txZip.setText(currentContact.getZipCode());

        return view;
    }
}
