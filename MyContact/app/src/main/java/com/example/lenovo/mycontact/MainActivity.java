package com.example.lenovo.mycontact;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextPaint;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    private ListView listView;
    private ImageButton add_button;
    private item_adapter myAdapter;
    private TextView add_ori, add_split;
    public List<contact_item> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.list_view);
        add_button = findViewById(R.id.add_button);
        add_ori = findViewById(R.id.add_text);
        add_split = findViewById(R.id.add_text_split);
        add_split.setVisibility(View.INVISIBLE);
        add_ori.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint3 = add_ori.getPaint();
        paint3.setFakeBoldText(true);
        add_split.setTypeface(Typeface.createFromAsset(getAssets(), "fonts/PAPYRUS.TTF"));
        TextPaint paint4 = add_ori.getPaint();
        paint4.setFakeBoldText(true);
        list = initData();
        myAdapter = new item_adapter(this, list, R.layout.contact_adapter);
        listView.setAdapter(myAdapter);


        add_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                add_ori.setVisibility(View.INVISIBLE);
                add_split.setVisibility(View.VISIBLE);
                Intent ncnt = new Intent(MainActivity.this,new_contact.class);
                startActivityForResult(ncnt, 0);
            }
        });

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                contact_item cur = list.get(position);
                String name = cur.getName();
                int head = cur.getHead();
                String phone = cur.getPhone();
                Intent dtl = new Intent(MainActivity.this,detail.class);
                Bundle bundle = new Bundle();
                bundle.putString("name", name);
                bundle.putInt("head", head);
                bundle.putString("phone", phone);
                dtl.putExtra("detail_info", bundle);
                startActivity(dtl);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Bundle b = data.getExtras();
        String name = b.getString("Name");
        String phone = b.getString("Phone");
        String address = b.getString("Address");
        String notes = b.getString("Notes");
        contact_item new_one = new contact_item();
        new_one.setName(name);
        new_one.setPhone(phone);
        new_one.setHead(R.drawable.head1);
        list.add(new_one);
        myAdapter.notifyDataSetChanged();
        add_ori.setVisibility(View.VISIBLE);
        add_split.setVisibility(View.INVISIBLE);
    }


    public List<contact_item> initData() {
        List<contact_item> list = new ArrayList<>();
        contact_item contact_itm;
        String[] nameStrings = {"Lisa", "Tom", "Ivan", "Peter", "Paul", "Hazel", "Mr.Cucumber", "Kurt", "Rachael", "Ross", "Dom", "Patrick"};
        int[] headNumber = {R.drawable.head1, R.drawable.head2, R.drawable.head3, R.drawable.head4, R.drawable.head5, R.drawable.head6, R.drawable.head7,R.drawable.head8,R.drawable.head9, R.drawable.head10};
        for (int i = 0; i < nameStrings.length; i++) {
            contact_itm = new contact_item();
            contact_itm.setName(nameStrings[i]);
            int num=(int)(Math.random()*10);
            contact_itm.setHead(headNumber[num]);
            contact_itm.setPhone("13167098515");
            list.add(contact_itm);
        }
        return list;
    }
}
