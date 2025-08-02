package itsme.mysterious.system.models;

import com.google.firebase.Timestamp;
import com.google.firebase.firestore.PropertyName;

public class LogBookEntry {
    private String LogTitle, LogText, LogTime;


    private Timestamp LastModified;

    private boolean LogStateFree, LogStateRaged, LogStateFocused, LogStateRegret;

    public LogBookEntry() {
        //For Firestore
    }

    public LogBookEntry(String LogTitle, String LogText, String LogTime, boolean LogStateFree, boolean LogStateRaged, boolean LogStateFocused, boolean LogStateRegret) {
        this.LogTitle = LogTitle;
        this.LogText = LogText;
        this.LogTime = LogTime;
        this.LogStateFree = LogStateFree;
        this.LogStateRaged = LogStateRaged;
        this.LogStateFocused = LogStateFocused;
        this.LogStateRegret = LogStateRegret;
    }


    @PropertyName("LastModified")
    public Timestamp getLastModified() {
        return LastModified;
    }

    @PropertyName("LastModified")
    public void setLastModified(Timestamp LastModified) {
        this.LastModified = LastModified;
    }

    @PropertyName("LogTitle")
    public String getLogTitle() {
        return LogTitle;
    }

    @PropertyName("LogTitle")
    public void setLogTitle(String Title) {
        this.LogTitle = Title;
    }

    @PropertyName("LogTime")
    public String getTime() {
        return LogTime;
    }

    @PropertyName("LogTime")
    public void setTime(String LogTime) {
        this.LogTime = LogTime;
    }

    @PropertyName("LogText")
    public String getText() {
        return LogText;
    }

    @PropertyName("LogText")
    public void setText(String LogText) {
        this.LogText = LogText;
    }

    @PropertyName("LogStateFree")
    public boolean isFree() {
        return LogStateFree;
    }

    @PropertyName("LogStateFree")
    public void setFree(boolean LogStateFree) {
        this.LogStateFree = LogStateFree;
    }

    @PropertyName("LogStateRaged")
    public boolean isRaged() {
        return LogStateRaged;
    }

    @PropertyName("LogStateRaged")
    public void setRaged(boolean LogStateRaged) {
        this.LogStateRaged = LogStateRaged;
    }

    @PropertyName("LogStateFocused")
    public boolean isFocused() {
        return LogStateFocused;
    }

    @PropertyName("LogStateFocused")
    public void setFocused(boolean LogStateFocused) {
        this.LogStateFocused = LogStateFocused;
    }

    @PropertyName("LogStateRegret")
    public boolean isRegret() {
        return LogStateRegret;
    }

    @PropertyName("LogStateRegret")
    public void setRegret(boolean LogStateRegret) {
        this.LogStateRegret = LogStateRegret;
    }
}
