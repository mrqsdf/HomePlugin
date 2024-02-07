package fr.mrqsdf.homeplugin.res;

import org.apache.commons.lang.SerializationUtils;
import org.bukkit.persistence.PersistentDataAdapterContext;
import org.bukkit.persistence.PersistentDataType;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;

public class HomeDataType implements PersistentDataType<byte[], Home> {

    @Override
    public Class<byte[]> getPrimitiveType() {
        return byte[].class;
    }

    @Override
    public Class<Home> getComplexType() {
        return Home.class;
    }

    @Override
    public byte[] toPrimitive(Home itemReworkData, PersistentDataAdapterContext persistentDataAdapterContext) {
        return SerializationUtils.serialize(itemReworkData);
    }

    @Override
    public Home fromPrimitive(byte[] bytes, PersistentDataAdapterContext persistentDataAdapterContext) {
        try {
            InputStream inputStream = new ByteArrayInputStream(bytes);
            ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
            return (Home) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

}
