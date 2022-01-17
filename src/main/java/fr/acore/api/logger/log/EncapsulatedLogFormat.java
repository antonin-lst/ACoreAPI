package fr.acore.api.logger.log;

public interface EncapsulatedLogFormat<T> {

    public String getFormat();
    public T getLog();

    public static <T extends ILog> EncapsulatedLogFormat<T> toELF(String format, T log){
        return new EncapsulatedLogFormat<T>() {
            @Override
            public String getFormat() {
                return format;
            }

            @Override
            public T getLog() {
                return log;
            }
        };
    }

    public static <T extends ILogToFile> EncapsulatedLogFormat<T> toELTFF(String format, T log){
        return new EncapsulatedLogFormat<T>() {
            @Override
            public String getFormat() {
                return format;
            }

            @Override
            public T getLog() {
                return log;
            }
        };
    }
}
