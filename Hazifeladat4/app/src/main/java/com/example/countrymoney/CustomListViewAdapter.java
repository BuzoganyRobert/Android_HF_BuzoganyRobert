package com.example.countrymoney;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;

public class CustomListViewAdapter extends ArrayAdapter<String> {
    private final Activity context;
    private final String[] moneyNameShort;
    private final String[] moneyName;
    private final Double[] money_buy;
    private final Double[] money_sell;
    private final Integer[] moneyPic;

        public CustomListViewAdapter(Activity context, String[] moneyNameShort, String[] moneyName, Double[] moneyBuy, Double[] moneySell, Integer[] moneyPic) {
        super(context, R.layout.list_item, moneyNameShort);
        this.context = context;
        this.moneyNameShort = moneyNameShort;
        this.moneyName = moneyName;
        this.money_buy = moneyBuy;
        this.money_sell = moneySell;
        this.moneyPic = moneyPic;
    }

    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_item, null, true);

        TextView moneyNameShortTextView = rowView.findViewById(R.id.money_short);
        TextView moneyNameTextView = rowView.findViewById(R.id.moneyName);
        TextView moneyBuyTextView = rowView.findViewById(R.id.money_value_buy);
        TextView moneySellTextView = rowView.findViewById(R.id.money_value_sell);
        ImageView countryFlagImageView = rowView.findViewById(R.id.countryFlag);
        ConstraintLayout myListContainer=rowView.findViewById(R.id.myListContainer);
        countryFlagImageView.setImageResource(moneyPic[position]);
        myListContainer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moneyNameShortTextView.setText(moneyNameShort[position]);
                moneyNameTextView.setText(moneyName[position]);
                moneyBuyTextView.setText(String.valueOf(money_buy[position]));
                moneySellTextView.setText(String.valueOf(money_sell[position]));
            }
        });



        return rowView;
    }
}
