package com.example.lenovo.mycontact;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by lenovo on 2018/3/31.
 */
public class contact_item implements Parcelable {
    private String name;
    private int head;
    private String phone_num;

    public String getName() {
        return name;
    }
    public int getHead() {
        return head;
    }
    public String getPhone() {
        return phone_num;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setHead(int head){
        this.head = head;
    }
    public void setPhone(String phone_num){
        this.phone_num = phone_num;
    }

    @Override
    public int describeContents() {
        // TODO Auto-generated method stub
        return 0;
    }

    public contact_item(String name, String phone, int head) {
        super();
        this.name = name;
        this.phone_num = phone;
        this.head = head;
    }

    public contact_item() {
        super();
    }


    @Override
    public String toString() {
        return "contact_item [name=" + name + ", phone_num =" + phone_num + "]";
    }


    @Override
    public void writeToParcel(Parcel arg0, int arg1) {
        // TODO Auto-generated method stub
        // 1.必须按成员变量声明的顺序封装数据，不然会出现获取数据出错
        // 2.序列化对象
        arg0.writeString(name);
        arg0.writeString(phone_num);
    }
    // 1.必须实现Parcelable.Creator接口,否则在获取Person数据的时候，会报错，如下：
    // android.os.BadParcelableException:
    // Parcelable protocol requires a Parcelable.Creator object called  CREATOR on class com.um.demo.Person
    // 2.这个接口实现了从Percel容器读取Person数据，并返回Person对象给逻辑层使用
    // 3.实现Parcelable.Creator接口对象名必须为CREATOR，不如同样会报错上面所提到的错；
    // 4.在读取Parcel容器里的数据事，必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
    // 5.反序列化对象
    public static final Creator CREATOR = new Creator(){
        @Override
        public contact_item createFromParcel(Parcel source) {
            // TODO Auto-generated method stub
            // 必须按成员变量声明的顺序读取数据，不然会出现获取数据出错
            contact_item p = new contact_item();
            p.setName(source.readString());
            p.setPhone(source.readString());
            return p;
        }

        @Override
        public contact_item[] newArray(int size) {
            // TODO Auto-generated method stub
            return new contact_item[size];
        }
    };
}