package com.example.sendmessageviewbinding.model.data;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;
import java.util.Objects;

/**
 * Clase Message que guarda un mensaje que manda una persona emisor a otra persona
 *
 * @version 1.0
 * @autor Alberto Sabarit Peñalosa
 */
public class Message implements Serializable, Parcelable {

    public static final String KEY = "Message";
    private int id;
    private String content;
    private Person sender;
    private Person receiver;

    public Message(int id, String content, Person sender, Person receiver) {
        this.id = id;
        this.content = content;
        this.sender = sender;
        this.receiver = receiver;
    }

    //region Métodos SET y GET de la clase Message


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Person getSender() {
        return sender;
    }

    public void setSender(Person sender) {
        this.sender = sender;
    }

    public Person getReceiver() {
        return receiver;
    }

    public void setReceiver(Person receiver) {
        this.receiver = receiver;
    }

    //endregion


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Message message = (Message) o;
        return id == message.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Message{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", sender=" + sender +
                ", receiver=" + receiver +
                '}';
    }


    protected Message(Parcel in) {
        id = in.readInt();
        content = in.readString();
        sender = in.readParcelable(Person.class.getClassLoader());
        receiver = in.readParcelable(Person.class.getClassLoader());
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(id);
        dest.writeString(content);
        dest.writeParcelable(sender, flags);
        dest.writeParcelable(receiver, flags);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Message> CREATOR = new Creator<Message>() {
        @Override
        public Message createFromParcel(Parcel in) {
            return new Message(in);
        }

        @Override
        public Message[] newArray(int size) {
            return new Message[size];
        }
    };
}
