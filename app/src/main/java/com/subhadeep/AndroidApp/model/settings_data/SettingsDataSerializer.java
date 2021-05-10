package com.subhadeep.AndroidApp.model.settings_data;

import org.jetbrains.annotations.NotNull;

import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

import androidx.datastore.core.Serializer;


public class SettingsDataSerializer implements Serializer<SettingsData> {

    @Override
    public SettingsData getDefaultValue() {
        return SettingsData.getDefaultSettings();
    }

    @Override
    public SettingsData readFrom(@NotNull InputStream inputStream) {
        try {
            ObjectInputStream ois = new ObjectInputStream(inputStream);
            return (SettingsData) ois.readObject();
        } catch (Exception e) {
            System.out.println(getClass().getName() + "::ERROR in readFrom()::" + e.toString());
        }
        return getDefaultValue();
    }

    @Override
    public void writeTo(SettingsData settingsData, @NotNull OutputStream outputStream) {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            objectOutputStream.writeObject(settingsData);
            objectOutputStream.flush();
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println(getClass().getName() + "::ERROR in writeTo()::" + e.toString());
        }
    }

}
