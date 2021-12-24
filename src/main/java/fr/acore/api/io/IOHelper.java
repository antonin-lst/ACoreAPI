package fr.acore.api.io;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public interface IOHelper {

    public default IEncapsulatedIO encapsulatedIO(final InputStream inputStream){
        return encapsulatedIO(inputStream, null);
    }

    public default IEncapsulatedIO encapsulatedIO(final InputStream inputStream, final OutputStream outputStream){
        return new IEncapsulatedIO() {

            private InputStream internalInputStream = inputStream;
            private OutputStream internalOutputStream = outputStream;

            @Override
            public InputStream getInputStream() {
                return this.internalInputStream;
            }

            @Override
            public void setInputStream(InputStream inputStreamTarget) {
                this.internalInputStream = inputStreamTarget;
            }

            @Override
            public OutputStream getOutputStream() {
                return this.internalOutputStream;
            }

            @Override
            public void setOutputStream(OutputStream outputStream) {
                this.internalOutputStream = outputStream;
            }

            @Override
            public void close() {
                if(internalInputStream != null){
                    try {
                        internalInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if(internalOutputStream != null){
                    try {
                        internalOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

            }
        };
    }

}
