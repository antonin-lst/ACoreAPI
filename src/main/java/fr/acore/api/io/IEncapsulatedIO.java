package fr.acore.api.io;

import java.io.InputStream;
import java.io.OutputStream;

public interface IEncapsulatedIO {

    public InputStream getInputStream();
    public void setInputStream(InputStream inputStream);

    public OutputStream getOutputStream();
    public void setOutputStream(OutputStream outputStream);

}
