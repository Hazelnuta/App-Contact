package com.example.lenovo.mycontact;

import android.app.PendingIntent;
import android.content.Intent;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

public class write_message extends AppCompatActivity {
    private EditText content;
    private ImageButton send;
    private TextView send_text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.write_layout);

        content = findViewById(R.id.letter_content);
        send = findViewById(R.id.send_button);
        send_text = findViewById(R.id.send_text);

        content.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint = content.getPaint();
        paint.setFakeBoldText(true);

        send_text.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint1 = send_text.getPaint();
        paint1.setFakeBoldText(true);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CharSequence message = content.getText();
                String msg = message.toString();
                Intent i = getIntent();
                String phone = i.getStringExtra("Phone_number");
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("sms:+86" + phone));
                intent.putExtra("sms_body", msg);
                startActivity(intent);
                finish();
            }
        });
    }
}
