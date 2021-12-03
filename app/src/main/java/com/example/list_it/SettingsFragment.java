package com.example.list_it;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.provider.Settings;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;


public class SettingsFragment extends Fragment {

    //private ArrayList<Settings> settingsList;
    private FirebaseAuth mAuth;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    //*public void populateSettings(String[] setting){
        //*settingsList.add(new Settings(setting[0], R.drawable.ic_donation));
        //*settingsList.add(new Settings(setting[1], R.drawable.ic_language));
        //*settingsList.add(new Settings(setting[2], R.drawable.ic_playstore));
        //*settingsList.add(new Settings(setting[3], R.drawable.ic_credits));
    //*}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_settings, container, false);
        mAuth=FirebaseAuth.getInstance();
        //*settingsList = new ArrayList<>();
        //*Resources res = getResources();
        //*String[] allSettings = res.getStringArray(R.array.settings);

        //*populateSettings(allSettings);

        //*SettingsAdapter adapter = new SettingsAdapter(getActivity().getApplicationContext(), R.layout.rowdesign, settingsList);
        String[] menuItems={
                getString(R.string.setting1),
                getString(R.string.setting2),
                getString(R.string.setting3),
                getString(R.string.setting4)
        };
        //*ListView listview = (ListView) getActivity().findViewById(R.id.settingsListView);
        ListView listview = (ListView) view.findViewById(R.id.settingsListView);
        ArrayAdapter<String> adapter=new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, menuItems
        );
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String s=menuItems[i];
                //Toast.makeText(getActivity(), "Clicked: " + s, Toast.LENGTH_SHORT).show();
                switch(i){
                    case 0:
                        Toast.makeText(getActivity(), "Clicked: 0" + s, Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        openSettings();
                        break;
                    case 2:
                        openPlayStore();
                        break;
                    case 3:
                        //log out
                        logOut();
                        break;
                }
            }
        });

        // Inflate the layout for this fragment
        return view;
    }

    public void openSettings(){
        Intent intent=new Intent(Settings.ACTION_SETTINGS);
        if(intent.resolveActivity(getActivity().getPackageManager())!=null){
            startActivity(intent);
        }
    }

    public void openPlayStore(){
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("market://details?id=com.YoStarEN.Arknights"));
        startActivity(intent);
    }

    public void logOut(){
        mAuth.signOut();
        startActivity(new Intent(getActivity(), AuthActivity.class));
        getActivity().finish();
    }
}
/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SettingsFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

/**
 // TODO: Rename parameter arguments, choose names that match
 // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
 private static final String ARG_PARAM1 = "param1";
 private static final String ARG_PARAM2 = "param2";

 // TODO: Rename and change types of parameters
 private String mParam1;
 private String mParam2;

 public SettingsFragment() {
 // Required empty public constructor
 }

 /*
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment SettingsFragment.

// TODO: Rename and change types and number of parameters
public static SettingsFragment newInstance(String param1, String param2) {
SettingsFragment fragment = new SettingsFragment();
Bundle args = new Bundle();
args.putString(ARG_PARAM1, param1);
args.putString(ARG_PARAM2, param2);
fragment.setArguments(args);
return fragment;
}*/