package com.example.lenovo.mycontact;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

/**
 * Created by lenovo on 2018/4/2.
 */

public class new_contact  extends AppCompatActivity {
    private EditText name, phone, address, notes;
    private ImageButton save;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_contact_layout);

        name = findViewById(R.id.new_name);
        phone = findViewById(R.id.new_phone);
        address = findViewById(R.id.new_address);
        notes = findViewById(R.id.new_notes);
        save = findViewById(R.id.save_button);

        name.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint = name.getPaint();
        paint.setFakeBoldText(true);

        phone.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint1 = phone.getPaint();
        paint.setFakeBoldText(true);

        address.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint2 = address.getPaint();
        paint.setFakeBoldText(true);

        notes.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint3 = notes.getPaint();
        paint.setFakeBoldText(true);

        save.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            CharSequence Name = name.getText();
            CharSequence Phone = phone.getText();
            CharSequence Address = address.getText();
            CharSequence Notes = notes.getText();
            String nm = Name.toString();
            String pn = Phone.toString();
            String ad = Address.toString();
            String nt = Notes.toString();

            Intent back = new Intent();
            back.putExtra("Name", nm);
            back.putExtra("Phone", pn);
            back.putExtra("Address", ad);
            back.putExtra("Notes", nt);
            // 设置结果，并进行传送
            setResult(0, back);
            finish();
        }
        });

        TextView fixed1 = findViewById(R.id.new_fixed1);
        TextView fixed2 = findViewById(R.id.new_fixed2);
        TextView fixed3 = findViewById(R.id.new_fixed3);
        TextView save_text = findViewById(R.id.save_text);

        fixed1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/segoepr.ttf"));
        TextPaint paint5 = fixed1.getPaint();
        paint5.setFakeBoldText(true);

        fixed2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/segoepr.ttf"));
        TextPaint paint6 = fixed2.getPaint();
        paint6.setFakeBoldText(true);

        fixed3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/segoepr.ttf"));
        TextPaint paint7 = fixed3.getPaint();
        paint7.setFakeBoldText(true);

        save_text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/segoepr.ttf"));
        TextPaint paint8 = save_text.getPaint();
        paint8.setFakeBoldText(true);
    }
}
