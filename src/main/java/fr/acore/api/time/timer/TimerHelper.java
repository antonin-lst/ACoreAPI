package fr.acore.api.time.timer;

public interface TimerHelper {

    public default ITimer timer(long delay){
        return timer(System.currentTimeMillis(), delay);
    }

    public default ITimer timer(long paramCurrent, long paramDelay){
        return new ITimer() {

            private long current = paramCurrent;
            private long delay = paramDelay;

            @Override
            public long getCurrent() {
                return this.current;
            }

            @Override
            public void setCurrent(long current) {
                this.current = current;
            }

            @Override
            public long getDelay() {
                return this.delay;
            }

            @Override
            public void setDelay(long delay) {
                this.delay = delay;
            }

            @Override
            public long getRemainingTime() {
                return (current + delay) - System.currentTimeMillis();
            }

            @Override
            public String getFormatedRemainingTime() {
                return timeToStringFromMs(getRemainingTime());
            }

            @Override
            public boolean isFinish() {
                return getRemainingTime() <= 0;
            }
        };
    }

}
