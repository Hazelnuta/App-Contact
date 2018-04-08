package com.example.lenovo.mycontact;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextPaint;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

/**
 * Created by lenovo on 2018/4/1.
 */

public class detail  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detail_layout);

        Bundle bundle = this.getIntent().getBundleExtra("detail_info");
        String name = bundle.getString("name");
        int head = bundle.getInt("head");
        final String phone = bundle.getString("phone");

        TextView Name = findViewById(R.id.detail_name);
        ImageView Head = findViewById(R.id.detail_head);
        TextView Phone = findViewById(R.id.detail_phone);
        TextView Notes = findViewById(R.id.detail_notes);
        TextView Address = findViewById(R.id.detail_address);
        TextView fixed1 = findViewById(R.id.detail_fixed1);
        TextView fixed2 = findViewById(R.id.detail_fixed2);
        TextView fixed3 = findViewById(R.id.detail_fixed3);
        TextView write = findViewById(R.id.write_text);
        ImageButton send_text = findViewById(R.id.send_button1);

        Name.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint = Name.getPaint();
        paint.setFakeBoldText(true);

        Phone.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint2 = Phone.getPaint();
        paint2.setFakeBoldText(true);

        Notes.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint3 = Notes.getPaint();
        paint3.setFakeBoldText(true);

        Address.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint4 = Address.getPaint();
        paint4.setFakeBoldText(true);

        fixed1.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/segoepr.ttf"));
        TextPaint paint5 = fixed1.getPaint();
        paint5.setFakeBoldText(true);

        fixed2.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/segoepr.ttf"));
        TextPaint paint6 = fixed2.getPaint();
        paint6.setFakeBoldText(true);

        fixed3.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/segoepr.ttf"));
        TextPaint paint7 = fixed3.getPaint();
        paint7.setFakeBoldText(true);

        write.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint8 = write.getPaint();
        paint8.setFakeBoldText(true);

        Name.setText(name);
        Phone.setText(phone);
        Head.setImageResource(head);

        send_text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent msg = new Intent(detail.this,write_message.class);
                msg.putExtra("Phone_number", phone);
                startActivity(msg);
            }
        });
    }
}
