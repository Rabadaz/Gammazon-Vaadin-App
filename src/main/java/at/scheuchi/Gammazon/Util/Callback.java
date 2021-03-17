package at.scheuchi.Gammazon.Util;

public class Callback {
    public interface callback1<T>{
        void run(T value);
    }

    public interface callback2<T,J>{
        void run(T value,J value2);
    }

    public interface callback3<T,J,Z>{
        void run(T value,J value2,Z value3);
    }


    public interface callbackret1<R,T>{
        R run(T value);
    }

    public interface callbackret2<R,T,J>{
        R run(T value,J value2);
    }

    public interface callbackret3<R,T,J,Z>{
        R run(T value,J value2,Z value3);
    }
}
