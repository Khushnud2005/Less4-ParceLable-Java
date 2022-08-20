package uz.exemple.less4fortasksparcelable.model;

import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class Member implements Parcelable {

    private int id;
    private String name;

    public static final Creator<Member> CREATOR = new Creator<Member>() {
        @Override
        public Member createFromParcel(Parcel source) {
            String name = source.readString();
            int id = source.readInt();
            return new Member(id, name);
        }

        @Override
        public Member[] newArray(int size) {
            return new Member[size];
        }
    };

    public Member(int id,String name){
        this.id = id;
        this.name = name;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
    }
    @NonNull
    public String toString() {
        return "Member{" +
                "name='" + name + '\'' +
                ", id=" + id +
                '}';
    }
}
