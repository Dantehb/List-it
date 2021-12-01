package com.example.list_it;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class SettingsAdapter extends ArrayAdapter<Settings> {
    private ArrayList<Settings> settingsList;

    public SettingsAdapter(@NonNull Context context, int resource, ArrayList<Settings> settingsList) {
        super(context, resource);
        this.settingsList = settingsList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        int settingIndex=position;

        if(convertView==null){
            convertView= LayoutInflater.from(getContext()).inflate(R.layout.rowdesign,
                    parent, false);
        }

        //*ImageView settingIcon=convertView.findViewById(R.id.iconImageView);*/
        TextView settingText=convertView.findViewById(R.id.settingsTextView);

        //*settingIcon.setImageResource(settingsList.get(settingIndex).getSettingImageId());*/
        settingText.setText(settingsList.get(settingIndex).getSettingName());

        return convertView;
    }
}
