package com.example.hazifeladat5;

import android.content.Context;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;

public class CustomListViewAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final ArrayList<String> contextus;

    public CustomListViewAdapter(Context context, ArrayList<String> contextus) {
        super(context, R.layout.list_items, contextus);
        this.context = context;
        this.contextus = contextus;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(context);
            convertView = inflater.inflate(R.layout.list_items, parent, false);
        }

        TextView randomWords = convertView.findViewById(R.id.randomWords);
        String itemText = contextus.get(position);

        // Replace "s" with "<font color='#RRGGBB'>r</font>" to change text color
        String coloredText = itemText.replace("s", "<font color='" + String.format("#%06X", 0xFFFFFF & randomWords.getCurrentTextColor()) + "'>r</font>");

        randomWords.setText(Html.fromHtml(coloredText, Html.FROM_HTML_MODE_LEGACY));

        return convertView;
    }

    public void changeItemColor(int position, int textColor) {
        // The color change is now applied in getView, so you only need to update the dataset
        notifyDataSetChanged();
    }

    public void sortItems() {
        Collections.sort(contextus, String.CASE_INSENSITIVE_ORDER);
        notifyDataSetChanged();
    }
}
